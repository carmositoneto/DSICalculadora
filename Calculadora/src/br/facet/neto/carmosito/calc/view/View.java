package br.facet.neto.carmosito.calc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.io.FileHandler;
import br.facet.neto.carmosito.calc.control.control;
import br.facet.neto.carmosito.calc.control.ControlToView;
import br.facet.neto.carmosito.calc.model.Model;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

/** @author Carmo Uma classe onde eh criado as interfaces graficas do projeto
 *         calculadora */
public class View extends JFrame implements ControlToView
{
    public static Model model = new Model();
    public static control control = new control();
    JPanel panel_result = new JPanel();
    JPanel panel_botoes = new JPanel();
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton buttonDiv = new JButton("/");
    JButton buttonSoma = new JButton("+");
    JButton buttonSub = new JButton("-");
    JButton buttonMult = new JButton("*");
    JButton buttonLimpar = new JButton("C");
    JButton buttonIgual = new JButton("=");
    JPanel panelPrincipal = new JPanel();
    JLabel lblResultado = new JLabel("");
    JLabel lblEqucao = new JLabel("");
    float valorInicial, valorFinal;
    String sinal;
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu mnMenu = new JMenu("Menu");
    private final JMenuItem mntmCarregar = new JMenuItem("Carregar");
    private final JMenuItem mntmSalvar = new JMenuItem("Salvar");
    private final JMenuItem mntmSair = new JMenuItem("Sair");
    
    /** Construtor da classe View, onde serao definidos os argumentos de botoes
     * e paineis */
    public View()
    {
        //
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
        setJMenuBar(menuBar);
        menuBar.add(mnMenu);
        mnMenu.add(mntmCarregar);
        mnMenu.add(mntmSalvar);
        mnMenu.add(mntmSair);
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
        ActionListener al = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                String botao = ((JButton) arg0.getSource()).getText();
                control.processaBotao(botao);
            }
        };
        buttonDiv.addActionListener(al);
        buttonMult.addActionListener(al);
        buttonSub.addActionListener(al);
        buttonSoma.addActionListener(al);
        button0.addActionListener(al);
        button1.addActionListener(al);
        button2.addActionListener(al);
        button3.addActionListener(al);
        button4.addActionListener(al);
        button5.addActionListener(al);
        button6.addActionListener(al);
        button7.addActionListener(al);
        button8.addActionListener(al);
        button9.addActionListener(al);
        buttonLimpar.addActionListener(al);
        buttonIgual.addActionListener(al);
        //
        pack();
        setLocationRelativeTo(null);
        //
        ActionListener carregar = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // TODO Auto-generated method stub
                carregarConfig();
            }
        };
        mntmCarregar.addActionListener(carregar);
        ActionListener salvar = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // TODO Auto-generated method stub
                salvarConfig();
            }
        };
        mntmSalvar.addActionListener(salvar);
        ActionListener sair = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // TODO Auto-generated method stub
                dispose();
            }
        };
        mntmSair.addActionListener(sair);
    }
    
    public void salvarConfig()
    {
        try
        {
            File file = new File("Calc.config.xml");
            file.createNewFile();
            //
            //
            XMLConfiguration config = new XMLConfiguration();
            //
            config.addProperty("calculadora.resultado", lblResultado.getText());
            FileHandler handler = new FileHandler(config);
            handler.save(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void carregarConfig()
    {
        try
        {
            File file = new File("Calc.config.xml");
            //
            //
            Configurations configs = new Configurations();
            XMLConfiguration config = configs.xml(file);
            //
            //
            String ssmax = config.getString("calculadora.resultado", "");
            //
            lblResultado.setText(ssmax);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /** Metodo onde ira limpar o conteudo das labels equacao e resultado */
    public void limparLabels()
    {
        lblEqucao.setText("");
        lblResultado.setText("");
    }
    
    /** @param botao eh um parametro onde recebe o conteudo dos buttons
     *        pressionados e neste metodo escreve o texto passado por parametro
     *        na label Equacao */
    public void labelEquacao(String botao)
    {
        lblEqucao.setText(lblEqucao.getText() + botao);
    }
    
    /** @param resul eh um parametro onde recebe o conteudo dos buttons
     *        pressionados e neste metodo escreve o texto passado por parametro
     *        na label Resultado */
    public void LabelResultado(String resul)
    {
        lblEqucao.setText("");
        lblResultado.setText(resul);
    }
}