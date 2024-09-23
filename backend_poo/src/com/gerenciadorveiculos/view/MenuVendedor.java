package src.com.gerenciadorveiculos.view;

import src.com.gerenciadorveiculos.exceptions.VeiculoNaoCadastradoException;
import src.com.gerenciadorveiculos.exceptions.VendedorCadastradoException;
import src.com.gerenciadorveiculos.exceptions.VendedorNaoCadastradoException;
import src.com.gerenciadorveiculos.model.Veiculo;
import src.com.gerenciadorveiculos.model.Vendedor;
import src.com.gerenciadorveiculos.service.VendedorService;

import java.util.Scanner;

import static src.com.gerenciadorveiculos.view.MenuPrincipal.aguardar;

public class MenuVendedor {
    private VendedorService vendedorService;

    public VendedorService getVendedorService() {
        return vendedorService;
    }

    public MenuVendedor() {
        this.vendedorService = new VendedorService();
    }

     public void exibirMenuVendedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma opçao:");
        System.out.println(" 1- Cadastrar");
        System.out.println(" 2- Alterar");
        System.out.println(" 3- Listar");
        System.out.println(" 4- Excluir");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                cadastrarVendedor();
                break;
            case 2:
                alterarVendedor();
                break;
            case 3:
                listarVendedor();
                break;
            case 4:
                excluirVendedor();
                break;
            default:
                break;


        }
    }

    private void listarVendedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cpf do vendedor:");
        String cpf = sc.next();

        Vendedor vendedor = this.vendedorService.consultarVendedor(cpf);

        if (vendedor == null) {
            System.out.println("Vendedor não cadastrado.");
            return;
        }

        System.out.println(vendedor);
        System.out.println();
        aguardar(3);
    }

    private void cadastrarVendedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Digite o nome do vendedor:");
        String nome = sc.next();
        System.out.println("Digite o cpf do vendedor:");
        String cpf = sc.next();
        System.out.println("Digite o telefone do vendedor:");
        String telefone = sc.next();

        Vendedor vendedor = new Vendedor(nome, cpf, telefone);
        try {
            this.vendedorService.cadastrarVendedor(vendedor);
        } catch (VendedorCadastradoException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Vendedor cadastrado com sucesso.");
        aguardar(1);
    }

    private void alterarVendedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Alterar cpf do vendedor:");
        String cpf = sc.next();
        System.out.println("Alterar nome do vendedor:");
        String nome = sc.next();
        System.out.println("Alterar telefone do vendedor:");
        String telefone = sc.next();

        Vendedor vendedor = new Vendedor(cpf, nome, telefone);
        try {
            this.vendedorService.alterarVendedor(vendedor);
        } catch (VendedorNaoCadastradoException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Vendedor alterado com sucesso.");
        aguardar(1);
    }

    private void excluirVendedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cpf do vendedor:");
        String cpf = sc.next();

        try {
            this.vendedorService.excluirVendedor(cpf);
        } catch (VendedorNaoCadastradoException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Vendedor excluido com sucesso.");
        aguardar(1);
    }

}
