package com.gerenciadorveiculos.view;

import com.gerenciadorveiculos.exceptions.ClienteCadastradoException;
import com.gerenciadorveiculos.exceptions.ClienteNaoCadastradoException;
import com.gerenciadorveiculos.exceptions.VendedorNaoCadastradoException;
import com.gerenciadorveiculos.model.Cliente;
import com.gerenciadorveiculos.service.ClienteService;

import java.util.Scanner;

import static com.gerenciadorveiculos.view.MenuPrincipal.aguardar;

public class MenuCliente {
    private ClienteService clienteService;

    public MenuCliente() {
        this.clienteService = new ClienteService();
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

     public void exibirMenuCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha uma opçao:");
        System.out.println(" 1- Cadastrar");
        System.out.println(" 2- Alterar");
        System.out.println(" 3- Listar");
        System.out.println(" 4- Excluir");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                alterarCliente();
                break;
            case 3:
                listarCliente();
                break;
            case 4:
                excluirCliente();
                break;
            default:
                break;


        }
    }

    private void listarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cpf do Cliente:");
        String cpf = sc.next();

        Cliente cliente = this.clienteService.consultarCliente(cpf);

        if (cliente == null) {
            System.out.println("Cliente não cadastrado.");
            return;
        }

        System.out.println(cliente);
        System.out.println();
        aguardar(3);
    }

    private void cadastrarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Digite o nome do cliente:");
        String nome = sc.next();
        System.out.println("Digite o cpf do cliente:");
        String cpf = sc.next();
        System.out.println("Digite o telefone do cliente:");
        String telefone = sc.next();

        Cliente cliente = new Cliente(nome, cpf, telefone);
        try {
            this.clienteService.cadastrarCliente(cliente);
        } catch (ClienteCadastradoException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Cliente cadastrado com sucesso.");
        aguardar(1);
    }

    private void alterarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Alterar cpf do cliente:");
        String cpf = sc.next();
        System.out.println("Alterar nome do cliente:");
        String nome = sc.next();
        System.out.println("Alterar telefone do cliente:");
        String telefone = sc.next();

        Cliente cliente = new Cliente(cpf, nome, telefone);
        try {
            this.clienteService.alterarCliente(cliente);
        } catch (ClienteNaoCadastradoException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Cliente alterado com sucesso.");
        aguardar(1);
    }

    private void excluirCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cpf do cliente:");
        String cpf = sc.next();

        try {
            this.clienteService.excluirCliente(cpf);
        } catch (VendedorNaoCadastradoException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Cliente excluido com sucesso.");
        aguardar(1);
    }

}
