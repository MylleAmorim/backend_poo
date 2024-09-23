package src.com.gerenciadorveiculos.repository;

import src.com.gerenciadorveiculos.model.Vendedor;

import java.util.HashMap;
import java.util.Map;

public class VendedorRepository {
    Map<String, Vendedor> vendedores = new HashMap<>();

    public void cadastrarVendedor(Vendedor vendedor) {
        this.vendedores.put(vendedor.getCpf(), vendedor);
    }

    public Vendedor consultarVendedor(String cpf) {
        return vendedores.getOrDefault(cpf, null);
    }

    public void alterarVendedor(Vendedor vendedor) {
        this.vendedores.put(vendedor.getCpf(), vendedor);
    }

    public void excluirVendedor(String placa) {
        this.vendedores.remove(placa);
    }
}
