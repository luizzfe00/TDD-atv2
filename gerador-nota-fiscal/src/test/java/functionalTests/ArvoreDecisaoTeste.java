package functionalTests;

import org.junit.jupiter.api.Test;
import tdd.Fatura;
import tdd.GeradorNotaFiscal;
import tdd.NotaFiscal;
import tdd.Servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArvoreDecisaoTeste {
    @Test
    void consultoriaValorZero() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.CONSULTORIA, 0.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(0.0, notaFiscal.getValorImposto(), 0.01);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
        assertEquals("Endereco", notaFiscal.getFatura().getEndereco());
        assertEquals(Servico.CONSULTORIA, notaFiscal.getFatura().getServico());
    }

    @Test
    void consultoriaValorPositivo() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.CONSULTORIA, 10.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(2.5, notaFiscal.getValorImposto(), 0.01);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
        assertEquals("Endereco", notaFiscal.getFatura().getEndereco());
        assertEquals(Servico.CONSULTORIA, notaFiscal.getFatura().getServico());
    }

    @Test
    void consultoriaValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco", Servico.CONSULTORIA, -1.0));
    }

    @Test
    void treinamentoValorZero() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.TREINAMENTO, 0.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(0.0, notaFiscal.getValorImposto(), 0.01);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
        assertEquals("Endereco", notaFiscal.getFatura().getEndereco());
        assertEquals(Servico.TREINAMENTO, notaFiscal.getFatura().getServico());
    }

    @Test
    void treinamentoValorPositivo() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.TREINAMENTO, 10.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(1.5, notaFiscal.getValorImposto(), 0.01);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
        assertEquals("Endereco", notaFiscal.getFatura().getEndereco());
        assertEquals(Servico.TREINAMENTO, notaFiscal.getFatura().getServico());
    }

    @Test
    void treinamentoValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco", Servico.TREINAMENTO, -1.0));
    }

    @Test
    void outroValorZero() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.OUTRO, 0.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(0.0, notaFiscal.getValorImposto(), 0.01);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
        assertEquals("Endereco", notaFiscal.getFatura().getEndereco());
        assertEquals(Servico.OUTRO, notaFiscal.getFatura().getServico());
    }

    @Test
    void outroValorPositivo() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.OUTRO, 10.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(0.6, notaFiscal.getValorImposto(), 0.01);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
        assertEquals("Endereco", notaFiscal.getFatura().getEndereco());
        assertEquals(Servico.OUTRO, notaFiscal.getFatura().getServico());
    }

    @Test
    void outroValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco", Servico.OUTRO, -1.0));
    }

    @Test
    void erroValorNull() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco", Servico.TREINAMENTO, null));
    }

}
