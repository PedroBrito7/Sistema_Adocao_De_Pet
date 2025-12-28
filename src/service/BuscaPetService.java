package service;

import model.Pet;
import repository.BuscaPetRepository;

import java.util.List;

public class BuscaPetService {

    private final BuscaPetRepository repository = new BuscaPetRepository();

    public List<Pet> buscar(
            Pet.PetType tipo,
            String nome,
            Integer idade,
            Double peso,
            String raca
    ) {
        if (tipo == null)
            throw new IllegalArgumentException("Tipo de animal é obrigatório");

        return repository.buscar(tipo, nome, idade, peso, raca);
    }
}
