package tdd;

public class Fatura {
    private String nome;
    private String endereco;
    private String servico;
    private Double valor;

    public Fatura(String nome, String endereco, String servico, Double valor) {
        this.nome = nome;
        this.endereco = endereco;
        this.servico = servico;
        this.valor = valor;
    }
}
