package com.mycompany.hiperexpress;
import java.util.ArrayList;
import java.util.Iterator;


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

public static void encontrarClientePorCPF(String cpf) {
        Iterator<Cliente> iterator = clienteCadastrado.iterator();

        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getCpf().equals(cpf)) {
                // Imprimir as informações do cliente
                System.out.println("Informações do cliente encontrado:");
                System.out.println(cliente);
                return;
            }
        }

        System.out.println("Cliente com CPF " + cpf + " não encontrado.");
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