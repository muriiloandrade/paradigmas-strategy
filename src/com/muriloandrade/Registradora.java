package com.muriloandrade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Registradora {
    public static void main(String[] args) {
        // Criando uma nova venda na registradora
        Venda venda = new Venda();

        // Dando um valor total à esta venda
        venda.setValorTotalVenda(1356.70);
        System.out.printf("O valor bruto da venda é: %.2f\n", venda.getValorTotalVenda());

        //Utilizando uma pequena biblioteca para ler de um JSON ao invés de um arquivo txt
        JSONParser parser = new JSONParser();
        try {
            //Pegando o caminho absoluto até a pasta atual
            String filePath = new File("").getAbsolutePath();
            //Referenciando o json
            Object obj = parser.parse(new FileReader(filePath + "/src/com/muriloandrade/nomeEstrategia.json"));
            JSONObject jsonObject = (JSONObject) obj;

            String nomeEstrategia = (String) jsonObject.get("name");

            System.out.println("O nome da estratégia de desconto: " + nomeEstrategia);
        } catch (SecurityException | IOException ex) {
            System.err.println("Erro: " + ex.getMessage());
        } catch (ParseException ex) {
            System.err.println("Erro: " + ex.toString());
        }
    }
}
