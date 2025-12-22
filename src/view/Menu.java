package view;

import java.util.Scanner;

public class Menu {

    public static void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Cadastrar um novo pet");
        System.out.println("2 - Alterar os dados do pet cadastrado");
        System.out.println("3 - Deletar um pet cadastrado");
        System.out.println("4 - Listar todos os pets cadastrados");
        System.out.println("5 - Listar pets por critério");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");
    }
    public static int lerOpcao(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int opcao = sc.nextInt();
                if (opcao > 0 && opcao <= 6) {
                    return opcao;
                } else {
                    System.out.println("Opção inválida! Digite um número entre 1 e 6.");
                }
            } else {
                System.out.println("Entrada inválida! Digite apenas números.");
                sc.next(); // limpa a entrada inválida
            }

          exibirMenu();


        }
    }
}