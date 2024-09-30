package com.gerenciadorveiculos.service;

import com.gerenciadorveiculos.exceptions.VendaNaoCadastradaException;
import com.gerenciadorveiculos.model.Venda;
import com.gerenciadorveiculos.repository.postgres.VendaRepository;

import java.util.Collection;

public class VendaService {
    VendaRepository vendaRepository = new VendaRepository();

    public void cadastrarVenda(Venda venda) {
        this.vendaRepository.cadastrarVenda(venda);
    }

    public Venda consultarVenda(Integer id){
        return this.vendaRepository.consultarVenda(id);
    }

    public Collection<Venda> listarVendas(){
        return this.vendaRepository.listarVendas();
    }

    public void alterarVenda(Venda venda) throws VendaNaoCadastradaException {
        if (consultarVenda(venda.getId()) == null) {
            throw new VendaNaoCadastradaException();
        }

        this.vendaRepository.alterarVenda(venda);

    }

    public void excluirVenda(Integer id) throws VendaNaoCadastradaException {
        if (consultarVenda(id) == null) {
            throw new VendaNaoCadastradaException();
        }

        this.vendaRepository.excluirVenda(id);

    }
}
