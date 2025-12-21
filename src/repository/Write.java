package repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void main(String[] args) {
        File file = new File("formulario.txt");
        try(FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw)) { // buffered more optimized
            bw.write("1 - Qual o nome e sobrenome do pet? \n");
            bw.write("2 - Qual o tipo do pet (Cachorro/Gato)? \n");
            bw.write("3 - Qual o sexo do animal?\n");
            bw.write("4 - Qual endereço e bairro que ele foi encontrado?\n");
            bw.write("5 - Qual a idade aproximada do pet?\n");
            bw.write("6 - Qual o peso aproximado do pet?\n");
            bw.write("7 - Qual a raça do pet?\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

