package com.muriloandrade;

public class EstrategiaPrecoFactory {
    private IEstrategiaPreco estrategia;

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
