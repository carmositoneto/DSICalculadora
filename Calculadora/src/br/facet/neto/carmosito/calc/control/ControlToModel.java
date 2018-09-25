package br.facet.neto.carmosito.calc.control;
/** esta interface serve para gerenciar a conexao entre o controle e o modelo
 * @author Carmo */
public interface ControlToModel
{
    void calcular(double valorInicial, double valorFinal, String sinal);
}
