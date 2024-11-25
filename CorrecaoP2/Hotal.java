package CorrecaoP2;

public class Hotal {
    public Hotel(int qtdAndares) throws Exception{
        super(qtdAndares);

        if(qtdAndares<=0) throw new Exception("Quantidade inválida!");
    }

    public void interdite(int nroApartamento) throws Exception {
        int i;
        // Se for implementado um novo qtd precisa do super... como o único é o herdado
        // não precisa
        for (i = 0; i < this.qtd; i++) {
            if (nroApartamento == this.apto[i].getNumero())
                break;
        }
        if (i == this.qtd)
            throw new Exception("Apartamento inexistente!");
        if (this.apto[i].isInterditado())
            throw new Exeception("Já interditado!");
        if (this.apto[i].isOcupado())
            throw new Exeception("Já ocupado!");
        this.apto[i].setInterditado(true);
    }

    // TÁ ERRADO
    // public void desinterdite(int nroApartamento) throws Exception {
    // int i;
    // for (i = 0; i < this.qtd; i++) {
    // if (nroApartamento == this.apto[i].getNumero())
    // break;
    // }
    // if (i == this.qtd)
    // throw new Exception("Apartamento inexistente!");
    // if (this.apto[i].isInterditado())
    // throw new Exeception("Já interditado!");
    // if (!this.apto[i].isInterditado())
    // throw new Exeception("Já está desinterditado!");
    // this.apto[i].setInterditado(false);
    // }

    public int capacidade() throws Exception {
        int cont = 0;
        for (int i = 0; i < this.qtd; i++) {
            if (!this.apto[i].isInterditado() && !this.apto[i].isOcupado())
                cont++;
        }

        return cont;
    }
}
