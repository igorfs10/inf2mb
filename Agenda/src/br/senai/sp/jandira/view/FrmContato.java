package br.senai.sp.jandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmContato extends JFrame {

	private JPanel painelPrincipal;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtDataDeNascimento;
	private JTextArea txtEndereco;
	private final JScrollPane scrollPane = new JScrollPane();

	public FrmContato(String operacao) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/editar32.png")));
		setTitle("Dados do Contato");
		setBounds(100, 100, 378, 478);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setLayout(null);
		painelTitulo.setBackground(Color.WHITE);
		painelTitulo.setBounds(0, 0, 374, 66);
		painelPrincipal.add(painelTitulo);
		
		JLabel lblTitulo = new JLabel("Contato");
		lblTitulo.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/editar32.png")));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setBounds(10, 11, 176, 44);
		painelTitulo.add(lblTitulo);
		
		JLabel lblOperacao = new JLabel(operacao);
		lblOperacao.setForeground(Color.BLUE);
		lblOperacao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblOperacao.setBounds(271, 24, 93, 24);
		painelTitulo.add(lblOperacao);
		
		JPanel painelConteudo = new JPanel();
		painelConteudo.setBorder(new TitledBorder(null, "Dados:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelConteudo.setBounds(10, 64, 354, 287);
		painelPrincipal.add(painelConteudo);
		painelConteudo.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 25, 26, 14);
		painelConteudo.add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(129, 22, 46, 20);
		painelConteudo.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 58, 38, 14);
		painelConteudo.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(129, 55, 215, 20);
		painelConteudo.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 120, 38, 14);
		painelConteudo.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(129, 117, 215, 20);
		painelConteudo.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 147, 57, 14);
		painelConteudo.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(129, 144, 215, 20);
		painelConteudo.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 178, 46, 14);
		painelConteudo.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(129, 175, 215, 20);
		painelConteudo.add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 237, 73, 14);
		painelConteudo.add(lblEndereo);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(10, 212, 115, 14);
		painelConteudo.add(lblDataDeNascimento);
		
		txtDataDeNascimento = new JTextField();
		txtDataDeNascimento.setBounds(129, 206, 215, 20);
		painelConteudo.add(txtDataDeNascimento);
		txtDataDeNascimento.setColumns(10);
		scrollPane.setBounds(129, 231, 215, 45);
		painelConteudo.add(scrollPane);
		
		txtEndereco = new JTextArea();
		scrollPane.setViewportView(txtEndereco);
		txtEndereco.setLineWrap(true);
		txtEndereco.setWrapStyleWord(true);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 89, 38, 14);
		painelConteudo.add(lblSexo);
		
		JComboBox cbbSexo = new JComboBox();
		cbbSexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		cbbSexo.setBounds(129, 86, 38, 20);
		painelConteudo.add(cbbSexo);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBounds(10, 362, 354, 66);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Contato contato = new Contato();
				contato.setNome(txtNome.getText());
				contato.setEmail(txtEmail.getText());
				contato.setSexo(cbbSexo.getSelectedItem().toString());
				contato.setTelefone(txtTelefone.getText());
				contato.setCelular(txtCelular.getText());
				contato.setDtNasc(txtDataDeNascimento.getText());
				contato.setEndereco(txtEndereco.getText());
				
				ContatoDAO contatoDao = new ContatoDAO();
				contatoDao.setContato(contato);
				
				if(lblOperacao.getText().equals("NOVO")){
					contatoDao.gravar();
				}
				limparControles();
			}
		});
		btnSalvar.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/salvar32.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setBounds(10, 11, 46, 44);
		painelBotoes.add(btnSalvar);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/sair32.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setBounds(300, 11, 44, 44);
		painelBotoes.add(btnSair);
	}
	
	private void limparControles(){
		txtNome.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtCelular.setText("");
		txtDataDeNascimento.setText("");
		txtEndereco.setText("");
		txtNome.requestFocus();
		
	}
}
