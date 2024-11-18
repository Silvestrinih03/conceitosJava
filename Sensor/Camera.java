import java.time.LocalDateTime; // Para trabalhar com data e hora
import java.time.format.DateTimeFormatter; // Para formatar a data e hora

public class Camera {
    private int numIdentificador; // Identificador da câmera

    // Construtor que inicializa o identificador
    public Camera(int identificador) {
        this.numIdentificador = identificador;
    }

    // Função fotografe que recebe um parâmetro String e imprime os detalhes
    public void fotografe(String descricao) {
        // Obtém o horário atual
        LocalDateTime horarioAtual = LocalDateTime.now();

        // Formata o horário em um formato legível
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String horarioFormatado = horarioAtual.format(formatter);

        // Simula a foto tirada, incluindo o horário e a descrição no canto inferior
        // direito
        System.out.println("Foto tirada pela câmera " + numIdentificador + ":");
        System.out.println("Descrição: " + descricao);
        System.out.println("Horário registrado (canto inferior direito): " + horarioFormatado);
    }

    // Método opcional para obter o identificador da câmera
    public int getNumIdentificador() {
        return this.numIdentificador;
    }
}
