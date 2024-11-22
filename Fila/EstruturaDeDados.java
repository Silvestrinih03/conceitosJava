package Fila;

public interface EstruturaDeDados<X> {
    void insira(X x) throws Exception;

    void remova() throws Exception;

    Object getConsulte() throws Exception;

    int getTamanho() throws Exception;

    boolean isVazia();

}
