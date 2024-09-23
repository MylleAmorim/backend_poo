package src.com.gerenciadorveiculos.view;

import src.com.gerenciadorveiculos.exceptions.VeiculoCadastradoException;
import src.com.gerenciadorveiculos.exceptions.VeiculoNaoCadastradoException;
import src.com.gerenciadorveiculos.exceptions.VendedorCadastradoException;
import src.com.gerenciadorveiculos.exceptions.VendedorNaoCadastradoException;
import src.com.gerenciadorveiculos.model.Veiculo;
import src.com.gerenciadorveiculos.model.Vendedor;
import src.com.gerenciadorveiculos.service.VeiculoService;
import src.com.gerenciadorveiculos.service.VendedorService;

import java.util.Scanner;

public class MenuPrincipal {
    MenuVeiculo menuVeiculo;
    MenuVendedor menuVendedor;
    MenuCliente menuCliente;
    MenuVenda menuVenda;

    public MenuPrincipal() {
        this.menuVeiculo = new MenuVeiculo();
        this.menuVendedor = new MenuVendedor();
        this.menuCliente = new MenuCliente();
        this.menuVenda = new MenuVenda(
                menuVendedor.getVendedorService(),
                menuVeiculo.getVeiculoService(),
                menuCliente.getClienteService()
        );
    }

    public void exibirMenuPrincipal() {
        int opcao = 0;
        while (opcao != 9) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println();
                System.out.println("***************************");
                System.out.println("*** Sistema de Veiculos ***");
                System.out.println("***************************");
                System.out.println("Escolha uma opçao:");
                System.out.println(" 1- Veiculos");
                System.out.println(" 2- Vendedores");
                System.out.println(" 3- Clientes");
                System.out.println(" 4- Vendas");
                System.out.println(" 9- Sair");
                opcao = sc.nextInt();
                System.out.println();

                switch (opcao) {
                    case 1:
                        menuVeiculo.exibirMenuVeiculo();
                        break;
                    case 2:
                        menuVendedor.exibirMenuVendedor();
                        break;
                    case 3:
                        menuCliente.exibirMenuCliente();
                        break;
                    case 4:
                        menuVenda.exibirMenuVenda();
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void aguardar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
