package com.gerenciadorveiculos.repository.postgres;

import com.gerenciadorveiculos.model.Cliente;
import com.gerenciadorveiculos.model.Veiculo;
import com.gerenciadorveiculos.model.Venda;
import com.gerenciadorveiculos.model.Vendedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class VendaRepository {

    private VeiculoRepository veiculoRepository = new VeiculoRepository();
    private VendedorRepository vendedorRepository = new VendedorRepository();
    private ClienteRepository clienteRepository = new ClienteRepository();

    public void cadastrarVenda(Venda venda) {
        String sql = "INSERT INTO Venda (veiculo_placa,vendedor_cpf,cliente_cpf,data_venda) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, venda.getVeiculoVendido().getPlaca());
            statement.setString(2, venda.getVendedorResponsavel().getCpf());
            statement.setString(3, venda.getClienteComprador().getCpf());
            statement.setString(4, venda.getDataDaVenda());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Venda consultarVenda(int id) {
        Venda venda = null;
        String sql = "SELECT * FROM Venda WHERE id = ?";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String veiculoPlaca = resultSet.getString("veiculo_placa");
                String vendedorCpf = resultSet.getString("vendedor_cpf");
                String clienteCpf = resultSet.getString("cliente_cpf");
                String dataDaVenda = resultSet.getString("data_venda");

                Veiculo veiculo = veiculoRepository.consultarVeiculoPorPlaca(veiculoPlaca);
                Vendedor vendedor = vendedorRepository.consultarVendedor(vendedorCpf);
                Cliente cliente = clienteRepository.consultarCliente(clienteCpf);

                venda = new Venda(veiculo,vendedor,cliente,dataDaVenda);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return venda;
    }

    public void alterarVenda(Venda venda) {
        String sql = "UPDATE Venda SET" +
                " veiculo_placa = ?," +
                " vendedor_cpf = ?," +
                " cliente_cpf = ?," +
                " data_venda = ?" +
                " WHERE id = ?";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setString(1, venda.getVeiculoVendido().getPlaca());
            statement.setString(2, venda.getVendedorResponsavel().getCpf());
            statement.setString(3, venda.getClienteComprador().getCpf());
            statement.setString(4, venda.getDataDaVenda());
            statement.setInt(5, venda.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirVenda(Integer id) {
        String sql = "DELETE FROM Venda WHERE id = ?";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Venda> listarVendas() {
        Collection<Venda> venda = new ArrayList<>();
        String sql = "SELECT * FROM Venda";

        try (PreparedStatement statement = Repository.getInstance().prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

             while (resultSet.next()) {
                String veiculoPlaca = resultSet.getString("veiculo_placa");
                String vendedorCpf = resultSet.getString("vendedor_cpf");
                String clienteCpf = resultSet.getString("cliente_cpf");
                String dataDaVenda = resultSet.getString("data_venda");

                Veiculo veiculo = veiculoRepository.consultarVeiculoPorPlaca(veiculoPlaca);
                Vendedor vendedor = vendedorRepository.consultarVendedor(vendedorCpf);
                Cliente cliente = clienteRepository.consultarCliente(clienteCpf);

                venda.add(new Venda(veiculo,vendedor,cliente,dataDaVenda));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return venda;
    }
}



