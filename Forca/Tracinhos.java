public class Tracinhos implements Cloneable {
    private char texto[];

    public Tracinhos(int qtd) throws Exception {
        // verifica se qtd não é positiva, lançando uma exceção.
        // instancia this.texto com um vetor com tamanho igual qtd.
        // preenche this.texto com underlines (_).

        if (qtd <= 0)
            throw new Exception("Valor inválido!");

        this.texto = new char[qtd];
        for (int i = 0; i < qtd; i++) {
            this.texto[i] = '_';
        }
    }

    public void revele(int posicao, char letra) throws Exception {
        // verifica se posicao é negativa ou então igual ou maior
        // do que this.texto.length, lançando uma exceção.
        // armazena a letra fornecida na posicao tambem fornecida
        // do vetor this.texto

        if (posicao < 0 || posicao >= this.texto.length)
            throw new Exception("Posição inválida!");

        this.texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos() {
        // percorre o vetor de char this.texto e verifica
        // se o mesmo ainda contem algum underline ou se ja
        // foram todos substituidos por letras; retornar true
        // caso ainda reste algum underline, ou false caso
        // contrario

        for (int i = 0; i < this.texto.length; i++) {
            if (this.texto[i] == '_')
                return true;
        }
        return false;
    }

    public String toString() {
        // retorna um String com TODOS os caracteres que há
        // no vetor this.texto, intercalados com espaços em
        // branco
        String ret = "";

        if (this.texto.length > 0)
            ret += this.texto[0];

        for (int i = 1; i < this.texto.length; i++)
            ret += " " + this.texto[i];

        return ret;
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

        Tracinhos tracinhos = (Tracinhos) obj;

        // Verificar se os tamanhos dos arrays são diferentes
        if (this.texto.length != tracinhos.texto.length)
            return false;

        // Comparar elemento por elemento
        for (int i = 0; i < this.texto.length; i++) {
            if (this.texto[i] != tracinhos.texto[i])
                return false;
        }

        return true;
    }

    public int hashCode() {
        // calcular e retornar o hashcode de this
        int ret = 1;

        for (int i = 0; i < this.texto.length; i++) {
            ret = ret * 13 + ((Character) this.texto[i]).hashCode();
        }

        if (ret < 0)
            ret = -ret;
        return ret;
    }

    public Tracinhos(Tracinhos t) throws Exception // construtor de cópia
    {
        // intanciar this.texto um vetor com o mesmo tamanho de t.texto
        // e compilar o conteúdo de t.texto para this.texto
        if (t == null)
            throw new Exception("Modelo ausente");

        this.texto = new char[t.texto.length];
        for (int i = 0; i < t.texto.length; i++) {
            this.texto[i] = t.texto[i];
        }
    }

    public Object clone() {
        // retornar uma copia de this
        Tracinhos ret = null;

        try {
            ret = new Tracinhos(this);
        } catch (Exception erro) {
            throw new RuntimeException("Erro ao clonar o objeto: " + erro.getMessage(), erro);
        }

        return ret;
    }
}
