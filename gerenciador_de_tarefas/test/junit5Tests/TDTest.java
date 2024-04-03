package junit5Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import vev.Gerenciador;
import vev.Prioridade;
import vev.Tarefa;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testes TD")
public class TDTest {

    private Gerenciador gerenciador;

    @BeforeEach
    public void setup() {
        this.gerenciador = new Gerenciador();
        this.gerenciador.criaTarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", "2024 3 1", "alta");
    }

    @Test
    @Tag("cria")
    @DisplayName("Criacao de tarefa com prioridade alta")
    public void testCriaTarefaPrioridadeAlta() {
        boolean status = this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "2024 04 20", "alta");
        assertTrue(status);
    }

    @Test
    @Tag("cria")
    @DisplayName("Cricao de tarefa com prioridade media")
    public void testCriaTarefaPrioridadeMedia() {
        boolean status = this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "2024 04 20", "media");
        assertTrue(status);
    }

    @Test
    @Tag("cria")
    @DisplayName("Criacao de tarefa com prioridade baixa")
    public void testCriaTarefaPrioridadeBaixa() {
        boolean status = this.gerenciador.criaTarefa("fazer exercicio", "Fazer exercicio a noite", "2024 04 20", "baixa");
        assertTrue(status);
    }

    @Test
    @Tag("cria_exception")
    @DisplayName("Criacao de tarefa com titulo invalido")
    public void testCriaTarefaTituloInvalido() {
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
    @DisplayName("Criacao de tarefa com descricao invalida")
    public void testCriaTarefaDescricaoInvalida() {
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
    @DisplayName("Criacao de tarefa com data invalida")
    public void testCriaTarefaDataInvalida() {
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
    @DisplayName("Criacao d etarefa com prioridade invalida")
    public void testCriaTarefaPrioridadeInvalida() {
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
        boolean status = this.gerenciador.atualizaTarefa("1", "data de vencimento", "2025 05 10");
        assertTrue(status);
    }

    @Test
    @Tag("atualiza")
    @DisplayName("Atualizacao de tarefa com prioridade media")
    public void testAtualizaTarefaPrioridadeMedia() {
        boolean status = this.gerenciador.atualizaTarefa("1", "prioridade", "media");
        assertTrue(status);
    }

    @Test
    @Tag("atualiza")
    @DisplayName("Atualizacao de tarefa com prioridade baixa")
    public void testAtualizaTarefaPrioridadeBaixa() {
        boolean status = this.gerenciador.atualizaTarefa("1", "prioridade", "baixa");
        assertTrue(status);
    }

    @Test
    @Tag("atualiza")
    @DisplayName("Atualizacao de tarefa com prioridade alta")
    public void testAtualizaTarefaPrioridadeAlta() {
        boolean status = this.gerenciador.atualizaTarefa("1", "prioridade", "alta");
        assertTrue(status);
    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa passsando indice fora do range")
    public void testAtualizaTarefaIndexOut() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.gerenciador.atualizaTarefa("2", "titulo",
                    "teste");
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao d etarefa passando campo inexistente")
    public void testAtualizaTarefaCampoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "outro",
                    "teste");
        });

    }

    @Test
    @Tag("atualiza_exception")
    @DisplayName("Atualizacao de tarefa com titulo invalido")
    public void testAtualizaTarefaTituloInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.gerenciador.atualizaTarefa("1", "titulo",
                    "fazer exercicio de recuperacao da informacao");
        });

    }

    @Test
    @Tag("exclui")
    @DisplayName("Exclusao tarefa valida")
    public void testExcluiTarefa() {
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

    @Test
    @Tag("lista")
    @DisplayName("Listagem de tarefas")
    public void testListaTarefas() {
        ArrayList<Tarefa> tarefas = this.gerenciador.listaTarefas();

        Tarefa tarefa1 = new Tarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", LocalDate.of(2024,3,1), Prioridade.ALTA);
        assertEquals(tarefas.get(0), tarefa1);
    }

    @Test
    @Tag("lista")
    @DisplayName("Listagem de tarefas sem tarefas")
    public void testListaTarefasVazia() {
        this.gerenciador.excluiTarefa("1");
        ArrayList<Tarefa> tarefas = this.gerenciador.listaTarefas();
        ArrayList<Tarefa> resultado = new ArrayList<>();

        assertEquals(tarefas, resultado);
    }
}
