package functionalTests;

import org.junit.jupiter.api.*;
import tdd.Fatura;
import tdd.GeradorNotaFiscal;
import tdd.NotaFiscal;
import tdd.Servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Testes por Particao de Equivalencia")
public class TestPartitionsByEquivalence {
    private GeradorNotaFiscal gerador;

    @BeforeEach
    void setUp() {
        gerador = new GeradorNotaFiscal();
    }
    @Test
    @DisplayName("Cliente String Vazia")
    void testeClienteTamanhoZero() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("", "Endereco1", Servico.CONSULTORIA, 1.0));
    }

    @Test
    @DisplayName("Cliente Tamanho Minimo")
    void testeClienteTamanhoMin() {
        Fatura fatura = new Fatura("C", "Endereco1", Servico.CONSULTORIA, 1.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals("C", notaFiscal.getFatura().getNome());
    }

    @Test
    @DisplayName("Cliente Caracter Invalido")
    void testeClienteCaracteresInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente1", "Endereco1", Servico.CONSULTORIA, 1.0));
    }

    @Test
    @DisplayName("Cliente Caracteres Validos")
    void testeClienteCaracteresValidos() {
        Fatura fatura = new Fatura("Cliente", "Endereco1", Servico.CONSULTORIA, 1.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals("Cliente", notaFiscal.getFatura().getNome());
    }

    @Test
    @DisplayName("Endereco Tamanho Zero")
    void testeEnderecoTamanhoZero() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "", Servico.CONSULTORIA, 1.0));
    }

    @Test
    @DisplayName("Endereco Tamanho Minimo")
    void testeEnderecoTamanhoMin() {
        Fatura fatura = new Fatura("Cliente", "Rua", Servico.CONSULTORIA, 1.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals("Rua", notaFiscal.getFatura().getEndereco());
    }

    @Test
    @DisplayName("Endereco Caractere Invalido")
    void testeEnderecoCaracteresInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco 1 @", Servico.CONSULTORIA, 1.0));
    }

    @Test
    @DisplayName("Endereco Caracteres Validos")
    void testeEnderecoCaracteresValidos() {
        Fatura fatura = new Fatura("Cliente", "Endereco 10000", Servico.CONSULTORIA, 1.0);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals("Endereco 10000", notaFiscal.getFatura().getEndereco());
    }

    @Test
    @DisplayName("Valor Negativo")
    void testeValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco 1", Servico.CONSULTORIA, -1.0));
    }

    @Test
    @DisplayName("Valor Com Muitas Casas Decimais")
    void testeValorComMuitasCasasDecimais() {
        assertThrows(IllegalArgumentException.class, () -> new Fatura("Cliente", "Endereco 1", Servico.CONSULTORIA, 1.521));
    }

    @Test
    @DisplayName("Valor Valido")
    void testeValorValido() {
        Fatura fatura = new Fatura("Cliente", "Endereco", Servico.CONSULTORIA, 1.00);

        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        assertEquals(1.0, notaFiscal.getFatura().getValor());
        assertEquals(0.25, notaFiscal.getValorImposto());
    }
}
