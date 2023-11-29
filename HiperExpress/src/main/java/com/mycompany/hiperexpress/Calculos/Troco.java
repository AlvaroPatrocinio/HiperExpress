package com.mycompany.hiperexpress.Calculos;

/**
 * Classe utilitária para cálculos relacionados ao troco em uma transação de compra.
 */
public class Troco {
    
    /** Variável estática que armazena o valor do troco. */
    static float  troco = -1;
    
    /**
     * Calcula o troco com base no preço total da compra e no valor passado pelo cliente.
     *
     * @param preco_total O preço total da compra.
     * @param preco_passado O valor passado pelo cliente.
     * @return O valor do troco a ser devolvido ao cliente.
     */
    public static float Troco(float preco_total, float preco_passado)
            
    {        
        troco = preco_passado - preco_total;
        return troco;
    }
    
    /**
     * Obtém o valor do troco armazenado.
     *
     * @return O valor do troco armazenado.
     */
    public static float RetornoTroco()
    {
        return troco;
    }
}

