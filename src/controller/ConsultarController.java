package controller;

import repository.ProdutoList;

public class ConsultarController {
    public static void consultarProduto() {
        System.out.println("Os produtos são:\n");

        for (int i = 0; i < ProdutoList.produtoArrayList.size(); i++) {
            System.out.printf("%s. ", i);
            System.out.println(ProdutoList.produtoArrayList.get(i));
            System.out.println("---------------------------");
        }

    }
}
