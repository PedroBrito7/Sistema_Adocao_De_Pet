package util;

import model.Endereco;

import java.text.Normalizer;

public class TextoUtil {
    public static String normalizar(String texto) {
        if (texto == null) return ""; // Evita NullPointerException
        return Normalizer
                .normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();
    }
    public static Endereco parseEndereco(String texto) {

        String[] partes = texto.split(",");

        if (partes.length != 3) {
            throw new IllegalArgumentException(
                    "Formato inválido. Use: rua, bairro, número"
            );
        }

        Endereco endereco = new Endereco();
        endereco.setRua(partes[0].trim());
        endereco.setBairro(partes[1].trim());
        endereco.setNumero(String.valueOf(Double.parseDouble(partes[2].trim())));

        return endereco;
    }
}