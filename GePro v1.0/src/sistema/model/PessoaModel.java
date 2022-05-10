package sistema.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class PessoaModel {
	private int ID;
	private String nome;
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PessoaModel(int iD, String nome){
		this.ID   = iD;
		this.nome = nome;
	}
	
	public PessoaModel(){}
	
	public PessoaModel(int iD){
		this.ID = iD;
	}	
	public void setID(int iD) {
		ID = iD;
	}		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public int getID(){
		return ID;
	}

	public void salvaDados(PessoaModel pm) {
		try{			
			Connection conn = ConexaoBanco.getConnection();
			
			String sql = "INSERT INTO pessoa(cpf_Pessoa, nome_Pessoa) VALUES("+"'"+ getCpf()+"',"+"'"+getNome()+"');";
					
			PreparedStatement Statement = conn.prepareStatement(sql); 
			
			Statement.executeUpdate();
			
		}		
		catch(SQLException e){			
			e.printStackTrace();
		}
		
	}
	public int getIdPessoa(String cpf){
		int idPessoa = -1;
		try{			
			Connection conn = ConexaoBanco.getConnection();
			Statement query;
			query = (Statement) conn.createStatement();
			
			String sql = "select id_Pessoa from pessoa where cpf_Pessoa = "+cpf+"";	  
     
	    	ResultSet rs = query.executeQuery(sql);
	    	if(rs.next()){
		        	idPessoa= rs.getInt("Pessoa.id_Pessoa");
		        }
		}		
		catch(SQLException e){			
			e.printStackTrace();
		}
		
		return idPessoa;
	}
	
	
}
