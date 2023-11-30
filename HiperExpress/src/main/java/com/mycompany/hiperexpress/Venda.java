package com.mycompany.hiperexpress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.Instant;


/**
 * Representa uma venda de produtos, contendo itens de venda e informações sobre a data da venda.
 */

public class Venda {
    
    /** Lista de itens de venda na venda atual. */
    private List<ItemVenda> itensVenda;

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
    
      /** Data em que a venda foi realizada. */
    private Date dataVenda;

    
       /**
     * Construtor padrão que inicializa a lista de itens de venda como uma nova ArrayList
     * e define a data da venda como a data e hora atuais.
     */
    public Venda() {
      this.itensVenda = new ArrayList<>();
      this.dataVenda = Date.from(Instant.now());
    }

     /**
     * Obtém a data da venda.
     * @return A data da venda.
     */  
    public Date getDataVenda() {
        return dataVenda;
    }

    
     /**
     * Define a data da venda.
     * @param dataVenda A nova data da venda.
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    
     /**
     * Adiciona um novo item de venda à venda atual, reduzindo o estoque correspondente.
     * @param produto O produto a ser adicionado à venda.
     * @param quantidade A quantidade do produto a ser adicionada à venda.
     * @param estoque O estoque que será atualizado após a venda.
     */
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
    
    
     /**
     * Finaliza a venda, exibindo um resumo dos itens vendidos, o total da venda
     * e a data da venda.
     */
    public void finalizarVenda() {
        System.out.println("---- Resumo da Venda ----");
        for (ItemVenda itemVenda : itensVenda) {
            System.out.println(itemVenda);
        }
        System.out.println("Total da venda: " + calcularTotalVenda());
        System.out.println("Venda finalizada em: " + dataVenda);
    }
    
    
     /**
     * Cancela a venda, adicionando os produtos de volta ao estoque e limpando a lista de itens.
     * @param estoque O estoque onde os produtos serão devolvidos.
     */
     public void cancelarVenda(Estoque estoque) {
        // Adiciona os produtos de volta ao estoque
        for (ItemVenda itemVenda : itensVenda) {
            Produto produto = itemVenda.getProduto();
            int quantidade = itemVenda.getQuantidade();
            estoque.adicionarProduto(produto, quantidade);
        }
        // Limpa a lista de itens da venda
        itensVenda.clear();

        System.out.println("Venda cancelada com sucesso.");
    }
     
     
     /**
     * Exibe um registro da venda, incluindo detalhes sobre os itens vendidos, o total da venda
     * e a data da venda.
     */
     public void recuperarRegistroVenda() {
        System.out.println("---- Registro da Venda ----");
        for (ItemVenda itemVenda : itensVenda) {
            System.out.println(itemVenda);
        }
        System.out.println("Total da venda: " + calcularTotalVenda());
        System.out.println("Venda realizada em: " + dataVenda);
    }
        

     /**
     * Calcula o total da venda somando os subtotais de todos os itens de venda.
     * @return O total da venda.
     */
    public double calcularTotalVenda() {
        double total = 0;
        for (ItemVenda itemVenda : itensVenda) {
            total += itemVenda.calcularSubtotal();
        }
        return total;
    }

    
     /**
     * Representa um item de venda, incluindo o produto, a quantidade e o subtotal.
     */
    public static class ItemVenda {
        
        /** O produto associado ao item de venda. */
        private Produto produto;
      
        /** A quantidade do produto vendida. */
        private int quantidade;

         /**
         * Construtor que inicializa um item de venda com um produto e uma quantidade.
         * @param produto O produto associado ao item de venda.
         * @param quantidade A quantidade do produto vendida.
         */
        public ItemVenda(Produto produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }
        
        
        /**
         * Calcula o subtotal do item multiplicando o valor do produto pela quantidade.
         * @return O subtotal do item de venda.
         */
        public double calcularSubtotal() {
            return produto.getValorDoProduto() * quantidade;
        }
        
        
        /**
         * Obtém o produto associado ao item de venda.
         * @return O produto associado ao item de venda.
         */
        public Produto getProduto() {
            return produto;
        }
        
        
         /**
         * Obtém a quantidade do produto vendida.
         * @return A quantidade do produto vendida.
         */
        public int getQuantidade() {
            return quantidade;
        }
        
        
         /**
         * Define um novo produto associado ao item de venda.
         * @param produto O novo produto associado ao item de venda.
         */
        public void setProduto(Produto produto) {
            this.produto = produto;
        }
        
        
         /**
         * Define uma nova quantidade do produto vendida.
         * @param quantidade A nova quantidade do produto vendida.
         */
        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        
         /**
         * Representação em formato de string do item de venda.
         * @return Uma string representando o item de venda.
         */
        //Questão 3
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
