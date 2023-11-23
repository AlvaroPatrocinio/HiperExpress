package com.mycompany.hiperexpress;

public class Cliente {
        
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    
    
    private static int numClientes = 0;
    protected static int numClientes2 = 0;

    public  Cliente() {
        numClientes++;
    }
    
        public static int getNumClientes(){
        return numClientes;
    }
    
   
    public Cliente(String nome, String telefone, String endereco, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
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
    public String toString() {
    return String.format("""
                         Cliente {
                           Nome: '%s',
                           Telefone: %.2f,
                           Endereco: '%s',
                           CPF: %d
                         }""",
        nome, telefone, endereco, cpf
    );
  
}
}
