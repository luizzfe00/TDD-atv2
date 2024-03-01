import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarefaTest {

    private Tarefa tarefa1;
    private Tarefa tarefa2;

    @BeforeEach
    public void setup() {
        tarefa1 = new Tarefa("Atividade de vev", "Preciso fazer a atividade de vev até hoje a noite", "01/03/2024", Prioridade.ALTA);
        tarefa2 = new Tarefa("Academia", "Ir a academia as 19:00 horas", "02/03/2024", Prioridade.BAIXA);
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
        String data1 = tarefa1.getDataVencimento();
        String data2 = tarefa2.getDataVencimento();

        assertEquals(data1, "01/03/2024");
        assertEquals(data2, "02/03/2024");

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
        tarefa1.setDataVencimento("02/03/2024");
        tarefa2.setDataVencimento("04/03/2024");

        String data1 = tarefa1.getDataVencimento();
        String data2 = tarefa2.getDataVencimento();

        assertEquals(data1, "02/03/2024");
        assertEquals(data2, "04/03/2024");

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
}


