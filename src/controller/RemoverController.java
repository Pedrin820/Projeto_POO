package controller;

import repository.ProdutoList;
import view.MenuInicial;

import java.util.Scanner;

public class RemoverController {
    public static void removerProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva o ID do produto que deseja remover\n");

        ConsultarController.consultarProduto();

        System.out.print("\nDigite o ID para remover: ");
        int id = scanner.nextInt();

        if (id >= ProdutoList.produtoArrayList.size()) {
            System.out.println("ID Inválido!");
            MenuInicial.mostrarMenuPrincipal();
        }
        else {
            ProdutoList.produtoArrayList.remove(id);
            System.out.println("Produto removido com sucesso!");
            MenuInicial.mostrarMenuPrincipal();
        }
    }
}
