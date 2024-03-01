import org.junit.jupiter.api.Test;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TarefaTest {

    private Tarefa tarefa1;
    private Tarefa tarefa2;

    @Before
    public void setup() {
        tarefa1 = new Tarefa("Atividade de vev", "Preciso fazer a atividade de vev atá hoje a noite", "01/03/2024", Prioridade.ALTA);
        tarefa2 = new Tarefa("Academia", "Ir a academia as 19:00 horas", "02/03/2024", Prioridade.BAIXA);
    }

    @Test
    public void testGetTitulo() {
        titulo1 = tarefa1.getTitulo();
        titulo2 = tarefa2.getTitulo();

        assertEquals(titulo1, "Atividade de vev");
        assertEquals(titulo2, "Academia");

    }

}


