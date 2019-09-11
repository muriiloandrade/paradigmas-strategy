package com.muriloandrade;

import java.util.ArrayList;
import java.util.Scanner;

public class DescontoFuncionarioStrategy implements IEstrategiaPreco {
    private double porcentagem;
    private ArrayList<String> funcionarios = new ArrayList<String>();

    public void addFuncionario(String funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public double getTotal(Venda venda) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String user = input.next();

        System.out.println("-------- Insira o(s) nome(s) do(s) funcionário(s) --------");
        int i=0;
        while (true) {
            System.out.printf("Digite o nome do %dº funcionário: ", i+1);
            String nome = input.next();
            addFuncionario(nome);

            System.out.print("Adicionar mais um funcionário [S/N]? ");
            String op = input.next();
            char flag = op.charAt(0);

            if (flag == 'n' || flag == 'N') {
                break;
            }

            i++;
        }

        for(String func : funcionarios){
            if (user.equalsIgnoreCase(func)) {
                setPorcentagem(0.6);
            }
        }

        return venda.getValorTotalVenda() * (1 - porcentagem);
    }
}
