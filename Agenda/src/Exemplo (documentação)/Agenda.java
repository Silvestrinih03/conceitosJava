package agenda;
import  java.util.regex.*;

/**
A classe Agenda representa uma simples agenda de telefone implemementada tendo
como base dois vetores que armazenam, respectivamente, os nomes e os telefones
dos contatos da agenda.
Inst�ncias desta classe permitem a reliza��o das opera��es b�sicas de uma agenda.
Nela encontramos, por exemplo, m�todos para incluir, excluir e listar
contatos.
@author Andr� Lu�s dos Reis Gomes de Carvalho.
@since 2000.
*/
public class Agenda implements Cloneable
{
    private static final String  regExNom  =
    "^[A-Z][a-z]*(?: (?:[A-Z]|[a-z])[a-z]*)*$";

    private static final Pattern padraoNom =
    Pattern.compile (Agenda.regExNom);

    private static final String  regExTel =
    "^(?:\\([0-9]{2}\\) )?9?[0-9]{4}-[0-9]{4}$";

    private static final Pattern padraoTel =
    Pattern.compile (Agenda.regExTel);

    /**
    Valida o nome de um contato.
    Verifica se o nome fornecido como par�metro � um nome v�lido,
    lan�ando exce��es, caso incorretudes sejam detectadas.
    @param nom o nome a ser validado.
    @throws Exception se n�o for fornecido um nome, ou se o nome fornecido
                      n�o parecer ser um nome correto.
    */
    protected static void valideNome (String nom) throws Exception
    {
        if (nom==null)
            throw new Exception ("Nome nao fornecido");

        if (!Agenda.padraoNom.matcher(nom).matches())
            throw new Exception ("Nome invalido");
    }

    /**
    Valida o telefone de um contato.
    Verifica se o n�mero de telefone fornecido � um n�mero
    nacional v�lido, lan�ando exce��es, caso incorretudes sejam
    detectadas.
    @param tel o telefone a ser validado.
    @throws Exception se n�o for fornecido um telefone, ou se o telefone
                      fornecido n�o parecer ser um telefone correto.
    */
    protected static void valideTelefone (String tel) throws Exception
    {
        if (tel==null)
            throw new Exception ("Telefone nao fornecido");

        if (!Agenda.padraoTel.matcher(tel).matches())
            throw new Exception ("Telefone invalido");
    }

    /**
    Expressa, em cada instante, a quantidade de contatos
    armazenados na agenda.
    */
    protected int qtdContatos=0;

    /**
    Mant�m armazenados os nomes dos contatos armazenados
    na agenda.
    */
    protected String[] nome;

    /**
    Mant�m armazenados os telefones dos contatos armazenados
    na agenda.
    */
    protected String[] telefone;

    /**
    Localiza um nome dado na agenda.
    Procura um contato na agenda, pelo m�todo da busca sequencial,
    resultando um n�mero inteiro negativo, quando o nome
    procurado n�o tiver sido encontrado, ou um numero inteiro
    positivo, quando o nome procurado tiver sido encontrado.
    @param nom o nome a ser procurado.
    @return um inteiro ao qual se deve dar a seguinte interpreta��o:
            <ol>
             <li>
              Um inteiro i negativo � retornado quando o nome
              procurado n�o foi encontrado, mas, caso ele fosse ser
              inserido, para manter os nomes da agenda em ordem
              alfab�tica, o local apropriado para a inser��o seria
              a posi��o -i-1.
             </li>
             <li>
              Um inteiro i positivo � retornado quando o nome
              procurado foi encontrado na posi��o i-1.
             </li>
            </ol>
    */
    protected int ondeEsta (String nom)
    {
        int pos;

        for (pos=0; pos<this.qtdContatos; pos++)
            if (nom.equals(this.nome[pos]))
                return pos+1;

        return -(pos+1);
    }

    /**
    Constroi uma nova inst�ncia da classe Agenda.
    Para tanto, deve ser fornecido um inteiro que ser� utilizado
    como capacidade da inst�ncia rec�m criada.
    @param cap o n�mero inteiro a ser utilizado como capacidade.
    @throws Exception se a capacidade for negativa ou zero.
    */
    public Agenda (int cap)
                   throws Exception
    {
        if (cap <= 0)
            throw new Exception ("Capacidade invalida");

        this.nome     = new String [cap];
        this.telefone = new String [cap];
    }

    /**
    Inclui um novo contato em uma agenda.
    Acrescenta um contato com o nome e telefone fornecidos na inst�ncia
    � qual este m�todo for aplicado.
    @param nom o nome do novo contato.
    @param tel o telefone do novo contato.
    @throws Exception se n�o for fornecido um nome, ou se o nome fornecido
                      n�o parecer ser um nome correto, ou se n�o for fornecido
                      um telefone, ou se o telefone fornecido n�o parecer ser
                      um telefone correto, ou se a agenda estiver cheia, ou
                      ainda se o nome fornecido j� estiver cadastrado.
    */
    public void registreContato (String nom,
                                 String tel)
                                 throws Exception
    {
        if (this.qtdContatos == this.nome.length)
            throw new Exception ("Agenda cheia");

        Agenda.valideNome     (nom);
        Agenda.valideTelefone (tel);

        int posicao = this.ondeEsta (nom);

        if (posicao > 0)
            throw new Exception ("Nome ja registrado");

        posicao = (-posicao)-1;

        /* 
           deslocando 1 posicao para frente todos os
           elementos do vetor this.nome e this.telefone,
           da posicao onde vou inserir um novo contato,
           para frente
        */
        for (int pos=this.qtdContatos-1; pos>=posicao; pos--)
        {
            this.nome     [pos+1] = this.nome     [pos];
            this.telefone [pos+1] = this.telefone [pos];
        }

        this.nome     [posicao] = nom;
        this.telefone [posicao] = tel;

        this.qtdContatos++; // aumentando a quantidade de contatos armazenados
    }

    /**
    Remove um contato, dado seu nome.
    Exclui da inst�ncia � qual este m�todo for aplicado o  contato
    cujo nome foi fornecido.
    @param nom o nome do contato a ser descartado.
    @throws Exception se n�o for fornecido um nome, ou se o nome fornecido
                      n�o parecer ser um nome correto, ou se a agenda
                      estiver vazia, ou ainda se a agenda n�o contiver um
                      contato com o nome fornecido.
    */
    public void descarteContato (String nom)
                                 throws Exception
    {
        if (this.qtdContatos == 0)
            throw new Exception ("Agenda vazia");

        Agenda.valideNome (nom);

        if (!Agenda.padraoNom.matcher(nom).matches())
            throw new Exception ("Nome invalido");

        int posicao = this.ondeEsta (nom);

        if (posicao < 0)
            throw new Exception ("Nome inexistente");

        posicao--;

        int pos;

        for (pos = posicao; pos < this.qtdContatos - 1; pos++)
        {
            this.nome     [pos] = this.nome     [pos+1];
            this.telefone [pos] = this.telefone [pos+1];
        }

        this.nome     [pos] = null;
        this.telefone [pos] = null;

        this.qtdContatos--;
    }

    /**
    Obtem o nome do contato com n�mero de ordem dado.
    Resulta o nome do contato cujo n�mero de ordem foi fornecido.
    @return o nome do contato desejado
    @throws Exception quando a agenda estiver vazia ou ent�o quando
                      o n�mero de ordem fornecido estiver fora dos
                      limites
    */
    public String getNome (int pos) throws Exception
    {
        if (this.qtdContatos == 0)
            throw new Exception ("Agenda vazia");

        if (pos < 0 || pos >= this.qtdContatos)
            throw new Exception ("Nome fora dos limites");

        return this.nome [pos];
    }

    /**
    Obtem o telefone do contato com n�mero de ordem dado.
    Resulta o telefone do contato cujo n�mero de ordem foi fornecido.
    @return o telefone do contato desejado
    @throws Exception quando a agenda estiver vazia ou ent�o quando
                      o n�mero de ordem fornecido estiver fora dos
                      limites
    */
    public String getTelefone (int pos) throws Exception
    {
        if (this.qtdContatos == 0)
            throw new Exception ("Agenda vazia");

        if (pos < 0 || pos >= this.qtdContatos)
            throw new Exception ("Telefone fora dos limites");

        return this.telefone [pos];
    }

    /**
    Obtem a capacidade de uma agenda.
    Resulta a capacidade da inst�ncia � qual este m�todo for aplicado.
    @return a capacidade da agenda chamante do m�todo.
    */
    public int getCapacidade ()
    {
        return this.nome.length;
    }

    /**
    Obtem a quantidade de contatos cadastrados em uma agenda.
    Resulta a quantidade de contatos armazenados na inst�ncia � qual este
    m�todo for aplicado.
    @return a quantidade de contatos da agenda chamante do m�todo.
    */
    public int getQtdContatos ()
    {
        return this.qtdContatos;
    }

    /**
    Verifica a presen�a de um contato em uma agenda.
    Resulta true, caso um contato com o nome fornecido estiver
    cadastrado na inst�ncia � qual este m�todo for aplicado, ou false,
    caso contr�rio.
    @return a indica��o da presen�a na agenda do contato procurado.
    */
    public boolean haRegistroDoContato (String nom)
    {
        return this.ondeEsta(nom)>0;
    }

    /**
    Gera uma representa��o textual de todo conte�do da agenda.
    Produz e resulta um String com todos os nomes e telefones contidos
    na agenda.
    @return um String contendo todo o conte�do da agenda.
    */
    public String toString ()
    {
        String ret = "";

        for (int pos=0; pos<this.qtdContatos; pos++)
            ret += this.nome[pos] + " (" + this.telefone[pos] + ")\n";

        return ret;
    }

    /**
    Verifica a igualdade entre duas agendas.
    Verifica se o Object fornecido como par�metro representa uma
    agenda igual �quela representada pela inst�ncia � qual este
    m�todo for aplicado, resultando true em caso afirmativo,
    ou false, caso contr�rio.
    @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
            for aplicado.
    @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
            m�todo representarem agendas iguais, ou false, caso contr�rio.
    */
    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Agenda agenda = (Agenda)obj;

        if (this.qtdContatos != agenda.qtdContatos)
            return false;

        for (int pos=0; pos<this.qtdContatos; pos++)
            if (!this.nome    [pos].equals(agenda.nome    [pos]) ||
                !this.telefone[pos].equals(agenda.telefone[pos]))
                return false;

        return true;
    }

    /**
    Calcula o c�digo de espalhamento (ou c�digo de hash) de uma agenda.
    Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
    hashcode) da agenda representada pela inst�ncia � qual o m�todo for aplicado.
    @return o c�digo de espalhamento da agenda chamante do m�todo.
    */
    public int hashCode ()
    {
        int ret = 666;

        ret = 13*ret + this.qtdContatos;

        for (int pos=0; pos<this.qtdContatos; pos++)
        {
            ret = 13*ret + this.nome    [pos].hashCode();
            ret = 13*ret + this.telefone[pos].hashCode();
        }

        return ret;
    }

    /**
    Constroi uma c�pia da inst�ncia da classe Agenda dada.
    Para tanto, deve ser fornecida uma instancia da classe Agenda para ser
    utilizada como modelo para a constru��o da nova inst�ncia criada.
    @param modelo a inst�ncia da classe Agenda a ser usada como modelo.
    @throws Exception se o modelo for null.
    */
    public Agenda (Agenda modelo)
                   throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo nao fornecido");

        this.nome     = new String [modelo.nome    .length];
        this.telefone = new String [modelo.telefone.length];

        this.qtdContatos = modelo.qtdContatos;

        for (int pos=0; pos<this.qtdContatos; pos++)
        {
            this.nome    [pos] = modelo.nome    [pos];
            this.telefone[pos] = modelo.telefone[pos];
        }
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
        Agenda copia=null;

        try
        {
            copia = new Agenda (this);
        }
        catch (Exception e)
        {}

        return copia;
    }
}
