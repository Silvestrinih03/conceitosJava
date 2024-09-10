public class Horario
{
    // Atributos
    private byte hora, min, seg;

    // Validar hora
    private static boolean isValida(byte hora, byte min, byte seg)
    {
        if (hora<0 || hora>24) return false;
        if (min<0 || min>60) return false;
        if (seg<0 || seg>60) return false;

        return true;
    }

    // construtor com parâmetros H, M e S
    public Horario(byte H, byte M, byte S) throws Exception
    {
        if (!Horario.isValida(H, M, S)) 
            throw new Exception ("Hora inválida!");
            
        this.hora = H;
        this.min = M;
        this.seg = S;
    }

    // getters para retornar atributos
    public byte getHora()
    {
        return this.hora;
    }

    public byte getMin()
    {
        return this.min;
    }
    public byte getSeg()
    {
        return this.seg;
    }

    // setters para alterar atributos
    public void setHora(byte hora) throws Exception
    {
        if (!Horario.isValida(hora, this.min, this.seg))
        {
            throw new Exception("Hora inválida!");
        }
        this.hora = hora;
    }

    public void setMin(byte min) throws Exception
    {
        if (!Horario.isValida(this.hora, min, this.seg)){
            throw new Exception ("Minuto invalido!");
        }
        this.min = min;
    }
    public void setSeg(byte seg) throws Exception
    {
        if (!Horario.isValida(this.hora, this.min, seg))
            throw new Exception("Segundo inválido!");
        this.seg = seg;
    }




    // toString e equals
    // public void adiante (int qtdSegundos) throw Exception
    // {
    //     // dar exceção se qtdSegundos<=0
    //     // ...
    // }
    // public void atrase (int qtdSegundos) throw Exception
    // {
    //     // dar exceção se qtdSegundos<=0
    //     // ...
    // }
    // public int diferença (Horario h) throws Exception
    // {
    //     // dar exceção se h for null
    //     // retornar quantos segundo há entre this e h
    // }
}
    