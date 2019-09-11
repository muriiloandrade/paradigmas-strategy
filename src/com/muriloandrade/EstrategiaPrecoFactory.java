package com.muriloandrade;

public class EstrategiaPrecoFactory {
    private static EstrategiaPrecoFactory instance = null;
    private IEstrategiaPreco estrategia;

    private EstrategiaPrecoFactory(){}

    public static EstrategiaPrecoFactory getInstance() {
        if(instance == null)
            instance = new EstrategiaPrecoFactory();
        return instance;
    }

    public IEstrategiaPreco getEstrategiaPreco(String nomeEstrategia){
        try {
            estrategia = (IEstrategiaPreco) Class.forName(nomeEstrategia).newInstance();
        } catch (IllegalAccessException e) {
            System.err.println("Erro => " + e.toString());
        } catch (InstantiationException e) {
            System.err.println("Erro => " + e.toString());
        } catch (ClassNotFoundException e) {
            System.err.println("Erro => " + e.toString());
        }
        return estrategia;
    }
}
