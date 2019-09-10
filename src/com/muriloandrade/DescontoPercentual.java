package com.muriloandrade;

public class DescontoPercentual implements IEstrategiaPreco {
    private double porcentagem;

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public double getTotal(Venda venda) {
        return venda.getValorTotalVenda() * porcentagem;
    }
}
