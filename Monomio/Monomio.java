package Monomio;

public class Monomio {
    private double coef;
    private int expo;

    public Monomio(double coef, int expo) {
        this.coef = coef;
        this.expo = expo;
    }

    public double getCoef() {
        return this.coef;
    }

    public int getExpo() {
        return this.expo;
    }

    public double aplicaA(double x) {
        return coef * Math.pow(x, expo);
    }

    @Override
    public String toString() {
        return "" + coef + "X^" + expo + "/n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Monomio))
            return false;
        Monomio mono = (Monomio) obj;
        return coef == mono.coef && expo == mono.expo;
    }

    // @Override
    // public int hashCode(){
    //     return Objects.hash(coef, expo);
    // }
}
