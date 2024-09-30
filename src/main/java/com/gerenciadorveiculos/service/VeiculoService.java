package com.gerenciadorveiculos.service;

import com.gerenciadorveiculos.exceptions.VeiculoCadastradoException;
import com.gerenciadorveiculos.exceptions.VeiculoNaoCadastradoException;
import com.gerenciadorveiculos.model.Veiculo;
import com.gerenciadorveiculos.repository.postgres.VeiculoRepository;

public class VeiculoService {
    VeiculoRepository veiculoRepository = new VeiculoRepository();

    public void cadastrarVeiculo(Veiculo veiculo) throws VeiculoCadastradoException {
        if (consultarVeiculoPorPlaca(veiculo.getPlaca()) != null) {
            throw new VeiculoCadastradoException();
        }

        this.veiculoRepository.cadastrarVeiculo(veiculo);
    }

    public Veiculo consultarVeiculoPorPlaca(String placa){
        return this.veiculoRepository.consultarVeiculoPorPlaca(placa);
    }

    public void alterarVeiculo(Veiculo veiculo) throws VeiculoNaoCadastradoException {
        if (consultarVeiculoPorPlaca(veiculo.getPlaca()) == null) {
            throw new VeiculoNaoCadastradoException();
        }

        this.veiculoRepository.alterarVeiculo(veiculo);

    }

    public void excluirVeiculoPorPlaca(String placa) throws VeiculoNaoCadastradoException {
        if (consultarVeiculoPorPlaca(placa) == null) {
            throw new VeiculoNaoCadastradoException();
        }

        this.veiculoRepository.excluirVeiculo(placa);

    }
}
