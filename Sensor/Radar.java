public class Radar extends Sensor {
    private Camera camera;
    private double velocidadeMax;

    public Radar(int numSensor, int numCamera, double velocidadeMax) {
        super(numSensor);
        this.camera = new Camera(numCamera);
        this.velocidadeMax = velocidadeMax;
    }

    public void entraEmAcao() {
        System.out.println("Operações do Radar Iniciadas.");

        while (true) {
            double velocidadeDetectada = this.getVelocidade();

            if (velocidadeDetectada > this.velocidadeMax) {
                String descricao = "Velocidade excedida! \n Detecção: " + velocidadeDetectada + "km/h";
                camera.fotografe(descricao);
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Radar Interrompido!");
                break;
            }

        }
    }

}

// 1. Derivada da classe Sensor e valendo-se da classe Camera, crie a classe
// Radar
// para representar um radar como estes que encontramos instalados nas
// principais
// ruas e avenidas das grandes cidades;

//  Implemente um construtor que recebe como parâmetro 2 números inteiros (um
// deles para o construtor de Sensor e o outro para o construtor de Camera) e um
// número real que representa a velocidade máxima da via na qual o radar vai ser
// instalado, iniciando apropriadamente a instância à qual se refere;

//  Implemente uma função de instância pública, chamada entreEmAcao, que
// coloca em operação de forma ininterrupta uma instância da classe Radar