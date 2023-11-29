package com.mycompany.hiperexpress;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Representa o estoque de produtos, mantendo um mapa de produtos e suas quantidades.
 */
public class Estoque {
    
    /** Map que associa produtos a suas quantidades no estoque. */
    private Map<Produto, Integer> estoqueProdutos;

    
     /**
     * Construtor que inicializa o estoque como um novo HashMap.
     */
    public Estoque() {
        this.estoqueProdutos = new HashMap<>();
    }

    
      /**
     * Adiciona uma determinada quantidade de um produto ao estoque.
     * @param produto O produto a ser adicionado ao estoque.
     * @param quantidade A quantidade do produto a ser adicionada.
     */
    public void adicionarProduto(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida. Adicione uma quantidade valida.");
            return;
        }

        estoqueProdutos.put(produto, estoqueProdutos.getOrDefault(produto, 0) + quantidade);
        System.out.println(quantidade + " unidades de " + produto.getNome() + " adicionadas ao estoque.");
    }
    
    
    /**
     * Encontra um produto no estoque pelo nome.
     * @param nomeProduto O nome do produto a ser encontrado.
     * @return O produto encontrado ou null se não encontrado.
     */
     public Produto encontrarProdutoPorNome(String nomeProduto) {
        for (Produto produto : estoqueProdutos.keySet()) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }

    /**
     * Remove uma determinada quantidade de um produto do estoque.
     * @param produto O produto a ser removido do estoque.
     * @param quantidade A quantidade do produto a ser removida.
     */
    public void removerProduto(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida. Insira uma quantidade positiva.");
            return;
        }

        if (estoqueProdutos.containsKey(produto)) {
            int quantidadeAtual = estoqueProdutos.get(produto);
            if (quantidadeAtual >= quantidade) {
                estoqueProdutos.put(produto, quantidadeAtual - quantidade);
                System.out.println(quantidade + " unidades de " + produto.getNome() + " removidas do estoque.");
            } else {
                System.out.println("Quantidade insuficiente em estoque para remover.");
            }
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }
    
    
    /**
     * Verifica a quantidade de um determinado produto no estoque.
     * @param produto O produto a ser verificado.
     * @return A quantidade do produto em estoque.
     */
    public int verificarEstoque(Produto produto) {
        int quantidade = estoqueProdutos.getOrDefault(produto, 0);
        System.out.println("Quantidade de " + produto.getNome() + " em estoque: " + quantidade + " unidades.");
        return quantidade;
    }
    
    /**
     * Exibe todos os produtos no estoque com suas quantidades.
     */
    public void exibirEstoque() {
        System.out.println("---- Estoque Atual ----");
        for (Map.Entry<Produto, Integer> entry : estoqueProdutos.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            System.out.println(produto.toString() + " - Quantidade em estoque: " + quantidade + " unidades.");
        }
    }
    
    
    /**
     * Adiciona uma determinada quantidade a um produto com base no ID do produto.
     * @param produtoId O ID do produto.
     * @param quantidade A quantidade do produto a ser adicionada.
     */
    public void adicionarQuantidadePorID(int produtoId, int quantidade) {
        Produto produto = encontrarProdutoPorID(produtoId);

        if (produto != null) {
            adicionarProduto(produto, quantidade);
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }
    
    
     /**
     * Encontra um produto no estoque pelo ID.
     * @param produtoId O ID do produto a ser encontrado.
     * @return O produto encontrado ou null se não encontrado.
     */
    public Produto encontrarProdutoPorID(int produtoId) {
        for (Produto produto : estoqueProdutos.keySet()) {
            if (produto.getId() == produtoId) {
                return produto;
            }
        }
        return null;
    }

     /**
     * Verifica se há estoque suficiente de um produto para uma determinada quantidade.
     * @param produto O produto a ser verificado.
     * @param quantidade A quantidade desejada do produto.
     * @return true se houver estoque suficiente, false caso contrário.
     */
    public boolean verificarEstoqueSuficiente(Produto produto, int quantidade) {
        int estoqueAtual = obterQuantidadeEstoque(produto);
        return estoqueAtual >= quantidade;
    }

     /**
     * Obtém a quantidade atual de um produto no estoque.
     * @param produto O produto a ser verificado.
     * @return A quantidade do produto em estoque.
     */
    public int obterQuantidadeEstoque(Produto produto) {
        return estoqueProdutos.getOrDefault(produto, 0);
    }

    /**
     * Obtém a lista de todos os produtos no estoque.
     * @return Uma lista contendo todos os produtos no estoque.
     */
    public List<Produto> getProdutos() {
        return new ArrayList<>(estoqueProdutos.keySet());
    }
}
