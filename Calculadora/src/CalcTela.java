import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

/** @author Carmo 
 * Uma classe 
 *  */
public class CalcTela extends JFrame
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
    private float valorInicial, valorFinal, sinal;
    private Calculadora calculadora = new Calculadora();
    JPanel panelPrincipal = new JPanel();
    String s;
    
    public CalcTela()
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
        panel_result.setLayout(new MigLayout("", "[284px]", "[40px]"));
        lblResultado.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
        lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_result.add(lblResultado, "cell 0 0,grow");
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
                s = ((JButton) arg0.getSource()).getText();
                //System.out.println("ESTE É O COMANDO " + s);
                //
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
            }
        });
        buttonIgual.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                valorFinal = Float.parseFloat(lblResultado.getText());
                calcular(valorInicial, valorFinal);
            }
        });
        //
        pack();
        setLocationRelativeTo(null);
        //
    }
    
    /** 
     * @author Carmo 
     * Método onde é realizada a chamada para a Classe Calculadora, onde será efetuado o cálculo pedido.
     * @param O primeiro parâmetro pedido é o valor que será pressionado antes do sinal de operação e o segundo parâmetro é o valor pressionado após o sinal da operção.
     * */
    public void calcular(float valorInicial, float valorFinal)
    {
        if (s.equals("+"))
        {
            lblResultado.setText("" + calculadora.soma(valorInicial, valorFinal));
        }
        else if (s.equals("-"))
        {
            lblResultado.setText("" + calculadora.subtracao(valorInicial, valorFinal));
        }
        else if (s.equals("*"))
        {
            lblResultado.setText("" + calculadora.multiplicacao(valorInicial, valorFinal));
        }
        else if (s.equals("/"))
        {
            if (calculadora.divisao(valorInicial, valorFinal) == Float.POSITIVE_INFINITY || calculadora.divisao(valorInicial, valorFinal) == Float.NEGATIVE_INFINITY)
            {
                lblResultado.setText("Não é possivel dividir por zero!");
            }
            else
            {
                lblResultado.setText("" + calculadora.divisao(valorInicial, valorFinal));
            }
        }
    }
    
    public static void main(String[] args)
    {
        CalcTela mainwindow = new CalcTela();
        mainwindow.setVisible(true);
    }
}
