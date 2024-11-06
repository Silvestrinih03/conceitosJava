public class ControladorDeLetrasJaDigitadas implements Cloneable {
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas() {
        // torna this.letrasJaDigitadas igual ao String vazio
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada(char letra) {
        // percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++) {
            if (letra == this.letrasJaDigitadas.charAt(i))
                return true;
        }
        return false;
    }

    public void registre(char letra) throws Exception {
        // verifica se a letra fornecida ja foi digitada (pode usar
        // o método this.isJaDigitada, para isso), lancando uma exceção
        // em caso afirmativo.
        // concatena a letra fornecida a this.letrasJaDigitadas.

        if (isJaDigitada(letra))
            throw new Exception("Essa letra já foi digitada!");

        this.letrasJaDigitadas += letra;

    }

    public String toString() {
        // retorna um String com TODAS as letras presentes em
        // this.letrasJaDigitadas separadas por vírgula (,).
        String ret = "";

        if (this.letrasJaDigitadas.length() > 0)
            ret += +this.letrasJaDigitadas.charAt(0);

        for (int i = 1; i < this.letrasJaDigitadas.length(); i++) {
            ret += ", " + this.letrasJaDigitadas.charAt(i);
        }
        return ret;
    }

    public boolean equals(Object obj) {
        // verificar se this e obj são iguais
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;

        ControladorDeLetrasJaDigitadas letras = (ControladorDeLetrasJaDigitadas) obj;

        // Verificar se os tamanhos dos arrays são diferentes
        if (this.letrasJaDigitadas.length() != letras.letrasJaDigitadas.length())
            return false;

        // Comparar elemento por elemento
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++) {
            if (this.letrasJaDigitadas.charAt(i) != letras.letrasJaDigitadas.charAt(i))
                return false;
        }

        return true;
    }

    public int hashCode() {
        // calcular e retornar o hashcode de this
        int ret = 1;

        for (int i = 0; i < this.letrasJaDigitadas.length(); i++) {
            ret = ret * 13 + ((Character) this.letrasJaDigitadas.charAt(i)).hashCode();
        }

        if (ret < 0)
            ret = -ret;
        return ret;
    }

    public ControladorDeLetrasJaDigitadas(
            ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
            throws Exception // construtor de cópia
    {
        // copiar c.letrasJaDigitadas em this.letrasJaDigitadas
        if (controladorDeLetrasJaDigitadas == null)
            throw new Exception("Modelo ausente");

        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    public Object clone() {
        // criar uma cópia do this com o construtor de cópia e retornar
        ControladorDeLetrasJaDigitadas ret = null;

        try {
            ret = new ControladorDeLetrasJaDigitadas(this);
        } catch (Exception erro) {
            throw new RuntimeException("Erro ao clonar o objeto: " + erro.getMessage(), erro);
        }

        return ret;
    }
}
