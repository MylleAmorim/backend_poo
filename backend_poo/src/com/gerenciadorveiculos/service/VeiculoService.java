package src.com.gerenciadorveiculos.service;

import src.com.gerenciadorveiculos.exceptions.VeiculoCadastradoException;
import src.com.gerenciadorveiculos.exceptions.VeiculoNaoCadastradoException;
import src.com.gerenciadorveiculos.model.Veiculo;
import src.com.gerenciadorveiculos.repository.VeiculoRepository;

import java.util.HashMap;
import java.util.Map;

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
