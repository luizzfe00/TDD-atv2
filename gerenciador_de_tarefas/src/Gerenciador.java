import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gerenciador {

    private ArrayList<Tarefa> tarefas;

    public Gerenciador() {
        this.tarefas = new ArrayList();
    }

    public boolean criaTarefa(String titulo, String descricao, String dataVencimento, String prioridade){
        if (titulo == null | descricao == null | dataVencimento == null | prioridade == null) {
            throw new NullPointerException("Nenhum dos valores de tarefa pode ser nulo. Tente novamente.");
        }
        Tarefa tarefa = new Tarefa(titulo, descricao, converteData(dataVencimento), Prioridade.valueOf(prioridade.toUpperCase()));
        this.tarefas.add(tarefa);
        return true;
    }

    public boolean atualizaTarefa (String indexAtividade, String campo, String novoValor) {
        if (indexAtividade == null | campo == null | novoValor == null) {
            throw new NullPointerException("Nenhum dos campos acima pode ser nulo. Tente novamente.");
        }
        int index = Integer.parseInt(indexAtividade);
        Tarefa tarefa = this.tarefas.get(index-1);

        switch (campo){
            case "titulo":
                tarefa.setTitulo(novoValor);
                break;
            case "descricao":
                tarefa.setDescricao(novoValor);
                break;
            case "data de vencimento":
                tarefa.setDataVencimento(converteData(novoValor));
                break;
            case "prioridade":
                    tarefa.setPrioridade(Prioridade.valueOf(novoValor.toUpperCase()));
                break;
            default:
                throw new IllegalArgumentException("O campo deve ser titulo, descricao, data de vencimento ou prioridade. Tente novamente.");
        }


        return true;
    }

    public boolean excluiTarefa(String indexAtividade) {
        if (indexAtividade == null) {
            throw new NullPointerException("A posição não pode ser nula. Tente novamente.");
        } else if (Integer.parseInt(indexAtividade) >= this.tarefas.size()) {
            throw new ArrayIndexOutOfBoundsException("Não existe uma tarefa nessa posição. Tente novamente.");
        }
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

    public ArrayList<Tarefa> listaTarefas() {
        Comparator<Tarefa> comparador = Comparator
                .comparing(Tarefa::getDataVencimento)
                .thenComparing(Tarefa::getPrioridade);

        Collections.sort(this.tarefas, comparador);

        return this.tarefas;
    }
}
