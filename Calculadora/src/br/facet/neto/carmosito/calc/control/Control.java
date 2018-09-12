package br.facet.neto.carmosito.calc.control;

import br.facet.neto.carmosito.calc.view.View;

public class Control implements ViewToControl
{
    static public View view = new View();
    private double valorInicial = 0;
    private double valorAtual = 0;
    private String sinal = "";
    
    public static void main(String[] args)
    {
        view.setVisible(true);
    }
    
    private void processaNumero(String botao)
    {
        if (valorInicial == 0)
        {
            valorInicial = Double.parseDouble(botao);
            System.out.println("VAlor inicial: " + valorInicial);
        }
        else
        {
            valorAtual = Double.parseDouble(botao);
            System.out.println("VAlor atual: " + valorAtual);
        }
    }
    
    private void processaOperador(String botao)
    {
        sinal = botao;
        System.out.println("sinal: " + sinal);
    }
    
    @Override
    public void processaBotao(String botao)
    {
        //switch manipulando o conteudo do botao selecionado e disparando para o modelo
        switch (botao)
        {
            case "1":
                processaNumero(botao);
                break;
            case "2":
                processaNumero(botao);
                break;
            case "3":
                processaNumero(botao);
                break;
            case "4":
                processaNumero(botao);
                break;
            case "5":
                processaNumero(botao);
                break;
            case "6":
                processaNumero(botao);
                break;
            case "7":
                processaNumero(botao);
                break;
            case "8":
                processaNumero(botao);
                break;
            case "9":
                processaNumero(botao);
                break;
            case "+":
                processaOperador(botao);
                break;
            case "-":
                processaOperador(botao);
                break;
            case "*":
                processaOperador(botao);
                break;
            case "/":
                processaOperador(botao);
                break;
            case "=":
                break;
            default:
                break;
        }
    }
}
