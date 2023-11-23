package com.mycompany.hiperexpress;

public class Produto {
       
    private String nome;
    private double valorDoProduto;
    private int id;
    private String categoria;  
    private static int count = 0;


   
    public Produto(String nome, double valorDoProduto, String categoria) {
        this.nome = nome;
        this.valorDoProduto = valorDoProduto;
        this.categoria = categoria; 
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

   
    @Override
    public String toString() {
    return String.format("""
                         Produto {
                           Nome: '%s',
                           Valor: %.2f,
                           Categoria: '%s',
                           ID: %d
                         }""",
        nome, valorDoProduto, categoria, id
    );
}
    }
