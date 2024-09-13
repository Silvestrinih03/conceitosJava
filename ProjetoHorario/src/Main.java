public class Main {
    public static void main(String[] args) throws Exception {

        Horario hora = new Horario((byte) 0, (byte) 20, (byte) 0);
        Horario hora2 = new Horario((byte) 14, (byte) 00, (byte) 0);

        System.out.println("Hora:" + hora.getHora());
        System.out.println("Minuto:" + hora.getMin());
        System.out.println("Segundo:" + hora.getSeg());

        hora.setHora((byte) 9);
        hora.setMin((byte) 59);
        hora.setSeg((byte) 17);
        System.out.println("Nova horário: " + hora.getHora() + ":" + hora.getMin() + ":" + hora.getSeg());

        System.out.println("\nAdiantar relógio");
        hora.adiante(3600);
        System.out.println("hora:" +
                hora.getHora() + ":" + hora.getMin() + ":" + hora.getSeg());

        hora.adiante(10800);
        System.out.println("hora:" +
                hora.getHora() + ":" + hora.getMin() + ":" + hora.getSeg());

        hora.adiante(3211);
        System.out.println("hora:" + hora.getHora() + ":" + hora.getMin() + ":" +
                hora.getSeg());

        hora.adiante(389);
        System.out.println("hora:" + hora.getHora() + ":" + hora.getMin() + ":" +
                hora.getSeg());

        System.out.println("\nAtrasar relógio");
        hora.atrase(3600);
        System.out.println("hora:" + hora.getHora() + ":" + hora.getMin() + ":" + hora.getSeg());

        hora.atrase(10800);
        System.out.println("hora:" + hora.getHora() + ":" + hora.getMin() + ":" + hora.getSeg());

        hora.atrase(3211);
        System.out.println("hora:" + hora.getHora() + ":" + hora.getMin() + ":" + hora.getSeg());

        hora.atrase(389);
        System.out.println("hora:" + hora.getHora() + ":" + hora.getMin() + ":" + hora.getSeg());

        System.out.println("\nDiferença entre horários");
        System.out.println("hora 1: " + hora.getHora() + ":" + hora.getMin() + ":" + hora.getSeg());
        System.out.println("hora 2: " + hora2.getHora() + ":" + hora2.getMin() + ":" + hora2.getSeg());

        System.out.println("Diferença em segundos: " + hora.diferenca(hora2));

    }

}
