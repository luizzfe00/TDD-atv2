package tdd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome na fatura:\n");
        String nome = scanner.nextLine();

        System.out.print("Informe o endereco na fatura:\n");
        String endereco = scanner.nextLine();

        System.out.print("Informe o valor da fatura:\n");
        String valor = scanner.nextLine();

        Servico servico = Servico.INVALIDO;

        while (servico == Servico.INVALIDO) {
            System.out.print("""
                    Qual foi o tipo de servico prestado:
                    1. CONSULTORIA
                    2. TREINAMENTO
                    3. OUTRO
                    """);

            String servicoEntrada = scanner.nextLine();
            servico = obtemServico(servicoEntrada);
        }

        Fatura fatura = new Fatura(nome, endereco, servico, Double.parseDouble(valor));
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal notaFiscal = gerador.gerarNotaFiscal(fatura);
        System.out.println(notaFiscal.toString());
    }

    private static Servico obtemServico(String servico) {
        switch (servico) {
            case "1":
                return Servico.CONSULTORIA;
            case "2":
                return Servico.TREINAMENTO;
            case "3":
                return Servico.OUTRO;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                return Servico.INVALIDO;
        }
    }
}