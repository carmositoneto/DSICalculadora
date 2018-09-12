package br.facet.neto.carmosito.calc.control;

import br.facet.neto.carmosito.calc.view.View;

public class Control implements ViewToControl
{
    static public View view = new View();
    public double valorInicial = 0;
    public double valorAtual = 0;
    public String sinal = "";
    
    public static void main(String[] args)
    {
        view.setVisible(true);
    }
    
    @Override
    public void processaBotao(String botao)
    {
        //switch manipulando o conteudo do botao selecionado e disparando para o modelo
        switch (botao)
        {
            case "":
                
                break;
            default:
                break;
        }
    }
}
