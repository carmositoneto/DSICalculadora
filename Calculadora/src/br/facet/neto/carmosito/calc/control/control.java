package br.facet.neto.carmosito.calc.control;

import br.facet.neto.carmosito.calc.model.Model;
import br.facet.neto.carmosito.calc.model.ModelToControl;
import br.facet.neto.carmosito.calc.view.View;
import br.facet.neto.carmosito.calc.view.ViewToControl;

public class control implements ViewToControl, ModelToControl
{
    static public View view = new View();
    static public Model model = new Model();
    private double valorInicial = 0;
    private double valorAtual = 0;
    private String valorAux = "";
    private String sinal = "";
    
    /** 
     * metodo principal do projeto Calculadora
     * @param args eh o parametro padrao*/
    public static void main(String[] args)
    {
        view.setVisible(true);
    }
    
    /** metodo onde sera processado o botao pressionado, que neste caso eh um
     * operando e salva este numero em uma variavel auxiliar
     * @param botao recebe o valor da botao pressionado */
    private void processaOperando(String botao)
    {
        valorAux += botao;
        view.labelEquacao(botao);
        //        System.out.println("valorAux " + valorAux);
    }
    
    /** metodo onde sera processado o botao pressionado, que neste caso eh um
     * operador e salva este sinal em uma variavel auxiliar, transfere o valor
     * que esta na variavel 'valorAux' para a variavel 'valorInicial'
     * @param botao recebe o valor da botao pressionado */
    private void processaOperador(String botao)
    {
        view.labelEquacao(botao);
        valorInicial = Double.parseDouble(valorAux);
        valorAux = "";
        sinal = botao;
        //        System.out.println("valorInicial " + valorInicial);
        //        System.out.println("sinal " + sinal);
    }
    
    /** este metodo recebe o botao pressionado e analisa no 'switch' se eh um
     * operador ou um operando, para ver se ira chamar o metodo
     * 'processaOperador' ou 'processaOperando'
     * @param botao recebe o valor da botao pressionado */
    public void processaBotao(String botao)
    {
        //switch manipulando o conteudo do botao selecionado e disparando para o modelo
        switch (botao)
        {
            case "0":
                processaOperando(botao);
                break;
            case "1":
                processaOperando(botao);
                break;
            case "2":
                processaOperando(botao);
                break;
            case "3":
                processaOperando(botao);
                break;
            case "4":
                processaOperando(botao);
                break;
            case "5":
                processaOperando(botao);
                break;
            case "6":
                processaOperando(botao);
                break;
            case "7":
                processaOperando(botao);
                break;
            case "8":
                processaOperando(botao);
                break;
            case "9":
                processaOperando(botao);
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
                view.limparLabels();
                break;
            default:
                break;
        }
    }
    
    /** este metodo ira mandar para a Classe 'View' para no metodo mandar para a
     * label demonstrar o resultado ao usuario
     * @param resul recebe o resultado da operacao */
    @Override
    public void processaResultado(String resul)
    {
        view.LabelResultado(resul);
    }
}
