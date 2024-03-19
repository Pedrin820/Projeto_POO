package controller;

import model.Usuario;
import repository.UsuariosList;
import view.MenuInicial;

import java.util.Scanner;

public class UsuarioController {
    private static Scanner scanner = new Scanner(System.in);
    private static UsuariosList usuariosList = new UsuariosList();
    private static String nome;
    private static String senha;

    public static void registrarUsuario() {
        System.out.print("Informe o nome do usuário: ");
        nome = scanner.nextLine();

        if (usuarioCadastrado(nome)) {
            System.out.println("Já existe um usuário cadastrado com esse nome.");
            MenuInicial.mostrarMenuLogin();
        } else {
            System.out.print("Informe a senha do usuário: ");
            senha = scanner.nextLine();

            System.out.printf("Usuário %s cadastrado com sucesso!\n", nome);

            usuariosList.usuarioArrayList.add(new Usuario(nome, senha));
            MenuInicial.mostrarMenuLogin();
        }
    }

    public static void logarUsuario() {
        System.out.print("Insira o usuário: ");
        nome = scanner.nextLine();

        System.out.print("Insira a senha: ");
        senha = scanner.nextLine();

        if (nome.equalsIgnoreCase("Lucas")) {
            System.out.println("Usuário invalido. A dica é um vilão do superman.");
            MenuInicial.mostrarMenuLogin();
        } else if (usuarioCadastrado(nome)) {
            if (usuarioValido(nome, senha)) {
                MenuInicial.mostrarMenuPrincipal();
            } else {
                System.out.println("Usuário ou senha inválida!");
                MenuInicial.mostrarMenuLogin();
            }
        } else {
            System.out.println("Usuário não cadastrado!");
            MenuInicial.mostrarMenuLogin();
        }
    }

    public static boolean usuarioCadastrado(String nome) {
        for (int i = 0; i < usuariosList.usuarioArrayList.size(); i++) {
            if (usuariosList.usuarioArrayList.get(i).getNome().equals(nome))  {
                return true;
            }
        }
        return false;
    }

    public static boolean usuarioValido(String nome, String senha) {
        for (Usuario usuario : usuariosList.usuarioArrayList) {
            if (usuario.getNome().equals(nome) &&  usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public static void registrarLucas() {
        usuariosList.usuarioArrayList.add(new Usuario("Lucas", "123"));
        usuariosList.usuarioArrayList.add(new Usuario("Lex Luthor", "123"));
    }
}
