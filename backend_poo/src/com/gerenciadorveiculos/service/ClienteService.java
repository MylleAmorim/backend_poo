package src.com.gerenciadorveiculos.service;

import src.com.gerenciadorveiculos.exceptions.ClienteCadastradoException;
import src.com.gerenciadorveiculos.exceptions.ClienteNaoCadastradoException;
import src.com.gerenciadorveiculos.exceptions.VendedorCadastradoException;
import src.com.gerenciadorveiculos.exceptions.VendedorNaoCadastradoException;
import src.com.gerenciadorveiculos.model.Cliente;
import src.com.gerenciadorveiculos.model.Vendedor;
import src.com.gerenciadorveiculos.repository.ClienteRepository;
import src.com.gerenciadorveiculos.repository.VendedorRepository;

public class ClienteService {
    ClienteRepository clienteRepository = new ClienteRepository();

    public void cadastrarCliente(Cliente cliente) throws ClienteCadastradoException {
        if (consultarCliente(cliente.getCpf()) != null) {
            throw new ClienteCadastradoException();
        }

        this.clienteRepository.cadastrarCliente(cliente);
    }


    public Cliente consultarCliente(String cpf){

        return this.clienteRepository.consultarCliente(cpf);
    }


    public void alterarCliente(Cliente cliente) throws ClienteNaoCadastradoException {
        if (consultarCliente(cliente.getCpf()) == null) {
            throw new ClienteNaoCadastradoException();
        }

        this.clienteRepository.alterarCliente(cliente);

    }

    public void excluirCliente(String cpf) throws VendedorNaoCadastradoException {
        if (consultarCliente(cpf) == null) {
            throw new VendedorNaoCadastradoException();
        }

        this.clienteRepository.excluirCliente(cpf);

    }
}
