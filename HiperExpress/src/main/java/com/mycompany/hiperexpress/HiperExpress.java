package com.mycompany.hiperexpress;
import java.util.ArrayList;
import java.util.List;
        
public class HiperExpress {
    
private static ArrayList<Produto> produtos;

private static List<Caixa> caixas;

private Estoque estoque = new Estoque();
        
        
public static void main(String[] args) {
       
       Sistema sistema = Sistema.getInstance();
       sistema.menuadm();
       
            

        /*
        // Adicionar produtos
        estoque.adicionarProduto(produto1, 50);
        estoque.adicionarProduto(produto2, 30);
        
        // Remover produtos
        estoque.removerProduto(produto2, 15);
        estoque.removerProduto(produto1, 25);
        
        // Verificar Produto
        estoque.verificarEstoque(produto1);
        estoque.verificarEstoque(produto2);
        
        // Exibir estoque
        estoque.exibirEstoque();

        // Criação da venda
        Venda venda = new Venda();

        // Adição de itens à venda
        venda.adicionarItemVenda(produto1, 3, estoque);
        venda.adicionarItemVenda(produto2, 2, estoque);

        // Finalização da venda
        venda.finalizarVenda();
        
        // Caixas
       
        List<Caixa> testcaixas = getCaixas();
        for (Caixa caixa : testcaixas) {
            System.out.println(caixa);
        } */
    
    
    }
}