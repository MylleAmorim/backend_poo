package com.gerenciadorveiculos.service;

import com.gerenciadorveiculos.exceptions.ClienteCadastradoException;
import com.gerenciadorveiculos.exceptions.ClienteNaoCadastradoException;
import com.gerenciadorveiculos.exceptions.VendedorNaoCadastradoException;
import com.gerenciadorveiculos.model.Cliente;
import com.gerenciadorveiculos.repository.postgres.ClienteRepository;


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
