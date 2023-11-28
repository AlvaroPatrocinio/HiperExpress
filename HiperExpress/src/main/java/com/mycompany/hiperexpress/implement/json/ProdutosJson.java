package com.mycompany.hiperexpress.implement.json;
import com.mycompany.hiperexpress.Produto;
import java.io.FileWriter;
import java.io.IOException;
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
        criarArquivoJson(produtosJson, nomeArquivo);
    }

    private static void criarArquivoJson(JSONArray dados, String nomeArquivo) {
        try (FileWriter arquivo = new FileWriter(nomeArquivo)) {
            arquivo.write(dados.toJSONString());
            System.out.println("Dados foram escritos com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    }
}