package functionalTests;

import org.junit.jupiter.api.Test;
import tdd.Fatura;
import tdd.GeradorNotaFiscal;
import tdd.NotaFiscal;
import tdd.Servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPartitionsByEquivalence {
    @Test
    void servicoConsultoria() {
        Fatura fatura = new Fatura("Cliente1", "Endereco1", Servico.CONSULTORIA, 100.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(25.0, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    void servicoTreinamento() {
        Fatura fatura = new Fatura("Cliente1", "Endereco1", Servico.TREINAMENTO, 100.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(15.0, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    void servicoOutro() {
        Fatura fatura = new Fatura("Cliente1", "Endereco1", Servico.OUTRO, 100.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(6.0, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    void servicoVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente1", "Endereco1", null, 100.0));
    }

    @Test
    void nomeClienteVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("", "Endereco1", Servico.CONSULTORIA, 100.0));
    }

    @Test
    void nomeClienteNull() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura(null, "Endereco1", Servico.CONSULTORIA, 100.0));
    }

    @Test
    void enderecoVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "", Servico.CONSULTORIA, 100.0));
    }

    @Test
    void enderecoNull() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", null, Servico.CONSULTORIA, 100.0));
    }
}
