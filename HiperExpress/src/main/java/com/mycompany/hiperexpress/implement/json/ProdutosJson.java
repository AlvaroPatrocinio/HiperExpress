package com.mycompany.hiperexpress.implement.json;

import com.mycompany.hiperexpress.Produto;
import static com.mycompany.hiperexpress.implement.json.ManipularJson.lerArquivoJson;

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
            produtoJson.put("quantidade", produto.getQuantidade());

            produtosJson.add(produtoJson);
        }
        ManipularJson.criarArquivoJson(produtosJson, nomeArquivo);
    }

    public static void removerProdutoDoJson(String nomeProduto, int quantidade, String nomeArquivo) {
        JSONArray produtosJson = ManipularJson.lerArquivoJson(nomeArquivo);

        if (produtosJson != null) {
            for (Object obj : produtosJson) {
                JSONObject produtoJson = (JSONObject) obj;
                String nome = (String) produtoJson.get("nome");

                if (nome.equalsIgnoreCase(nomeProduto)) {
                    // Atualiza a quantidade do produto
                    int quantidadeAtual = ((Number) produtoJson.get("quantidade")).intValue();
                    int novaQuantidade = Math.max(quantidadeAtual - quantidade, 0);
                    produtoJson.put("quantidade", novaQuantidade);

                    // Escreve as alterações de volta no arquivo JSON
                    ManipularJson.escreverParaArquivo(produtosJson, nomeArquivo);

                    System.out.println(quantidade + " unidades de " + nomeProduto + " removidas do arquivo JSON.");
                    return; // Produto encontrado e atualizado, podemos sair do método
                }
            }

            System.out.println("Produto não encontrado no arquivo JSON.");
        } else {
            System.out.println("Falha ao ler os produtos do arquivo JSON.");
        }
    }

    public static void exibirEstoqueDoJson(String nomeArquivo) {
        JSONArray produtosJson = lerArquivoJson(nomeArquivo);

        if (produtosJson != null) {
            for (Object obj : produtosJson) {
                JSONObject produtoJson = (JSONObject) obj;
                String nome = (String) produtoJson.get("nome");
                String categoria = (String) produtoJson.get("categoria");
                double valor = (double) produtoJson.get("valorDoProduto");
                int quantidade = ((Long) produtoJson.get("quantidade")).intValue();

                System.out.println("Nome: " + nome);
                System.out.println("Categoria: " + categoria);
                System.out.println("Valor: " + valor);
                System.out.println("Quantidade: " + quantidade);
                System.out.println("-----------------------");
            }
        } else {
            System.out.println("Falha ao ler os produtos do arquivo JSON.");
        }
    }

    public static JSONObject pesquisarProdutoPorNome(String nomeProduto, String nomeArquivo) {
        JSONArray produtosJson = lerArquivoJson(nomeArquivo);

        if (produtosJson != null) {
            for (Object obj : produtosJson) {
                JSONObject produtoJson = (JSONObject) obj;
                String nome = (String) produtoJson.get("nome");

                if (nome.equalsIgnoreCase(nomeProduto)) {
                    return produtoJson;
                }
            }
        } else {
            System.out.println("Falha ao ler os produtos do arquivo JSON.");
        }

        return null;
    }
}
