package src.com.gerenciadorveiculos.repository;

import src.com.gerenciadorveiculos.model.Venda;

import java.util.*;

public class VendaRepository {
    Map<Integer, Venda> vendas = new HashMap<>();

    public void cadastrarVenda(Venda venda) {
        venda.setId(vendas.size() + 1);
        this.vendas.put(venda.getId(), venda);
    }

    public Collection<Venda> listarVendas() {
        return vendas.values();
    }

    public Venda consultarVenda(Integer id) {
        return vendas.getOrDefault(id, null);
    }

    public void alterarVenda(Venda venda) {
        this.vendas.put(venda.getId(), venda);
    }

    public void excluirVenda(Integer id) {
        this.vendas.remove(id);
    }
}
