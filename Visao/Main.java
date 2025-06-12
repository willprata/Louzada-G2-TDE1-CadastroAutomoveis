package visao;

import modell.Automovel;
import controller.AutomovelController;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutomovelController controle = new AutomovelController();
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Incluir automóvel");
            System.out.println("2 - Remover automóvel");
            System.out.println("3 - Alterar automóvel");
            System.out.println("4 - Consultar por placa");
            System.out.println("5 - Listar automóveis");
            System.out.println("6 - Salvar e sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    boolean ok = controle.adicionar(new Automovel(placa, modelo, marca, ano, valor));
                    System.out.println(ok ? "Adicionado com sucesso!" : "Erro: placa já cadastrada.");
                }
                case 2 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    boolean ok = controle.remover(placa);
                    System.out.println(ok ? "Removido!" : "Placa não encontrada.");
                }
                case 3 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Novo modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Nova marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Novo ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Novo valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    boolean ok = controle.alterar(placa, modelo, marca, ano, valor);
                    System.out.println(ok ? "Alterado!" : "Placa não encontrada.");
                }
                case 4 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    Automovel a = controle.buscar(placa);
                    System.out.println(a != null ? a.toString() : "Automóvel não encontrado.");
                }
                case 5 -> {
                    System.out.print("Ordenar por (placa, modelo, marca): ");
                    String crit = sc.nextLine();
                    List<Automovel> lista = controle.listarOrdenado(crit);
                    for (Automovel a : lista) System.out.println(a);
                }
                case 6 -> {
                    controle.salvar();
                    System.out.println("Dados salvos. Até mais!");
                }
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        sc.close();
    }
}
