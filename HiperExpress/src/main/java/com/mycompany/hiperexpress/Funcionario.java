package com.mycompany.hiperexpress;

public class Funcionario {
    
   private String nome;
   private String senha;
   private int id;
   
   public Funcionario (String nome, String senha, int id){
       this.nome = nome;
       this.senha = senha;
       this.id = id;
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
   
    @Override
    public String toString() {
    return String.format("""
                         Funcionario: {
                           Senha: '%s',
                           ID: %.2f,
                         }""",
        nome, senha, id
    );
   
}}
