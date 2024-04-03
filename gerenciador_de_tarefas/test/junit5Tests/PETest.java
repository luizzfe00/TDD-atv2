package junit5Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import vev.Gerenciador;
import vev.Tarefa;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testes PE")
public class PETest {

    private Gerenciador gerenciador;

    @BeforeEach
    public void setup() {
        this.gerenciador = new Gerenciador();
        this.gerenciador.criaTarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", "2024 3 1", "alta");
    }

    @Test
    @Tag("cria")
    @DisplayName("Criacao de tarefa valida")
    public void testCriaTarefa() {
        boolean status = this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "2024 04 20", "media");
        assertTrue(status);

    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com titulo vazio")
    public void testCriaTarefaTituloEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("", "Fazer exercicio a noite", "2024 04 20", "media");
        });

    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com titulo maior que o maximo")
    public void testCriaTarefaTituloBiggerMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio de recuperacao da informacao", "Fazer exercicio a noite", "2024 04 20", "media");
        });

    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com titulo nulo")
    public void testCriaTarefaTituloNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa(null, "Fazer exercicio a noite", "2024 04 20", "media");
        });

    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com descricao vazia")
    public void testCriaTarefaDescricaoEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", "", "2024 04 20", "media");
        });

    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com descricao maior que o maximo")
    public void testCriaTarefaDescricaoBiggerMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio",
                    "O sistema deve permitir que os usuários criem novas tarefas, inserindo informações como título, descrição, data de vencimento e prioridade.",
                    "2024 04 20", "media");
        });

    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com descricao nula")
    public void testCriaTarefaDescricaoNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", null, "2024 04 20", "media");
        });

    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com data fora do formato")
    public void testCriaTarefaDataNotFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "04 20 2024", "media");
        });

    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com data nula")
    public void testCriaTarefaDataNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", null, "media");
        });

    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com tipo prioridade inexistente")
    public void testCriaTarefaPrioridadeNotEnum() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "2024 04 20", "outro");
        });

    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com prioridade nula")
    public void testCriaTarefaPrioridadeNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "2024 04 20", null);
        });

    }

    @Test
    @Tag("atualiza")
    @DisplayName("Atualizacao de tarefa com titulo valido")
    public void testAtualizaTarefaTitulo() {
        boolean status = this.gerenciador.atualizaTarefa("1", "titulo", "teste");
        assertTrue(status);
    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com index fora do range")
    public void testAtualizaTarefaIndexOut() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.atualizaTarefa("2", "titulo",
                    "teste");
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com indice null")
    public void testAtualizaTarefaIndexNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa(null, "titulo",
                    "teste");
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com campo inexistente")
    public void testAtualizaTarefaCampoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "outro",
                    "teste");
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com campo nulo")
    public void testAtualizaTarefaCampoNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa("1", null,
                    "teste");
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com novo valor nulo")
    public void testAtualizaTarefaNovoValorNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "titulo",
                    null);
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com tamanho de titulo invalido")
    public void testAtualizaTarefaTituloInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "titulo",
                    "fazer exercicio de recuperacao da informacao");
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com descricao nula")
    public void testAtualizaTarefaDescricaoNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "descricao",
                    null);
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com tamanho de descricao invalida")
    public void testAtualizaTarefaDescricaoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "descricao",
                    "O sistema deve permitir que os usuários criem novas tarefas, inserindo informações como título, descrição, data de vencimento e prioridade.");
        });

    }

    @Test
    @Tag("atualiza")
    @DisplayName("Atualizacao de tarefa com descricao valida")
    public void testAtualizaTarefaDescricao() {
        boolean status = this.gerenciador.atualizaTarefa("1", "descricao", "teste");
        assertTrue(status);
    }

    @Test
    @Tag("atualiza")
    @DisplayName("Atualizacao de tarefa com data valida")
    public void testAtualizaTarefaData() {
        boolean status = this.gerenciador.atualizaTarefa("1", "data de vencimento", "2024 04 20");
        assertTrue(status);
    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com data invalida")
    public void testAtualizaTarefaDataInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "data de vencimento",
                    "04 20 2024");
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com data nula")
    public void testAtualizaTarefaDataNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "data de vencimento",
                    null);
        });

    }

    @Test
    @Tag("atualiza")
    @DisplayName("Atualizacao de tarefa com prioridade valida")
    public void testAtualizaTarefaPrioridade() {
        boolean status = this.gerenciador.atualizaTarefa("1", "prioridade", "media");
        assertTrue(status);

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com prioridade invalida")
    public void testAtualizaTarefaPrioridadeInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "prioridade",
                    "outro");
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao com prioridade nula")
    public void testAtualizaTarefaPrioridadeNull() {
        assertThrows(NullPointerException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "prioridade",
                    null);
        });

    }

    @Test
    @Tag("exclui")
    @DisplayName("Exclusao de tarefa valida")
    public void testExcluiTarefa() {
        ArrayList<Tarefa> tarefas = this.gerenciador.listaTarefas();
        System.out.println(tarefas.size());
        boolean status = this.gerenciador.excluiTarefa("1");
        assertTrue(status);

    }

    @Test
    @Tag("exclui_exception")
    @DisplayName("Exclusao de tarefa passando indece fora do range")
    public void testExcluiTarefaIndexOut() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.excluiTarefa("2");
        });

    }
}
