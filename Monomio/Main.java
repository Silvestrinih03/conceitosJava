package Monomio;

public class Main {
    public static void main(String[] args) {
        Monomio mono = new Monomio(2, 2);
        System.out.println(mono.toString());

        Monomio mono2 = new Monomio(2, 3);
        System.out.println(
                "O monomio " + mono.toString() + " é igual o monomio " + mono2.toString() + "? " + mono.equals(mono2));

        System.out.println(
                "O monomio " + mono.toString() + " é igual ao monomio " + mono.toString() + "? " + mono.equals(mono));

        System.out.println("aplicaA: " + mono.aplicaA(2));
        System.out.println("aplicaA: " + mono2.aplicaA(2));
    }

}
