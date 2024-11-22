package Fila;

public class Fila<X> implements EstruturaDeDados<X>, Cloneable {
    protected Object[] elemento;
    protected int qtd = -1;

    public Fila() {
        this.elemento = new Object[10];
    }

    public void insira(X x) throws Exception {
        if (isVazia())
            throw new Exception("Lista Vazia!");
        if (x == null)
            throw new Exception("Elemento nulo!");

        if (qtd >= this.elemento.length) {
            Object[] novo = new Object[this.elemento.length * 2];
            for (int i = 0; i <= qtd; i++)
                novo[i] = this.elemento[i];
            this.elemento = novo;
        }

        this.elemento[++qtd] = x;
    }

    public void remova() throws Exception {
        if (isVazia())
            throw new Exception("Lista vazia!");
        for (int i = 0; i <= qtd; i++) {
            this.elemento[i] = this.elemento[i + 1];
        }
        this.elemento[qtd] = null;
        qtd--;
    }

    public Object getConsulte() throws Exception {
        if (isVazia())
            throw new Exception("Lista vazia!");

        return this.elemento[0];
    }

    public int getTamanho() throws Exception {
        return qtd + 1;
    }

    public boolean isVazia() {
        return qtd == -1;
    }

    @Override
    public String toString() {
        if (isVazia())
            return "Fila vazia!";

        String ret = "Fila: [ " + this.elemento[0];

        for (int i = 1; i <= qtd; i++) {
            ret += ", " + this.elemento[i];
        }

        ret += " ]";

        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;

        Fila<X> f = (Fila<X>) obj;

        if (this.qtd != f.qtd)
            return false;
        for (int i = 0; i < this.elemento.length; i++) {
            if (!this.elemento[i].equals(f.elemento[i]))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int ret = 7;
        ret = 13 * ret + this.qtd;
        for (int i = 0; i < this.elemento.length; i++)
            ret = 31 * ret + this.elemento[i].hashCode();
        return ret;
    }

    // Construtor de cópia
    public Fila(Fila<X> modelo) throws Exception {
        if (modelo == null)
            throw new Exception();
        this.qtd = modelo.qtd;
        for (int i = 0; i < this.elemento.length; i++) {
            this.elemento[i] = modelo.elemento[i];
        }
    }

    @Override
    public Fila<X> clone() {
        Fila<X> copia = null;
        try {
            copia = new Fila<>(this);
        } catch (Exception e) {
            e.printStackTrace(); // Isso não deve ocorrer, já que o modelo existe.
        }
        return copia;
    }
}
