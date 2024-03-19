package functionalTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vev.Gerenciador;
import vev.Prioridade;
import vev.Tarefa;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TDTest {

    private Gerenciador gerenciador;

    @BeforeEach
    public void setup() {
        this.gerenciador = new Gerenciador();
        this.gerenciador.criaTarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", "2024 3 1", "alta");
    }

    @Test
    public void testCriaTarefaPrioridadeAlta() {
        boolean status = this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "2024 04 20", "alta");
        assertTrue(status);
    }

    @Test
    public void testCriaTarefaPrioridadeMedia() {
        boolean status = this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "2024 04 20", "media");
        assertTrue(status);
    }

    @Test
    public void testCriaTarefaPrioridadeBaixa() {
        boolean status = this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "2024 04 20", "baixa");
        assertTrue(status);
    }

    @Test
    public void testCriaTarefaTituloInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio de recuperacao da informacao", "Fazer exercicio a noite", "2024 04 20", "media");
        });

    }

    @Test
    public void testCriaTarefaTituloNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa(null, "Fazer exercicio a noite", "2024 04 20", "media");
        });

    }

    @Test
    public void testCriaTarefaDescricaoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio",
                    "O sistema deve permitir que os usuários criem novas tarefas, inserindo informações como título, descrição, data de vencimento e prioridade.",
                    "2024 04 20", "media");
        });

    }

    @Test
    public void testCriaTarefaDescricaoNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", null, "2024 04 20", "media");
        });

    }

    @Test
    public void testCriaTarefaDataInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "04 20 2024", "media");
        });

    }

    @Test
    public void testCriaTarefaDataNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", null, "media");
        });

    }

    @Test
    public void testCriaTarefaPrioridadeInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "2024 04 20", "outro");
        });

    }

    @Test
    public void testCriaTarefaPrioridadeNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "2024 04 20", null);
        });

    }

    @Test
    public void testAtualizaTarefaTitulo() {
        boolean status = this.gerenciador.atualizaTarefa("1", "titulo", "teste");
        assertTrue(status);
    }

    @Test
    public void testAtualizaTarefaDescricao() {
        boolean status = this.gerenciador.atualizaTarefa("1", "descricao", "teste");
        assertTrue(status);
    }

    @Test
    public void testAtualizaTarefaData() {
        boolean status = this.gerenciador.atualizaTarefa("1", "data de vencimento", "2025 05 10");
        assertTrue(status);
    }

    @Test
    public void testAtualizaTarefaPrioridadeMedia() {
        boolean status = this.gerenciador.atualizaTarefa("1", "prioridade", "media");
        assertTrue(status);
    }

    @Test
    public void testAtualizaTarefaPrioridadeBaixa() {
        boolean status = this.gerenciador.atualizaTarefa("1", "prioridade", "baixa");
        assertTrue(status);
    }

    @Test
    public void testAtualizaTarefaPrioridadeAlta() {
        boolean status = this.gerenciador.atualizaTarefa("1", "prioridade", "alta");
        assertTrue(status);
    }

    @Test
    public void testAtualizaTarefaIndexOut() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.atualizaTarefa("2", "titulo",
                    "teste");
        });

    }

    @Test
    public void testAtualizaTarefaCampoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "outro",
                    "teste");
        });

    }

    @Test
    public void testAtualizaTarefaTituloInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "titulo",
                    "fazer exercicio de recuperacao da informacao");
        });

    }

    @Test
    public void testExcluiTarefa() {
        boolean status = this.gerenciador.excluiTarefa("1");
        assertTrue(status);

    }

    @Test
    public void testExcluiTarefaIndexOut() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.excluiTarefa("2");
        });

    }

    @Test
    public void testListaTarefas() {
        ArrayList<Tarefa> tarefas = this.gerenciador.listaTarefas();

        Tarefa tarefa1 = new Tarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", LocalDate.of(2024,3,1), Prioridade.ALTA);
        assertEquals(tarefas.get(0), tarefa1);
    }

    @Test
    public void testListaTarefasVazia() {
        this.gerenciador.excluiTarefa("1");
        ArrayList<Tarefa> tarefas = this.gerenciador.listaTarefas();
        ArrayList<Tarefa> resultado = new ArrayList<>();

        assertEquals(tarefas, resultado);
    }
}
