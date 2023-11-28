package com.mycompany.hiperexpress.implement.json;
import com.mycompany.hiperexpress.Produto;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class ProdutosJson {

    public static void escreverProdutosParaJson(List<Produto> produtos, String nomeArquivo) {
        JSONArray produtosJson = new JSONArray();
        for (Produto produto : produtos) {
            JSONObject produtoJson = new JSONObject();
            produtoJson.put("id", produto.getId());
            produtoJson.put("nome", produto.getNome());
            produtoJson.put("categoria", produto.getCategoria());
            produtoJson.put("valorDoProduto", produto.getValorDoProduto());
            
            
            produtosJson.add(produtoJson);
        }
        ManipularJson.criarArquivoJson(produtosJson, nomeArquivo);
    }
    
    
}