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
    void testeClienteTamanhoZero() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("", "Endereco1", Servico.CONSULTORIA, 1.0));
    }

    @Test
    void testeClienteTamanhoMin() {
        Fatura fatura = new Fatura("C", "Endereco1", Servico.CONSULTORIA, 1.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals("C", notaFiscal.getFatura().getNome());
    }

    @Test
    void testeClienteCaracteresInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente1", "Endereco1", Servico.CONSULTORIA, 1.0));
    }

    @Test
    void testeClienteCaracteresValidos() {
        Fatura fatura = new Fatura("Cliente", "Endereco1", Servico.CONSULTORIA, 1.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals("Cliente", notaFiscal.getFatura().getNome());
    }

    @Test
    void testeEnderecoTamanhoZero() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "", Servico.CONSULTORIA, 1.0));
    }

    @Test
    void testeEnderecoTamanhoMin() {
        Fatura fatura = new Fatura("Cliente", "Rua", Servico.CONSULTORIA, 1.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals("Rua", notaFiscal.getFatura().getEndereco());
    }

    @Test
    void testeEnderecoCaracteresInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco 1 @", Servico.CONSULTORIA, 1.0));
    }

    @Test
    void testeEnderecoCaracteresValidos() {
        Fatura fatura = new Fatura("Cliente", "Endereco 10000", Servico.CONSULTORIA, 1.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals("Endereco 10000", notaFiscal.getFatura().getEndereco());
    }

    @Test
    void testeValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco 1", Servico.CONSULTORIA, -1.0));
    }

    @Test
    void testeValorComMuitasCasasDecimais() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco 1", Servico.CONSULTORIA, 1.521));
    }

    @Test
    void testeValorValido() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.CONSULTORIA, 1.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(1.0, notaFiscal.getFatura().getValor());
        assertEquals(0.25, notaFiscal.getValorImposto());

    }
}
