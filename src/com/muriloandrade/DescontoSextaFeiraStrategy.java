package com.muriloandrade;

import java.util.Calendar;

public class DescontoSextaFeiraStrategy implements IEstrategiaPreco {
    private double porcentagem;

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public double getTotal(Venda venda) {
        Calendar cal = Calendar.getInstance();

        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            setPorcentagem(0.3);
        } else {
            setPorcentagem(0);
        }

        return venda.getValorTotalVenda() * (1 - porcentagem);
    }
}
