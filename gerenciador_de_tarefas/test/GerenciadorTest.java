import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorTest {

    private Gerenciador gerenciador;

    @BeforeEach
    public void setup() {
        this.gerenciador = new Gerenciador();

    }

    @Test
    public void testCriaTarefa() {
        assertTrue(this.gerenciador.criaTarefa("Contas", "Pagar as contas segunda", "04/03/2024", Prioridade.ALTA));
    }
}
