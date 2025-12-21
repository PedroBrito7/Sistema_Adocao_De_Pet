package model;

public class Endereco {
    String rua;
    String bairro;

    public Endereco(String rua, String bairro) {
        this.rua = rua;
        this.bairro = bairro;

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
