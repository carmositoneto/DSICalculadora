package br.facet.neto.carmosito.calc.model;
public class ControlToModel
{
    static public Model calculadora = new Model();
    /** @author Carmo Método onde é realizada a chamada para a Classe
     *         Calculadora, onde será efetuado o cálculo pedido.
     * @param O primeiro parâmetro pedido é o valor que será pressionado antes
     *        do sinal de operação e o segundo parâmetro é o valor pressionado
     *        após o sinal da operção. */
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
                    resul = "\"Não é possivel dividir por zero!";
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
