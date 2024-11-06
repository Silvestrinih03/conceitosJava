public class ControladorDeErros implements Cloneable {
    private int qtdMax, qtdErr = 0;

    public ControladorDeErros(int qtdMax) throws Exception {
        // verifica se qtdMax fornecida não é positiva, lançando
        // uma exceção.
        // armazena qtdMax fornecida em this.qtdMax.
        if (qtdMax < 0)
            throw new Exception("Quantidade invalida");

        this.qtdMax = qtdMax;
    }

    public void registreUmErro() throws Exception {
        // verifica se this.qtdErr ja é igual a this.qtdMax,
        // lançando excecao em caso positivo ou
        // incrementando this.qtdErr em caso negativo
        if (this.qtdErr == this.qtdMax)
            throw new Exception("Errou alem do maximo");

        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros() {
        // returna true se this.qtdErr for igual a this.qtdMax,
        // ou então false, caso contrario.
        /*
         * if (this.qtdErr==this.qtdMax)
         * return true;
         * else
         * return false;
         */

        return this.qtdErr == this.qtdMax;
    }

    public String toString() {
        return "Erros: " + this.qtdErr + "/" + this.qtdMax;
    }

    public boolean equals(Object obj) {
        // verificar se this e obj possuem o mesmo conteúdo, retornando
        // true no caso afirmativo ou false no caso negativo
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;

        ControladorDeErros erros = (ControladorDeErros) obj;

        if (erros.qtdErr != this.qtdErr)
            return false;
        if (erros.qtdMax != this.qtdMax)
            return false;

        return true;
    }

    public int hashCode() {
        // calcular e retornar o hashcode de this
        int ret = 1;

        ret = ret * 31 + this.qtdErr;
        ret = ret * 13 + this.qtdMax;

        if (ret < 0)
            ret = -ret;
        return ret;
    }

    public ControladorDeErros(ControladorDeErros c) throws Exception // construtor de cópia
    {
        // copiar c.qtdMax e c.qtdErr, respectivamente em, this.qtdMax e this.qtdErr
        if (c == null)
            throw new Exception("Modelo ausente!");

        this.qtdErr = c.qtdErr;
        this.qtdMax = c.qtdMax;

    }

    public Object clone() {
        // returnar uma cópia de this
        ControladorDeErros ret = null;

        try {
            ret = new ControladorDeErros(this);
        } catch (Exception erro) {
            throw new RuntimeException("Erro ao clonar o objeto: " + erro.getMessage(), erro);
        }

        return ret;
    }
}
