package com.muriloandrade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Registradora {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Criando uma nova venda na registradora
        Venda venda = new Venda();

        System.out.print("Digite o valor total da venda: ");
        venda.setValorTotalVenda(input.nextDouble());
        System.out.printf("O valor bruto da venda é: %.2f\n", venda.getValorTotalVenda());

        //Utilizando uma pequena biblioteca para ler de um JSON ao invés de um arquivo txt
        JSONParser parser = new JSONParser();
        String nomeEstrategia = "";
        try {
            //Pegando o caminho absoluto até a pasta atual
            String filePath = new File("").getAbsolutePath();
            //Referenciando o json
            //Altere o nome da classe no atributo "name" do JSON com uma classe *Strategy para manter o funcionamento
            Object obj = parser.parse(new FileReader(filePath + "/src/com/muriloandrade/nomeEstrategia.json"));
            JSONObject jsonObject = (JSONObject) obj;

            nomeEstrategia = (String) jsonObject.get("name");
        } catch (SecurityException | IOException ex) {
            System.err.println("Erro => " + ex.getMessage());
        } catch (ParseException ex) {
            System.err.println("Erro => " + ex.toString());
        }

        EstrategiaPrecoFactory estrategia = new EstrategiaPrecoFactory();
        try {
            System.out.printf("Preço com desconto: %f", estrategia.getEstrategiaPreco(nomeEstrategia).getTotal(venda));
        } catch (NullPointerException ex) {
            System.err.println("Erro ao tentar calcular o valor do desconto, estratégia não encontrada!");
        }
    }
}
