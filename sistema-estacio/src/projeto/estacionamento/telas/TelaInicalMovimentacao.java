package projeto.estacionamento.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicalMovimentacao extends JFrame implements ActionListener {

    private JButton butEntrada;
    private JButton butSaida;

    //TODO deletar apos concluido
    public static void main(String[] args) {
        TelaInicalMovimentacao tela = new TelaInicalMovimentacao();
        tela.setVisible(true);
    }

    public TelaInicalMovimentacao(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1050, 500));
        setResizable(false);
        setTitle("Sistema de Estacionamento");
        getContentPane().setLayout(new GridLayout(1,2,0,0));

        butEntrada = new JButton("");
        butEntrada.setIcon(new ImageIcon(TelaInicalMovimentacao.class.getResource("/recursos/veiculoEntradaUM.png")));
        butEntrada.addActionListener( this);
        butEntrada.setActionCommand("Entrada");
        getContentPane().add(butEntrada);

        butSaida = new JButton("");
        butSaida.setIcon(new ImageIcon(TelaInicalMovimentacao.class.getResource("/recursos/veiculoSaida.png")));
        butSaida.addActionListener(this);
        butSaida.setActionCommand("Saida");
        getContentPane().add(butSaida);

        }

    @Override
    public void actionPerformed(ActionEvent acao) {
        String command = acao.getActionCommand();
        JFrame tela = null;

        if (command.equals("Entrada")){
            tela = new TelaEntradaVeiculo(this);
        } else {
            tela = new TelaSaidaVeiculo(this);
        }
        tela.setVisible(true);
        this.setVisible(false);

    }
}
