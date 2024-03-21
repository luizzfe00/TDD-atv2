package functionalTests;

import org.junit.jupiter.api.Test;
import tdd.Fatura;
import tdd.GeradorNotaFiscal;
import tdd.NotaFiscal;
import tdd.Servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestLimitValues {
    @Test
    void valorNeutro() {
        Fatura fatura = new Fatura("Cliente1", "Endereco1", Servico.CONSULTORIA, 0.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(0, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    void valorPositivo() {
        Fatura fatura = new Fatura("Cliente1", "Endereco1", Servico.CONSULTORIA, 1.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(0.25, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    void valorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente1", "Endereco1", Servico.CONSULTORIA, -1.0));
    }

    @Test
    void clienteVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("", "Endereco1", Servico.CONSULTORIA, 1.0));
    }

    @Test
    void clienteNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura(null, "Endereco1", Servico.CONSULTORIA, 1.0));
    }

    @Test
    void clienteCaractere() {
        Fatura fatura = new Fatura("C", "Endereco1", Servico.CONSULTORIA, 1.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals("C", notaFiscal.getFatura().getNome());
    }

    @Test
    void enderecoVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "", Servico.CONSULTORIA, 1.0));
    }

    @Test
    void enderecoNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", null, Servico.CONSULTORIA, 1.0));
    }

    @Test
    void enderecoCaractere() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente1", "E", Servico.CONSULTORIA, 1.0));
    }

    @Test
    void enderecoTamanhoMin() {
        Fatura fatura = new Fatura("Cliente", "Rua", Servico.CONSULTORIA, 1.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals("Rua", notaFiscal.getFatura().getEndereco());
    }
}
