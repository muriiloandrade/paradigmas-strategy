package com.muriloandrade;

public class Registradora {
    public static void main(String[] args) {
        // Criando uma nova venda na registradora
        Venda venda = new Venda();

        // Dando um valor total à esta venda
        venda.setValorTotalVenda(1356.70);
        System.out.printf("O valor bruto da venda é: %.2f\n", venda.getValorTotalVenda());


    }
}
