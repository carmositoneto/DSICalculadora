package br.facet.neto.carmosito.calc.model;

import br.facet.neto.carmosito.calc.control.control;
import br.facet.neto.carmosito.calc.control.ControlToModel;

public class Model implements ControlToModel
{
    public static control control = new control();
    
    /** o metedo serve para, ao receber os parametros calcular a soma dos mesmos
     * e retornar o resultado
     * @param num1 primeiro valor pressionado
     * @param num2 segundo valor pressionado
     * @return retorna o valor da soma dos parametros */
    private double soma(double num1, double num2)
    {
        double resul = 0;
        resul = num1 + num2;
        return resul;
    }
    
    /** o metedo serve para, ao receber os parametros calcular a subtracao dos
     * mesmos e retornar o resultado
     * @param num1 primeiro valor pressionado
     * @param num2 segundo valor pressionado
     * @return retorna o valor da soma dos parametros */
    private double subtracao(double num1, double num2)
    {
        double resul = 0;
        resul = num1 - num2;
        return resul;
    }
    
    /** o metedo serve para, ao receber os parametros calcular a multiplicao dos
     * mesmos e retornar o resultado
     * @param num1 primeiro valor pressionado
     * @param num2 segundo valor pressionado
     * @return retorna o valor da soma dos parametros */
    private double multiplicacao(double num1, double num2)
    {
        double resul = 0;
        resul = num1 * num2;
        return resul;
    }
    
    /** o metedo serve para, ao receber os parametros calcular a divisao dos
     * mesmos e retornar o resultado
     * @param num1 primeiro valor pressionado
     * @param num2 segundo valor pressionado
     * @return retorna o valor da soma dos parametros */
    private double divisao(double num1, double num2)
    {
        double resul = 0;
        if (num2 == 0)
        {
            System.out.println("Erro! Divis�o por zero");
        }
        resul = num1 / num2;
        return resul;
    }
    
    /** @author Carmo Metodo onde eh realizada a chamada para a Classe
     *         Calculadora, onde sera efetuado o calculo pedido. O primeiro
     *         parametro pedido e o valor que sera pressionado antes do sinal de
     *         operacao e o segundo parametro eh o valor pressionado apos o
     *         sinal da operacao. */
    public void calcular(double valorInicial, double valorFinal, String sinal)
    {
        String resul = "";
        switch (sinal)
        {
            case "+":
                resul = String.valueOf(soma(valorInicial, valorFinal));
                break;
            case "-":
                resul = String.valueOf(subtracao(valorInicial, valorFinal));
                break;
            case "*":
                resul = String.valueOf(multiplicacao(valorInicial, valorFinal));
                break;
            case "/":
                if (divisao(valorInicial, valorFinal) == Float.POSITIVE_INFINITY || divisao(valorInicial, valorFinal) == Float.NEGATIVE_INFINITY)
                {
                    resul = "\"Não é possivel dividir por zero!";
                }
                else
                {
                    resul = String.valueOf(divisao(valorInicial, valorFinal));
                }
                break;
            default:
                break;
        }
        control.processaResultado(resul);
    }
}
