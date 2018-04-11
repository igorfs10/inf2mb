package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class FrmContato extends JFrame {

	private JPanel painelPrincipal;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final JScrollPane scrollPane = new JScrollPane();

	public FrmContato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 478);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 310, 66);
		painelPrincipal.add(panel);
		
		JLabel lblTitulo = new JLabel("Contato");
		lblTitulo.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/editar32.png")));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setBounds(10, 11, 176, 44);
		panel.add(lblTitulo);
		
		JLabel lblAcao = new JLabel("Novo");
		lblAcao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAcao.setBounds(196, 24, 93, 24);
		panel.add(lblAcao);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dados:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(10, 64, 290, 287);
		painelPrincipal.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 25, 15, 14);
		panel_1.add(lblId);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(75, 22, 200, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 50, 38, 14);
		panel_1.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 47, 200, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 75, 38, 14);
		panel_1.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(75, 72, 200, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 100, 46, 14);
		panel_1.add(lblTelefone);
		
		textField_3 = new JTextField();
		textField_3.setBounds(75, 97, 200, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 125, 46, 14);
		panel_1.add(lblCelular);
		
		textField_4 = new JTextField();
		textField_4.setBounds(75, 122, 200, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 150, 49, 14);
		panel_1.add(lblEndereo);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(10, 262, 99, 14);
		panel_1.add(lblDataDeNascimento);
		
		textField_5 = new JTextField();
		textField_5.setBounds(119, 259, 156, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		scrollPane.setBounds(75, 153, 200, 98);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 362, 290, 66);
		painelPrincipal.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/editar32.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setBounds(10, 11, 46, 44);
		panel_2.add(btnSalvar);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/sair32.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setBounds(234, 11, 44, 44);
		panel_2.add(btnSair);
	}
}
