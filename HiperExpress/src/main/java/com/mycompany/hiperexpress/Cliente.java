package com.mycompany.hiperexpress;

public class Cliente {
        
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    private int ID;
    
    private static int numClientes = 0;
    protected static int numClientes2 = 0;

    public  Cliente() {
        numClientes++;
    }
    
        public static int getNumClientes(){
        return numClientes;
    }
    
   
    public Cliente(String nome, String telefone, String endereco, String cpf, int ID) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.ID = numClientes;
        numClientes++;
    }
    
   
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }
    
    
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
     @Override
    public String toString(){
        
        return "\n------------------------------------------------------------------------"+""
             + "\nNOME = " + this.getNome() + ""
             + "\nTELEFONE = " + this.getTelefone() + ""
             + "\nENDERECO = " + this.getEndereco()+ ""
             + "\nCPF = " + this.getCpf()+ "" + "\n" +
               "------------------------------------------------------------------------";

    }
}
