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
    public void salvar(Pet pet, Endereco endereco) throws IOException {
        File arquivoBase = new File(DIRETORIO + "formulario.txt");
        if(!arquivoBase.exists()){
            arquivoBase.createNewFile();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoBase))) {
            String conteudo =
                    pet.getNomeCompleto().toUpperCase() + "\n" +
                            pet.getTipo() + "\n" +
                            pet.getSexo() + "\n" +
                            endereco.getRua() + ", " + endereco.getBairro() + "\n" +
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

}
