package com.mycompany.hiperexpress.Calculos;

/**
 * Classe utilitária para cálculos relacionados ao preço total de uma compra.
 */
public class PrecoTotal {
    
    /**
     * Calcula o preço total de uma compra com base na quantidade e no preço unitário.
     *
     * @param quantidade A quantidade de itens na compra.
     * @param preco O preço unitário dos itens.
     * @param soma O valor acumulado do preço total até o momento.
     * @return O preço total da compra após a adição dos novos itens.
     */
public static float TotalCompra(int quantidade, float preco,float soma)
    {
        float total = quantidade * preco;
        soma = soma+total;
        return soma;
    }
}