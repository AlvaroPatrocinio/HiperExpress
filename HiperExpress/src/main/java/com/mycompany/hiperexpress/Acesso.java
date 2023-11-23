package com.mycompany.hiperexpress;
public class Acesso {
    
    private String nome;
    private String id;
    private String senha;
    
    public Acesso() {
    this.nome = nome;
    this.id = id;
    this.senha = senha;
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public String toString() {
    return String.format("""
                         Acesso: {
                           Nome: '%s',
                           ID: %.2f,
                         Senha: '%s',
                         }""",
        nome, senha, id
    );
}}
