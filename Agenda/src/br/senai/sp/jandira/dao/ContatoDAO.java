package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.model.Contato;

public class ContatoDAO {
	
	private Contato contato;
	private PreparedStatement stm;
	private ResultSet rs;
	
	
	public void gravar(){
		String sql = "INSERT INTO contatos "
				+ "(nome, dtNasc, email, endereco, telefone, celular, sexo) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
	stm = null;
	
	try {
		stm = Conexao.abrirConexao().prepareStatement(sql);
		stm.setString(1, contato.getNome());
		stm.setString(2, contato.getDtNasc());
		stm.setString(3, contato.getEmail());
		stm.setString(4, contato.getEndereco());
		stm.setString(5, contato.getTelefone());
		stm.setString(6, contato.getCelular());
		stm.setString(7, contato.getSexo());
		stm.execute();
		
		JOptionPane.showMessageDialog(null, "Contato gravado com sucesso",
				"Grava��o",
				JOptionPane.INFORMATION_MESSAGE);
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}

	
	}
	
	public void atualizar(){
		
	}
	
	public void excluir(){
		
	}
	
	public Contato getContato(int id){
		return contato;
	}
	
	public void setContato(Contato contato){
		this.contato = contato;
	}
	
	public ArrayList<Contato> getContatos(){
		ArrayList<Contato> contatos = new ArrayList<>();
		
		String sql = "SELECT * FROM contatos";
		
		stm = null;
		rs = null;
		
		try{
			stm = Conexao.abrirConexao().prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				contato.setDtNasc(rs.getString("DtNasc"));
				contato.setSexo(rs.getString("sexo"));
				contato.setEndereco(rs.getString("endereco"));
				contatos.add(contato);
			}
			
			Conexao.abrirConexao().close();
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return contatos;
	}
}