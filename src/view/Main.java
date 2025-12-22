package view;

import controller.Arquivo;
import model.Endereco;
import model.Pet;

import java.io.IOException;
import java.util.Scanner;

import static repository.Read.imprimirPergunta;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Arquivo arquivo = new Arquivo();
        int option;
        do {
            Menu.exibirMenu();
            option = Menu.lerOpcao(sc);
            switch (option) {
                case 1:
                    System.out.println("Cadastrar um novo pet");
                    Pet pet = imprimirPergunta();
                    Endereco endereco = new Endereco();
                    arquivo.salvar(pet, endereco);
                    break;
                case 2:
                    System.out.println("Alterar os dados do pet cadastrado");
                    break;
                case 3:
                    System.out.println("Deletar um pet cadastrado");
                    break;
                case 4:
                    System.out.println("Listar todos os pets cadastrados");

                    break;
                case 5:
                    System.out.println("Listar pets por algum critério (idade, nome, raça)");
                    break;
                case 6:
                    System.out.println("Sair");
                    break;
            }
        }while (option!=6);

        sc.close();
    }
}