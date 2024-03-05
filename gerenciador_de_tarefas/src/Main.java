import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Gerenciador gerenciador = new Gerenciador();

        while(true) {

            System.out.print("""
                    O que você desaja fazer:
                    1. Criar atividade
                    2. Atualizar atividade
                    3. Excluir atividade
                    4. Ver atividades
                    5. Sair
                    """);

            String funcionalidade = scanner.nextLine();

            try {
                switch (funcionalidade) {
                    case "1":
                        System.out.print("Insira o título: ");
                        String titulo = scanner.nextLine();

                        System.out.print("Insira a descrição: ");
                        String descricao = scanner.nextLine();

                        System.out.print("Insira a data(YY MM DD): ");
                        String data = scanner.nextLine();

                        System.out.print("Insira a priorida(alta, media, baixa): ");
                        String prioridade = scanner.nextLine();

                        boolean status = gerenciador.criaTarefa(titulo, descricao, data, prioridade);

                        if (status) {
                            System.out.print("Tarefa criada\n");
                        } else {
                            System.out.print("Desculpe. Algo deu errado.\n");
                        }

                        break;

                    case "2":
                        System.out.print("Qual a posição da tarefa que você deseja atualizar: ");
                        String index = scanner.nextLine();

                        System.out.print("Que campo da tarefa você deseja atualizar: ");
                        String campo = scanner.nextLine();

                        System.out.print("Qual será o novo valor: ");
                        String valor = scanner.nextLine();

                        boolean status2 = gerenciador.atualizaTarefa(index, campo, valor);

                        if (status2) {
                            System.out.print("Tarefa atualizada\n");
                        } else {
                            System.out.print("Desculpe. Algo deu errado.\n");
                        }

                        break;

                    case "3":
                        System.out.print("Qual a posição da tarefa que você deseja excluir: ");
                        String index2 = scanner.nextLine();

                        boolean status3 = gerenciador.excluiTarefa(index2);

                        if (status3) {
                            System.out.print("Tarefa excluida\n");
                        } else {
                            System.out.print("Desculpe. Algo deu errado.\n");
                        }

                        break;

                    case "4":
                        System.out.print("Essas são suas tarefas: \n");

                        ArrayList<Tarefa> tarefas = gerenciador.listaTarefas();

                        for (Tarefa tarefa : tarefas) {
                            System.out.print(tarefa.toString());
                        }

                        break;

                    case "5":
                        System.out.println("\nEncerrando aplicação.\n");
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
