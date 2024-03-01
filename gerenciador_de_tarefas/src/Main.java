import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void Main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                            O que você desaja fazer:
                            1. Criar atividade
                            2. Atualizar atividade
                            3. Excluir atividade
                            4. Ver atividades
                            """);

        String funcionalidade = scanner.nextLine();

        Gerenciador gerenciador =  new Gerenciador();

        switch (funcionalidade) {
            case "1":
                System.out.print("Insira o título:");
                String titulo = scanner.nextLine();

                System.out.print("Insira a descrição:");
                String descricao = scanner.nextLine();

                System.out.print("Insira a data(YY MM DD):");
                String data = scanner.nextLine();

                System.out.print("Insira a priorida(alta, media, baixa:");
                String prioridade = scanner.nextLine();

                boolean status = gerenciador.criaTarefa(titulo, descricao, data, prioridade);

                if (status) {
                    System.out.print("Tarefa criada");
                } else {
                    System.out.print("Desculpe. Algo deu errado.");
                }

                break;

            case "2":
                System.out.print("Qual a posição da tarefa que você deseja atualizar:");
                String index = scanner.nextLine();

                System.out.print("Que campo da tarefa você deseja atualizar:");
                String campo = scanner.nextLine();

                System.out.print("Qual será o novo valor:");
                String valor = scanner.nextLine();

                boolean status2 = gerenciador.atualizaTarefa(index, campo, valor);

                if (status2) {
                    System.out.print("Tarefa atualizada");
                } else {
                    System.out.print("Desculpe. Algo deu errado.");
                }

                break;

            case "3":
                System.out.print("Qual a posição da tarefa que você deseja excluir:");
                String index2 = scanner.nextLine();

                boolean status3 = gerenciador.excluiTarefa(index2);

                if (status3) {
                    System.out.print("Tarefa excluida");
                } else {
                    System.out.print("Desculpe. Algo deu errado.");
                }

                break;

            case "4":
                System.out.print("Essas são suas tarefas:");

                ArrayList<Tarefa> tarefas = gerenciador.listaTarefas();

                for (Tarefa tarefa : tarefas){
                    System.out.print(tarefa.toString());
                }

                break;
        }
    }
}
