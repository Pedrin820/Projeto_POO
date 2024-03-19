package view;

import controller.*;

import java.util.Scanner;

public class MenuInicial {
    private static boolean executando = true;

    public static void mostrarMenuLogin() {
        Scanner scanner = new Scanner(System.in);
        UsuarioController.registrarLucas();
        System.out.print("""
                BEM-VINDO AO SISTEMA DE ESTOQUE!
                Faça o login ou registre-se para entrar no sistema.
                                
                1. Logar
                2. Registrar
                0. Sair
                                
                ->\s""");

        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1" -> {
                UsuarioController.logarUsuario();
            }
            case "2" -> {
                UsuarioController.registrarUsuario();
            }
            case "0" -> {
                System.exit(0);
            }
            default -> {
                System.out.println("Opção inválida!");
            }
        }
    }

    public static void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seja bem-vindo ao sistema de estoque!");
        while (executando) {
            System.out.print("""
                    O que você deseja fazer?

                    1. Adicionar Produto
                    2. Remover Produto
                    3. Consultar Produto(s)
                    4. Atualizar Produto
                    0. Deslogar
                    ->\s""");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1" -> AdicionarController.adicionarProduto();
                case "2" -> RemoverController.removerProduto();
                case "3" -> ConsultarController.consultarProduto();
                case "4" -> AtualizarController.atualizarProduto();
                case "0" -> mostrarMenuLogin();
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}