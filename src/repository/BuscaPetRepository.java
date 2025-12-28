package repository;

import model.Pet;
import util.TextoUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BuscaPetRepository {

    private static final String DIR =
            "/home/pedro/Documents/Sistema_Adocao_De_Pet/petsCadastrados";

    public List<Pet> buscar(
            Pet.PetType tipoAnimal,
            String nome,
            Integer idade,
            Double peso,
            String raca
    ) {

        List<Pet> resultado = new ArrayList<>();

        File pasta = new File(DIR);
        File[] arquivos = pasta.listFiles();

        if (arquivos == null) return resultado;

        // 🔹 converte o tipo digitado UMA VEZ
        Pet.PetType tipoBuscado;
        try {
            tipoBuscado = Pet.PetType.valueOf(
                    TextoUtil.normalizar(String.valueOf(tipoAnimal)).toUpperCase()
            );
        } catch (IllegalArgumentException e) {
            return resultado; // tipo inválido
        }

        for (File arquivo : arquivos) {

            List<Pet> pets = LeitorDeArquivo.lerArquivo(arquivo);

            for (Pet p : pets) {

                // REGRA OBRIGATÓRIA: tipo
                if (p.getTipo() != tipoBuscado) {
                    continue;
                }

                boolean bate = true;

                if (nome != null && !nome.isEmpty()) {
                    bate &= TextoUtil.normalizar(p.getNomeCompleto())
                            .contains(TextoUtil.normalizar(nome));
                }

                if (idade != null) {
                    bate &= p.getIdade() == idade;
                }

                if (peso != null) {
                    bate &= Double.compare(p.getPeso(), peso) == 0;
                }

                if (raca != null && !raca.isEmpty()) {
                    bate &= TextoUtil.normalizar(p.getRaca())
                            .equals(TextoUtil.normalizar(raca));
                }

                if (bate) {
                    resultado.add(p);
                }
            }
        }

        return resultado;
    }
}
