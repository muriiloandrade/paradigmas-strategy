package com.muriloandrade;

import java.util.Scanner;

public class DescontoPercentualStrategy implements IEstrategiaPreco {
    private double porcentagem;

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public double getTotal(Venda venda) {
        System.out.print("Digite a porcentagem do desconto (0-100): ");
        Scanner input = new Scanner(System.in);
        setPorcentagem(input.nextDouble());

        return venda.getValorTotalVenda() * ((100 - porcentagem)/100);
    }
}
