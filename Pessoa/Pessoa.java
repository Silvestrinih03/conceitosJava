package Pessoa;

import java.util.Objects;

public class Pessoa {
    private String nome, cpf;
    private int idade;

    private Boolean isValidNome(String nome) {
        if (nome == null)
            return false;

        return true;
    }

    private Boolean isValidCpf(String cpf) {
        if (cpf == null)
            return false;

        return true;

    }

    private Boolean isValidIdade(int idade) {
        if (idade < 0 || idade > 120)
            return false;

        return true;

    }

    public Pessoa(String nome, String cpf, int idade) throws Exception {
        if (!isValidNome(nome) || !isValidCpf(cpf) || !isValidIdade(idade))
            throw new Exception("Dados inválidos!");

        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    // public

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int novaidade) throws Exception {
        if (!isValidIdade(novaidade))
            throw new Exception("A idade informada não é válida");

        this.idade = novaidade;

    }

    @Override
    public String toString() {
        return "Dados Pessoais \nNome: " + this.nome + "\nCPF: " + this.cpf + "\nIdade: " + this.idade + "\n\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Pessoa))
            return false;
        Pessoa pessoa = (Pessoa) obj;
        return idade == pessoa.idade && nome.equals(pessoa.nome) && cpf.equals(pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, cpf);
    }

}
