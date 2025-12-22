package controller;

import model.Endereco;
import model.Pet;

import java.io.*;
import java.util.regex.Pattern;

public class Arquivo {
    OutputStream os;
    OutputStreamWriter osw;
    BufferedWriter bw ;

    public Arquivo(){
        try {
            os = new FileOutputStream("^petCadastrados.txt",true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
        } catch (FileNotFoundException e) {
            // throw new RuntimeException(e);
            System.out.println("não encontrou o arquivo de texto");
        }
    }
    public void salvar (Pet pet, Endereco endereco) throws IOException {
        String objeto = pet.getNomeCompleto() + "\n"
                + pet.getTipo() + "\n"
                + pet.getSexo() + "\n"
                + endereco.getRua()+ ", " + endereco.getBairro()+"\n"
                 + pet.getIdade()+ "\n"
                + pet.getPeso()+ "\n"
                + pet.getRaca();
    bw.append(objeto);
    bw.newLine();
    bw.close();
    osw.close();
    os.close();
    }

}


