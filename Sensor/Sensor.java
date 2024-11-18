public class Sensor {
    private int numIdentificador; // Identificador do sensor
    private double velocidade; // Velocidade do objeto detectado

    // Construtor que inicializa o identificador
    public Sensor(int identificador) {
        this.numIdentificador = identificador;
        this.velocidade = 0.0; // Inicializa como 0 (nada detectado)
    }

    // Método para retornar a velocidade detectada
    public double getVelocidade() {
        return this.velocidade;
    }

    // Método opcional para simular a alteração da velocidade detectada
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    // Método opcional para obter o número identificador
    public int getNumIdentificador() {
        return this.numIdentificador;
    }
}
