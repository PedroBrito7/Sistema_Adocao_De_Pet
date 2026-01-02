package controller;

import model.Endereco;
import model.Pet;
import util.FormatarNomeArquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    private static final String DIRETORIO = "/home/pedro/Documents/Sistema_Adocao_De_Pet/petsCadastrados/";
    public void salvar(Pet pet ) throws IOException {
        File arquivoBase = new File(DIRETORIO + "formulario.txt");
        if(!arquivoBase.exists()){
            arquivoBase.createNewFile();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoBase))) {
            Endereco endereco = pet.getEndereco();
            String conteudo =
                    pet.getNomeCompleto().toUpperCase() + "\n" +
                            pet.getTipo() + "\n" +
                            pet.getSexo() + "\n" +
                            endereco.getRua() + ", " + endereco.getNumero() + ", "+ endereco.getBairro() + "\n" +
                            pet.getIdade() + "\n" +
                            pet.getPeso() + "\n" +
                            pet.getRaca();

            bw.write(conteudo);
        }
        String nomeArquivoFinal = FormatarNomeArquivo.gerarNomeArquivo(arquivoBase.getAbsolutePath());
        File arquivoFinal = new File(DIRETORIO + nomeArquivoFinal);
        boolean renomear = arquivoBase.renameTo(arquivoFinal);


        if (!renomear) {
            throw new IOException("Não foi possível renomear o arquivo");
        }

    }

    public static void alterarPet(Pet pet) {
        String novoNome =  pet.getNomeCompleto().toUpperCase();
        String novaRaca = pet.getRaca();
        int novaIdade = pet.getIdade();
        Double novoPeso = pet.getPeso();
        if (novoNome != null && !novoNome.isEmpty()) {
            pet.setNomeCompleto(novoNome);
        }
        if (novaIdade != 0) {
            pet.setIdade(novaIdade);
        }
        if (novoPeso != null) {
            pet.setPeso(novoPeso);
        }
        if (novaRaca != null && !novaRaca.isEmpty()) {
            pet.setRaca(novaRaca);
        }
    }

    public static void salvarAlteracao(File arquivoAntigo, Pet petAlterado) throws IOException {
        File arquivoBase = new File(DIRETORIO + "formulario.txt");
        if(!arquivoBase.exists()){
            arquivoBase.createNewFile();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoBase))) {
            Endereco endereco = petAlterado.getEndereco();
            String conteudo =
                    petAlterado.getNomeCompleto().toUpperCase() + "\n" +
                            petAlterado.getTipo() + "\n" +
                            petAlterado.getSexo() + "\n" +
                            endereco.getRua() + ", " + endereco.getNumero() + ", "+ endereco.getBairro() + "\n" +
                            petAlterado.getIdade() + "\n" +
                            petAlterado.getPeso() + "\n" +
                            petAlterado.getRaca();

            bw.write(conteudo);
        }
        String nomeArquivoFinal = FormatarNomeArquivo.gerarNomeArquivo(arquivoBase.getAbsolutePath());
        File arquivoFinal = new File(DIRETORIO + nomeArquivoFinal);
        boolean renomear = arquivoBase.renameTo(arquivoFinal);


        if (!renomear) {
            throw new IOException("Não foi possível renomear o arquivo");
        }

    }


}

