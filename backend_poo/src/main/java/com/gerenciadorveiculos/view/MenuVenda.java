package com.gerenciadorveiculos.view;

import com.gerenciadorveiculos.exceptions.VendaNaoCadastradaException;
import com.gerenciadorveiculos.model.Venda;
import com.gerenciadorveiculos.service.ClienteService;
import com.gerenciadorveiculos.service.VeiculoService;
import com.gerenciadorveiculos.service.VendaService;
import com.gerenciadorveiculos.service.VendedorService;

import java.util.Collection;
import java.util.Scanner;

import static com.gerenciadorveiculos.view.MenuPrincipal.aguardar;

public class MenuVenda {
    VendaService vendaService;
    VendedorService vendedorService;
    VeiculoService veiculoService;
    ClienteService clienteService;

    public MenuVenda(VendedorService vendedorService,
                     VeiculoService veiculoService,
                     ClienteService clienteService) {
        this.vendaService = new VendaService();
        this.vendedorService = vendedorService;
        this.veiculoService = veiculoService;
        this.clienteService = clienteService;
    }

     public void exibirMenuVenda() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma opçao:");
        System.out.println(" 1- Cadastrar");
        System.out.println(" 2- Alterar");
        System.out.println(" 3- Listar");
        System.out.println(" 4- Excluir");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                cadastrarVenda();
                break;
            case 2:
                alterarVenda();
                break;
            case 3:
                listarVenda();
                break;
            case 4:
                excluirVenda();
                break;
            default:
                break;


        }
    }

    private void listarVenda() {
        Scanner sc = new Scanner(System.in);
        Collection<Venda> vendas = this.vendaService.listarVendas();

        if (vendas.isEmpty()) {
            System.out.println("Não existem vendas cadastradas.");
            return;
        }

        System.out.println(vendas);
        System.out.println();
        aguardar(3);
    }

    private void cadastrarVenda() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Digite a placa do veiculo:");
        String placa = sc.next();
        System.out.println("Digite o cpf do vendedor:");
        String cpfVendedor = sc.next();
        System.out.println("Digite o cpf do cliente:");
        String cpfCliente = sc.next();
        System.out.println("Digite a data da compra:");
        String data = sc.next();

        var veiculo = veiculoService.consultarVeiculoPorPlaca(placa);
        var vendedor = vendedorService.consultarVendedor(cpfVendedor);
        var cliente = clienteService.consultarCliente(cpfCliente);


        Venda venda = new Venda(veiculo, vendedor, cliente, data);
        this.vendaService.cadastrarVenda(venda);

        System.out.println("Venda cadastrada com sucesso.");
        aguardar(1);
    }

    private void alterarVenda() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Digite a chave da venda:");
        Integer id = sc.nextInt();
        System.out.println(" Digite a placa do veiculo:");
        String placa = sc.next();
        System.out.println("Digite o cpf do vendedor:");
        String cpfVendedor = sc.next();
        System.out.println("Digite o cpf do cliente:");
        String cpfCliente = sc.next();
        System.out.println("Digite a data da compra:");
        String data = sc.next();

        var veiculo = veiculoService.consultarVeiculoPorPlaca(placa);
        var vendedor = vendedorService.consultarVendedor(cpfVendedor);
        var cliente = clienteService.consultarCliente(cpfCliente);

        Venda venda = new Venda(veiculo, vendedor, cliente, data);
        venda.setId(id);
        try {
            this.vendaService.alterarVenda(venda);
        } catch (VendaNaoCadastradaException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Venda alterada com sucesso.");
        aguardar(1);
    }

    private void excluirVenda() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a chave da venda:");
        Integer id = sc.nextInt();

        try {
            this.vendaService.excluirVenda(id);
        } catch (VendaNaoCadastradaException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Venda excluida com sucesso.");
        aguardar(1);
    }

}
