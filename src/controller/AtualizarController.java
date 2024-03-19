package controller;

import repository.ProdutoList;
import view.MenuInicial;

import java.util.Scanner;

public class AtualizarController {

    public static void atualizarProduto() {
        Scanner scanner = new Scanner(System.in);
        ConsultarController.consultarProduto();

        System.out.print("Digite o ID do produto que deseja atualizar: ");

        int id = scanner.nextInt();
        scanner.nextLine();

        if (idInvalido(id)) {
            System.out.println("ID inválido.");
            MenuInicial.mostrarMenuPrincipal();
        } else {
            System.out.println(ProdutoList.produtoArrayList.get(id));
            System.out.print("""
                    O que você deseja modificar?
                                        
                    1. Nome
                    2. Quantidade
                    3. Preço
                    ->\s""");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1" -> {
                    System.out.println("Digite o novo nome do produto:");
                    String nome = scanner.nextLine();
                    atualizarNome(id, nome);
                }
                case "2" -> {
                    System.out.println("Digite a nova quantidade do produto:");
                    int quantidade = scanner.nextInt();
                    atualizarQuantidade(id, quantidade);
                }
                case "3" -> {
                    System.out.println("Digite o novo preço: ");
                    float preco = scanner.nextFloat();
                    atualizarPreco(id, preco);
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    public static void atualizarNome(int id, String nome) {
        if (nomeInvalido(nome)) {
            System.out.println("Já existe um produto com esse nome!");
        } else {
            ProdutoList.produtoArrayList.get(id).setNome(nome);
            System.out.println("Nome atualizado com sucesso!");
        }
    }

    public static void atualizarQuantidade(int id, int quantidade) {
        if (!quantidadeInvalida(id)) {
            System.out.println("Quantidade inválida!");
        } else {
            ProdutoList.produtoArrayList.get(id).setQuantidade(quantidade);
            System.out.println("Quantidade atualizada com sucesso!");
        }
    }

    public static void atualizarPreco(int id, float preco) {
        if (!precoInvalido(preco)) {
            System.out.println("Quantidade inválida!");
        } else {
            ProdutoList.produtoArrayList.get(id).setPreco(preco);
            System.out.println("Preço atualizada com sucesso!");
        }
    }

    public static boolean idInvalido(int id) {
        if (id >= ProdutoList.produtoArrayList.size()) {
            return true;
        }
        return false;
    }

    public static boolean precoInvalido(float preco) {
        if (preco >= 0) {
            return true;
        }
        return false;
    }

    public static boolean nomeInvalido(String nome) {
        for (int i = 0; i < ProdutoList.produtoArrayList.size(); i++) {
            if (ProdutoList.produtoArrayList.get(i).getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public static boolean quantidadeInvalida(int quantidade) {
        if (quantidade >= 0) {
            return true;
        }
        return false;
    }
}