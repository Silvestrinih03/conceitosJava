public class Palavra implements Comparable<Palavra> {
    private String texto;

    public Palavra(String texto) throws Exception {
        // verifica se o texto recebido é nulo ou então vazio,
        // ou seja, sem nenhum caractere, lançando exceção.
        // armazena o texto recebido em this.texto.
        if (texto == null || texto.isEmpty())
            throw new Exception("Palavra inválida!");
        this.texto = texto;
    }

    public int getQuantidade(char letra) {
        // percorre o String this.texto, conta e retorna
        // quantas letras existem nele iguais a letra fornecida
        char[] caracteres = this.texto.toCharArray();
        int cont = 0;

        // percorre o array e conta quantas vezes a letra aparece
        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == letra) {
                cont++;
            }
        }
        return cont;
    }

    public int getPosicaoDaIezimaOcorrencia(int i, char letra) throws Exception {
        // se i==0, retorna a posicao em que ocorre a primeira
        // aparicao de letra fornecida em this.texto;
        // se i==1, retorna a posicao em que ocorre a segunda
        // aparicao de letra fornecida em this.texto;
        // se i==2, retorna a posicao em que ocorre a terceira
        // aparicao de letra fornecida em this.texto;
        // e assim por diante.
        // lançar excecao caso nao encontre em this.texto
        // a Iézima aparição da letra fornecida.
        int ocorrenciasEncontradas = 0;

        // Percorre o texto caractere por caractere
        for (int j = 0; j < this.texto.length(); j++) {
            if (this.texto.charAt(j) == letra) {
                // Incrementa o contador de ocorrências
                if (ocorrenciasEncontradas == i) {
                    return j; // Retorna a posição da Iézima ocorrência
                }
                ocorrenciasEncontradas++;
            }
        }

        // Se não encontrou a Iézima ocorrência, lança uma exceção
        throw new Exception("A Iézima ocorrência da letra não foi encontrada.");
    }

    public int getTamanho() {
        return this.texto.length();
    }

    public String toString() {
        return this.texto;
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

        Palavra palavra = (Palavra) obj;
        return this.texto.equals(palavra.texto);
    }

    public int hashCode() {
        // calcular e retornar o hashcode de this
        int ret = 1;

        for (int i = 0; i < this.texto.length(); i++) {
            ret = ret * 13 + this.texto.hashCode();
        }

        if (ret < 0)
            ret = -ret;
        return ret;

        // return this.texto.hashCode();
    }

    public int compareTo(Palavra palavra) {
        return this.texto.compareTo(palavra.texto);
    }
}
