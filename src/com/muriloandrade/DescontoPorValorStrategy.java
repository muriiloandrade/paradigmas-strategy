package com.muriloandrade;

public class DescontoPorValorStrategy implements IEstrategiaPreco {
    private double porcentagem;

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public double getTotal(Venda venda) {
        if (venda.getValorTotalVenda() >= 300) {
            setPorcentagem(0.1);
        } else {
            setPorcentagem(0);
        }
        return venda.getValorTotalVenda() * (1 - porcentagem);
    }
}
