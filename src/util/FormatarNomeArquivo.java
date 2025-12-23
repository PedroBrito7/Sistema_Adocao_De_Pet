package util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatarNomeArquivo {
    public static String gerarNomeArquivo(String caminhoArquivo) {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm");
        String dataHoraFormatada = agora.format(formatador);
        String primeiraLinha = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            primeiraLinha = reader.readLine();
            primeiraLinha = primeiraLinha.replaceAll("\\s+", "");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
        String novoNome= dataHoraFormatada + "-" + primeiraLinha;
        String novoNome1 = novoNome + ".txt";
        System.out.println(novoNome1);
        return novoNome1;
    }
    }


