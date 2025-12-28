package view;

import controller.Arquivo;
import model.Endereco;
import model.Pet;
import service.BuscaPetService;
import util.TextoUtil;

import java.io.IOException;
import java.util.List;
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
                    arquivo.salvar(pet);
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
                    System.out.println("Listar pets por critério");

                    sc.nextLine(); // limpa buffer

                    System.out.print("Tipo do animal (obrigatório): ");
                    String tipoInput = sc.nextLine();

                    Pet.PetType tipo;
                    try {
                        tipo = Pet.PetType.valueOf(
                                TextoUtil.normalizar(tipoInput).toUpperCase()
                        );
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo inválido.");
                        break;
                    }

                    String nome = null;
                    Integer idade = null;
                    Double peso = null;
                    String raca = null;

                    int criteriosEscolhidos = 0;

                    while (criteriosEscolhidos < 2) {
                        MenuBusca.exibir();
                        int escolha = MenuBusca.ler(sc);
                        sc.nextLine();

                        if (escolha == 0) break;

                        switch (escolha) {
                            case 1:
                                System.out.print("Digite o nome ou parte do nome: ");
                                nome = sc.nextLine();
                                criteriosEscolhidos++;
                                break;

                            case 2:
                                System.out.print("Digite a idade: ");
                                idade = sc.nextInt();
                                sc.nextLine();
                                criteriosEscolhidos++;
                                break;

                            case 3:
                                System.out.print("Digite o peso: ");
                                peso = sc.nextDouble();
                                sc.nextLine();
                                criteriosEscolhidos++;
                                break;

                            case 4:
                                System.out.print("Digite a raça: ");
                                raca = sc.nextLine();
                                criteriosEscolhidos++;
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }
                    }

                    BuscaPetService service = new BuscaPetService();
                    List<Pet> encontrados = service.buscar(tipo, nome, idade, peso, raca);

                    if (encontrados.isEmpty()) {
                        System.out.println("Nenhum pet encontrado.");
                    } else {
                        int i = 1;
                        for (Pet p : encontrados) {
                            System.out.println(
                                    i++ + ". " +
                                            p.getNomeCompleto() + " - " +
                                            p.getTipo() + " - " +
                                            p.getSexo() + " - " +
                                            p.getEndereco().getRua() + ", " +
                                            p.getEndereco().getNumero() + " - " +
                                            p.getEndereco().getBairro() + " - " +
                                            p.getIdade() + " anos - " +
                                            p.getPeso() + "kg - " +
                                            p.getRaca()
                            );
                        }
                    }
                    break;
                case 6:
                    System.out.println("Sair");
                    break;
            }
        }while (option!=6);

        sc.close();
    }
}