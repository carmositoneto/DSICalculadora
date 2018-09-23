package br.facet.neto.carmosito.calc.model;

import br.facet.neto.carmosito.calc.control.Control;
import br.facet.neto.carmosito.calc.control.ControlToModel;

public class Model implements ControlToModel
{
    public static Control control = new Control();
    
    /** O metódo serve para, ao receber os parametros calcular a soma dos mesmos
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
    
    /** O metódo serve para, ao receber os parametros calcular a subtração dos
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
    
    /** O metódo serve para, ao receber os parametros calcular a multiplicação
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
    
    /** O metódo serve para, ao receber os parametros calcular a divisao dos
     * mesmos e retornar o resultado
     * @param num1 primeiro valor pressionado
     * @param num2 segundo valor pressionado
     * @return retorna o valor da soma dos parametros */
    private double divisao(double num1, double num2)
    {
        double resul = 0;
        if (num2 == 0)
        {
            System.out.println("Erro! Divisão por zero");
        }
        resul = num1 / num2;
        return resul;
    }
    
    /** @author Carmo Método onde é realizada a chamada para a Classe
     *         Calculadora, onde será efetuado o cálculo pedido.
     * @param O primeiro parâmetro pedido é o valor que será pressionado antes
     *        do sinal de operação e o segundo parâmetro é o valor pressionado
     *        após o sinal da operção. */
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
