public class Main {
    public static void main(String[] args) {
        Radar radar = new Radar(1, 101, 60.0); // Cria um radar com limite de 60 km/h

        // Simulação em uma thread separada para permitir interação externa
        Thread radarThread = new Thread(radar::entreEmAcao);
        radarThread.start();

        // Simula o ajuste da velocidade detectada
        new Thread(() -> {
            try {
                for (double v = 50.0; v <= 70.0; v += 5.0) {
                    radar.setVelocidade(v); // Configura a velocidade detectada
                    Thread.sleep(3000); // Intervalo de 3 segundos
                }
                radarThread.interrupt(); // Interrompe o radar após a simulação
            } catch (InterruptedException e) {
                System.out.println("Simulação interrompida.");
            }
        }).start();
    }
}
