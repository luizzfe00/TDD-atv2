public class Tarefa {

    private String titulo;
    private String descricao;
    private String data_vencimento;
    private Prioridade prioridade;

    public Tarefa(String titulo, String descricao, String data_vencimento, Prioridade prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data_vencimento = data_vencimento;
        this.prioridade = prioridade;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
