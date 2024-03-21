package functionalTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vev.Gerenciador;
import vev.Tarefa;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PETest {

    private Gerenciador gerenciador;

    @BeforeEach
    public void setup() {
        this.gerenciador = new Gerenciador();
        this.gerenciador.criaTarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", "2024 3 1", "alta");
    }

    @Test
    public void testCriaTarefa() {
        boolean status = this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "2024 04 20", "media");
        assertTrue(status);

    }

    @Test
    public void testCriaTarefaTituloEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("", "Fazer exercicio a noite", "2024 04 20", "media");
        });

    }

    @Test
    public void testCriaTarefaTituloBiggerMax() {
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
    public void testCriaTarefaDescricaoEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", "", "2024 04 20", "media");
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
    public void testCriaTarefaDescricaoNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", null, "2024 04 20", "media");
        });

    }

    @Test
    public void testCriaTarefaDataNotFormat() {
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
    public void testCriaTarefaPrioridadeNotEnum() {
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
    public void testAtualizaTarefaIndexOut() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.atualizaTarefa("2", "titulo",
                    "teste");
        });

    }

    @Test
    public void testAtualizaTarefaIndexNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa(null, "titulo",
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
    public void testAtualizaTarefaCampoNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa("1", null,
                    "teste");
        });

    }

    @Test
    public void testAtualizaTarefaNovoValorNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "titulo",
                    null);
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
    public void testAtualizaTarefaDescricaoNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "descricao",
                    null);
        });

    }

    @Test
    public void testAtualizaTarefaDescricaoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "descricao",
                    "O sistema deve permitir que os usuários criem novas tarefas, inserindo informações como título, descrição, data de vencimento e prioridade.");
        });

    }

    @Test
    public void testAtualizaTarefaDescricao() {
        boolean status = this.gerenciador.atualizaTarefa("1", "descricao", "teste");
        assertTrue(status);
    }

    @Test
    public void testAtualizaTarefaData() {
        boolean status = this.gerenciador.atualizaTarefa("1", "data de vencimento", "2024 04 20");
        assertTrue(status);
    }

    @Test
    public void testAtualizaTarefaDataInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "data de vencimento",
                    "04 20 2024");
        });

    }

    @Test
    public void testAtualizaTarefaDataNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "data de vencimento",
                    null);
        });

    }

    @Test
    public void testAtualizaTarefaPrioridade() {
        boolean status = this.gerenciador.atualizaTarefa("1", "prioridade", "media");
        assertTrue(status);

    }

    @Test
    public void testAtualizaTarefaPrioridadeInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "prioridade",
                    "outro");
        });

    }

    @Test
    public void testAtualizaTarefaPrioridadeNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "prioridade",
                    null);
        });

    }

    @Test
    public void testExcluiTarefa() {
        ArrayList<Tarefa> tarefas = this.gerenciador.listaTarefas();
        System.out.println(tarefas.size());
        boolean status = this.gerenciador.excluiTarefa("1");
        assertTrue(status);

    }

    @Test
    public void testExcluiTarefaIndexOut() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.excluiTarefa("2");
        });

    }

}
