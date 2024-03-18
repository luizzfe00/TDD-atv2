package tdd;


public class NotaFiscal {
    private Fatura fatura;
    private Double valorImposto;

    public NotaFiscal(Fatura fatura, Double valorImposto) {
        this.fatura = fatura;
        this.valorImposto = valorImposto;
    }

    public Double getValorImposto() {
        return this.valorImposto;
    }

    public Fatura getFatura() {
        return this.fatura;
    }

     @Override
    public String toString() {
        return "NotaFiscal={" +
                "nomeCliente='" + this.fatura.getNome() + '\'' +
                ", valorNota=" + this.fatura.getValor() +
                ", valorImposto=" + valorImposto +
                '}';
    }
}