import java.time.LocalDate;

public class Tarefa {

    private String titulo;
    private String descricao;
    private LocalDate dataVencimento;
    private Prioridade prioridade;

    public Tarefa(String titulo, String descricao, LocalDate dataVencimento, Prioridade prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.prioridade = prioridade;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public LocalDate getDataVencimento() {
        return this.dataVencimento;
    }

    public Prioridade getPrioridade() {
        return this.prioridade;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return (this.titulo.equals(tarefa.titulo) & this.dataVencimento.equals(tarefa.dataVencimento));
    }
}
