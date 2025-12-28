package repository;

import model.Endereco;
import model.Pet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeArquivo {

    public static List<Pet> lerArquivo(File arquivo) {
        List<Pet> pets = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

            List<String> linhas = new ArrayList<>();
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    linhas.add(linha);
                }
            }

            if (linhas.size() < 7) {
                System.out.println("Arquivo inválido: " + arquivo.getName());
                return pets;
            }

            Pet pet = new Pet();
            pet.setNomeCompleto(linhas.get(0));
            pet.setTipo(Pet.PetType.valueOf(linhas.get(1)));
            pet.setSexo(Pet.PetSex.valueOf(linhas.get(2)));
            pet.setEndereco(new Endereco());
            pet.setIdade((int) Double.parseDouble(linhas.get(4)));
            pet.setPeso(Double.parseDouble(linhas.get(5)));
            pet.setRaca(linhas.get(6));

            pets.add(pet);

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + arquivo.getName());
        }

        System.out.println("TOTAL DE PETS LIDOS: " + pets.size());
        return pets;
    }
}