package view;

import controller.Arquivo;
import model.Endereco;
import model.Pet;

import repository.Read;
import service.BuscaPetService;
import util.TextoUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static repository.Read.imprimirPergunta;
import static repository.Read.imprimirPerguntaRenomear;

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
                    sc.nextLine();
                    System.out.println("Para isso você irá selecionar o pet novamente na busca.");
                    System.out.print("Tipo do animal (obrigatório): ");
                    String tipoInput1 = sc.nextLine();
                    Pet.PetType tipo;
                    try {
                        tipo = Pet.PetType.valueOf(
                                TextoUtil.normalizar(tipoInput1).toUpperCase()
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

                        // 1️⃣ Exibe a lista numerada
                        for (int i = 0; i < encontrados.size(); i++) {
                            Pet p = encontrados.get(i);
                            System.out.println(
                                    (i + 1) + ". " +
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


                        System.out.print("Digite o número do pet que deseja alterar: ");
                        int opcao = sc.nextInt();
                        sc.nextLine();

                        if (opcao < 1 || opcao > encontrados.size()) {
                            System.out.println("Opção inválida.");
                            break;
                        }

                        // 3️⃣ AQUI entra o ponto-chave
                        Pet petSelecionado = encontrados.get(opcao - 1);
                        File arquivoAntigo = petSelecionado.getArquivoOrigem();


                        // ⃣ oleta apenas os novos dados
                        Pet petAlterado = Read.imprimirPerguntaRenomear();

                        // ⃣ Garante regras: tipo e sexo NÃO mudam
                        petAlterado.setTipo(petSelecionado.getTipo());
                        petAlterado.setSexo(petSelecionado.getSexo());
                        petAlterado.setEndereco(petSelecionado.getEndereco());


                        Arquivo.salvarAlteracao(arquivoAntigo, petAlterado);
                        arquivoAntigo.delete();
                        System.out.println("Dados alterados com sucesso.");
                        System.out.println("Pode buscar novamente para ver as alterações.");
                    }
                    break;
                case 3:
                    System.out.println("Deletar um pet cadastrado");
                    sc.nextLine();
                    System.out.println("Para isso você irá selecionar o pet novamente na busca.");
                    System.out.print("Tipo do animal (obrigatório): ");
                    String tipoInput3 = sc.nextLine();
                    Pet.PetType tipo3;
                    try {
                        tipo3 = Pet.PetType.valueOf(
                                TextoUtil.normalizar(tipoInput3).toUpperCase()
                        );
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo inválido.");
                        break;
                    }

                    String nome3 = null;
                    Integer idade3 = null;
                    Double peso3 = null;
                    String raca3 = null;

                    int criteriosEscolhidos3 = 0;

                    while (criteriosEscolhidos3 < 2) {
                        MenuBusca.exibir();
                        int escolha = MenuBusca.ler(sc);
                        sc.nextLine();

                        if (escolha == 0) break;

                        switch (escolha) {
                            case 1:
                                System.out.print("Digite o nome ou parte do nome: ");
                                nome3 = sc.nextLine();
                                criteriosEscolhidos3++;
                                break;

                            case 2:
                                System.out.print("Digite a idade: ");
                                idade3 = sc.nextInt();
                                sc.nextLine();
                                criteriosEscolhidos3++;
                                break;

                            case 3:
                                System.out.print("Digite o peso: ");
                                peso3 = sc.nextDouble();
                                sc.nextLine();
                                criteriosEscolhidos3++;
                                break;

                            case 4:
                                System.out.print("Digite a raça: ");
                                raca3 = sc.nextLine();
                                criteriosEscolhidos3++;
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }
                    }
                    BuscaPetService serviceDelete = new BuscaPetService();
                    List<Pet> encontrado= serviceDelete.buscar(tipo3, nome3, idade3, peso3, raca3);
                    if (encontrado.isEmpty()) {
                        System.out.println("Nenhum pet encontrado.");
                    } else {

                        // 1️⃣ Exibe a lista numerada
                        for (int i = 0; i < encontrado.size(); i++) {
                            Pet p = encontrado.get(i);
                            System.out.println(
                                    (i + 1) + ". " +
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

                        System.out.print("Digite o número do pet que deseja excluir: ");
                        int opcao = sc.nextInt();
                        sc.nextLine();

                        if (opcao < 1 || opcao > encontrado.size()) {
                            System.out.println("Opção inválida.");
                            break;
                        }
                        Pet petSelecionado = encontrado.get(opcao - 1);
                        File arquivoAntigo = petSelecionado.getArquivoOrigem();
                        arquivoAntigo.delete();
                        System.out.println("Dado Excluído com sucesso.");
                        System.out.println("Pode buscar novamente para ver as alterações.");
                    }
                    break;
                case 4:
                    System.out.println("Listar todos os pets cadastrados");
                    arquivo.listarTodos();


                    break;
                case 5:
                    System.out.println("Listar pets por critério");

                    sc.nextLine(); // limpa buffer

                    System.out.print("Tipo do animal (obrigatório): ");
                    String tipoInput = sc.nextLine();

                    Pet.PetType tipo2;
                    try {
                        tipo2 = Pet.PetType.valueOf(
                                TextoUtil.normalizar(tipoInput).toUpperCase()
                        );
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo inválido.");
                        break;
                    }

                    String nome2 = null;
                    Integer idade2 = null;
                    Double peso2 = null;
                    String raca2 = null;

                    int criteriosEscolhidos2 = 0;

                    while (criteriosEscolhidos2 < 2) {
                        MenuBusca.exibir();
                        int escolha = MenuBusca.ler(sc);
                        sc.nextLine();

                        if (escolha == 0) break;

                        switch (escolha) {
                            case 1:
                                System.out.print("Digite o nome ou parte do nome: ");
                                nome2 = sc.nextLine();
                                criteriosEscolhidos2++;
                                break;

                            case 2:
                                System.out.print("Digite a idade: ");
                                idade2 = sc.nextInt();
                                sc.nextLine();
                                criteriosEscolhidos2++;
                                break;

                            case 3:
                                System.out.print("Digite o peso: ");
                                peso2 = sc.nextDouble();
                                sc.nextLine();
                                criteriosEscolhidos2++;
                                break;

                            case 4:
                                System.out.print("Digite a raça: ");
                                raca2 = sc.nextLine();
                                criteriosEscolhidos2++;
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }
                    }

                    BuscaPetService service2= new BuscaPetService();
                    List<Pet> encontrados2 = service2.buscar(tipo2, nome2, idade2, peso2, raca2);

                    if (encontrados2.isEmpty()) {
                        System.out.println("Nenhum pet encontrado.");
                    } else {
                        int i = 1;
                        for (Pet p : encontrados2) {
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