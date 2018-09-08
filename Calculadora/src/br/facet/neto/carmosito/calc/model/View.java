package br.facet.neto.carmosito.calc.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;

/** @author Carmo Uma classe onde é criado as interfaces gráficas do projeto
 *         calculadora */
public class View extends JFrame
{
    JPanel panel_result = new JPanel();
    JPanel panel_botoes = new JPanel();
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton buttonDiv = new JButton("/");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton buttonMult = new JButton("*");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton buttonSub = new JButton("-");
    JButton button3 = new JButton("3");
    JButton button0 = new JButton("0");
    JButton buttonLimpar = new JButton("C");
    JButton buttonIgual = new JButton("=");
    JButton buttonSoma = new JButton("+");
    JLabel lblResultado = new JLabel("");
    float valorInicial, valorFinal;
    JPanel panelPrincipal = new JPanel();
    public static ControlToModel controlToModel = new ControlToModel();
    String sinal;
    private final JLabel lblEqucao = new JLabel("");
    
    public View()
    {
        setMinimumSize(new Dimension(350, 450));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calc Facetzika");
        //
        getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        panelPrincipal.setLayout(new BorderLayout(0, 0));
        panel_result.setBorder(new EmptyBorder(8, 8, 8, 8));
        panel_result.setBackground(Color.WHITE);
        panelPrincipal.add(panel_result, BorderLayout.NORTH);
        panel_result.setLayout(new MigLayout("", "[318px]", "[30px][30px]"));
        lblEqucao.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
        lblEqucao.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_result.add(lblEqucao, "cell 0 0,growx,aligny top");
        lblResultado.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
        lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_result.add(lblResultado, "cell 0 1,growx,aligny top");
        panel_botoes.setBorder(new EmptyBorder(7, 7, 7, 7));
        panelPrincipal.add(panel_botoes, BorderLayout.CENTER);
        panel_botoes.setLayout(new GridLayout(4, 4, 5, 5));
        panel_botoes.add(button7);
        panel_botoes.add(button8);
        panel_botoes.add(button9);
        panel_botoes.add(buttonDiv);
        panel_botoes.add(button4);
        panel_botoes.add(button5);
        panel_botoes.add(button6);
        panel_botoes.add(buttonMult);
        panel_botoes.add(button1);
        panel_botoes.add(button2);
        panel_botoes.add(button3);
        panel_botoes.add(buttonSub);
        panel_botoes.add(buttonLimpar);
        panel_botoes.add(button0);
        panel_botoes.add(buttonIgual);
        panel_botoes.add(buttonSoma);
        //
        //OPERADORES//
        //
        ActionListener actionOperadores = new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                sinal = ((JButton) arg0.getSource()).getText();
                lblEqucao.setText(lblEqucao.getText() + sinal);
                valorInicial = Float.parseFloat(lblResultado.getText());
                lblResultado.setText("");
            }
        };
        buttonDiv.addActionListener(actionOperadores);
        buttonMult.addActionListener(actionOperadores);
        buttonSub.addActionListener(actionOperadores);
        buttonSoma.addActionListener(actionOperadores);
        //
        //NUMERADORES//
        //
        ActionListener actionNumeros = new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                lblEqucao.setText(lblEqucao.getText() + ((JButton) arg0.getSource()).getText());
                lblResultado.setText(lblResultado.getText() + ((JButton) arg0.getSource()).getText());
            }
        };
        button0.addActionListener(actionNumeros);
        button1.addActionListener(actionNumeros);
        button2.addActionListener(actionNumeros);
        button3.addActionListener(actionNumeros);
        button4.addActionListener(actionNumeros);
        button5.addActionListener(actionNumeros);
        button6.addActionListener(actionNumeros);
        button7.addActionListener(actionNumeros);
        button8.addActionListener(actionNumeros);
        button9.addActionListener(actionNumeros);
        //
        buttonLimpar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                lblResultado.setText("");
                lblEqucao.setText("");
            }
        });
        buttonIgual.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                valorFinal = Float.parseFloat(lblResultado.getText());
                lblResultado.setText(controlToModel.calcular(valorInicial, valorFinal, sinal));
            }
        });
        //
        pack();
        setLocationRelativeTo(null);
        //
    }
}
