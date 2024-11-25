package CorrecaoP2;

public class MinhaMalhaViaria {
    public MinhaMalhaViaria(int qc, int qv) {
        super(qc, qv);
        if (qc <= 0)
            throw new Exception("Quantidade de cidades inválida!");
        if (qv <= 0)
            throw new Exception("Quantidade de vias inválida!");
    }
}
