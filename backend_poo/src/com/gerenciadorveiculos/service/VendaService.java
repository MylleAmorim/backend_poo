package src.com.gerenciadorveiculos.service;

import src.com.gerenciadorveiculos.exceptions.VendaNaoCadastradaException;
import src.com.gerenciadorveiculos.exceptions.VendedorNaoCadastradoException;
import src.com.gerenciadorveiculos.model.Venda;
import src.com.gerenciadorveiculos.model.Vendedor;
import src.com.gerenciadorveiculos.repository.VendaRepository;

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
