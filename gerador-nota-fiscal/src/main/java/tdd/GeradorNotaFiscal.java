package tdd;

public class GeradorNotaFiscal {

    private double calculaValorImposto(Fatura fatura) {
        Double porcentagemImposto = 0.06;
        switch (fatura.getServico()) {
            case "CONSULTORIA":
                porcentagemImposto = 0.25;
                break;
            case "TREINAMENTO":
                porcentagemImposto = 0.15;
                break;
        }
        return fatura.getValor() * porcentagemImposto;
    }
    public NotaFiscal gerarNotaFiscal(Fatura fatura) {
        Double valorImposto = this.calculaValorImposto(fatura);
        return new NotaFiscal(fatura, valorImposto);
    }
}
