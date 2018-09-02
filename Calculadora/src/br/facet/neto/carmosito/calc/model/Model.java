package br.facet.neto.carmosito.calc.model;
public class Model
{
    public double soma(double num1, double num2)
    {
        double resul = 0;
        resul = num1 + num2;
        return resul;
    }
    
    public double subtracao(double num1, double num2)
    {
        double resul = 0;
        resul = num1 - num2;
        return resul;
    }
    
    public double multiplicacao(double num1, double num2)
    {
        double resul = 0;
        resul = num1 * num2;
        return resul;
    }
    
    public double divisao(double num1, double num2)
    {
        double resul = 0;
        if (num2 == 0)
        {
            System.out.println("Erro! Divisão por zero");
        }
        resul = num1 / num2;
        return resul;
    }
}
