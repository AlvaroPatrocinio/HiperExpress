package com.mycompany.hiperexpress;

import com.mycompany.hiperexpress.implement.json.ProdutosJson;
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

    private Sistema() {
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
    Venda venda = new Venda();

    private Produto encontrarProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    private static void exibirInicio() {
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("-----------------HiperEXPRESS-----------------");
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");
    }

    public void menuadm() {

        System.out.println("----------------------------------------------");
        System.out.println("-----------Bem vindo ao HiperEXPRESS----------");
        System.out.println("----------------------------------------------");
        System.out.println("**********Selecione a Opção desejada**********");
        System.out.println("----------------------------------------------");
        System.out.println("/    Opção 1 - Estoque     /");
        System.out.println("/    Opção 2 - Venda    /");
        System.out.println("/    Opção 3 - Relatorios     /");
        System.out.println("/    Opção 4 - Cadastros     /");
        System.out.println("/    Opção 5 - Sair     /");

        int option = input.nextInt();
        switch (option) {
            default:
                System.out.println("------------Opção Inválida!------------");

            /* Gerenciar Estoque e Afins
                
             */
            case 1:

                exibirInicio();
                System.out.println("/    Opção 1 - Adicionar Produto     /");
                System.out.println("/    Opção 2 - Remover Produto    /");
                System.out.println("/    Opção 3 - Exibir Estoque     /");
                System.out.println("/    Opção 4 - Pesquisar Produto     /");
                System.out.println("/    Opção 5 - Voltar ao Menu Principal     /");

                int estoquec = input.nextInt();
                switch (estoquec) {

                    case 1:
                        System.out.println("Digite o nome do Produto: ");
                        String Produtonome = input2.nextLine();
                        System.out.println("Digite o preço do Produto: ");
                        Double Produtopreco = input.nextDouble();
                        System.out.println("Digite a Categoria Desejada: ");
                        System.out.println("-HortiFruti\n-Alimentos \n-Congelados \n-Bebidas");
                        String ProdutoCategoria = input2.nextLine();

                        Produto produto1 = new Produto(Produtonome, Produtopreco, ProdutoCategoria);
                        produtos.add(produto1);

                        System.out.println("Digite a quantidade a dar entrada no estoque: ");
                        int Produtoestoque = input.nextInt();
                        estoque.adicionarProduto(produto1, Produtoestoque);
                        System.out.println("------------Produto Adicionado!------------");

                        // Chamando o método para escrever os produtos no arquivo JSON
                        ProdutosJson.escreverProdutosParaJson(produtos, "Dados-Produto-HiperExpress.json");
                        exibirInicio();
                        menuadm();
                        break;

                    case 2:
                        // remover produto
                        System.out.println("Digite o nome do Produto: ");
                        String Produtoremovenome = input2.nextLine();
                        System.out.println("Digite a quantidade a dar baixa no estoque: ");
                        int Produtoremoveestoque = input.nextInt();
                        estoque.removerProduto(encontrarProdutoPorNome(Produtoremovenome), Produtoremoveestoque);
                        System.out.println(encontrarProdutoPorNome(Produtoremovenome) +  " Removido");
                        menuadm();

                    case 3:
                        // Exibir Estoque
                        exibirInicio();
                        estoque.exibirEstoque();
                        exibirInicio();
                        menuadm();
                        
                    case 4:
                        //Pesquisar Produto
                        System.out.println("Insira o nome do Produto: ");
                        String Produtopesquisarnome = input2.nextLine();
                        estoque.verificarEstoque(encontrarProdutoPorNome(Produtopesquisarnome));
                        exibirInicio();
                        menuadm();


                    case 5:
                        exibirInicio();
                        menuadm();

                }

            /* Gerar Vendas e coisas relacionadas a vendas
                
             */
            case 2:
                exibirInicio();
                System.out.println("/    Opção 1 - Realizar Venda     /");
                System.out.println("/    Opção 2 - Cancelar Ultima Venda    /");
                System.out.println("/    Opção 3 - Emitir RV     /");
                System.out.println("/    Opção 4 - Sair     /");
                System.out.println("/    Opção 5 - Voltar ao Menu Principal     /");

                int vendac = input.nextInt();
                switch (vendac) {

                    case 1:
                        System.out.println("Produtos disponíveis no estoque:");
                        for (Produto produto : produtos) {
                            System.out.println(produto);
                        }

                        System.out.println("Digite o nome do produto para adicionar ao carrinho (ou 'fim' para finalizar): ");
                        String nomeProduto;
                        while (!(nomeProduto = input2.nextLine()).equalsIgnoreCase("fim")) {
                            Produto produtoSelecionado = encontrarProdutoPorNome(nomeProduto);
                            if (produtoSelecionado != null) {
                                System.out.println("Digite a quantidade desejada: ");
                                int quantidade = input.nextInt();
                                if (estoque.verificarEstoqueSuficiente(produtoSelecionado, quantidade)) {
                                    venda.adicionarItemVenda(produtoSelecionado, quantidade, estoque);
                                } else {
                                    System.out.println("Estoque insuficiente para o produto selecionado.");
                                }
                            } else {
                                System.out.println("Produto não encontrado.");
                            }

                            System.out.println("Digite o nome do próximo produto (ou 'fim' para finalizar): ");
                        }
                        venda.finalizarVenda();
                        System.out.println("\"/    Opção 1 - Voltar ao menu Inicial     /\"");
                        System.out.println("\"/    Opção 2 - Sair     /\"");
                        int fim = input.nextInt();
                        switch (fim) {
                            case 1:
                                menuadm();
                            case 2:
                                System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                                System.exit(0);
                            default:
                                System.out.println("Opção invalida! ");
                        }

                    case 2:
                        // Cancelar uma Venda
                        exibirInicio();
                        venda.cancelarVenda(estoque);
                        menuadm();
                        
                    case 3:
                        exibirInicio();
                        venda.recuperarRegistroVenda();
                        menuadm();

                    case 4:
                        System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                        System.exit(0);
                    case 5:
                        exibirInicio();
                        menuadm();
                        
                }

            /* Gerar Relatorios Mensais e Diarios
                
             */
            case 3:

                exibirInicio();
                System.out.println("/    Opção 1 - Rendimento Diario     /");
                System.out.println("/    Opção 2 - Rendimento Mensal    /");
                System.out.println("/    Opção 3 - Voltar ao Menu Principal     /");

                int relatorioc = input.nextInt();
                switch (relatorioc) {

                    case 1:
                        // Rendimento Diario
                        System.out.println("Relatorio de Rendimento Diario");
                    case 2:
                        // Rendimento Mensal
                        System.out.println("Relatorio de Rendimento Mensal");
                    case 3:
                        exibirInicio();
                        menuadm();
                }

            /* Cadastrar Funcionario, Cliente, etc
                
             */
            case 4:

                exibirInicio();
                System.out.println("/    Opção 1 - Cadastrar Funcionario    /");
                System.out.println("/    Opção 2 - Cadastrar Cliente    /");
                System.out.println("/    Opção 3 - Excluir Cadastro    /");
                System.out.println("/    Opção 4 - Listar Cadastros    /");
                System.out.println("/    Opção 5 - Sair     /");

                int cadastroc = input.nextInt();
                switch (cadastroc) {

                    case 1:
                        //Cadastrar Funcionario
                        System.out.println("Cadastrar Funcionario");

                    case 2:
                        boolean cpfExiste = false;
                        Scanner scanCliente = new Scanner(System.in);
                        System.out.println("----------CADASTRO DE CLIENTES----------");
                        Cliente novoCliente = new Cliente();
                        System.out.printf("Nome completo: ");
                        novoCliente.setNome(scanCliente.nextLine());
                        System.out.printf("Telefone: ");
                        novoCliente.setTelefone(scanCliente.nextLine());
                        System.out.printf("Endereco: ");
                        novoCliente.setEndereco(scanCliente.nextLine());
                        System.out.printf("CPF: ");
                        novoCliente.setCpf(scanCliente.nextLine());

                        for (Cliente cliente : HiperExpress.ClienteCadastrado()) {
                            if (cliente.getCpf().equals(novoCliente.getCpf())) {
                                cpfExiste = true;
                                break;
                            }
                        }
                        if (cpfExiste) {
                            System.out.println("Esse cpf já é nosso cliente. Favor verificar.");
                            System.out.println("\"/    Opção 1 - Voltar ao menu Inicial     /\"");
                            System.out.println("\"/    Opção 2 - Sair     /\"");
                            int fim2 = input.nextInt();
                            switch (fim2) {
                                case 1:
                                    menuadm();
                                case 2:
                                    System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                                    System.exit(0);
                                default:
                                    System.out.println("Opção invalida! ");
                            }
                        }
                        HiperExpress.ClienteCadastrado().add(novoCliente);
                        System.out.println("Cliente cadastrado com sucesso");
                        System.out.println("\"/    Opção 1 - Voltar ao menu Inicial     /\"");
                        System.out.println("\"/    Opção 2 - Sair     /\"");
                        int fim2 = input.nextInt();
                        switch (fim2) {
                            case 1:
                                menuadm();
                            case 2:
                                System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                                System.exit(0);
                            default:
                                System.out.println("Opção invalida! ");

                        }

                    case 3:
                        // Excluir Cadastro
                        System.out.println("Cadastrar Funcionario");

                    case 4:
                        // Listar Cadastros
                        System.out.println("----------CLIENTES CADASTRADOS----------");
                        System.out.println("Quantidade total: " + HiperExpress.ClienteCadastrado().size() + " clientes cadastrados no sistema.");
                        System.out.println(HiperExpress.getClienteCadastrado());


                    case 5:
                        System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                        System.exit(0);
                }

            case 5:
                System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                System.exit(0);
                
        }
    }
}
