package src.com.gerenciadorveiculos.model;

import java.time.LocalDate;

public class Venda {

    private int id;
    private Veiculo veiculoVendido;
    private Vendedor vendedorResponsavel;
    private Cliente clienteComprador;
    private String dataDaVenda;

    public Venda(Veiculo veiculoVendido, Vendedor vendedorResponsavel, Cliente clienteComprador, String dataDaVenda) {
        this.veiculoVendido = veiculoVendido;
        this.vendedorResponsavel = vendedorResponsavel;
        this.clienteComprador = clienteComprador;
        this.dataDaVenda = dataDaVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Veiculo getVeiculoVendido() {
        return veiculoVendido;
    }

    public void setVeiculoVendido(Veiculo veiculoVendido) {
        this.veiculoVendido = veiculoVendido;
    }

    public Vendedor getVendedorResponsavel() {
        return vendedorResponsavel;
    }

    public void setVendedorResponsavel(Vendedor vendedorResponsavel) {
        this.vendedorResponsavel = vendedorResponsavel;
    }

    public Cliente getClienteComprador() {
        return clienteComprador;
    }

    public void setClienteComprador(Cliente clienteComprador) {
        this.clienteComprador = clienteComprador;
    }

    public String getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(String dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    @Override
    public String toString() {
        return "\n*****************\n" +
                "**** Venda " + id + " ****\n" +
                "*****************\n" +
                "Veiculo Vendido: \n" + veiculoVendido + "\n" +
                "Vendedor Responsavel: \n" + vendedorResponsavel + "\n" +
                "Cliente Comprador: \n" + clienteComprador + "\n" +
                "Data da Venda: " + dataDaVenda + "\n";
    }


}
