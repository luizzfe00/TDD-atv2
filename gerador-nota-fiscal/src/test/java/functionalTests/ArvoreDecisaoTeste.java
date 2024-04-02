package functionalTests;

import org.junit.jupiter.api.*;
import tdd.Fatura;
import tdd.GeradorNotaFiscal;
import tdd.NotaFiscal;
import tdd.Servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Testes de Arvore de Decisao para GeradorNotaFiscal")
public class ArvoreDecisaoTeste {
    private GeradorNotaFiscal gerador;

    @BeforeEach
    void setUp() {
        gerador = new GeradorNotaFiscal();
    }
    @Test
    @DisplayName("Consultoria - Valor Zero")
    void consultoriaValorZero() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.CONSULTORIA, 0.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(0.0, notaFiscal.getValorImposto(), 0.01);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
        assertEquals("Endereco", notaFiscal.getFatura().getEndereco());
        assertEquals(Servico.CONSULTORIA, notaFiscal.getFatura().getServico());
    }

    @Test
    @DisplayName("Consultoria - Valor Positivo")
    void consultoriaValorPositivo() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.CONSULTORIA, 10.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(2.5, notaFiscal.getValorImposto(), 0.01);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
        assertEquals("Endereco", notaFiscal.getFatura().getEndereco());
        assertEquals(Servico.CONSULTORIA, notaFiscal.getFatura().getServico());
    }

    @Test
    @DisplayName("Consultoria - Valor Negativo")
    void consultoriaValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco", Servico.CONSULTORIA, -1.0));
    }

    @Test
    @DisplayName("Treinamento - Valor Zero")
    void treinamentoValorZero() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.TREINAMENTO, 0.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(0.0, notaFiscal.getValorImposto(), 0.01);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
        assertEquals("Endereco", notaFiscal.getFatura().getEndereco());
        assertEquals(Servico.TREINAMENTO, notaFiscal.getFatura().getServico());
    }

    @Test
    @DisplayName("Treinamento - Valor Positivo")
    void treinamentoValorPositivo() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.TREINAMENTO, 10.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(1.5, notaFiscal.getValorImposto(), 0.01);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
        assertEquals("Endereco", notaFiscal.getFatura().getEndereco());
        assertEquals(Servico.TREINAMENTO, notaFiscal.getFatura().getServico());
    }

    @Test
    @DisplayName("Treinamento - Valor Negativo")
    void treinamentoValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco", Servico.TREINAMENTO, -1.0));
    }

    @Test
    @DisplayName("Outro - Valor Zero")
    void outroValorZero() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.OUTRO, 0.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(0.0, notaFiscal.getValorImposto(), 0.01);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
        assertEquals("Endereco", notaFiscal.getFatura().getEndereco());
        assertEquals(Servico.OUTRO, notaFiscal.getFatura().getServico());
    }

    @Test
    @DisplayName("Outro - Valor Positivo")
    void outroValorPositivo() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.OUTRO, 10.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(0.6, notaFiscal.getValorImposto(), 0.01);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
        assertEquals("Endereco", notaFiscal.getFatura().getEndereco());
        assertEquals(Servico.OUTRO, notaFiscal.getFatura().getServico());
    }

    @Test
    @DisplayName("Outro - Valor Negativo")
    void outroValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco", Servico.OUTRO, -1.0));
    }

    @Test
    @DisplayName("Valor Nulo")
    void erroValorNull() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco", Servico.TREINAMENTO, null));
    }

}
