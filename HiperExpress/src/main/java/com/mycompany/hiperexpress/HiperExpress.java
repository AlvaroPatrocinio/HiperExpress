package com.mycompany.hiperexpress;

public class HiperExpress {
    

    public static void main(String[] args) {
        
        //Criar produto
        Produto produto1 = new Produto("Arroz", 1.5, "Alimento");
        Produto produto2 = new Produto("Feijão", 2.0, "Alimento");

        // Criação do estoque
        Estoque estoque = new Estoque();
        estoque.adicionarProduto(produto1, 50);
        estoque.adicionarProduto(produto2, 30);

        // Criação da venda
        Venda venda = new Venda();

        // Adição de itens à venda
        venda.adicionarItemVenda(produto1, 3, estoque);
        venda.adicionarItemVenda(produto2, 2, estoque);

        // Finalização da venda
        venda.finalizarVenda(); 
        
        
    }}
    
