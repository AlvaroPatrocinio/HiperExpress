package com.mycompany.hiperexpress;


/**
 * Representa um produto com informações como nome, valor, categoria, quantidade e identificador único.
 */
public class Produto {
     
    /** Nome do produto. */  
    private String nome;
    /** Valor do produto. */
    private double valorDoProduto;
    /** Identificador único do produto. */
    private int id;
    /** Categoria do produto. */
    private String categoria;  
    /** Quantidade disponível do produto. */
    private int quantidade;
    /** Contador estático para atribuir identificadores únicos aos produtos. */
    private static int count = 0;
    


    /**
     * Construtor que inicializa um produto com nome, valor, categoria e quantidade.
     * O identificador único é gerado automaticamente.
     * @param nome O nome do produto.
     * @param valorDoProduto O valor do produto.
     * @param categoria A categoria do produto.
     * @param quantidade A quantidade disponível do produto.
     */
    public Produto(String nome, double valorDoProduto, String categoria, int quantidade) {
        this.nome = nome;
        this.valorDoProduto = valorDoProduto;
        this.categoria = categoria; 
        this.quantidade = quantidade;
        this.id = count; 
        count++; 
    }

     /**
     * Obtém o número total de produtos criados.
     * @return O número total de produtos criados.
     */
    public static int getCount() {
        return count;
    }

    /**
     * Obtém o nome do produto.
     * @return O nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o valor do produto.
     * @return O valor do produto.
     */
    public double getValorDoProduto() {
        return valorDoProduto;
    }

     /**
     * Define um novo valor para o produto.
     * @param valorDoProduto O novo valor do produto.
     */
    public void setValorDoProduto(double valorDoProduto) {
        this.valorDoProduto = valorDoProduto;
    }

     /**
     * Obtém a categoria do produto.
     * @return A categoria do produto.
     */
    public String getCategoria() {
        return categoria;
    }

      /**
     * Define uma nova categoria para o produto.
     * @param categoria A nova categoria do produto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Obtém o identificador único do produto.
     * @return O identificador único do produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Define manualmente o identificador único do produto.
     * Este método permite atribuir um identificador específico a um produto.
     * @param id O novo identificador único do produto.
     */
    public void setId(int id) {
        this.id = id;
    }
    
     /**
     * Obtém a quantidade disponível do produto.
     * @return A quantidade disponível do produto.
     */
    public int getQuantidade() {
        return quantidade;
    }
    
     /**
     * Define uma nova quantidade disponível para o produto.
     * @param quantidade A nova quantidade disponível do produto.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

      /**
     * Representação em formato de string do produto.
     * @return Uma string representando o produto.
     */
    //Questão 3
    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", valorDoProduto=" + valorDoProduto + ", id=" + id + ", categoria=" + categoria + ", quantidade=" + quantidade + '}';
    }

   
    }
