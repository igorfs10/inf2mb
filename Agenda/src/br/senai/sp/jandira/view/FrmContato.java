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
import java.awt.Toolkit;

public class FrmContato extends JFrame {

	private JPanel painelPrincipal;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtDataDeNascimento;
	private final JScrollPane scrollPane = new JScrollPane();

	public FrmContato(String operacao) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/editar32.png")));
		setTitle("Dados do Contato");
		setBounds(100, 100, 326, 478);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setLayout(null);
		painelTitulo.setBackground(Color.WHITE);
		painelTitulo.setBounds(0, 0, 310, 66);
		painelPrincipal.add(painelTitulo);
		
		JLabel lblTitulo = new JLabel("Contato");
		lblTitulo.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/editar32.png")));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setBounds(10, 11, 176, 44);
		painelTitulo.add(lblTitulo);
		
		JLabel lblAcao = new JLabel(operacao);
		lblAcao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAcao.setBounds(196, 24, 93, 24);
		painelTitulo.add(lblAcao);
		
		JPanel painelConteudo = new JPanel();
		painelConteudo.setBorder(new TitledBorder(null, "Dados:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelConteudo.setBounds(10, 64, 290, 287);
		painelPrincipal.add(painelConteudo);
		painelConteudo.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 25, 15, 14);
		painelConteudo.add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(75, 22, 200, 20);
		painelConteudo.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 50, 38, 14);
		painelConteudo.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(75, 47, 200, 20);
		painelConteudo.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 75, 38, 14);
		painelConteudo.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(75, 72, 200, 20);
		painelConteudo.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 100, 46, 14);
		painelConteudo.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(75, 97, 200, 20);
		painelConteudo.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 125, 46, 14);
		painelConteudo.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(75, 122, 200, 20);
		painelConteudo.add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 150, 49, 14);
		painelConteudo.add(lblEndereo);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(10, 262, 99, 14);
		painelConteudo.add(lblDataDeNascimento);
		
		txtDataDeNascimento = new JTextField();
		txtDataDeNascimento.setBounds(119, 259, 156, 20);
		painelConteudo.add(txtDataDeNascimento);
		txtDataDeNascimento.setColumns(10);
		scrollPane.setBounds(75, 153, 200, 98);
		painelConteudo.add(scrollPane);
		
		JTextArea txtEndereco = new JTextArea();
		scrollPane.setViewportView(txtEndereco);
		txtEndereco.setLineWrap(true);
		txtEndereco.setWrapStyleWord(true);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBounds(10, 362, 290, 66);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/editar32.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setBounds(10, 11, 46, 44);
		painelBotoes.add(btnSalvar);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/sair32.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setBounds(234, 11, 44, 44);
		painelBotoes.add(btnSair);
	}
}
