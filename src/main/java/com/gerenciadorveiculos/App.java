package com.gerenciadorveiculos;

import com.gerenciadorveiculos.view.MenuPrincipal;

import java.sql.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try {

            MenuPrincipal menuPrincipal = new MenuPrincipal();
            //menuPrincipal.exibirMenuPrincipal();

            //conexao
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String usuario = "postgres";
            String senha = "220504";

            Connection myConnection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com sucesso!");
            String cpf = "14785296363";
            int idade = 100;

            myConnection.close();

            //e/s -entrada/saida de dados
            Scanner entradaDeDados = new Scanner(System.in);

            System.out.println("Digite seu cpf:"); // parte de inserção
            cpf =  entradaDeDados.nextLine();

            System.out.println("Digite sua idade:");
            idade = entradaDeDados.nextInt();


            //System.out.println("Conectado com sucesso no banco de dados (:!");

            //insert into usuario (cpf, idade) values (?, ?);

            String comandoSQL = "insert into usuario (cpf, idade) values(?,?)";

            PreparedStatement pstm = myConnection.prepareStatement(comandoSQL);

            pstm.setString(1, cpf);
            pstm.setInt(2, idade);
            pstm.execute();

            System.out.println("Digite o cpf que deseja pesquisar:");
            entradaDeDados.nextLine(); ///tenho que colocar o nextLine pq se não vai travar essa sessão
            ///no terminal

            ///parte de consulta
            String cpfPesquisa = entradaDeDados.nextLine();

            String comandoSQlConsulta = "select codigo, cpf, idade from usuario where cpf like ?";

            PreparedStatement pstmConsulta = myConnection.prepareStatement(comandoSQlConsulta);

            pstmConsulta.setString(1, cpfPesquisa + "%");

            ResultSet resultadoConsulta =	pstmConsulta.executeQuery();


            while(resultadoConsulta.next()) {

                //extrair os dados do resultset

                int codigo = resultadoConsulta.getInt("codigo");
                String cpf1 = resultadoConsulta.getString("cpf");
                int idade1 = resultadoConsulta.getInt("idade");

                System.out.println("Código:" + codigo);
                System.out.println("CPF:" + cpf1);
                System.out.println("Idade:" + idade1);
            }

            myConnection.prepareStatement(comandoSQlConsulta);

            myConnection.close();
            entradaDeDados.close();


        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}