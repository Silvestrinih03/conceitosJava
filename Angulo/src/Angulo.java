public class Angulo /* throws Exception */ {
    private short valorAngular;

    private static boolean isValido(byte ang) {
        if (ang < 0 || ang > 360)
            return false;

        return true;
    }

    /* Construtor - recebendo um valor angular expresso em graus, o armazena */
    public Angulo(short ang) throws Exception {
        if (!isValido(ang)) {
            this.valorAngular = setValorEmGraus(ang);
        }

        else
            this.valorAngular = ang;
    }

    // sem receber parâmetros retorna valor em graus
    public short getValorEmGraus() {
        return this.valorAngular;
    }

    private short setValorEmGraus(short ang) {
        var novoang = ang % 360;
        return (short) novoang;
    }

    /*
     * Escreva métodos de instância chamadas setValorEmGraus, setValorEmGrados e
     * setValorEmRadianos que, recebendo como parâmetro um valor angular
     * expresso, respectivamente, em graus, em grados e em radianos, ajustam o valor
     * angular, sempre expresso em graus, da instância chamante.
     */

    /*
     * Crie os métodos padrão necessários e cabíveis
     * Fazer:
     * 1. toString
     * 2. equals
     * 3. hashCode
     * 4. compareTo
     * 5. construtor de cópia e clone
     */
}

// // sem receber parâmetros retorna valor em grados
// public double getValorEmGrados() {
// var grados = 400 / 360 * this.valorAngular;
// return grados;

// }

// // sem receber parâmetros retorna valor em radianos
// public double getValorEmRadianos() {
// var rad = this.valorAngular * (Math.PI / 180);
// return rad;
// }

// public void setValorEmGrados(double ang) {
// var valorGrados = getValorEmGrados();

// }