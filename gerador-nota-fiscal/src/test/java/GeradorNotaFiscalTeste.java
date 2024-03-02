import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeradorNotaFiscalTeste {
    @Test
    void calculaTaxaParaServicoConsultoria() {
        Fatura fatura = new Fatura("Cliente1", "Endereco1", "CONSULTORIA", 1000.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(250.0, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    void calculaTaxaParaServicoTreinamento() {
        Fatura fatura = new Fatura("Cliente2", "Endereco2", "TREINAMENTO", 800.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(120.0, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    void calculaTaxaParaOutrosServicos() {
        Fatura fatura = new Fatura("Cliente3", "Endereco3", "OUTRO", 1500.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertEquals(90.0, notaFiscal.getValorImposto(), 0.01);
    }

    @Test
    void enviaEmailAoGerarNotaFiscal() {
        Fatura fatura = new Fatura("Cliente4", "Endereco4", "OUTRO", 2000.0);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);

        assertTrue(gerador.isEmailSent());
    }
}
