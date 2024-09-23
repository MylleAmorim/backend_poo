package src.com.gerenciadorveiculos.repository;

import src.com.gerenciadorveiculos.model.Veiculo;

import java.util.HashMap;
import java.util.Map;

public class VeiculoRepository {
    Map<String, Veiculo> veiculos = new HashMap<>();

    public void cadastrarVeiculo(Veiculo veiculo) {
        this.veiculos.put(veiculo.getPlaca(), veiculo);
    }

    public Veiculo consultarVeiculoPorPlaca(String placa) {
        return veiculos.getOrDefault(placa, null);
    }

    public void alterarVeiculo(Veiculo veiculo) {
        this.veiculos.put(veiculo.getPlaca(), veiculo);
    }

    public void excluirVeiculo(String placa) {
        this.veiculos.remove(placa);
    }
}
