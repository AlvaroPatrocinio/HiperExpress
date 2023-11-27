package com.mycompany.hiperexpress; 
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Estoque {

    private Map<Produto, Integer> estoqueProdutos;

    public Estoque() {
        this.estoqueProdutos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida. Adicione uma quantidade positiva.");
            return;
        }

        estoqueProdutos.put(produto, estoqueProdutos.getOrDefault(produto, 0) + quantidade);
        System.out.println(quantidade + " unidades de " + produto.getNome() + " adicionadas ao estoque.");
    }

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

    public int verificarEstoque(Produto produto) {
        int quantidade = estoqueProdutos.getOrDefault(produto, 0);
        System.out.println("Quantidade de " + produto.getNome() + " em estoque: " + quantidade + " unidades.");
        return quantidade;
    }

    public void exibirEstoque() {
        System.out.println("---- Estoque Atual ----");
        for (Map.Entry<Produto, Integer> entry : estoqueProdutos.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            System.out.println(produto.toString() + " - Quantidade em estoque: " + quantidade + " unidades.");
        }
    }

    public void adicionarQuantidadePorID(int produtoId, int quantidade) {
        Produto produto = encontrarProdutoPorID(produtoId);

        if (produto != null) {
            adicionarProduto(produto, quantidade);
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }

    public Produto encontrarProdutoPorID(int produtoId) {
        for (Produto produto : estoqueProdutos.keySet()) {
            if (produto.getId() == produtoId) {
                return produto;
            }
        }
        return null;
    }
    
    public boolean verificarEstoqueSuficiente(Produto produto, int quantidade) {
    int estoqueAtual = obterQuantidadeEstoque(produto);
    return estoqueAtual >= quantidade;
}

public int obterQuantidadeEstoque(Produto produto) {
    return estoqueProdutos.getOrDefault(produto, 0);
}

    public List<Produto> getProdutos() {
        return new ArrayList<>(estoqueProdutos.keySet());
    }
}
