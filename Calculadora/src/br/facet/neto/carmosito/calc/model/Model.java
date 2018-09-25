package br.facet.neto.carmosito.calc.model;

import br.facet.neto.carmosito.calc.control.control;
import br.facet.neto.carmosito.calc.control.ControlToModel;

public class Model implements ControlToModel
{
    public static control control = new control();
    
    /** O met�do serve para, ao receber os parametros calcular a soma dos mesmos
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
    
    /** O met�do serve para, ao receber os parametros calcular a subtra��o dos
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
    
    /** O met�do serve para, ao receber os parametros calcular a multiplica��o
     * dos mesmos e retornar o resultado
     * @param num1 primeiro valor pressionado
     * @param num2 segundo valor pressionado
     * @return retorna o valor da soma dos parametros */
    private double multiplicacao(double num1, double num2)
    {
        double resul = 0;
        resul = num1 * num2;
        return resul;
    }
    
    /** O met�do serve para, ao receber os parametros calcular a divisao dos
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
    
    /** @author Carmo M�todo onde � realizada a chamada para a Classe
     *         Calculadora, onde ser� efetuado o c�lculo pedido.
     * @param O primeiro par�metro pedido � o valor que ser� pressionado antes
     *        do sinal de opera��o e o segundo par�metro � o valor pressionado
     *        ap�s o sinal da oper��o. */
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
                    resul = "\"N�o � possivel dividir por zero!";
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
