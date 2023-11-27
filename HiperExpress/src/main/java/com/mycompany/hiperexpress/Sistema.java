package com.mycompany.hiperexpress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sistema {
    
    private static Scanner input = new Scanner(System.in);
    private static Scanner input2 = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static ArrayList<Produto> carrinho;
    private static List<Caixa> caixas;
    private Estoque estoque = new Estoque();
    private static Sistema instance;
    
    
    private Sistema(){
    }

    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }
    
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
    static {
        // Inicialização da lista de produtos
        produtos = new ArrayList<>();
    }
    
       private Produto encontrarProdutoPorNome(String nome){
    for (Produto produto : produtos) {
        if (produto.getNome().equalsIgnoreCase(nome)) {
            return produto;
        }
    }
     return null;
    }
      
    public void menuadm(){
        
         System.out.println("----------------------------------------------");
        System.out.println("-----------Bem vindo ao HiperEXPRESS----------");
        System.out.println("----------------------------------------------");
        System.out.println("**********Selecione a Opção desejada**********");
        System.out.println("----------------------------------------------");
        System.out.println("/    Opção 1 - Cadastrar de Produto     /");
        System.out.println("/    Opção 2 - Listar Estoque    /");
        System.out.println("/    Opção 3 - Realizar Venda     /");
        System.out.println("/    Opção 4 - Carrinho     /");
        System.out.println("/    Opção 5 - Sair     /");
        
        int option = input.nextInt();
        switch (option){
            default:
                System.out.println("------------Opção Inválida!------------");
                
            case 1:
                System.out.println("Digite o nome do Produto: ");
            String Produtonome = input2.nextLine();
                System.out.println("Digite o preço do Produto: ");
            Double Produtopreco = input.nextDouble();
                System.out.println("Digite a Categoria Desejada: ");
                System.out.println("-HortiFruti\n-Alimentos \n-Congelados \n-Bebidas");
             String ProdutoCategoria  = input2.nextLine();
              Produto produto1 = new Produto(Produtonome, Produtopreco, ProdutoCategoria);   
              produtos.add(produto1);
                System.out.println("Digite a quantidade a dar entrada no estoque: ");
                int Produtoestoque = input.nextInt();
                estoque.adicionarProduto(produto1, Produtoestoque);
                System.out.println("------------Produto Adicionado!------------");
                menuadm();
                           
            case 2:
                estoque.exibirEstoque();
                menuadm();
                
            case 3:
            // Criar uma nova venda
    Venda venda = new Venda();
    System.out.println("Produtos disponíveis no estoque:");
    for (Produto produto : produtos) {
        System.out.println(produto);
    }
    
    System.out.println("Digite o nome do produto para adicionar ao carrinho (ou 'fim' para finalizar): ");
    String nomeProduto;
    while (!(nomeProduto = input2.nextLine()).equalsIgnoreCase("fim")) 
    {
        Produto produtoSelecionado = encontrarProdutoPorNome(nomeProduto);
        if (produtoSelecionado != null) {
            System.out.println("Digite a quantidade desejada: ");
            int quantidade = input.nextInt();
            if (estoque.verificarEstoqueSuficiente(produtoSelecionado, quantidade)) {
                venda.adicionarItemVenda(produtoSelecionado, quantidade, estoque);
                estoque.removerProduto(produtoSelecionado, quantidade);
            } else {
                System.out.println("Estoque insuficiente para o produto selecionado.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }

        System.out.println("Digite o nome do próximo produto (ou 'fim' para finalizar): ");
    }
    // Finalizar a venda
    venda.finalizarVenda();
    menuadm();
     }

}}