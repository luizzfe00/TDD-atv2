import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarefaTest {

    private Tarefa tarefa1;
    private Tarefa tarefa2;

    @BeforeEach
    public void setup() {
        tarefa1 = new Tarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", LocalDate.of(2024,3,1), Prioridade.ALTA);
        tarefa2 = new Tarefa("Academia", "Ir a academia as 19:00 horas", LocalDate.of(2024,3,2), Prioridade.BAIXA);
    }

    @Test
    public void testGetTitulo() {
        String titulo1 = tarefa1.getTitulo();
        String titulo2 = tarefa2.getTitulo();

        assertEquals(titulo1, "Atividade de vev");
        assertEquals(titulo2, "Academia");

    }

    @Test
    public void testGetDescricao() {
        String descricao1 = tarefa1.getDescricao();
        String descricao2 = tarefa2.getDescricao();

        assertEquals(descricao1, "Preciso fazer a atividade de vev até hoje a noite");
        assertEquals(descricao2, "Ir a academia as 19:00 horas");

    }

    @Test
    public void testGetDataVencimento() {
        LocalDate data1 = tarefa1.getDataVencimento();
        LocalDate data2 = tarefa2.getDataVencimento();

        assertEquals(data1, LocalDate.of(2024,3,1));
        assertEquals(data2, LocalDate.of(2024,3,2));

    }

    @Test
    public void testGetPrioridade() {
        Prioridade prioridade1 = tarefa1.getPrioridade();
        Prioridade prioridade2 = tarefa2.getPrioridade();

        assertEquals(prioridade1, Prioridade.ALTA);
        assertEquals(prioridade2, Prioridade.BAIXA);

    }

    @Test
    public void testSetTitulo() {
        tarefa1.setTitulo("Atividade de compila");
        tarefa2.setTitulo("Yoga");

        String titulo1 = tarefa1.getTitulo();
        String titulo2 = tarefa2.getTitulo();

        assertEquals(titulo1, "Atividade de compila");
        assertEquals(titulo2, "Yoga");

    }

    @Test
    public void testSetDescricao() {
        tarefa1.setDescricao("Preciso fazer a atividade de vev até amanhã");
        tarefa2.setDescricao("Ir a academia pela manhã");

        String descricao1 = tarefa1.getDescricao();
        String descricao2 = tarefa2.getDescricao();

        assertEquals(descricao1, "Preciso fazer a atividade de vev até amanhã");
        assertEquals(descricao2, "Ir a academia pela manhã");

    }

    @Test
    public void testSetDataVencimento() {

        LocalDate novaData1 = LocalDate.of(2024,3,2);
        LocalDate novaData2 = LocalDate.of(2024,3,4);

        tarefa1.setDataVencimento(novaData1);
        tarefa2.setDataVencimento(novaData2);

        LocalDate data1 = tarefa1.getDataVencimento();
        LocalDate data2 = tarefa2.getDataVencimento();

        assertEquals(data1, novaData1);
        assertEquals(data2, novaData2);

    }

    @Test
    public void testSetPrioridade() {
        tarefa1.setPrioridade(Prioridade.MEDIA);
        tarefa2.setPrioridade(Prioridade.ALTA);

        Prioridade prioridade1 = tarefa1.getPrioridade();
        Prioridade prioridade2 = tarefa2.getPrioridade();

        assertEquals(prioridade1, Prioridade.MEDIA);
        assertEquals(prioridade2, Prioridade.ALTA);

    }

    @Test
    public void testToString() {
        String conteudo = """
                            Título: Atividade de vev
                            Descrição: Preciso fazer a atividade de vev até hoje a noite
                            Data: 2024-03-01
                            Prioridade: ALTA
                            -------------------------\n
                            """;

        assertEquals(conteudo, tarefa1.toString());

    }
}


