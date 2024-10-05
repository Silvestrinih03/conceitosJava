package Pessoa;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {

        Pessoa P1 = new Pessoa("Nicole", "468.452.446-75", 20);
        Pessoa P2 = new Pessoa("Letícia", "456.235.998-51", 13);
        Pessoa P3 = new Pessoa("Nicole", "468.452.446-75", 20);

        // System.out.printf("Pessoa 1 \nNome: %s \nCPF: %s \nIdade: %d", P1.getNome(),
        // P1.getCpf(), P1.getIdade());
        System.out.println("Lista de Pessoas: ");
        System.out.println(P1.toString());
        System.out.println(P2.toString());
        System.out.println(P3.toString());

        // P1.setIdade(21);
        // System.out.printf("\n\nA nova idade de %s é %d\n\n", P1.getNome(),
        // P1.getIdade());

        var aaa = P1.equals(P2);
        System.out.println("Resultado equals: " + aaa);

        var bbb = P1.equals(P1);
        System.out.println("Resultado equals: " + bbb);

        HashSet<Pessoa> pessoas = new HashSet<>();
        pessoas.add(P1);
        pessoas.add(P2);
        pessoas.add(P3);

        System.out.println("(HashCode) Lista de Pessoas: ");
        for (Pessoa p : pessoas) {
            System.out.println(p);
        }

        Pessoa verificarPessoa = new Pessoa("Nicole", "468.452.446-75", 20);
        System.out.println("O conjunto contém a Nicole? " + pessoas.contains(verificarPessoa));
    }

}
