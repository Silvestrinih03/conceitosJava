public class Main {
    public static void main(String[] args) throws Exception {
        Funcionario func1 = new Funcionario("João", 20, 1200);
        Funcionario func2 = new Funcionario("Maria", 26, 2000);
        Funcionario copiafunc1 = new Funcionario(func1);

        System.out.println(func1.toString());
        System.out.println(func2.toString());

        System.out.println("Funcionário cópia:\n" + copiafunc1.toString());

        copiafunc1.setNome("Gustavo");
        copiafunc1.setIdade(30);
        copiafunc1.setSalario(3000);

        System.out.println("Funcionário cópia alterado:\n" + copiafunc1.toString());
    }
}
