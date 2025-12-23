package model;

public class Endereco {
    String rua;
    String bairro;
    String numero;

    public Endereco(String rua, String numero, String bairro) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    public Endereco() {

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String cidade) {
        this.bairro = bairro;
    }



}
