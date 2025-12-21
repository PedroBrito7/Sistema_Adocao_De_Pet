package service;

import exception.PetInvalidoException;
import util.Constantes;

public class CadastroPetService {
    public String validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return Constantes.NAO_INFORMADO;
        }

        if (!nome.matches("[A-Za-z ]+ ")) {
            throw new PetInvalidoException(
                    "Nome do pet não pode conter números ou caracteres especiais."
            );
        }

        if (!nome.contains(" ")) {
            throw new PetInvalidoException(
                    "O pet deve possuir nome e sobrenome."
            );
        }
        return nome;
    }


    public double validarPeso(String pesoTexto) {

        if (pesoTexto == null || pesoTexto.trim().isEmpty()) {
            return Constantes.NAO_INFORMADO_NUMERO;
        }

        double peso = Double.parseDouble(pesoTexto);

        if (peso < 0.5 || peso > 60) {
            throw new PetInvalidoException(
                    "Pet deve pesar entre 0.5kg e 60kg"
            );
        }

        return peso;
    }

    public double validarIdade(String idadeTexto) {

        if (idadeTexto == null || idadeTexto.trim().isEmpty()) {
            return Constantes.NAO_INFORMADO_NUMERO;
        }

        double idade = Double.parseDouble(idadeTexto);

        if (idade < 0 || idade > 20) {
            throw new PetInvalidoException(
                    "Idade deve estar entre 0 e 20 anos"
            );
        }

        return idade;
    }



        public String validarRaca(String raca) {
            if (raca == null || raca.trim().isEmpty()) {
                return Constantes.NAO_INFORMADO;
            }
            if (!raca.matches("[A-Za-z]")) {
                throw new PetInvalidoException(
                        "Nome do pet não pode conter números ou caracteres especiais."
                );
            }
            return raca;
        }
}

