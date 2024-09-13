public class Horario {
    // Atributos
    private byte hora, min, seg;

    // Validar hora
    private static boolean isValida(byte hora, byte min, byte seg) {
        if (hora < 0 || hora > 23)
            return false;
        if (min < 0 || min > 59)
            return false;
        if (seg < 0 || seg > 59)
            return false;

        return true;
    }

    // construtor com parâmetros H, M e S
    public Horario(byte H, byte M, byte S) throws Exception {
        if (!Horario.isValida(H, M, S))
            throw new Exception("Hora inválida!");

        this.hora = H;
        this.min = M;
        this.seg = S;
    }

    // getters para retornar atributos
    public byte getHora() {
        return this.hora;
    }

    public byte getMin() {
        return this.min;
    }

    public byte getSeg() {
        return this.seg;
    }

    // setters para alterar atributos
    public void setHora(byte hora) throws Exception {
        if (!Horario.isValida(hora, this.min, this.seg)) {
            throw new Exception("Hora inválida!");
        }
        this.hora = hora;
    }

    public void setMin(byte min) throws Exception {
        if (!Horario.isValida(this.hora, min, this.seg)) {
            throw new Exception("Minuto invalido!");
        }
        this.min = min;
    }

    public void setSeg(byte seg) throws Exception {
        if (!Horario.isValida(this.hora, this.min, seg))
            throw new Exception("Segundo inválido!");
        this.seg = seg;
    }

    public void trasformarEmHora(int totalSegundos) {
        totalSegundos = totalSegundos % (24 * 3600);

        if (totalSegundos < 0) {
            totalSegundos += 24 * 3600;
        }

        this.hora = (byte) (totalSegundos / 3600);
        this.min = (byte) ((totalSegundos % 3600) / 60);
        this.seg = (byte) (totalSegundos % 60);
    }

    // Pra frenteeeeee
    public void adiante(int qtdSegundos) throws Exception {
        if (qtdSegundos <= 0)
            throw new Exception("Para adiantar você deve inserir um valor positivo maior que zero!");

        int totalSegundos = (this.hora * 3600) + (this.min * 60) + this.seg + qtdSegundos;

        trasformarEmHora(totalSegundos);

    }

    // Para trás!!!!!!
    public void atrase(int qtdSegundos) throws Exception {
        if (qtdSegundos <= 0)
            throw new Exception("A quantide de segundos deve ser maior que 0!");

        var totalSegundos = (this.hora * 3600) + (this.min * 60) + this.seg - qtdSegundos;

        trasformarEmHora(totalSegundos);
    }

    public int diferenca(Horario h) throws Exception {
        if (!isValida(h.hora, h.min, h.seg))
            throw new Exception("A hora fornecida é inválida!");

        var primeiroHorario = (h.hora * 3600) + (h.min * 60) + h.seg;

        var segundoHorario = (this.hora * 3600) + (this.min * 60) + this.seg;

        return Math.abs(primeiroHorario - segundoHorario);
    }
}

// var totalsegundos = qtdSegundos + this.seg;
// var novosegundo = totalsegundos % 60;
// int totalminutos = (this.min + (totalsegundos / 60));
// int novomin = totalminutos % 60;
// int novahora = (this.hora + (totalminutos / 60)) % 24;

// // if (!isValida((byte) novahora, (byte) novomin, (byte) novosegundo))
// throw new Exception("Você fez alguma cagada!!");
// else {
// s.seg = (byte) novosegundo;
// this.min = (byte) novomin;
// this.hora = (byte) novahora; // }