package org.example;

import dao.AnotacaoDAO;
import dao.CategoriaDAO;
import dao.DBConnection;
import model.Anotacao;
import model.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("[1] - Adicionar anotação");
            System.out.println("[2] - Remover anotação");
            System.out.println("[3] - Atualizar anotação");
            System.out.println("[4] - Visualizar anotação");
            System.out.println("[0] - Para sair");

            opcao = sc.nextInt();


            if (opcao == 1) {
                AnotacaoDAO anotacaoDAO = new AnotacaoDAO();
                String titulo;
                String conteudo;
                String data;
                int categoria;

                System.out.println("Digite o titulo da anotação: ");
                sc.nextLine();
                titulo = sc.nextLine();

                System.out.println("Digite o conteudo da anotação: ");
                conteudo = sc.nextLine();

                System.out.println("Digite a data da anotação: ");
                data = sc.nextLine();

                System.out.println("Digite a categoria da anotação: ");
                categoria = sc.nextInt();

                anotacaoDAO.inserir(titulo, conteudo, data, categoria);
            } else if (opcao == 2) {
                AnotacaoDAO anotacaoDAO = new AnotacaoDAO();
                int id;

                System.out.println("Digite o ID do registro que deseja deletar: ");
                sc.nextLine();
                id = sc.nextInt();

                anotacaoDAO.deletar(id);
            } else if (opcao == 3) {
                int opcao3;
                do {
                    System.out.println("[1] - Atualizar a coluna Titulo");
                    System.out.println("[2] - Atualizar a coluna Conteúdo");
                    System.out.println("[3] - Atualizar a coluna Data");
                    System.out.println("[4] - Atualizar a coluna de Categoria");
                    System.out.println("[0] - Para voltar ao Menu Principal");


                    opcao3 = sc.nextInt();
                    if (opcao3 == 1) {
                        AnotacaoDAO anotacaoDAO = new AnotacaoDAO();
                        String novaAnotacao;
                        int id;

                        System.out.println("Digte o titulo que deseja atualizar: ");
                        sc.nextLine();
                        novaAnotacao = sc.nextLine();
                        System.out.println("Digte o ID: ");
                        id = sc.nextInt();

                        anotacaoDAO.atualizar("titulo", novaAnotacao, id);
                    }
                    if (opcao3 == 2) {
                        AnotacaoDAO anotacaoDAO = new AnotacaoDAO();
                        String novaAnotacao;
                        int id;

                        System.out.println("Digte o titulo que deseja atualizar: ");
                        sc.nextLine();
                        novaAnotacao = sc.nextLine();
                        System.out.println("Digte o ID: ");
                        id = sc.nextInt();

                        anotacaoDAO.atualizar("conteudo", novaAnotacao, id);
                    }
                    if (opcao3 == 3) {
                        AnotacaoDAO anotacaoDAO = new AnotacaoDAO();
                        String novaAnotacao;
                        int id;

                        System.out.println("Digite o titulo2 que deseja atualizar: ");
                        sc.nextLine();
                        novaAnotacao = sc.nextLine();
                        System.out.println("Digite o ID: ");
                        id = sc.nextInt();

                        anotacaoDAO.atualizar("data", novaAnotacao, id);
                    }
                    if (opcao3 == 4) {
                        AnotacaoDAO anotacaoDAO = new AnotacaoDAO();
                        String novaAnotacao;
                        int id;

                        System.out.println("Digite o texto que deseja atualizar: ");
                        sc.nextLine();
                        novaAnotacao = sc.nextLine();
                        System.out.println("Digite o ID: ");
                        id = sc.nextInt();

                        anotacaoDAO.atualizar("categoria_id", novaAnotacao, id);
                    }
                } while (opcao3 != 0);

            } else if (opcao == 4) {
                AnotacaoDAO anotacaoDAO = new AnotacaoDAO();
                List<Anotacao> anotacao = anotacaoDAO.listar();
                for (Anotacao a : anotacao) {
                    System.out.println(a);
                }
            }
        } while (opcao != 0);
    }
}