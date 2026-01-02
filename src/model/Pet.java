package model;

import java.io.File;

public class Pet {
    private File arquivoOrigem; // ponto-chave tipo um id

    public File getArquivoOrigem() {
        return arquivoOrigem;
    }

    public void setArquivoOrigem(File arquivoOrigem) {
        this.arquivoOrigem = arquivoOrigem;
    }
    public void setNome(String nome) {

    }

    public enum PetType {
        DOG,
        CAT,

    }

    public enum PetSex {
        MALE,
        FEMALE
    }

    private String nomeCompleto;
    private String raca;
    private int idade;
    private double peso;
    private PetType tipo;
    private PetSex sexo;
    private Endereco endereco;

    public Pet() {
        this.nomeCompleto = nomeCompleto;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.tipo = tipo;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public PetType getTipo() {
        return tipo;
    }

    public void setTipo(PetType tipo) {
        this.tipo = tipo;
    }

    public PetSex getSexo() {
        return sexo;
    }

    public void setSexo(PetSex sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
