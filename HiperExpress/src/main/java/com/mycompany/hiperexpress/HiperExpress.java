package com.mycompany.hiperexpress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class HiperExpress {
    
    private static Scanner input = new Scanner(System.in);
    private static Scanner input2 = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
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
    
    private static void menuadm(){
        
         System.out.println("----------------------------------------------");
        System.out.println("-----------Bem vindo ao HiperEXPRESS----------");
        System.out.println("----------------------------------------------");
        System.out.println("**********Selecione a Opção desejada**********");
        System.out.println("----------------------------------------------");
        System.out.println("/    Opção 1 - Cadastrar de Produto     /");
        System.out.println("/    Opção 2 - Listar     /");
        System.out.println("/    Opção 3 - Comprar     /");
        System.out.println("/    Opção 4 - Carrinho     /");
        System.out.println("/    Opção 5 - Sair     /");
        
        int option = input.nextInt();
        switch (option){
            default:
                System.out.println("Opção Inválida!");
                
            case 1:
                System.out.println("Digite o nome do Produto: ");
            String Produtonome = input2.nextLine();
                System.out.println("Digite o preço do Produto: ");
            Double Produtopreco = input.nextDouble();
                System.out.println("Digite a Categoria Desejada: ");
                System.out.println("HortiFruti\nAlimentos \nCongelados \nBebidas");
             String ProdutoCategoria  = input2.nextLine();
              Produto produto1 = new Produto(Produtonome, Produtopreco, ProdutoCategoria);   
              produtos.add(produto1);
              Estoque estoque = new Estoque();
                System.out.println("Digite a quantidade a dar entrada no estoque: ");
                int Produtoestoque = input.nextInt();
                estoque.adicionarProduto(produto1, Produtoestoque);
                System.out.println("Produto Adicionado!"); 
        }
        

        
    }

    

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        menuadm(); 
        /* 
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
        } */

    }
    
}


