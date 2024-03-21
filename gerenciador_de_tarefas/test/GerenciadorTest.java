import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vev.Gerenciador;
import vev.Prioridade;
import vev.Tarefa;


import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorTest {

    private Gerenciador gerenciador;

    @BeforeEach
    public void setup() {
        this.gerenciador = new Gerenciador();
        this.gerenciador.criaTarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", "2024 3 1", "alta");
        this.gerenciador.criaTarefa("Academia", "Ir a academia as 19:00 horas", "2024 3 2", "baixa");
        this.gerenciador.criaTarefa("Entrega trabalho", "Entregar trabalho de compila hoje", "2024 3 1", "alta");
        this.gerenciador.criaTarefa("Roupa", "Levar roupa na costureira", "2024 3 1", "media");
    }

    @Test
    public void testCriaTarefa() {
        boolean status = this.gerenciador.criaTarefa("Contas", "Pagar as contas segunda", "2024 3 4", "alta");
        assertTrue(status);
    }

    @Test
    public void testCriaTarefaNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa(null, "Pagar as contas segunda", "2024 3 4", "alta");
        });

        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa("Contas", null, "2024 3 4", "alta");
        });
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa("Contas", "Pagar as contas segunda", null, "alta");
        });
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa("Contas", "Pagar as contas segunda", "2024 3 4", null);
        });

    }

    @Test
    public void testAtualizaTarefa() {
        boolean status1 = this.gerenciador.atualizaTarefa("2", "titulo", "Yoga");
        boolean status2 = this.gerenciador.atualizaTarefa("2", "descricao", "ir segunda");
        boolean status3 = this.gerenciador.atualizaTarefa("2", "data de vencimento", "2024 3 4");
        boolean status4 = this.gerenciador.atualizaTarefa("2", "prioridade", "alta");

        assertTrue(status1);
        assertTrue(status2);
        assertTrue(status3);
        assertTrue(status4);
    }

    @Test
    public void testAtualizaTarefaNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa(null, "titulo", "Yoga");
        });
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa("2", null, "ir segunda");
        });
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa("2", "data de vencimento", null);
        });

    }

    @Test
    public void testAtualizaTarefaIllegal() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("2", "nome", "Yoga");
        });

    }

    @Test
    public void testExcluiTarefa() {
        boolean status = this.gerenciador.excluiTarefa("1");

        assertTrue(status);
    }

    @Test
    public void testExcluiTarefaNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.excluiTarefa(null);
        });

    }

    @Test
    public void testExcluiTarefaIndexOut() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.excluiTarefa("7");
        });

    }

    @Test
    public void testListaTarefas() {
        ArrayList<Tarefa> tarefas = this.gerenciador.listaTarefas();

        Tarefa tarefa1 = new Tarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", LocalDate.of(2024,3,1), Prioridade.ALTA);
        Tarefa tarefa2 = new Tarefa("Entrega trabalho", "Entregar trabalho de compila hoje", LocalDate.of(2024,3,1), Prioridade.ALTA);
        Tarefa tarefa3 = new Tarefa("Roupa", "Levar roupa na costureira", LocalDate.of(2024,3,1), Prioridade.MEDIA);
        Tarefa tarefa4 = new Tarefa("Academia", "Ir a academia as 19:00 horas", LocalDate.of(2024,3,2), Prioridade.BAIXA);


        assertEquals(tarefas.get(0), tarefa1);
        assertEquals(tarefas.get(1), tarefa2);
        assertEquals(tarefas.get(2), tarefa3);
        assertEquals(tarefas.get(3), tarefa4);
    }
}
