package view;

import java.util.Scanner;

public class MenuBusca {

    public static void exibir() {
        System.out.println("\n=== BUSCA DE PETS ===");
        System.out.println("Escolha até 2 critérios:");
        System.out.println("1 - Nome ou sobrenome");
        System.out.println("2 - Idade");
        System.out.println("3 - Peso");
        System.out.println("4 - Raça");
        System.out.println("0 - Finalizar escolha");
    }
    public static int ler(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Digite um número válido.");
            sc.next();
        }
        return sc.nextInt();
    }
}
