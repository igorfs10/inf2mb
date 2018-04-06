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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaContatos;
	JScrollPane scrollTabela;
	JPanel painelTabela;

	public FrmAgenda() {
		setTitle("Agenda de contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.WHITE);
		painelTitulo.setBounds(0, 0, 434, 66);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/agenda32.png")));
		lblAgenda.setFont(new Font("Arial", Font.BOLD, 28));
		lblAgenda.setBounds(10, 11, 414, 44);
		painelTitulo.add(lblAgenda);
		
		painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(null, "Meus Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 0, 204)));
		painelTabela.setBounds(0, 64, 434, 197);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		criarTabela();
		
		/*
		tabelaContatos = new JTable();
		tabelaContatos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "NOME", "E-MAIL"
			}
		));
		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(45);
		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(261);
		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(308);
		scrollTabela.setViewportView(tabelaContatos);
		
		*/
	}
	
	public void criarTabela(){
		DefaultTableModel modeloTabela = new DefaultTableModel();
		Object[] linhas = new Object[3];
		
		int i = 0;
		while(i < 5){
			linhas [0] = "1";
			linhas [1] = "Maria";
			linhas [2] = "maria@teste.com.br";
			modeloTabela.addRow(linhas);
			i++;
		}
		String[] titulo = {"ID", "NOME", "E-MAIL"};
		modeloTabela.setColumnIdentifiers(titulo);
		
		tabelaContatos.setModel(modeloTabela);
		scrollTabela.setViewportView(tabelaContatos);
		
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 24, 414, 145);
		painelTabela.add(scrollTabela);
	}
}
