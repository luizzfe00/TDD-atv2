import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class GeradorNotaFiscalTeste {
        @Test
        void calculaTaxaParaServicoConsultoria() {
            Fatura fatura = new Fatura("Cliente1", "Endereco1", "CONSULTORIA", 1000.0);
            NotaFiscalGenerator generator = new NotaFiscalGenerator();

            NotaFiscal notaFiscal = generator.gerarNotaFiscal(fatura);

            assertEquals(250.0, notaFiscal.getValorImposto(), 0.01);
        }
}
