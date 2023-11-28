package com.mycompany.hiperexpress;

public class Funcionario {
    
   private String nome;
   private String senha;
   private int id;
   private String CPF;
   
   public Funcionario (String nome, String senha, String CPF){
       this.nome = nome;
       this.senha = senha;
       this.CPF = CPF;
   }
   
     
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    
   
    @Override
    public String toString() {
        return "\n------------------------------------------------------------------------"+""
             + "\nNOME = " + this.getNome() + ""
             + "\nSENHA = " + this.getSenha() + ""
             + "\nID = " + this.getId() + ""
             + "\nCPF = " + this.getCPF()+ "" + "\n" +
              "------------------------------------------------------------------------";
   
}}
