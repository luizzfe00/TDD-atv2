package tdd;

public class GeradorNotaFiscal {
    private boolean salvoNoBD;
    private boolean emailEnviado;
    private boolean sapEnviado;

    public NotaFiscal gerarNotaFiscal(Fatura fatura) {
        validaFatura(fatura);
        Double valorImposto = this.calculaValorImposto(fatura);
        NotaFiscal notaFiscal = new NotaFiscal(fatura, valorImposto);
        enviaEmailNotaGerada(notaFiscal);
        enviaSAPNotaGerada(notaFiscal);
        salvaNotaBD(notaFiscal);
        return notaFiscal;
    }

    public boolean isEmailEnviado() {
        return this.emailEnviado;
    }

    public boolean isSAPEnviado() {
        return this.sapEnviado;
    }

    public boolean isSalvoBancoDeDados() {
        return this.salvoNoBD;
    }

    private void validaFatura(Fatura fatura) {
        if (fatura.getNome() == null || fatura.getEndereco() == null || fatura.getValor() == null)
            throw new IllegalArgumentException("Nome, endereco e valor nao podem ser nulos.");
    }

    private double calculaValorImposto(Fatura fatura) {
        Double porcentagemImposto = 0.06;
        switch (fatura.getServico()) {
            case CONSULTORIA:
                porcentagemImposto = 0.25;
                break;
            case TREINAMENTO:
                porcentagemImposto = 0.15;
                break;
        }
        return fatura.getValor() * porcentagemImposto;
    }

    private void enviaEmailNotaGerada(NotaFiscal notaFiscal) {
        Smtp.envia(notaFiscal);
        this.emailEnviado = true;
    }

    private void enviaSAPNotaGerada(NotaFiscal notaFiscal) {
        SAP.envia(notaFiscal);
        this.sapEnviado = true;
    }

    private void salvaNotaBD(NotaFiscal notaFiscal) {
        NotaFiscalDao.salva(notaFiscal);
        this.salvoNoBD = true;
    }
}
