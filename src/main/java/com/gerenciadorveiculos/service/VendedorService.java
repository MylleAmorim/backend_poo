package com.gerenciadorveiculos.service;

import com.gerenciadorveiculos.exceptions.VendedorCadastradoException;
import com.gerenciadorveiculos.exceptions.VendedorNaoCadastradoException;
import com.gerenciadorveiculos.model.Vendedor;
import com.gerenciadorveiculos.repository.postgres.VendedorRepository;

public class VendedorService {
    VendedorRepository vendedorRepository = new VendedorRepository();
    public void cadastrarVendedor(Vendedor vendedor) throws VendedorCadastradoException {
        if (consultarVendedor(vendedor.getCpf()) != null) {
            throw new VendedorCadastradoException();
        }

        this.vendedorRepository.cadastrarVendedor(vendedor);
    }

    public Vendedor consultarVendedor(String cpf){
        return this.vendedorRepository.consultarVendedor(cpf);
    }

    public void alterarVendedor(Vendedor vendedor) throws VendedorNaoCadastradoException {
        if (consultarVendedor(vendedor.getCpf()) == null) {
            throw new VendedorNaoCadastradoException();
        }

        this.vendedorRepository.alterarVendedor(vendedor);

    }

    public void excluirVendedor(String cpf) throws VendedorNaoCadastradoException {
        if (consultarVendedor(cpf) == null) {
            throw new VendedorNaoCadastradoException();
        }

        this.vendedorRepository.excluirVendedor(cpf);

    }
}
