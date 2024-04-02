package functionalTests;

import org.junit.jupiter.api.*;
import tdd.Fatura;
import tdd.GeradorNotaFiscal;
import tdd.NotaFiscal;
import tdd.Servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Testes de Valores Limites")
public class TestLimitValues {
    private GeradorNotaFiscal gerador;

    @BeforeEach
    void setUp() {
        gerador = new GeradorNotaFiscal();
    }
    @Test
    @DisplayName("Valor Neutro")
    void valorNeutro() {
        Fatura fatura = new Fatura("Cliente", "Endereco1", Servico.CONSULTORIA, 0.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(0, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    @DisplayName("Valor Positivo")
    void valorPositivo() {
        Fatura fatura = new Fatura("Cliente", "Endereco1", Servico.CONSULTORIA, 1.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(0.25, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    @DisplayName("Valor Negativo")
    void valorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente1", "Endereco1", Servico.CONSULTORIA, -1.0));
    }

    @Test
    @DisplayName("Cliente Vazio")
    void clienteVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("", "Endereco1", Servico.CONSULTORIA, 1.0));
    }

    @Test
    @DisplayName("Cliente Nulo")
    void clienteNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura(null, "Endereco1", Servico.CONSULTORIA, 1.0));
    }

    @Test
    @DisplayName("Cliente Com 1 Caractere")
    void clienteCaractere() {
        Fatura fatura = new Fatura("C", "Endereco1", Servico.CONSULTORIA, 1.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals("C", notaFiscal.getFatura().getNome());
    }

    @Test
    @DisplayName("Endereco Vazio")
    void enderecoVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "", Servico.CONSULTORIA, 1.0));
    }

    @Test
    @DisplayName("Endereco Nulo")
    void enderecoNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", null, Servico.CONSULTORIA, 1.0));
    }

    @Test
    @DisplayName("Endereco Com 1 Caractere")
    void enderecoCaractere() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente1", "E", Servico.CONSULTORIA, 1.0));
    }

    @Test
    @DisplayName("Endereco Com Tamanho Minimo")
    void enderecoTamanhoMin() {
        Fatura fatura = new Fatura("Cliente", "Rua", Servico.CONSULTORIA, 1.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals("Rua", notaFiscal.getFatura().getEndereco());
    }
}
