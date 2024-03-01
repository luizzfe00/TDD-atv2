import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Gerenciador {

    private ArrayList<Tarefa> tarefas;

    public Gerenciador() {
        this.tarefas = new ArrayList();
    }

    public boolean criaTarefa(String titulo, String descricao, String dataVencimento, Prioridade prioridade){
        Tarefa tarefa = new Tarefa(titulo, descricao, converteData(dataVencimento), prioridade);
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
                tarefa.setDataVencimento(converteData(novoValor));
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

    private LocalDate converteData(String dataString){
        String[] data = dataString.split(" ");
        int ano = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int dia = Integer.parseInt(data[2]);

        return LocalDate.of(ano,mes, dia);
    }
}
