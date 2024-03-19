package controller;

import model.Produto;
import repository.ProdutoList;
import view.MenuInicial;

import java.util.Scanner;

public class AdicionarController {
    public static void adicionarProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        if (produtoExistente(nome)) {
            System.out.println("Produto já cadastrado no sistema, insira outro produto.");
            MenuInicial.mostrarMenuPrincipal();
        }

        System.out.println("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();

        if (quantidadeInvalida(quantidade)){
            System.out.println("Quantidade inválida.");
            MenuInicial.mostrarMenuPrincipal();
        }

        System.out.println("Digite o preço do produto: ");
        float preco = scanner.nextFloat();

        if (precoInvalido(preco)) {
            System.out.println("Preço inválido.");
            MenuInicial.mostrarMenuPrincipal();
        }

        ProdutoList.produtoArrayList.add(new Produto(nome, quantidade, preco));
    }

    public static boolean produtoExistente(String nome) {
        for (int i = 0; i < ProdutoList.produtoArrayList.size(); i++) {
            if (ProdutoList.produtoArrayList.get(i).getNome().equalsIgnoreCase(nome))  {
                return true;
            }
        }
        return false;
    }

    public static boolean precoInvalido(float preco) {
        if (preco <= 0) {
            return true;
        }
        return false;
    }

    public static boolean quantidadeInvalida(int quantidade) {
        if (quantidade <= 0) {
            return true;
        }
        return false;
    }
}
