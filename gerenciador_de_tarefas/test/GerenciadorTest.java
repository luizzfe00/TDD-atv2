import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorTest {

    private Gerenciador gerenciador;

    @BeforeEach
    public void setup() {
        this.gerenciador = new Gerenciador();

    }

    @Test
    public void testCriaTarefa() {
        boolean status = this.gerenciador.criaTarefa("Contas", "Pagar as contas segunda", "04/03/2024", Prioridade.ALTA);
        assertTrue(status);
    }

    @Test
    public void testAtualizaTarefa(String titulo, String campo, String novoValor) {
        boolean status = this.gerenciador.atualizaTarefa(titulo, campo, novoValor);
        assertTrue(status);
    }
}
