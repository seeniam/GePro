package sistema.model;

import java.sql.*;
import java.util.ArrayList;

public class SetorModel {
	private String nome;
	private String sigla;
	private int id_Setor;
	
	public SetorModel(){
		
	}
	
	public SetorModel (int idSetor, String nome, String sigla){
		this.setNomeSetor(nome);
		this.sigla = sigla;
		this.id_Setor = idSetor;
	}
	
	public int pegarIdSetor(){
		int idSetor = 0;
		
		try {			
			Connection conn = ConexaoBanco.getConnection();
			Statement query = conn.createStatement();
			String sql = "SELECT MAX(setor.id_Setor) FROM setor";
			ResultSet ns = query.executeQuery(sql);
			if (ns.first()){
				idSetor = ns.getInt("setor.id_Setor");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return idSetor;
	}
	
	public ArrayList<String> pegarSiglaSetor(){
		String s = "";
		
		ArrayList<String> dados = new ArrayList<String>();
		try {			
			Connection conn = ConexaoBanco.getConnection();
			Statement query = conn.createStatement();
			String sql = "SELECT setor.sigla_Setor FROM setor";
			ResultSet ns = query.executeQuery(sql);
			
			while (ns.next()){
				s = ns.getString("setor.sigla_Setor");
				dados.add(s);
			}		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return dados;
	}
	
	public void salvaDados() {
		try{			
			Connection conn = ConexaoBanco.getConnection();			
			String sql = "INSERT INTO setor( nome_Setor, sigla_Setor) VALUES('"+ getNomeSetor()+"',"+"'"+getSigla()+"');";
			PreparedStatement Statement = conn.prepareStatement(sql); 
			Statement.executeUpdate();	
		}		
		catch(SQLException e){			
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		SetorModel sm = new SetorModel();
		sm.setNomeSetor("TESTasdaE");
		sm.setSigla("SIGLATasdasdESTE");
		sm.salvaDados();
	}
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}	
	public String getNomeSetor() {
		return nome;
	}
	public void setNomeSetor(String nome) {
		this.nome = nome;
	}
	public int getId_Setor() {
		return id_Setor;
	}
	public void setId_Setor(int id_Setor) {
		this.id_Setor = id_Setor;
	}	
	
		
}
