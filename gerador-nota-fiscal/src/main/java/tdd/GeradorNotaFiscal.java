package tdd;

public class GeradorNotaFiscal {
    private boolean salvoNoBD;
    private boolean emailEnviado;
    private boolean sapEnviado;

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
        NotaFiscal notaFiscal = new NotaFiscal(fatura, valorImposto);
        enviaEmailNotaGerada(notaFiscal);
        enviaSAPNotaGerada(notaFiscal);
        return notaFiscal;
    }

    private void enviaEmailNotaGerada(NotaFiscal notaFiscal) {
        Smtp.envia(notaFiscal);
        this.emailEnviado = true;
    }

    private void enviaSAPNotaGerada(NotaFiscal notaFiscal) {
        SAP.envia(notaFiscal);
        this.sapEnviado = true;
    }
}
