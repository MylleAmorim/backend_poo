package src.com.gerenciadorveiculos.service;

import src.com.gerenciadorveiculos.exceptions.VeiculoCadastradoException;
import src.com.gerenciadorveiculos.exceptions.VeiculoNaoCadastradoException;
import src.com.gerenciadorveiculos.exceptions.VendedorCadastradoException;
import src.com.gerenciadorveiculos.exceptions.VendedorNaoCadastradoException;
import src.com.gerenciadorveiculos.model.Veiculo;
import src.com.gerenciadorveiculos.model.Vendedor;
import src.com.gerenciadorveiculos.repository.VeiculoRepository;
import src.com.gerenciadorveiculos.repository.VendedorRepository;

public class VendedorService {
    VendedorRepository vendedorRepository = new VendedorRepository();
    public void cadastrarVendedor(Vendedor vendedor) throws VendedorCadastradoException {
        if (consultarVendedor(vendedor.getCpf()) != null) {
            throw new VendedorCadastradoException();
        }

        this.vendedorRepository.cadastrarVendedor(vendedor);
    }

    public Vendedor consultarVendedor(String cpf){
        return this.vendedorRepository.consultarVendedor(cpf);
    }

    public void alterarVendedor(Vendedor vendedor) throws VendedorNaoCadastradoException {
        if (consultarVendedor(vendedor.getCpf()) == null) {
            throw new VendedorNaoCadastradoException();
        }

        this.vendedorRepository.alterarVendedor(vendedor);

    }

    public void excluirVendedor(String cpf) throws VendedorNaoCadastradoException {
        if (consultarVendedor(cpf) == null) {
            throw new VendedorNaoCadastradoException();
        }

        this.vendedorRepository.excluirVendedor(cpf);

    }
}
