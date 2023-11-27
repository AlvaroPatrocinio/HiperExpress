package com.mycompany.hiperexpress;
import java.util.ArrayList;
import java.util.List;



public class HiperExpress {
    
     private static List<Caixa> caixas;

     static {
        // Inicialização da lista de caixas
        caixas = new ArrayList<>();
        caixas.add(new Caixa(1, "Rápida"));
        caixas.add(new Caixa(2, "Preferencial"));
        caixas.add(new Caixa(3, "Normal"));
        caixas.add(new Caixa(4, "Normal"));
        caixas.add(new Caixa(5, "Normal"));
    }

    // Acessar os caixas
    public static List<Caixa> getCaixas() {
        return caixas;
    }


    public static void main(String[] args) {

        
        //Criar produto
        Produto produto1 = new Produto("Arroz", 1.5, "Alimento");
        Produto produto2 = new Produto("Feijão", 2.0, "Alimento");

        // Criação do estoque
        Estoque estoque = new Estoque();
        
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
        }
    }
    
}