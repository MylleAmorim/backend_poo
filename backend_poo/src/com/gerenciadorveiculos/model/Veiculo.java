package src.com.gerenciadorveiculos.model;

public class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private String categoria;
    private String descricao;
    private double preco;

    public Veiculo(String placa, String marca, String modelo, int ano, String categoria, String descricao, double preco) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Veiculo() {}

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "placa: " + placa + '\n' +
                "marca: " + marca + '\n' +
                "modelo: " + modelo + '\n' +
                "ano: " + ano + '\n' +
                "categoria: " + categoria + '\n' +
                "descricao: " + descricao + '\n' +
                "preco: " + preco + '\n';
    }
}

