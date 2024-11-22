package conjunto.ordenado;

//import clonador.*;
import clonador.Clonador;

//import conjunto.*;
import conjunto.Conjunto;

public class ConjuntoOrdenado<X extends Comparable<X>> extends Conjunto<X>
{
    public /*void*/ ConjuntoOrdenado (int capInicial) throws Exception
    {
        super(capInicial);
    }
    
    //construtor padrao
    public /*void*/ ConjuntoOrdenado ()
    {
        super();
    }    
    
    // procura x em this.elem e, se achou:
    // na posicao 0, retorna 1;
    // na posicao 1, retorna 2;
    // na posicao 2, retorna 3;
    // e assim por diante; MAS, se não achou e concluiu
    // que o lugar para inserir, mantendo a ordenacao do
    // vetor, aquilo que foi buscado e não foi encontrado era:
    // a posicao 0, retorna -1;
    // a posicao 1, retorna -2;
    // a posicao 2, retorna -3;
    // e assim por diante.
    @Override
    protected Object[] ondeEsta (X x)
    {
        int inicio=0, fim=this.qtd-1, meio;
        
        while (inicio<=fim)
        {
            meio = (inicio+fim)/2;
            
            int comp = x.compareTo((X)this.elem[meio]);
            
            if (comp==0) // achei
            {
                Object[] ret = {true,meio};
                return ret;
            }
                
            if (comp<0)
                fim = meio-1;
            else
                inicio = meio+1;
        }
        
        Object[] ret = {false,inicio};
        return ret;
    }
    
    //construtor de copia
    public ConjuntoOrdenado (ConjuntoOrdenado<X> modelo) throws Exception
    {
        super(modelo);
    }
    
    @Override
    public Object clone ()
    {
        ConjuntoOrdenado<X> ret=null;
        
        try
        {
            ret = new ConjuntoOrdenado<X> (this);
        }
        catch (Exception erro)
        {}
        
        return ret;
    }    
}
