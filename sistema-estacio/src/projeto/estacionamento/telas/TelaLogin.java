package projeto.estacionamento.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaLogin extends JFrame implements ActionListener {

    private JPasswordField txtSenha;
    private JPanel panel_2;
    private JRadioButton butOperacional;
    private JRadioButton butRelatorio;
    private JButton btnOk;
    //TODO deletar após projeto concluido
    public static void main(String[] args) {
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }

    public TelaLogin(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(500,150));
        setResizable(false);
        setTitle("Login");

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);

        btnOk = new JButton("Continuar");
        btnOk.addActionListener(this);
        btnOk.setActionCommand("Continuar");
        panel.add(btnOk);

        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));

        panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.SOUTH);

        JLabel lblSenha = new JLabel("SENHA:");
        panel_2.add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setColumns(20);
        panel_2.add(txtSenha);

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.CENTER);

        ButtonGroup butgrupo = new ButtonGroup();

        butOperacional = new JRadioButton("Operacional");
        butOperacional.setSelected(true);
        butOperacional.addActionListener(this);
        butOperacional.setActionCommand("operacional");
        butgrupo.add(butOperacional);
        panel_3.add(butOperacional);

        butRelatorio = new JRadioButton("Relatrio");
        butRelatorio.addActionListener(this);
        butRelatorio.setActionCommand("relatorio");
        butgrupo.add(butRelatorio);
        panel_3.add(butRelatorio);

        panel_2.setVisible(false);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        String command = acao.getActionCommand();
        JFrame tela = null;

        if (command.equals("operacional")){
            panel_2.setVisible(false);
        }else if (command.equals("relatorio")){
            txtSenha.setText("");
            panel_2.setVisible(true);
        }else if (command.equals("Continuar")){
            if(butOperacional.isSelected()){
                tela = new TelaInicalMovimentacao();
                tela.setVisible(true);
            }else {
                String senha = new String(txtSenha.getPassword());
                if(senha.equals("adm")){
                    tela = new TelaInicialRelatorio();
                    tela.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Senha invalida", "Falha Login", JOptionPane.ERROR_MESSAGE);
                    txtSenha.setText("");
                    return;
                }
            } this.dispose();
        }


    }
}
