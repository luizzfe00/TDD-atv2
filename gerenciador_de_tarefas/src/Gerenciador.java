import java.util.ArrayList;
import java.util.HashMap;

public class Gerenciador {

    private ArrayList<Tarefa> tarefas;

    public Gerenciador() {
        this.tarefas = new ArrayList();
    }

    public boolean criaTarefa(String titulo, String descricao, String dataVencimento, Prioridade prioridade){
        Tarefa tarefa = new Tarefa(titulo, descricao, dataVencimento, prioridade);
        this.tarefas.add(tarefa);
        return true;
    }

    public boolean atualizaTarefa (String indexAtividade, String campo, String novoValor) {
        int index = Integer.parseInt(indexAtividade);
        Tarefa tarefa = this.tarefas.get(index-1);

        switch (campo){
            case "titulo":
                tarefa.setTitulo(novoValor);
            case "descricao":
                tarefa.setDescricao(novoValor);
            case "data de vencimento":
                tarefa.setDataVencimento(novoValor);
            case "prioridade":
                novoValor = novoValor.toLowerCase();
                if (novoValor.equals("alta")){
                    tarefa.setPrioridade(Prioridade.ALTA);
                } else if (novoValor.equals("media")){
                    tarefa.setPrioridade(Prioridade.MEDIA);
                } else {
                    tarefa.setPrioridade(Prioridade.BAIXA);
                }
        }


        return true;
    }

    public boolean excluiTarefa(String indexAtividade) {
        int index = Integer.parseInt(indexAtividade);
        this.tarefas.remove(index-1);

        return true;
    }
}
