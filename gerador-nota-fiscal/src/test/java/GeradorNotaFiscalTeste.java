import org.junit.jupiter.api.Test;
import tdd.Fatura;
import tdd.GeradorNotaFiscal;
import tdd.NotaFiscal;
import tdd.Servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeradorNotaFiscalTeste {
    @Test
    void calculaTaxaParaServicoConsultoria() {
        Fatura fatura = new Fatura("Cliente1", "Endereco1", Servico.CONSULTORIA, 1000.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(250.0, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    void calculaTaxaParaServicoTreinamento() {
        Fatura fatura = new Fatura("Cliente2", "Endereco2", Servico.TREINAMENTO, 800.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(120.0, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    void calculaTaxaParaOutrosServicos() {
        Fatura fatura = new Fatura("Cliente3", "Endereco3", Servico.OUTRO, 1500.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(90.0, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    void enviaEmailAoGerarNotaFiscal() {
        Fatura fatura = new Fatura("Cliente4", "Endereco4", Servico.OUTRO, 2000.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertTrue(gerador.isEmailEnviado());
    }

    @Test
    void enviaSAPAoGerarNotaFiscal() {
        Fatura fatura = new Fatura("Cliente4", "Endereco4", Servico.OUTRO, 2000.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertTrue(gerador.isSAPEnviado());
    }

    @Test
    void salvaNoBancoDeDadosAoGerarNotaFiscal() {
        Fatura fatura = new Fatura("Cliente5", "Endereco5", Servico.OUTRO, 2500.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertTrue(gerador.isSalvoBancoDeDados());
    }

    @Test
    void geradorNotaFiscalSemNome() {
        Fatura fatura = new Fatura(null, "Address", Servico.CONSULTORIA, 1000.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        assertThrows(IllegalArgumentException.class, () -> gerador.gerarNotaFiscal(fatura));
    }

    @Test
    void geradorNotaFiscalSemEndereco() {
        Fatura fatura = new Fatura("Client", null, Servico.CONSULTORIA, 1000.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        assertThrows(IllegalArgumentException.class, () -> gerador.gerarNotaFiscal(fatura));
    }
}
