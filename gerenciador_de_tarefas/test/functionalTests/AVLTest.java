package functionalTests;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import vev.Gerenciador;
import vev.Tarefa;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AVLTest {

    private Gerenciador gerenciador;

    @BeforeEach
    public void setup() {
        this.gerenciador = new Gerenciador();
        this.gerenciador.criaTarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", "2024 3 1", "alta");
    }

    @Test
    public void testCriaTarefaTituloEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("", "Fazer exercicio a noite", "2024 04 20", "media");
        });

    }

    @Test
    public void testCriaTarefaTituloMin() {
        boolean status = this.gerenciador.criaTarefa("T", "Fazer exercicio a noite", "2024 04 20", "media");
        assertTrue(status);

    }

    @Test
    public void testCriaTarefaTituloMax() {
        boolean status =this.gerenciador.criaTarefa("fazer exercicio de recuperacao", "Fazer exercicio a noite", "2024 04 20", "media");
        assertTrue(status);

    }

    @Test
    public void testCriaTarefaTituloBiggerMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio de recuperacao da informacao", "fazer exercicio de recuperacao da informacao", "2024 04 20", "media");
        });

    }

    @Test
    public void testCriaTarefaDescricaoBiggerMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio",
                    "O sistema deve permitir que os usuários criem novas tarefas, inserindo informações como título, descrição, data de vencimento e prioridade.",
                    "2024 04 20", "media");
        });

    }

    @Test
    public void testCriaTarefaDescricaoMax() {
        boolean status = this.gerenciador.criaTarefa("fazer exercicio",
                    "O sistema deve permitir que os usuários criem novas tarefas, inserindo informações como título, desc",
                    "2024 04 20", "media");
        assertTrue(status);

    }

    @Test
    public void testCriaTarefaDescricaoMin() {
        boolean status = this.gerenciador.criaTarefa("fazer exercicio", "o", "2024 04 20", "media");
        assertTrue(status);

    }

    @Test
    public void testCriaTarefaDescricaoEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", "", "2024 04 20", "media");
        });

    }

    @Test
    public void testAtualizaTarefaTituloEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "titulo", "");
        });
    }

    @Test
    public void testAtualizaTarefaTituloMin() {
        boolean status = this.gerenciador.atualizaTarefa("1", "titulo", "t");
        assertTrue(status);
    }

    @Test
    public void testAtualizaTarefaTituloMax() {
        boolean status = this.gerenciador.atualizaTarefa("1", "titulo", "fazer exercicio de recuperacao");
        assertTrue(status);
    }

    @Test
    public void testAtualizaTarefaTituloBiggerMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "titulo",
                    "fazer exercicio de recuperacao da informacao");
        });

    }

    @Test
    public void testAtualizaTarefaIndexOutMin() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.atualizaTarefa("0", "titulo",
                    "fazer exercicio");
        });

    }

    @Test
    public void testAtualizaTarefaIndexOutMax() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.atualizaTarefa("2", "titulo",
                    "fazer exercicio");
        });

    }

    @Test
    public void testExcluiTarefaIndexOutMin() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.excluiTarefa("0");
        });

    }

    @Test
    public void testExcluiTarefaExtremo() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.excluiTarefa("1");
        });

    }

    @Test
    public void testExcluiTarefaIndexOutMax() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.excluiTarefa("2");
        });

    }
}
