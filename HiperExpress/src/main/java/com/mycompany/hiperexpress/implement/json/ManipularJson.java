package com.mycompany.hiperexpress.implement.json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ManipularJson {

    public static void criarArquivoJson(JSONArray dados, String nomeArquivo) {
        try (FileWriter arquivo = new FileWriter(nomeArquivo)) {
            arquivo.write(dados.toJSONString());
            System.out.println("Dados foram escritos com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao escrever no arquivo JSON: " + e.getMessage());
        }  
    }
    
    public static JSONObject lerArquivoJson(String nomeArquivo) {
        JSONParser parser = new JSONParser();

        try (FileReader arquivo = new FileReader(nomeArquivo)) {
            Object objeto = parser.parse(arquivo);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo JSON: " + e.getMessage());
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(ManipularJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
 