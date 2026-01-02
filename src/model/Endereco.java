package model;

public class Endereco {
    private String rua;
    private String bairro;
    private String numero; // Alterado para String (melhor para números de casa como "10A" ou "S/N")

    // 1. Construtor Vazio (Necessário para criar objetos vazios se precisar)
    public Endereco() {
    }

    // 2. NOVO: Construtor com Parâmetros (Resolve o erro do 'new Endereco(rua, bairro, numero)')
    public Endereco(String rua, String bairro, String numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    // Getters e Setters
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}