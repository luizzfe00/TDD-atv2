import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GerenciadorDeTarefasTest {

    private Tarefa tarefa1;
    private Tarefa tarefa2;

    @BeforeEach
    public void setup() {
        tarefa1 = new Tarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", "01/03/2024", Prioridade.ALTA);
        tarefa2 = new Tarefa("Academia", "Ir a academia as 19:00 horas", "02/03/2024", Prioridade.BAIXA);
    }

    @Test
    public void testCriaTarefa() {
        assertDoesNotThrow(() -> {
            new Tarefa("Contas", "Pagar as contas segunda", "04/03/2024", Prioridade.ALTA);
        });
    }
}
