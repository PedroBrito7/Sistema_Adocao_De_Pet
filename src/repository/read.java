package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class read {
    public static void imprimirPergunta(){
        File file = new File("formulario.txt");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)){
            String s;
            while ((s = br.readLine())!= null){
                System.out.println(s);
            }
        }  catch (IOException e) {
            System.out.println("###### Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }

}

