package br.facet.neto.carmosito.calc.model;
public class Model
{
    private double soma(double num1, double num2)
    {
        double resul = 0;
        resul = num1 + num2;
        return resul;
    }
    
    private double subtracao(double num1, double num2)
    {
        double resul = 0;
        resul = num1 - num2;
        return resul;
    }
    
    private double multiplicacao(double num1, double num2)
    {
        double resul = 0;
        resul = num1 * num2;
        return resul;
    }
    
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
    // ******* COLOCAR NO MODEL ****** // INTERFACE CONTROLE MODEL
    public String calcular(double valorInicial, double valorFinal, String sinal)
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
        return resul;
    }
}
