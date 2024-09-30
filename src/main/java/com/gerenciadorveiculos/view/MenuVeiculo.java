package com.gerenciadorveiculos.view;

import com.gerenciadorveiculos.exceptions.VeiculoCadastradoException;
import com.gerenciadorveiculos.exceptions.VeiculoNaoCadastradoException;
import com.gerenciadorveiculos.model.Veiculo;
import com.gerenciadorveiculos.service.VeiculoService;

import java.util.Scanner;

import static com.gerenciadorveiculos.view.MenuPrincipal.aguardar;

public class MenuVeiculo {
    private VeiculoService veiculoService;

    public MenuVeiculo() {
        this.veiculoService = new VeiculoService();
    }

    public VeiculoService getVeiculoService() {
        return veiculoService;
    }

    public void exibirMenuVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma opçao:");
        System.out.println(" 1- Cadastrar");
        System.out.println(" 2- Alterar");
        System.out.println(" 3- Listar");
        System.out.println(" 4- Excluir");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                cadastrarVeiculo();
                break;
            case 2:
                alterarVeiculo();
                break;
            case 3:
                listarVeiculo();
                break;
            case 4:
                excluirVeiculo();
                break;
            default:
                break;


        }
    }

    private void listarVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a placa do veiculo:");
        String placa = sc.next();

        Veiculo veiculo = this.veiculoService.consultarVeiculoPorPlaca(placa);

        if (veiculo == null) {
            System.out.println("Veículo não cadastrado.");
            return;
        }

        System.out.println(veiculo);
        System.out.println();
        aguardar(3);
    }

    private void cadastrarVeiculo() {
        System.out.println("Digite a placa do veiculo:");
        String placa = new Scanner(System.in).next();
        System.out.println("Digite a marca do veiculo:");
        String marca = new Scanner(System.in).next();
        System.out.println("Digite o modelo do veiculo:");
        String modelo = new Scanner(System.in).next();
        System.out.println("Digite o ano do veiculo:");
        int ano = new Scanner(System.in).nextInt();
        System.out.println("Digite a categoria do veiculo:");
        String categoria = new Scanner(System.in).next();
        System.out.println("Digite a descrição do veiculo:");
        String descricao = new Scanner(System.in).next();
        System.out.println("Digite o preço do veiculo:");
        Double preco = new Scanner(System.in).nextDouble();

        Veiculo veiculo = new Veiculo(placa, marca, modelo, ano, categoria,descricao,preco);
        try {
            this.veiculoService.cadastrarVeiculo(veiculo);
        } catch (VeiculoCadastradoException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Veículo cadastrado com sucesso.");
        aguardar(1);
    }

    private void alterarVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Alterar a placa do veiculo:");
        String placa = sc.next();
        System.out.println("Alterar a marca do veiculo:");
        String marca = sc.next();
        System.out.println("Alterar o modelo do veiculo:");
        String modelo = sc.next();
        System.out.println("Alterar o ano do veiculo:");
        int ano = sc.nextInt();
        System.out.println("Alterar a categoria do veiculo:");
        String categoria = sc.next();
        System.out.println("Alterar a descrição do veiculo:");
        String descricao = sc.next();
        System.out.println("Alterar o preço do veiculo:");
        Double preco = sc.nextDouble();

        Veiculo veiculo = new Veiculo(placa, marca, modelo, ano, categoria,descricao,preco);
        try {
            this.veiculoService.alterarVeiculo(veiculo);
        } catch (VeiculoNaoCadastradoException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Veículo alterado com sucesso.");
        aguardar(1);
    }

    private void excluirVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a placa do veiculo:");
        String placa = sc.next();

        Veiculo veiculo = null;
        try {
            this.veiculoService.excluirVeiculoPorPlaca(placa);
        } catch (VeiculoNaoCadastradoException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Veículo excluido com sucesso.");
        aguardar(1);
    }

}
