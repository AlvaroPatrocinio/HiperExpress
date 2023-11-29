package com.mycompany.hiperexpress;

import com.mycompany.hiperexpress.implement.json.ProdutosJson;
import com.mycompany.hiperexpress.implement.json.CadastroJson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONObject;

public class Sistema {

    private static Scanner input = new Scanner(System.in);
    private static Scanner input2 = new Scanner(System.in);
    private static Scanner input3 = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
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

    public void excluirADM(String CPF) {
        Iterator<Administrador> iterator = HiperExpress.getAdmCadastrado().iterator();

        while (iterator.hasNext()) {
            Administrador administrador = iterator.next();
            if (administrador.getCPF() == null ? CPF == null : administrador.getCPF().equals(CPF)) {
                iterator.remove();
                System.out.println("Administrador removido com sucesso.");
                return;
            }
        }

        System.out.println("Administrador não encontrado com o CPF fornecido.");
    }

    public void excluirFUN(String CPF) {
        Iterator<Funcionario> iterator = HiperExpress.getFuncionarioCadastrado().iterator();

        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if (funcionario.getCPF() == null ? CPF == null : funcionario.getCPF().equals(CPF)) {
                iterator.remove();
                System.out.println("Funcionário removido com sucesso.");
                return;
            }
        }

        System.out.println("Funcionário não encontrado com o CPF fornecido.");
    }

    public void excluirCLI(String CPF) {
        Iterator<Cliente> iterator = HiperExpress.getClienteCadastrado().iterator();

        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getCpf() == null ? CPF == null : cliente.getCpf().equals(CPF)) {
                iterator.remove();
                System.out.println("Cliente removido com sucesso.");
                return;
            }
        }

        System.out.println("Cliente não encontrado com o CPF fornecido.");
    }

    public void editarCadastroCliente() {
        Scanner edit1 = new Scanner(System.in);
        Scanner edit2 = new Scanner(System.in);
        System.out.println("Informe o CPF do cliente que deseja editar:");
        String CPF = (edit1.nextLine());
        boolean alt;

        try {
            for (Cliente cliente : HiperExpress.getClienteCadastrado()) {

                if (cliente.getCpf().equals(CPF)) {
                    boolean verdade = true;
                    while (verdade) {
                        System.out.println("Qual dado deseja modificar?: ");
                        System.out.println("/    Opção 1 - Nome     /");
                        System.out.println("/    Opção 2 - Telefone     /");
                        System.out.println("/    Opção 3 - Endereço     /");
                        System.out.println("/    Opção 4 - CPF     /");
                        int alterar;
                        alterar = edit1.nextInt();
                        switch (alterar) {

                            case 1:
                                String Newnome;
                                System.out.println("Digite o novo nome: ");
                                Newnome = edit2.nextLine();
                                cliente.setNome(Newnome);
                                System.out.println("Nome alterado com sucesso!\n");
                                //JSON
                                menuadm();

                            case 2:
                                String NewTel;
                                System.out.println("Digite o novo telefone: ");
                                NewTel = edit2.nextLine();
                                cliente.setTelefone(NewTel);
                                System.out.println("Telefone alterado com sucesso!\n");
                                //JSON
                                menuadm();
                            case 3:
                                String NewEnd;
                                System.out.println("Digite o novo endereço: ");
                                NewEnd = edit2.nextLine();
                                cliente.setEndereco(NewEnd);
                                System.out.println("Endereço alterado com sucesso!\n");
                                //JSON
                                menuadm();
                            case 4:
                                String NewCPF;
                                System.out.println("Digite o novo CPF: ");
                                NewCPF = edit2.nextLine();
                                cliente.setCpf(NewCPF);
                                System.out.println("CPF alterado com sucesso!\n");
                                //JSON
                                menuadm();
                        }
                    }

                } else {
                    System.out.println("Opção Invalida!");
                    menuadm();
                }

            }
        } catch (RuntimeException e) {
            e.getMessage();
        }
    }

    public void editarCadastroADM() {
        Scanner edit1 = new Scanner(System.in);
        Scanner edit2 = new Scanner(System.in);
        System.out.println("Informe o CPF do administrador que deseja editar:");
        String CPF = (edit1.nextLine());
        boolean alt;

        try {
            for (Administrador administrador : HiperExpress.getAdmCadastrado()) {

                if (administrador.getCPF().equals(CPF)) {
                    boolean verdade = true;
                    while (verdade) {
                        System.out.println("Qual dado deseja modificar?: ");
                        System.out.println("/    Opção 1 - Nome     /");
                        System.out.println("/    Opção 2 - Senha     /");
                        System.out.println("/    Opção 3 - CPF     /");
                        int alterar;
                        alterar = edit1.nextInt();
                        switch (alterar) {

                            case 1:
                                String Newnome;
                                System.out.println("Digite o novo nome: ");
                                Newnome = edit2.nextLine();
                                administrador.setNome(Newnome);
                                System.out.println("Nome alterado com sucesso!\n");
                                //JSON
                                menuadm();

                            case 2:
                                String NewPass;
                                System.out.println("Digite a nova senha: ");
                                NewPass = edit2.nextLine();
                                administrador.setSenha(NewPass);
                                System.out.println("Senha alterada com sucesso!\n");
                                //JSON
                                menuadm();
                            case 3:
                                String NewCPF;
                                System.out.println("Digite o novo CPF: ");
                                NewCPF = edit2.nextLine();
                                administrador.setSenha(NewCPF);
                                System.out.println("CPF alterado com sucesso!\n");
                                //JSON
                                menuadm();
                        }
                    }

                } else {
                    System.out.println("Opção Invalida!");
                    System.exit(0);
                }

            }
        } catch (RuntimeException e) {
            e.getMessage();
        }
    }

    public void editarCadastroFUN() {
        Scanner edit1 = new Scanner(System.in);
        Scanner edit2 = new Scanner(System.in);
        System.out.println("Informe o CPF do funcionário que deseja editar:");
        String CPF = (edit1.nextLine());
        boolean alt;

        try {
            for (Funcionario funcionario : HiperExpress.getFuncionarioCadastrado()) {

                if (funcionario.getCPF().equals(CPF)) {
                    boolean verdade = true;
                    while (verdade) {
                        System.out.println("Qual dado deseja modificar?: ");
                        System.out.println("/    Opção 1 - Nome     /");
                        System.out.println("/    Opção 2 - Senha     /");
                        System.out.println("/    Opção 3 - CPF     /");
                        int alterar;
                        alterar = edit1.nextInt();
                        switch (alterar) {

                            case 1:
                                String Newnome;
                                System.out.println("Digite o novo nome: ");
                                Newnome = edit2.nextLine();
                                funcionario.setNome(Newnome);
                                System.out.println("Nome alterado com sucesso!\n");
                                //JSON
                                menuadm();

                            case 2:
                                String NewPass;
                                System.out.println("Digite a nova senha: ");
                                NewPass = edit2.nextLine();
                                funcionario.setSenha(NewPass);
                                System.out.println("Senha alterada com sucesso!\n");
                                //JSON
                                menuadm();
                            case 3:
                                String NewCPF;
                                System.out.println("Digite o novo CPF: ");
                                NewCPF = edit2.nextLine();
                                funcionario.setCPF(CPF);
                                System.out.println("CPF alterado com sucesso!\n");
                                //JSON
                                menuadm();
                        }
                    }

                } else {
                    System.out.println("Opção Invalida!");
                    System.exit(0);
                }

            }
        } catch (RuntimeException e) {
            e.getMessage();
        }
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
                        while (true) {
                            System.out.println("Digite o nome do Produto: ");
                            String Produtonome = input2.nextLine();
                            System.out.println("Digite o preço do Produto: ");
                            Double Produtopreco = input.nextDouble();
                            System.out.println("Digite a Categoria Desejada: ");
                            System.out.println("-HortiFruti\n-Alimentos \n-Congelados \n-Bebidas");
                            String ProdutoCategoria = input2.nextLine();
                            System.out.println("Digite a quantidade a dar entrada no estoque: ");
                            int ProdutoQuantidade = input2.nextInt();

                            Produto produto1 = new Produto(Produtonome, Produtopreco, ProdutoCategoria, ProdutoQuantidade);
                            produtos.add(produto1);

                            estoque.adicionarProduto(produto1, ProdutoQuantidade);
                            
                            System.out.println("------------Produto Adicionado!------------");

                            // Chamando o método para escrever os produtos no arquivo JSON
                            ProdutosJson.escreverProdutosParaJson(produtos, "Dados-Produto-HiperExpress.json");

                            // Quebra de linha pendente
                            input2.nextLine();

                            // Oferecer a opção de continuar adicionando produtos ou voltar ao menu inicial
                            System.out.println("Deseja adicionar outro produto? (S para Sim, qualquer outra tecla para voltar ao menu)");
                            String continuar = input2.nextLine().toUpperCase();
                            if (!continuar.equals("S")) {
                                break;
                            }
                        }
                        exibirInicio();
                        menuadm();
                        break;

                    case 2:
                        // Remover produto do estoque
                        System.out.println("Digite o nome do Produto: ");
                        String Produtoremovenome = input2.nextLine();
                        System.out.println("Digite a quantidade a dar baixa no estoque: ");
                        int Produtoremoveestoque = input.nextInt();

                        // Chamando o método para remover o produto no arquivo JSON
                        ProdutosJson.removerProdutoDoJson(Produtoremovenome, Produtoremoveestoque, "Dados-Produto-HiperExpress.json");

                    case 3:
                        // Exibir Estoque
                        exibirInicio();
                        ProdutosJson.exibirEstoqueDoJson("Dados-Produto-HiperExpress.json");
                        menuadm();
                        break;

                    case 4:
                        // Pesquisar produto por nome
                        System.out.println("Digite o nome do produto a ser pesquisado: ");
                        String nomeProdutoPesquisa = input2.nextLine();
                        JSONObject resultadoPesquisa = ProdutosJson.pesquisarProdutoPorNome(nomeProdutoPesquisa, "Dados-Produto-HiperExpress.json");

                        if (resultadoPesquisa != null) {
                            System.out.println(resultadoPesquisa.toJSONString());
                        } else {
                            System.out.println("Produto não encontrado.");
                        }

                        menuadm();
                        break;

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
                System.out.println("/    Opção 1 - Cadastrar Administrador    /");
                System.out.println("/    Opção 2 - Cadastrar Funcionário    /");
                System.out.println("/    Opção 3 - Cadastrar Cliente    /");
                System.out.println("/    Opção 4 - Excluir Cadastro    /");
                System.out.println("/    Opção 5 - Listar Cadastros    /");
                System.out.println("/    Opção 6 - Editar Cadastro     /");
                System.out.println("/    Opção 7 - Sair     /");

                int cadastroc = input.nextInt();
                switch (cadastroc) {
                    case 1:
                        boolean CPFExistente = false;
                        Scanner scanAdm = new Scanner(System.in);
                        System.out.println("----------CADASTRO DE ADMINISTRADOR----------");
                        System.out.printf("Nome completo: ");
                        String NomeADM = scanAdm.nextLine();
                        System.out.printf("Senha: ");
                        String SenhaADM = scanAdm.nextLine();
                        System.out.println("CPF: ");
                        String cpfADM = scanAdm.nextLine();
                        Administrador novoAdministrador = new Administrador(NomeADM, SenhaADM, cpfADM);

                        // Chama o método para cadastrar o administrador
                        CadastroJson.cadastrarNovoAdministrador(NomeADM, SenhaADM, cpfADM);

                        for (Administrador administrador : HiperExpress.getAdmCadastrado()) {
                            if (administrador.getCPF().equals(novoAdministrador.getCPF())) {
                                CPFExistente = true;
                                break;
                            }
                        }
                        if (CPFExistente) {
                            System.out.println("Esse cpf já é Administrador do Sistema. Favor verificar.");
                            System.out.println("\"/    Opção 1 - Voltar ao menu Inicial     /\"");
                            System.out.println("\"/    Opção 2 - Sair     /\"");
                            int fim2 = input.nextInt();
                            switch (fim2) {
                                case 1:
                                    menuadm();
                                    break;
                                case 2:
                                    System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Opção inválida! ");
                                    break;
                            }
                        } else {
                            HiperExpress.getAdmCadastrado().add(novoAdministrador);
                            System.out.println("Administrador cadastrado com Sucesso!.");
                            System.out.println("\"/    Opção 1 - Voltar ao menu Inicial     /\"");
                            System.out.println("\"/    Opção 2 - Sair     /\"");
                            int fim2 = input.nextInt();
                            switch (fim2) {
                                case 1:
                                    menuadm();
                                    break;
                                case 2:
                                    System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Opção inválida! ");
                                    break;
                            }
                        }
                        break;

                    case 2:
                        boolean CPFFExistente = false;
                        Scanner scanFun = new Scanner(System.in);
                        System.out.println("----------CADASTRO DE FUNCIONARIO----------");
                        System.out.printf("Nome completo: ");
                        String NomeFUN = scanFun.nextLine();
                        System.out.printf("Senha: ");
                        String SenhaFUN = scanFun.nextLine();
                        System.out.println("CPF: ");
                        String CpfFUN = scanFun.nextLine();
                        System.out.println("Cargo: ");
                        String CargoFUN = scanFun.nextLine();
                        Funcionario novoFuncionario = new Funcionario(NomeFUN, SenhaFUN, CpfFUN, CargoFUN);

                        // Chama o método para cadastrar o Funcionario
                        CadastroJson.cadastrarNovoFuncionario(NomeFUN, SenhaFUN, CpfFUN, CargoFUN);

                        for (Funcionario funcionario : HiperExpress.getFuncionarioCadastrado()) {
                            if (funcionario.getCPF().equals(novoFuncionario.getCPF())) {
                                CPFFExistente = true;
                                break;
                            }
                        }
                        if (CPFFExistente) {
                            System.out.println("Esse cpf já é funcionário do HiperExpress. Favor verificar.");
                            System.out.println("\"/    Opção 1 - Voltar ao menu Inicial     /\"");
                            System.out.println("\"/    Opção 2 - Sair     /\"");
                            int fim2 = input2.nextInt();
                            switch (fim2) {
                                case 1:
                                    menuadm();
                                case 2:
                                    System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                                    System.exit(0);
                                default:
                                    System.out.println("Opção invalida! ");
                            }
                        } else {
                            HiperExpress.getFuncionarioCadastrado().add(novoFuncionario);
                            System.out.println("Funcionário cadastrado com Sucesso!.");
                            System.out.println("\"/    Opção 1 - Voltar ao menu Inicial     /\"");
                            System.out.println("\"/    Opção 2 - Sair     /\"");
                            int fim2 = input2.nextInt();
                            switch (fim2) {
                                case 1:
                                    menuadm();
                                case 2:
                                    System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                                    System.exit(0);
                                default:
                                    System.out.println("Opção invalida!");
                            }
                        }

                    case 3:
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

                        // Chama o método para cadastrar o Cliente
                        CadastroJson.cadastrarNovoCliente(novoCliente);

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
                            int fim3 = input.nextInt();
                            switch (fim3) {
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
                        int fim4 = input.nextInt();
                        switch (fim4) {
                            case 1:
                                menuadm();
                            case 2:
                                System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                                System.exit(0);
                            default:
                                System.out.println("Opção invalida! ");

                        }

                    case 4:
                        System.out.println("DDigite a opção desejada: ");
                        System.out.println("\"/    Opção 1 - Exclusão de Clientes     /\"");
                        System.out.println("\"/    Opção 2 - Exclusão de Funcionario     /\"");
                        System.out.println("\"/    Opção 3 - Exclusão de Administrador     /\"");
                        int ExcOption = input.nextInt();
                        switch (ExcOption) {

                            case 1:
                                System.out.println("Digite o CPF do Cliente: ");
                                String cpfExclusao1 = input3.nextLine();
                                CadastroJson.excluirCliente(cpfExclusao1);
                                menuadm();

                            case 2:
                                System.out.println("Digite o CPF do Funcionario: ");
                                String cpfExclusao2 = input3.nextLine();
                                CadastroJson.excluirFuncionario(cpfExclusao2);
                                ;
                                menuadm();

                            case 3:
                                System.out.println("Digite o CPF do Administrador: ");
                                String cpfExclusao3 = input3.nextLine();
                                CadastroJson.excluirAdministrador(cpfExclusao3);
                                ;
                                menuadm();
                            default:
                                System.out.println("Opção Invalida!");
                                menuadm();
                        }

                    case 5:
                        System.out.println("Digite a opção desejada: ");
                        System.out.println("\"/    Opção 1 - Cadastro de Administrador     /\"");
                        System.out.println("\"/    Opção 2 - Cadastro de Funcionarios   /\"");
                        System.out.println("\"/    Opção 3 - Cadastro de Cliente   /\"");
                        int fim5 = input.nextInt();
                        switch (fim5) {
                            case 1:
                                System.out.println("----------ADMINISTRADORES CADASTRADOS----------");
                                CadastroJson.listarAdministradores();
                                menuadm();
                                break;

                            case 2:
                                System.out.println("----------FUNCIONARIOS CADASTRADOS----------");
                                CadastroJson.listarFuncionarios();
                                menuadm();
                                break;

                            case 3:
                                System.out.println("----------CLIENTES CADASTRADOS----------");
                                CadastroJson.listarClientes();
                                menuadm();
                                break;
                        }

                    case 6:
                        System.out.println("Digite a opção desejada: ");
                        System.out.println("\"/    Opção 1 - Editar dados de Clientes     /\"");
                        System.out.println("\"/    Opção 2 - Editar dados do Administrador     /\"");
                        System.out.println("\"/    Opção 3 - Editar dados do Funcionarios     /\"");
                        int Option = input.nextInt();
                        switch (Option) {
                            case 1:
                                CadastroJson.editarDadosCliente();
                                menuadm();
                                break;
                            case 2:
                                CadastroJson.editarDadosAdministrador();
                                menuadm();
                                break;
                            case 3:
                                CadastroJson.editarDadosFuncionario();
                                menuadm();
                                break;
                        }

                    case 7:
                        System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                        System.exit(0);
                }

            case 5:
                System.out.println("-----Obrigado pela preferência! Volte Sempre!-----");
                System.exit(0);
        }

    }
}
