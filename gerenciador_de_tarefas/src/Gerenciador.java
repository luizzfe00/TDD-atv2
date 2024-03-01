public class Gerenciador {

    public Gerenciador() {
    }

    public boolean criaTarefa(String titulo, String descricao, String dataVencimento, Prioridade prioridade){
        Tarefa tarefa = new Tarefa(titulo, descricao, dataVencimento, prioridade);
        return true;
    }
}
