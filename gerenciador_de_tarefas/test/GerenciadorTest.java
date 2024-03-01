import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorTest {

    private Gerenciador gerenciador;

    @BeforeEach
    public void setup() {
        this.gerenciador = new Gerenciador();
        this.gerenciador.criaTarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", "01/03/2024", Prioridade.ALTA);
        this.gerenciador.criaTarefa("Academia", "Ir a academia as 19:00 horas", "02/03/2024", Prioridade.BAIXA);
    }

    @Test
    public void testCriaTarefa() {
        boolean status = this.gerenciador.criaTarefa("Contas", "Pagar as contas segunda", "04/03/2024", Prioridade.ALTA);
        assertTrue(status);
    }

    @Test
    public void testAtualizaTarefa() {
        boolean status1 = this.gerenciador.atualizaTarefa("2", "titulo", "Yoga");
        boolean status2 = this.gerenciador.atualizaTarefa("2", "descricao", "ir segunda");
        boolean status3 = this.gerenciador.atualizaTarefa("2", "data de vencimento", "04/03/2024");
        boolean status4 = this.gerenciador.atualizaTarefa("2", "prioridade", "alta");

        assertTrue(status1);
        assertTrue(status2);
        assertTrue(status3);
        assertTrue(status4);
    }

    @Test
    public void testExcluiTarefa() {
        boolean status = this.gerenciador.excluiTarefa("1");

        assertTrue(status);
    }

    /**@Test
    public void testListaTarefas() {
        HashMap<String, Tarefa> tarefas = this.gerenciador.listaTarefas();


    }*/
}
