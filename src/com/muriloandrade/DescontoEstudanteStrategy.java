package com.muriloandrade;

public class DescontoEstudanteStrategy implements IEstrategiaPreco {
    private final double porcentagemDescontoEstudante = 0.5;

    @Override
    public double getTotal(Venda venda) {
        return venda.getValorTotalVenda() * porcentagemDescontoEstudante;
    }
}
