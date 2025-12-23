package repository;

import model.Endereco;
import model.Pet;
import service.CadastroPetService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Read {

    public static Pet imprimirPergunta() {

        File file = new File("formulario.txt");
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet();
        CadastroPetService service = new CadastroPetService();


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String linha;
            int indice = 1;

            while ((linha = br.readLine()) != null) {

                System.out.println(linha);
                String resposta = scanner.nextLine();

                switch (indice) {

                    case 1:
                        pet.setNomeCompleto(resposta);
                        break;

                    case 2:
                        if (resposta.equalsIgnoreCase("cachorro")) {
                            pet.setTipo(Pet.PetType.DOG);
                        } else if (resposta.equalsIgnoreCase("gato")) {
                            pet.setTipo(Pet.PetType.CAT);
                        }
                        break;

                    case 3:
                        if (resposta.equalsIgnoreCase("macho")) {
                            pet.setSexo(Pet.PetSex.MALE);
                        } else if (resposta.equalsIgnoreCase("fêmea")
                                || resposta.equalsIgnoreCase("femea")) {
                            pet.setSexo(Pet.PetSex.FEMALE);
                        }
                        break;

                    case 4:
                        System.out.println("Informe a rua:");
                        String rua = scanner.nextLine();

                        System.out.println("Informe o numero:");
                        String numero = scanner.nextLine();

                        System.out.println("Informe o bairro:");
                        String bairro = scanner.nextLine();

                        Endereco endereco = new Endereco(rua, bairro, numero);
                        pet.setEndereco(endereco);
                        break;

                    case 5:
                        pet.setIdade(service.validarIdade(resposta));
                        break;

                    case 6:
                        pet.setPeso(service.validarPeso(resposta));
                        break;

                    case 7:
                        pet.setRaca(resposta);
                        break;
                }

                indice++;
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o formulário: " + e.getMessage());
        }
        return pet;



    }
}
