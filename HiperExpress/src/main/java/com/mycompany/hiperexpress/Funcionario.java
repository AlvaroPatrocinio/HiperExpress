package com.mycompany.hiperexpress;

public class Funcionario {
    
   private String nome;
   private String senha;
   private String CPF;
   private String cargo;

    public Funcionario(String nome, String senha, String CPF) {
        this.nome = nome;
        this.senha = senha;
        this.CPF = CPF;
    }

    public Funcionario(String nome, String senha, String CPF, String cargo) {
        this.nome = nome;
        this.senha = senha;
        this.CPF = CPF;
        this.cargo = cargo;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", senha=" + senha + ", CPF=" + CPF + ", cargo=" + cargo + '}';
    }
   
}
