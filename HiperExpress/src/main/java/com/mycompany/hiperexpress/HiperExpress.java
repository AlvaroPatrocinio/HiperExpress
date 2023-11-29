package com.mycompany.hiperexpress;
import java.util.ArrayList;
import Comparator.VendaComparator;
import Comparator.ProdutoComparator;

public class HiperExpress { 
    

//ArrayList e encapsulamento de Clientes.
private static ArrayList<Cliente> clienteCadastrado = new ArrayList<>();
public static ArrayList<Cliente> ClienteCadastrado(){
return clienteCadastrado;
    }
public static ArrayList<Cliente> getClienteCadastrado() {
        return clienteCadastrado;
    }
public static void setClienteCadastrado(ArrayList<Cliente> clienteCadastrado) {
        HiperExpress.clienteCadastrado = clienteCadastrado;
    }


//ArrayList e encapsulamento de Funcionário.
//Questão 2
private static ArrayList<Funcionario> funcionarioCadastrado = new ArrayList<>();
public static ArrayList<Funcionario> getFuncionarioCadastrado() {
        return funcionarioCadastrado;
    }
public static void setFuncionarioCadastrado(ArrayList<Funcionario> funcionarioCadastrado) {
        HiperExpress.funcionarioCadastrado = funcionarioCadastrado;
    }


//ArrayList e encapsulamento de Administrador.
//Questão 2
private static ArrayList<Administrador> AdmCadastrado = new ArrayList<>();
public static ArrayList<Administrador> getAdmCadastrado() {
        return AdmCadastrado;
    }
public static void setAdmCadastrado(ArrayList<Administrador> AdmCadastrado) {
        HiperExpress.AdmCadastrado = AdmCadastrado;
    }


public static void main(String[] args) {
    Sistema sistema = Sistema.getInstance();
    sistema.menuadm();


    }
}



       
            

        /* Teste de Comunicação
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
    
    
    
