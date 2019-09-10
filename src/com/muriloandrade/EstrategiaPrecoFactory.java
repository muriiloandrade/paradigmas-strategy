package com.muriloandrade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EstrategiaPrecoFactory {
    private static EstrategiaPrecoFactory instance;

    public static EstrategiaPrecoFactory getInstance() {
        return instance;
    }

    public IEstrategiaPreco getEstrategiaPreco(){
        //Utilizando uma pequena biblioteca para ler de um JSON ao invés de um arquivo txt
        JSONParser parser = new JSONParser();
        IEstrategiaPreco estrategia = null;
        try {
            //Pegando o caminho absoluto até a pasta atual
            String filePath = new File("").getAbsolutePath();
            //Referenciando o json
            Object obj = parser.parse(new FileReader(filePath + "/src/com/muriloandrade/nomeEstrategia.json"));
            JSONObject jsonObject = (JSONObject) obj;

            String nomeEstrategia = (String) jsonObject.get("name");
            estrategia = (IEstrategiaPreco) Class.forName(nomeEstrategia).newInstance();
        } catch (SecurityException | IOException ex) {
            System.err.println("Erro: " + ex.getMessage());
        } catch (ParseException ex) {
            System.err.println("Erro: " + ex.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return estrategia;
    }
}
