package br.facet.neto.carmosito.calc.control;

import br.facet.neto.carmosito.calc.model.Model;
import br.facet.neto.carmosito.calc.model.ModelToControl;
import br.facet.neto.carmosito.calc.view.View;
import br.facet.neto.carmosito.calc.view.ViewToControl;

public class Control implements ViewToControl, ModelToControl
{
    static public View view = new View();
    static public Model model = new Model();
    private double valorInicial = 0;
    private double valorAtual = 0;
    private String valorAux = "";
    private String sinal = "";
    
    public static void main(String[] args)
    {
        view.setVisible(true);
    }
    
    private void processaNumero(String botao)
    {
        valorAux += botao;
        view.labelEquacao(botao);
        //        System.out.println("valorAux " + valorAux);
    }
    
    private void processaOperador(String botao)
    {
        view.labelEquacao(botao);
        valorInicial = Double.parseDouble(valorAux);
        valorAux = "";
        sinal = botao;
        //        System.out.println("valorInicial " + valorInicial);
        //        System.out.println("sinal " + sinal);
    }
    
    @Override
    public void processaBotao(String botao)
    {
        //switch manipulando o conteudo do botao selecionado e disparando para o modelo
        switch (botao)
        {
            case "0":
                processaNumero(botao);
                break;
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
                valorAtual = Double.parseDouble(valorAux);
                //                System.out.println("valorAtual " + valorAtual);
                model.calcular(valorInicial, valorAtual, sinal);
                valorAtual = 0;
                valorInicial = 0;
                valorAux = "";
                break;
            case "C":
                valorAtual = 0;
                valorInicial = 0;
                valorAux = "";
                break;
            default:
                break;
        }
    }
    
    @Override
    public void processaResultado(String resul)
    {
        view.LabelResultado(resul);
    }
}
