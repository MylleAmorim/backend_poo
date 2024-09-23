package src.com.gerenciadorveiculos.repository;

import src.com.gerenciadorveiculos.model.Cliente;
import src.com.gerenciadorveiculos.model.Vendedor;


import java.util.HashMap;
import java.util.Map;

public class ClienteRepository {
    Map<String, Cliente> clientes = new HashMap<>();

    public void cadastrarCliente(Cliente cliente) {
        this.clientes.put(cliente.getCpf(), cliente);
    }

    public Cliente consultarCliente(String cpf) {
        return clientes.getOrDefault(cpf, null);
    }

    public void alterarCliente(Cliente cliente) {
        this.clientes.put(cliente.getCpf(), cliente);
    }

    public void excluirCliente(String cpf) {

        this.clientes.remove(cpf);
    }

}
