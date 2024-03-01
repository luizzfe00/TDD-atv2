import java.util.ArrayList;
import java.util.HashMap;

public class Gerenciador {

    private HashMap<String, Tarefa> tarefas;

    public Gerenciador() {
        this.tarefas = new HashMap();
    }

    public boolean criaTarefa(String titulo, String descricao, String dataVencimento, Prioridade prioridade){
        Tarefa tarefa = new Tarefa(titulo, descricao, dataVencimento, prioridade);
        this.tarefas.put(titulo, tarefa);
        return true;
    }

    public boolean atualizaTarefa (String titulo, String campo, String novoValor) {
        Tarefa tarefa = this.tarefas.get(titulo);

        switch (campo){
            case "1":
                tarefa.setTitulo(novoValor);
                this.tarefas.remove(titulo);
                this.tarefas.put(tarefa.getTitulo(), tarefa);
            case "2":
                tarefa.setDescricao(novoValor);
            case "3":
                tarefa.setDataVencimento(novoValor);
            case "4":
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
}
