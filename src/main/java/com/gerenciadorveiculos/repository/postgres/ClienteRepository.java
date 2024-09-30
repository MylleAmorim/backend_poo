package com.gerenciadorveiculos.repository.postgres;

import com.gerenciadorveiculos.model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class ClienteRepository {

    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (cpf, nome, telefone) VALUES (?, ?, ?)";
        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, cliente.getCpf());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getTelefone());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente consultarCliente(String cpf) {
        Cliente cliente = null;
        String sql = "SELECT * FROM Cliente WHERE cpf = ?";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                cliente = new Cliente(nome, cpf, telefone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    public Collection<Cliente> consultarClientePorNome(String nomePesquisado) {
        Collection<Cliente> cliente = null;
        String sql = "select * from cliente where nome like '%?%'";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, nomePesquisado);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String cpf = resultSet.getString("cpf");
                cliente.add(new Cliente(nome, cpf, telefone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    public void alterarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ?, telefone = ? WHERE cpf = ?";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getCpf());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirCliente(String cpf) {
        String sql = "DELETE FROM Cliente WHERE cpf = ?";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, cpf);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
