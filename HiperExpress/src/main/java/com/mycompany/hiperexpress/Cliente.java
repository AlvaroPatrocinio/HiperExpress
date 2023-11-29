package com.mycompany.hiperexpress;

public class Cliente {
        
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    
    //Questão 11A - Segurança proporcionada pelo encapsulamento.
    private static int numCliente = 0;
    
    //Questão 11B - Atributo protegido para acesso direto pelos filhos.
    protected static int numClienteProtegido = 0;
    
    
    /**
     * Construtor padrão da classe <b>Cliente</b>, com um contador instanciado.
     */
    
     public Cliente() {
     numCliente++;
    }
    
    
    public static int getNumCliente(){
        return numCliente;
    }
    

    public Cliente(String nome, String telefone, String endereco, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }
    
    public void editarCadastro(String novoNome, String novoTelefone, String novoEnd, String novoCPF) {
    this.nome = novoNome;
    this.telefone = novoTelefone;
    this.endereco = novoEnd;
    this.cpf = novoCPF;
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
