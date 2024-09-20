package agenda.consultavel;
import  agenda.*;

/**
A classe AgendaConsutavel representa uma simples agenda de telefone
poss�vel de ser consultada.

Inst�ncias desta classe permitem a reliza��o das opera��es b�sicas de uma agenda.
Nela encontramos, n�o s�, m�todos para incluir, excluir e listar
contatos, mas tamb�m m�todos que permitem consult�-la.
@author Andr� Lu�s dos Reis Gomes de Carvalho.
@since 2000.
*/
public class AgendaConsultavel extends Agenda
{
    /**
    Constroi uma nova inst�ncia da classe AgendaConsutavel.
    Para tanto, deve ser fornecido um inteiro que ser� utilizado
    como capacidade da inst�ncia rec�m criada.
    @param cap o n�mero inteiro a ser utilizado como capacidade.
    @throws Exception se a capacidade for negativa ou zero.
    */
    public AgendaConsultavel (int cap) throws Exception
    {
        super (cap); // invoca o construtor da classe Agenda
    }

    /**
    Obtem o telefone de um dado nome.
    Resulta o telefone do contato cujo nome foi fornecido.
    @return o telefone do contato desejado.
    @throws Exception se n�o for fornecido um nome, ou se o nome fornecido
                      n�o parecer ser um nome correto, ou se a agenda
                      estiver vazia, ou ainda se a agenda n�o contiver um
                      contato com o nome fornecido.
    */
    public String getTelefone (String nom)
                               throws Exception
    {
	Agenda.valideNome (nom);

        if (this.qtdContatos == 0)
            throw new Exception ("Agenda vazia");

        int posicao = this.ondeEsta (nom);

        if (posicao < 0)
            throw new Exception ("Nome inexistente");

        posicao--;

        return this.telefone [posicao];
    }

    /**
    Constroi uma c�pia da inst�ncia da classe AgendaConsultavel dada.
    Para tanto, deve ser fornecida uma instancia da classe AgendaConsultavel
    para ser utilizada como modelo para a constru��o da nova inst�ncia
    criada.
    @param modelo a inst�ncia da classe AgendaConsultavel a ser usada como
                  modelo.
    @throws Exception se o modelo for null.
    */
    public AgendaConsultavel (AgendaConsultavel modelo) throws Exception
    {
        super (modelo);
    }
    
    /**
    Clona uma agenda.
    Produz e resulta uma c�pia da agenda representada pela inst�ncia
    � qual o m�todo for aplicado.
    @return a c�pia da agenda representada pela inst�ncia � qual
            o m�todo for aplicado.
    */
    public Object clone ()
    {
        AgendaConsultavel copia=null;

        try
        {
            copia = new AgendaConsultavel (this);
        }
        catch (Exception e)
        {}

        return copia;
    }
}
