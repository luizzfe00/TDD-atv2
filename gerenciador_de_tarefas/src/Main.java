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

                gerenciador.criaTarefa(titulo, descricao, data, prioridade);
        }
    }
}
