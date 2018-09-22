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
    
    /** Método principal do projeto Calculadora
     * @param args */
    public static void main(String[] args)
    {
        view.setVisible(true);
    }
    
    /** Método onde será processado o botão pressionado, que neste caso é um
     * operando e salva este número em uma variável auxiliar
     * @param botao recebe o valor da botão pressionado */
    private void processaOperando(String botao)
    {
        valorAux += botao;
        view.labelEquacao(botao);
        //        System.out.println("valorAux " + valorAux);
    }
    
    /** Método onde será processado o botão pressionado, que neste caso é um
     * operador e salva este sinal em uma variável auxiliar, transfere o valor
     * que esta na variável 'valorAux' para a variável 'valorInicial'
     * @param botao recebe o valor da botão pressionado */
    private void processaOperador(String botao)
    {
        view.labelEquacao(botao);
        valorInicial = Double.parseDouble(valorAux);
        valorAux = "";
        sinal = botao;
        //        System.out.println("valorInicial " + valorInicial);
        //        System.out.println("sinal " + sinal);
    }
    
    /** Este método recebe o botão pressionado e analisa no 'switch' se é um
     * operador ou um operando, para ver se irá chamar o método
     * 'processaOperador' ou 'processaOperando'
     * @param botao recebe o valor da botão pressionado */
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
                break;
            default:
                break;
        }
    }
    
    /** Este método íra mandar para a Classe 'View' para no método mandar para a
     * label demonstrar o resultado ao usuário
     * @param resul recebe o resultado da operação */
    @Override
    public void processaResultado(String resul)
    {
        view.LabelResultado(resul);
    }
}
