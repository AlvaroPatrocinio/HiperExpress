package com.mycompany.hiperexpress.implement.json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ManipularJson {

    public static void criarArquivoJson(JSONArray dados, String nomeArquivo) {
        JSONArray jsonArrayExistente = lerArquivoJson(nomeArquivo);

        if (jsonArrayExistente != null) {
            jsonArrayExistente.addAll(dados);
            dados = jsonArrayExistente;
        }

        try (FileWriter arquivo = new FileWriter(nomeArquivo)) {
            arquivo.write(dados.toJSONString());
            System.out.println("Dados foram escritos com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    }

    public static JSONArray lerArquivoJson(String nomeArquivo) {
        JSONParser parser = new JSONParser();

        try (FileReader arquivo = new FileReader(nomeArquivo)) {
            Object objeto = parser.parse(arquivo);
            if (objeto instanceof JSONArray) {
                return (JSONArray) objeto;
            } else {
                System.out.println("O conteúdo do arquivo não é um JSONArray.");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo JSON: " + e.getMessage());
        } catch (ParseException ex) {
            System.out.println("Erro de análise JSON: " + ex.getMessage());
        }
        return new JSONArray(); // Retorna um JSONArray vazio em caso de erro
    }

    public static void escreverParaArquivo(JSONArray jsonArray, String nomeArquivo) {
        try (FileWriter file = new FileWriter(nomeArquivo)) {
            file.write(jsonArray.toJSONString());
            System.out.println("Alterações gravadas no arquivo JSON com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    }

}
