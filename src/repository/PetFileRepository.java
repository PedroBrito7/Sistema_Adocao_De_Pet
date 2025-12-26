package repository;

import model.Pet;
import model.Endereco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PetFileRepository {

    public Pet fileParaPet(File arquivo) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(arquivo));

        String nome = br.readLine();
        String tipo = br.readLine();
        String sexo = br.readLine();
        String enderecoLinha = br.readLine();
        String idadeLinha = br.readLine();
        String pesoLinha = br.readLine();
        String raca = br.readLine();

        br.close();


        String[] partesEndereco = enderecoLinha.split(",");
        String rua = partesEndereco[0].trim();
        String bairro = partesEndereco[1].trim();
        String cidade = partesEndereco[2].trim();

        Endereco endereco = new Endereco();

        Pet pet = new Pet();
        pet.setNome(nome);
        pet.setTipo(Pet.PetType.valueOf(tipo));
        pet.setSexo(Pet.PetSex.valueOf(sexo));
        pet.setEndereco(endereco);
        pet.setIdade(Double.parseDouble(idadeLinha));
        pet.setPeso(Double.parseDouble(pesoLinha));
        pet.setRaca(raca);

        return pet;
    }
    public void abridorDePasta (Pet pet) {
        final String dir = "/home/pedro/Documents/Sistema_Adocao_De_Pet/petsCadastrados";
        File[] arquivos = dir.listfiles();
            for (File arquivo : arquivos) {
              for (arquivo:){

              }
            }

    }
}