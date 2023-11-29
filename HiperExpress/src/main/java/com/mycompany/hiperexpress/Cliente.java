package com.mycompany.hiperexpress;

public class Cliente {

    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
    private int id;

    private static int numClientes = 0;

    protected static int numClientes2 = 0;

    public Cliente() {
        numClientes++;
    }

    public static int getNumClientes() {
        return numClientes;
    }

    public Cliente(String nome, String telefone, String endereco, String cpf, int id) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.id = numClientes;
        numClientes++;
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
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", cpf=" + cpf + ", id=" + id + '}';
    }

}
