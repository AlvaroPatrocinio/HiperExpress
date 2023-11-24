package com.mycompany.hiperexpress.Calculos;


public class PrecoTotal {
    
public static float TotalCompra(int quantidade, float preco,float soma)
    {
        float total = quantidade * preco;
        soma = soma+total;
        return soma;
    }
}
    