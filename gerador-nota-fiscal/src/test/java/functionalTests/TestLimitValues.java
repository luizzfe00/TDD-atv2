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
        Fatura fatura = new Fatura("Cliente1", "Endereco1", Servico.CONSULTORIA, 100.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(25.0, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    void valorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente1", "Endereco1", Servico.CONSULTORIA, -100.0));
    }
}
