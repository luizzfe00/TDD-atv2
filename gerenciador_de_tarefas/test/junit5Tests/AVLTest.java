package junit5Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import vev.Gerenciador;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testes AVL")
public class AVLTest {

    private Gerenciador gerenciador;

    @BeforeEach
    public void setup() {
        this.gerenciador = new Gerenciador();
        this.gerenciador.criaTarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", "2024 3 1", "alta");
    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com título vazio")
    public void testCriaTarefaTituloEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("", "Fazer exercicio a noite", "2024 04 20", "media");
        });

    }

    @Test
    @Tag("cria")
    @DisplayName("Criacao de tarefa com um titulo minimo")
    public void testCriaTarefaTituloMin() {
        boolean status = this.gerenciador.criaTarefa("T", "Fazer exercicio a noite", "2024 04 20", "media");
        assertTrue(status);

    }

    @Test
    @Tag("cria")
    @DisplayName("Criacao de tarefa com um titulo maximo")
    public void testCriaTarefaTituloMax() {
        boolean status =this.gerenciador.criaTarefa("fazer exercicio de recuperacao", "Fazer exercicio a noite", "2024 04 20", "media");
        assertTrue(status);

    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com um titulo maior que o maximo")
    public void testCriaTarefaTituloBiggerMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.criaTarefa("fazer exercicio de recuperacao da informacao", "fazer exercicio de recuperacao da informacao", "2024 04 20", "media");
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
    @Tag("cria")
    @DisplayName("Criacao de tarefa com descricao maxima")
    public void testCriaTarefaDescricaoMax() {
        boolean status = this.gerenciador.criaTarefa("fazer exercicio",
                "O sistema deve permitir que os usuários criem novas tarefas, inserindo informações como título, desc",
                "2024 04 20", "media");
        assertTrue(status);

    }

    @Test
    @Tag("cria")
    @DisplayName("Criacao d etarefa com descricao minima")
    public void testCriaTarefaDescricaoMin() {
        boolean status = this.gerenciador.criaTarefa("fazer exercicio", "o", "2024 04 20", "media");
        assertTrue(status);

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
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com titulo vazio")
    public void testAtualizaTarefaTituloEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "titulo", "");
        });
    }

    @Test
    @Tag("atualiza")
    @DisplayName("Atualizacao de tarefa com titulo minimo")
    public void testAtualizaTarefaTituloMin() {
        boolean status = this.gerenciador.atualizaTarefa("1", "titulo", "t");
        assertTrue(status);
    }

    @Test
    @Tag("atualiza")
    @DisplayName("Atualizacao de tarefa com titulo maximo")
    public void testAtualizaTarefaTituloMax() {
        boolean status = this.gerenciador.atualizaTarefa("1", "titulo", "fazer exercicio de recuperacao");
        assertTrue(status);
    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com titulo maior que o maximo")
    public void testAtualizaTarefaTituloBiggerMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "titulo",
                    "fazer exercicio de recuperacao da informacao");
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa passando indice menor que o minimo")
    public void testAtualizaTarefaIndexOutMin() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.atualizaTarefa("0", "titulo",
                    "fazer exercicio");
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa passando indice maior que o maximo")
    public void testAtualizaTarefaIndexOutMax() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.atualizaTarefa("2", "titulo",
                    "fazer exercicio");
        });

    }

    @Test
    @Tag("exclui_exception")
    @DisplayName("Exclusao de tarefa passando indice menor que o minimo")
    public void testExcluiTarefaIndexOutMin() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.excluiTarefa("0");
        });

    }

    @Test
    @Tag("exclui_exception")
    @DisplayName("Exclusao de tarefa passando indice dos extremos")
    public void testExcluiTarefaExtremo() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.excluiTarefa("1");
        });

    }

    @Test
    @Tag("exclui_exception")
    @DisplayName("Exclusao de tarefa passando indice maior que o maximo")
    public void testExcluiTarefaIndexOutMax() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.excluiTarefa("2");
        });

    }
}
