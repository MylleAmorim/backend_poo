package com.gerenciadorveiculos.repository.postgres;

import com.gerenciadorveiculos.model.Cliente;
import com.gerenciadorveiculos.model.Vendedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorRepository {

    public void cadastrarVendedor(Vendedor vendedor) {
        String sql = "INSERT INTO Vendedor (cpf, nome, telefone) VALUES (?, ?, ?)";
        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, vendedor.getCpf());
            statement.setString(2, vendedor.getNome());
            statement.setString(3, vendedor.getTelefone());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Vendedor consultarVendedor(String cpf) {
        Vendedor vendedor = null;
        String sql = "SELECT * FROM Vendedor WHERE cpf = ?";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                vendedor = new Vendedor(nome, cpf, telefone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vendedor;
    }

    public void alterarVendedor(Vendedor vendedor) {
        String sql = "UPDATE Vendedor SET nome = ?, telefone = ? WHERE cpf = ?";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, vendedor.getNome());
            statement.setString(2, vendedor.getTelefone());
            statement.setString(3, vendedor.getCpf());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirVendedor(String cpf) {
        String sql = "DELETE FROM Vendedor WHERE cpf = ?";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, cpf);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
