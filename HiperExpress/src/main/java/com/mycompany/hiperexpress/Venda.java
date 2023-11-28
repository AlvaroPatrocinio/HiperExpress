package com.mycompany.hiperexpress;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.Instant;

public class Venda {

    private List<ItemVenda> itensVenda;
    private Date dataVenda;

    public Venda() {
        this.itensVenda = new ArrayList<>();
        this.dataVenda = Date.from(Instant.now());

    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void adicionarItemVenda(Produto produto, int quantidade, Estoque estoque) {
        if (estoque.verificarEstoque(produto) >= quantidade) {
            ItemVenda itemVenda = new ItemVenda(produto, quantidade);
            itensVenda.add(itemVenda);
            estoque.removerProduto(produto, quantidade);
            System.out.println("Item adicionado à venda: " + itemVenda);
        } else {
            System.out.println("Estoque insuficiente para adicionar o item à venda.");
        }
    }

    public void finalizarVenda() {
        System.out.println("---- Resumo da Venda ----");
        for (ItemVenda itemVenda : itensVenda) {
            System.out.println(itemVenda);
        }
        System.out.println("Total da venda: " + calcularTotalVenda());
        System.out.println("Venda finalizada em: " + dataVenda);
    }

    public double calcularTotalVenda() {
        double total = 0;
        for (ItemVenda itemVenda : itensVenda) {
            total += itemVenda.calcularSubtotal();
        }
        return total;
    }

    private static class ItemVenda {

        private Produto produto;
        private int quantidade;

        public ItemVenda(Produto produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }

        public double calcularSubtotal() {
            return produto.getValorDoProduto() * quantidade;
        }

        public Produto getProduto() {
            return produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        @Override
        public String toString() {
            return "ItemVenda{"
                    + "Produto=" + produto.getNome()
                    + ", Quantidade=" + quantidade
                    + ", Subtotal=" + calcularSubtotal()
                    + '}';
        }
    }
}
