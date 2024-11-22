package Pilha;

// Classe genérica capaz de guardar qualquer coisa 

public class Pilha<X> implements Cloneable {
    protected Object[] elemento;
    protected int ultimo = -1;

    public Pilha() {
        this.elemento = new Object[10];
    }

    public Pilha(int capacidade) throws Exception {
        if (capacidade <= 0)
            throw new Exception("Capacidade inválida!");

        this.elemento = new Object[capacidade];
    }

    public void guardeUmItem(X x) throws Exception {
        if (x == null)
            throw new Exception("Elemento ausente!");
        if (this.ultimo == this.elemento.length - 1)
            throw new Exception("Não há espaço disponível!");
        // if (x instanceof Cloneable)
        // this.elem[++this.ultimo] = (new Clonador<X>()).clone(x);
        // else
        // this.elem[++this.ultimo] = x;
        this.elemento[++this.ultimo] = x;
    }

    public Object getUmItem() throws Exception {
        if (this.ultimo == -1)
            throw new Exception("Vetor vazio!");
        return this.elemento[this.ultimo];
    }

    public void removaUmItem() throws Exception {
        if (this.ultimo == -1)
            throw new Exception("Vetor Vazio!");
        this.elemento[this.ultimo--] = null;
    }

    public int getTamanho() {
        return this.ultimo + 1;
    }

    @Override
    public String toString() {
        return "Pilha com " + (this.ultimo + 1) + " elementos" +
                (this.ultimo == -1 ? "" : ",\nsendo o ultimo deles: " + this.elem[this.ultimo]);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (obj.getClass() != this.getClass())
            return false;
        Pilha<X> p = (Pilha<X>) obj;

        if (p.ultimo != this.ultimo)
            return false;

        for (int i = 0; i <= this.ultimo; i++) {
            if (!p.elemento[i].equals(this.elemento[i]))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        ret = 2 * ret + ((Integer) this.ultimo).hashCode();
        for (int i = 0; i <= this.ultimo; i++)
            ret = 31 * ret + this.elemento[i].hashCode();
        if (ret < 0)
            ret = -ret;

        return ret;
    }

    // Construtor de cópia
    public Pilha(Pilha<X> modelo) throws Exception {
        if (modelo == null)
            throw new Exception("Modelo ausente!");
        this.ultimo = modelo.ultimo;
        this.elemento = new Object[this.elemento.length];

        for (int i = 0; i <= this.ultimo; i++)
            this.elemento[i] = modelo.elemento[i];
    }

    @Override
    public Object clone() {
        Pilha<X> ret = null;
        try {
            ret = new Pilha<X>(this);
        } catch (Exception erro) {
        }

        return ret;
    }

}
