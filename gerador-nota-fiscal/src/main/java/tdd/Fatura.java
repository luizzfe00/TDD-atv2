package tdd;

public class Fatura {
    private String nome;
    private String endereco;
    private Servico servico;
    private Double valor;

    public Fatura(String nome, String endereco, Servico servico, Double valor) {
        this.nome = nome;
        this.endereco = endereco;
        this.servico = servico;
        this.valor = valor;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public Double getValor() {
        return this.valor;
    }

    public Servico getServico() {
        return this.servico;
    }
}
