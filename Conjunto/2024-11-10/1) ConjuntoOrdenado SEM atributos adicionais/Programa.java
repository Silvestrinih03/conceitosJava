//import conjunto.ordenado.*;
import conjunto.ordenado.ConjuntoOrdenado;

//import conjunto.*;
import conjunto.Conjunto;

public class Programa
{
    public static void main (String[] args)
    {
        try
        {
            ConjuntoOrdenado<String> c1 = new ConjuntoOrdenado<String> (4);
            
            c1.inclua("vermelho");
            c1.inclua("azul");
            c1.inclua("branco");
            c1.inclua("lilas");
            c1.inclua("verde");
            System.out.println (c1);
            
            c1.remova("azul");
            System.out.println (c1);
        }
        catch (Exception erro)
        {
            System.err.println (erro.getMessage());
        }
    }
}
