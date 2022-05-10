package sistema.model;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import java.sql.*;
import sistema.controller.LoginController;
import sistema.model.ConexaoBanco;
import sistema.model.PessoaModel;
import sistema.model.SetorModel;
import sistema.model.UsuarioModel;

public class ProcessoModel {
	
	private int idProcesso;
	private String status = "Trânsito";
	private String assunto;
	private String naturezaProcesso;
	private String descricao;
	private UsuarioModel idUsuario;
	private PessoaModel idPessoa;
	private SetorModel idSetor;
	private String cliente; //chave estrangeira da tabela Pessoa - id_Pessoa --> Pessoa_id_Pessoa
	private String cpf_cliente; //da tabela pessoa.cpf - cpf_pessoa //não tem utilidade em inserir na tabela processo
	private int id_Usuário; //chave estrangeira da tabela usuário - usuário_id --> Usuário_id_Usuário
	
	public ProcessoModel() {
		
	}

	public ProcessoModel(int idProcesso2, String status2, String assunto2, String naturezaProcesso2, String descricao2,
			int idUsuario2, int idSetor2, int idPessoa2) {
		
		this.idProcesso       = idProcesso2;
		this.status           = status2;
		this.assunto          = assunto2;
		this.naturezaProcesso = naturezaProcesso2;
		this.descricao        = descricao2;
	}
	
	
	
	public ProcessoModel(int idProcesso, String status, String assunto, String naturezaProcesso, String descricao,
			UsuarioModel idUsuario, PessoaModel idPessoa, SetorModel idSetor) {
		
		this.idProcesso       = idProcesso;
		this.status           = status;
		this.assunto          = assunto;
		this.naturezaProcesso = naturezaProcesso;
		this.descricao        = descricao;
		this.idUsuario        = idUsuario;
		this.idPessoa         = idPessoa;
		this.idSetor          = idSetor;
	}

	
	public void salvaDados() {		
		try{			
			Connection conn = ConexaoBanco.getConnection();
			String sql = "INSERT INTO processo(id_Processo, status_Processo, assunto_Processo, natureza_Processo, "
					+ "descricao_Processo, Usuario_id_Usuario, Pessoa_id_Pessoa, Setor_id_Setor)"
					+ " VALUES( "
					+ "'" + getIdProcesso() + "'," 					
					+ "'" + getStatus() + "',"
					+ "'" + getAssunto() + "',"
					+ "'" + getNaturezaProcesso() + "',"
					+ "'" + getDescricao() + "',"					
					+ "'" + getIdUsuario().getID() + "',"
					+ "'" + getIdPessoa().getID() + "',"
					+ "'" + getIdSetor().getId_Setor() + "'"
					+ " );";
			System.out.println("finalizou");
				
			PreparedStatement Statement = conn.prepareStatement(sql); 
			
			Statement.executeUpdate();
			
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		}
		
	}
	
	public void mudaStatus(ProcessoModel processo) {		
		try{			
			Connection conn = ConexaoBanco.getConnection();
			String sql = "UPDATE `mydb`.`processo` SET `status_Processo`='"+getStatus()+"' WHERE `id_Processo`='"+processo.getIdProcesso()+"';";
				
			PreparedStatement Statement = conn.prepareStatement(sql); 
			Statement.executeUpdate();			
		}		
		catch(SQLException e){			
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<ProcessoModel> buscaDados(SetorModel setor, String dados, String search){
		Statement query;
		ProcessoModel processo = null;		
		Connection conn        = null;
		int idProcesso         = 0;
		int idUsuario          = 0;
		int idSetor            = 0;
		int idPessoa           = 0;
		String nome;
		String status;
		String assunto;
		String naturezaProcesso;
		String descricao;
		ArrayList<ProcessoModel> vetor = new ArrayList<ProcessoModel>();
		try {
	    	  conn = ConexaoBanco.getConnection();
	    	  query = (Statement) conn.createStatement();
	    	  
	    	  String sql = "SELECT * FROM mydb.processo where Setor_id_Setor = '"+setor.getId_Setor()+"' and "+dados+" = '"+search+"';";
	    	    
	    	  ResultSet rs = query.executeQuery(sql);  
		         
	          while(rs.next()){
	        	    idProcesso       = rs.getInt("Processo.id_Processo");	        		
		        	status           = rs.getString("Processo.status_Processo"); 
		        	assunto          = rs.getString("Processo.assunto_Processo");
		        	naturezaProcesso = rs.getString("Processo.natureza_Processo");
		        	descricao        = rs.getString("Processo.descricao_Processo");
		        	idSetor          = rs.getInt("Processo.Setor_id_Setor");
		        	idUsuario        = rs.getInt("Processo.Usuario_id_Usuario");
		        	idPessoa         = rs.getInt("Processo.Pessoa_id_Pessoa");				 		
		        	processo         = new ProcessoModel(idProcesso, status, assunto, naturezaProcesso, descricao, idUsuario, idSetor, idPessoa);
		        	vetor.add(processo);
		        	System.out.println("chegou depois vetor");
	        }
	        conn.close();
	      } 
		catch (SQLException e) {  
	    	  e.printStackTrace();   
	      }
		return vetor;
	}
	
	public static ArrayList<ProcessoModel> buscaProcesso(SetorModel setor)
	{	
		Statement query;
		ProcessoModel processo = null;		
		Connection conn        = null;
		int idProcesso         = 0;
		int idUsuario          = 0;
		int idSetor            = 0;
		int idPessoa           = 0;
		String nome;
		String status;
		String assunto;
		String naturezaProcesso;
		String descricao;
		
		ArrayList<ProcessoModel> dados = new ArrayList<ProcessoModel>();		
	      try {
	    	  conn = ConexaoBanco.getConnection();
	    	  query = (Statement) conn.createStatement();
	    	  
	    	  String sql = "SELECT * FROM mydb.processo where Setor_id_Setor = '"+setor.getId_Setor()+"';";
	    	  //String sql2 = "SELECT * FROM Processo inner join Setor on Setor_id_Setor = Processo.Setor_id_Setor where processo.setor_id_setor = setor.id_setor";
	    	     
	    	  ResultSet rs = query.executeQuery(sql);  
		         
	          while(rs.next()){
	        	idProcesso       = rs.getInt("Processo.id_Processo");	        		
	        	status           = rs.getString("Processo.status_Processo"); 
	        	assunto          = rs.getString("Processo.assunto_Processo");
	        	naturezaProcesso = rs.getString("Processo.natureza_Processo");
	        	descricao        = rs.getString("Processo.descricao_Processo");
	        	idSetor          = rs.getInt("Processo.Setor_id_Setor");
	        	idUsuario        = rs.getInt("Processo.Usuario_id_Usuario");
	        	idPessoa         = rs.getInt("Processo.Pessoa_id_Pessoa");				 		
	        	processo         = new ProcessoModel(idProcesso, status, assunto, naturezaProcesso, descricao, idUsuario, idSetor, idPessoa);
	        	dados.add(processo);
	        	 
	        }
	        conn.close();
	      } catch (SQLException e) {  
	    	  e.printStackTrace();   
	      }
	      
	      return dados;
		
	}
	
	public int getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getNaturezaProcesso() {
		return naturezaProcesso;
	}

	public void setNaturezaProcesso(String naturezaProcesso) {
		this.naturezaProcesso = naturezaProcesso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UsuarioModel getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UsuarioModel idUsuario) {
		this.idUsuario = idUsuario;
	}

	public PessoaModel getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(PessoaModel idPessoa) {
		this.idPessoa = idPessoa;
	}

	public SetorModel getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(SetorModel idSetor) {
		this.idSetor = idSetor;
	}
}
