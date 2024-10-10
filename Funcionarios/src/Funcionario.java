public class Funcionario implements Cloneable {
    private String nome;
    private int idade;
    private float salario;

    private static boolean isNomeValido(String nome) {
        if (nome == null || nome.length() < 2)
            return false;
        return true;
    }

    private static boolean isIdadeValida(int idade) {
        if (idade < 0 || idade > 120)
            return false;
        return true;
    }

    private static boolean isSalarioValido(float salario) {
        if (salario < 0)
            return false;
        return true;
    }

    // Construtor
    public Funcionario(String nome, int idade, float salario) throws Exception {
        if (!isNomeValido(nome))
            throw new Exception("Preencha o nome!");
        if (!isIdadeValida(idade))
            throw new Exception("A idade deve ser um inteiro entre 0 e 120 anos!");
        if (!isSalarioValido(salario))
            throw new Exception("O salário deve ser um float maior ou igual a 0.");
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    // Construtor de cópia
    public Funcionario(Funcionario modelo) throws Exception {
        if (modelo == null)
            throw new Exception("Modelo ausente!");
        this.nome = modelo.nome; // Copia o nome
        this.idade = modelo.idade; // Copia a idade
        this.salario = modelo.salario; // Copia o salário
    }

    // Implementação do método clone()
    @Override
    public Object clone() {
        Funcionario ret = null;
        try {
            return new Funcionario(this);
        } catch (Exception erro) {
            // erros
        }
        return ret;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int novaidade) throws Exception {
        if (!isIdadeValida(novaidade))
            throw new Exception("A idade deve ser um inteiro entre 0 e 120 anos!");
        this.idade = novaidade;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float novosalario) throws Exception {
        if (!isSalarioValido(novosalario))
            throw new Exception("O salário deve ser um float maior ou igual a 0.");
        this.salario = novosalario;
    }

    @Override
    public String toString() {
        return "Dados do Funcionário:\nNome: " + this.nome + "\nIdade: " + this.idade + " anos" + "\nSalário: R$"
                + this.salario + "\n\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Funcionario))
            return false;
        Funcionario func = (Funcionario) obj;
        return this.nome.equals(func.nome) && this.idade == func.idade &&
                this.salario == func.salario;
    }

    // Implementar o método hashCode() para garantir que dois objetos com os mesmos
    // atributos tenham o mesmo código hash.
    @Override
    public int hashCode() {
        // Usa o hashCode do nome (String)
        int result = nome.hashCode();
        // Multiplica o resultado por um número primo e adiciona a idade
        result = 31 * result + idade;
        // Converte o salário para bits de inteiro e usa no cálculo
        result = 31 * result + Float.floatToIntBits(salario);
        return result;
    }
}