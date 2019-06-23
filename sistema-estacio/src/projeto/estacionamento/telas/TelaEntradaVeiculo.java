package projeto.estacionamento.telas;

import projeto.estacionamento.controller.EstacionamentoControl;
import projeto.estacionamento.controller.EstacionamentoException;
import projeto.estacionamento.controller.VeiculoException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class TelaEntradaVeiculo extends JFrame implements ActionListener {

    private JFrame parent;
    private JFormattedTextField txfPlaca;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtCor;
    private JButton butOk;
    private JButton butCancel;

    //TODO deleter depois apos concluido
    public static void main(String[] args) {
        TelaEntradaVeiculo tela = new TelaEntradaVeiculo(null);
        tela.setVisible(true);
    }

    public TelaEntradaVeiculo(JFrame parent) {

        setResizable(false);
        setSize(400,320);
        setTitle("Entrada de Veiculos");
        this.parent = parent;
        getContentPane().setLayout(null);

        JLabel lblPlaca = new JLabel("Placa:");
        lblPlaca.setBounds(94,46,46,14);
        getContentPane().add(lblPlaca);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(94,85,46,14);
        getContentPane().add(lblMarca);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(94,124,46,14);
        getContentPane().add(lblModelo);

        JLabel lblCor = new JLabel("Cor:");
        lblCor.setBounds(94,163,46,14);
        getContentPane().add(lblCor);

        txtMarca = new JTextField();
        txtMarca.setBounds(174,82,97,20);
        getContentPane().add(txtMarca);
        txtMarca.setColumns(10);

        txtModelo = new JTextField();
        txtModelo.setBounds(174,121,97,20);
        getContentPane().add(txtModelo);
        txtModelo.setColumns(10);

        txtCor = new JTextField();
        txtCor.setBounds(174,160,97,20);
        getContentPane().add(txtCor);
        txtCor.setColumns(10);

        butOk = new JButton("Continuar");
        butOk.setBounds(104, 241, 97, 23);
        butOk.addActionListener(this);
        butOk.setActionCommand("Continuar");
        getContentPane().add(butOk);

        butCancel = new JButton("Continuar");
        butCancel.setBounds(210, 241, 97, 23);
        butCancel.addActionListener(this);
        butCancel.setActionCommand("Cancelar");
        getContentPane().add(butCancel);

        try {
            txfPlaca = new JFormattedTextField(new MaskFormatter("UUU-####"));
        } catch (ParseException e) {
            assert false:"Padrao de placa invalida";
        }
        txfPlaca.setBounds(174,43,97,20);
        getContentPane().add(txfPlaca);

        setLocationRelativeTo(null);




    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getActionCommand().equals("Continuar")){
            EstacionamentoControl control = new EstacionamentoControl();
            try {
                control.processarEntrada(txfPlaca.getText(), txtMarca.getText(), txtModelo.getText(), txtCor.getText());

                JOptionPane.showMessageDialog(null, "Veiculo registrado com sucesso"
                                                ,"Entrada de veiculo", JOptionPane.INFORMATION_MESSAGE);

            } catch (EstacionamentoException | VeiculoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Falha na entrada",
                                                JOptionPane.ERROR_MESSAGE);
            }

        }
        this.parent.setVisible(true);
        this.dispose();
    }
}
