package tdd;

public class Fatura {
    private String nome;
    private String endereco;
    private Servico servico;
    private Double valor;

    public Fatura(String nome, String endereco, Servico servico, Double valor) {
        this.validaConstrutor(nome, endereco, servico, valor);
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

    private void validaConstrutor(String nome, String endereco, Servico servico, Double valor) {
        if (nome == null || nome.isEmpty() || nome.isBlank()) {
            throw new IllegalArgumentException("Necessário informar um nome");
        }
        if (endereco == null || endereco.isEmpty() || endereco.isBlank()) {
            throw new IllegalArgumentException("Necessário informar um endereco");
        }
        if (servico == null) {
            throw new IllegalArgumentException("Necessário informar um servico válido");
        }
        if (valor == null) {
            throw new IllegalArgumentException("Necessário informar um valor");
        }
        if (valor < 0.0)
            throw new IllegalArgumentException("Valor precisa ser positivo");
    }
}
