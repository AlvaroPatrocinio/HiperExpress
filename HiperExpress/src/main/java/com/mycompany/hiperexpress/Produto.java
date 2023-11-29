package com.mycompany.hiperexpress;

public class Produto {
       
    private String nome;
    private double valorDoProduto;
    private int id;
    private String categoria;  
    private static int count = 0;
    private int quantidade;


   
    public Produto(String nome, double valorDoProduto, String categoria, int quantidade) {
        this.nome = nome;
        this.valorDoProduto = valorDoProduto;
        this.categoria = categoria; 
        this.quantidade = quantidade;
        this.id = count; 
        count++; 
    }

    public static int getCount() {
        return count;
    }

   
    public String getNome() {
        return nome;
    }

   
    public double getValorDoProduto() {
        return valorDoProduto;
    }

   
    public void setValorDoProduto(double valorDoProduto) {
        this.valorDoProduto = valorDoProduto;
    }

    
    public String getCategoria() {
        return categoria;
    }

    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

  
    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", valorDoProduto=" + valorDoProduto + ", id=" + id + ", categoria=" + categoria + ", quantidade=" + quantidade + '}';
    }

   
    }
