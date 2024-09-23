package com.gerenciadorveiculos.repository;

import com.gerenciadorveiculos.model.Venda;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
