package com.gerenciadorveiculos.repository.postgres;

import com.gerenciadorveiculos.model.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeiculoRepository {

    public void cadastrarVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO Veiculo (placa,marca,modelo,ano,categoria,descricao,preco) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, veiculo.getPlaca());
            statement.setString(2, veiculo.getMarca());
            statement.setString(3, veiculo.getModelo());
            statement.setInt   (4, veiculo.getAno());
            statement.setString(5, veiculo.getCategoria());
            statement.setString(6, veiculo.getDescricao());
            statement.setDouble(7, veiculo.getPreco());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Veiculo consultarVeiculoPorPlaca(String placa) {
        Veiculo veiculo = null;
        String sql = "SELECT * FROM Veiculo WHERE placa = ?";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, placa);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                int ano = resultSet.getInt("ano");
                String categoria = resultSet.getString("categoria");
                String descricao = resultSet.getString("descricao");
                double preco = resultSet.getDouble("preco");


                veiculo = new Veiculo(placa, marca, modelo, ano, categoria, descricao, preco);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return veiculo;
    }

    public void alterarVeiculo(Veiculo veiculo) {
        String sql = "SELECT * FROM Veiculo WHERE placa = ?";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, veiculo.getMarca());
            statement.setString(2, veiculo.getModelo());
            statement.setInt   (3, veiculo.getAno());
            statement.setString(4, veiculo.getCategoria());
            statement.setString(5, veiculo.getDescricao());
            statement.setDouble(6, veiculo.getPreco());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirVeiculo(String placa) {
        String sql = "DELETE FROM Veiculo WHERE cpf = ?";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, placa);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
