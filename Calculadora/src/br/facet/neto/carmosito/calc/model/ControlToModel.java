package br.facet.neto.carmosito.calc.model;
public class ControlToModel
{
    static public Model calculadora = new Model();
    /** @author Carmo M�todo onde � realizada a chamada para a Classe
     *         Calculadora, onde ser� efetuado o c�lculo pedido.
     * @param O primeiro par�metro pedido � o valor que ser� pressionado antes
     *        do sinal de opera��o e o segundo par�metro � o valor pressionado
     *        ap�s o sinal da oper��o. */
    public String calcular(double valorInicial, double valorFinal, String sinal)
    {
        String resul = "";
        switch (sinal)
        {
            case "+":
                resul = String.valueOf(calculadora.soma(valorInicial, valorFinal));
                break;
            case "-":
                resul = String.valueOf(calculadora.subtracao(valorInicial, valorFinal));
                break;
            case "*":
                resul = String.valueOf(calculadora.multiplicacao(valorInicial, valorFinal));
                break;
            case "/":
                if (calculadora.divisao(valorInicial, valorFinal) == Float.POSITIVE_INFINITY || calculadora.divisao(valorInicial, valorFinal) == Float.NEGATIVE_INFINITY)
                {
                    resul = "\"N�o � possivel dividir por zero!";
                }
                else
                {
                    resul = String.valueOf(calculadora.divisao(valorInicial, valorFinal));
                }
                break;
            default:
                break;
        }
        return resul;
    }
}
