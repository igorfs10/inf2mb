package br.senai.sp.jandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaContatos;
	private JScrollPane scrollTabela;
	private JPanel painelTabela;

	public FrmAgenda() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/agenda32.png")));
		setTitle("Agenda de contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 390);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.WHITE);
		painelTitulo.setBounds(0, 0, 434, 66);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTituloTela = new JLabel("Agenda");
		lblTituloTela.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/agenda32.png")));
		lblTituloTela.setFont(new Font("Arial", Font.BOLD, 28));
		lblTituloTela.setBounds(10, 11, 414, 44);
		painelTitulo.add(lblTituloTela);
		
		JLabel lblData = new JLabel("New label");
		lblData.setBounds(338, 11, 86, 28);
		
		Date dataAtual = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		lblData.setText(df.format(dataAtual));
		
		painelTitulo.add(lblData);
		
		painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Meus Contatos:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 0, 204)));
		painelTabela.setBounds(10, 64, 414, 197);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBotoes.setBounds(10, 272, 414, 66);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnNovo = new JButton("");
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmContato contato = new FrmContato("NOVO");
				contato.setVisible(true);
			}
		});
		
		btnNovo.setToolTipText("Adicionar contato");
		btnNovo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/novo32.png")));
		btnNovo.setBounds(10, 11, 44, 44);
		painelBotoes.add(btnNovo);
		
		JButton btnEditar = new JButton("");
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				abrirJanelaContato("EDITAR");
				
			}
		});
		
		btnEditar.setToolTipText("Editar contato");
		btnEditar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/editar32.png")));
		btnEditar.setBounds(64, 11, 44, 44);
		painelBotoes.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				abrirJanelaContato("EXCLUIR");
				
			}
		});
		
		btnExcluir.setToolTipText("Excluir contato");
		btnExcluir.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/excluir32.png")));
		btnExcluir.setBounds(118, 11, 44, 44);
		painelBotoes.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/sair32.png")));
		btnSair.setBounds(360, 11, 44, 44);
		painelBotoes.add(btnSair);
		
		criarTabela();
	
	}
	
	public void criarTabela(){
		
		// Cria e adiciona um scroll no painel da table
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 32, 394, 154);
		painelTabela.add(scrollTabela);
		
		tabelaContatos = new JTable();
		
		// Define o modelo da tabela
		DefaultTableModel modeloTabela = new DefaultTableModel();
		String[] nomesColunas = {"ID", "NOME", "E-MAIL"};
		modeloTabela.setColumnIdentifiers(nomesColunas);
		
		// Recupera os dados e poe na array para mostrar na tabela
		ContatoDAO contatoDAO = new ContatoDAO();
		ArrayList<Contato> contatos = new ArrayList<>();
		
		contatos = contatoDAO.getContatos();
		
		// Cria cada linha que ira compor a tabela
		Object[] linha = new Object[3];
		for(Contato contato : contatos){
			linha[0] = contato.getId();
			linha[1] = contato.getNome();
			linha[2] = contato.getEmail();
			modeloTabela.addRow(linha);
		}
		
		tabelaContatos.setModel(modeloTabela);
		
		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(31);
		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(143);
		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(151);
		scrollTabela.setViewportView(tabelaContatos);
	}
	
	private void abrirJanelaContato(String operacao){
		try {
			int linha;
			
			linha = tabelaContatos.getSelectedRow();
			
			int id;
			
			id = (int) tabelaContatos.getValueAt(linha, 0);
			
			ContatoDAO contatoDao = new ContatoDAO();
			Contato contato = contatoDao.getContato(id);
							
			FrmContato frmContato = new FrmContato(operacao);
			frmContato.setTxtId(String.valueOf(contato.getId()));
			frmContato.setTxtNome(contato.getNome());
			frmContato.setTxtEmail(contato.getEmail());
			frmContato.setTxtTelefone(contato.getTelefone());
			frmContato.setTxtCelular(contato.getCelular());
			frmContato.setTxtDtNasc(contato.getDtNasc());
			frmContato.setTxtEndereco(contato.getEndereco());
			frmContato.setCbSexo(contato.getSexo());
			
			frmContato.setVisible(true);
			
		} catch (Exception erro){
			JOptionPane.showMessageDialog(null, "Por favor selecione um contato!", 
					"Atenção", JOptionPane.WARNING_MESSAGE);
		}
	}
}