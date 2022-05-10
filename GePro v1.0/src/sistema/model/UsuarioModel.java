package sistema.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UsuarioModel extends PessoaModel {

	private String     senha;
	private SetorModel setor;
	private String     login;
	private int        tipo;
	private int        idUsuario;
	private int 	   idSetor;
	

	public UsuarioModel(String login, String nome, String senha, SetorModel setor, int tipo, int idSetor){
		super(tipo, nome);		
		this.login = login;
		this.senha = senha;
		this.setor = setor;
		this.tipo  = tipo;
		this.idSetor = idSetor;
	}
	
	public UsuarioModel() {
		
	}
	
	public UsuarioModel(String login2, String nome, String senha2, SetorModel setor2, int tipo2) {
		
		this.login = login2;
		this.senha = senha2;
		this.setor = setor2;
		this.tipo  = tipo2;
	}	
	
	public static UsuarioModel buscaUsuario(String login){
		Connection conn = null;
		UsuarioModel usuario = null;
		SetorModel setor;
		String nome;
		String senha;
		String setorNome;
		String siglaSetor;
		int idUsuario;
		int SetorId;
		int tipo;	
		
		try{
			conn = ConexaoBanco.getConnection();
			Statement query = conn.createStatement();
			String sql = "SELECT pessoa.nome_Pessoa, usuario.senha_Usuario, usuario.id_Usuario, usuario.tipo_Usuario, setor.nome_Setor, setor.sigla_Setor, setor.id_Setor "
					+ "From usuario "
					+ "inner join pessoa on usuario.Pessoa_id_Pessoa = pessoa.id_Pessoa "
					+ "inner join setor on usuario.Setor_id_Setor = setor.id_Setor "
					+ "where usuario.email_Usuario = '"+login+ "'";
			ResultSet resultado = query.executeQuery(sql);
			
			if( resultado.next()){
				idUsuario = resultado.getInt("usuario.id_Usuario");
				nome      = resultado.getString("pessoa.nome_Pessoa");
				setorNome = resultado.getString("setor.nome_Setor");
				SetorId   = resultado.getInt("setor.id_Setor");
				siglaSetor= resultado.getString("setor.sigla_Setor");
				senha     = resultado.getString("usuario.senha_Usuario");
				tipo      = resultado.getInt("usuario.tipo_Usuario");
				setor     = new SetorModel(SetorId, setorNome, siglaSetor);
				usuario   = new UsuarioModel(login, nome, senha, setor, tipo);
				usuario.setID(idUsuario);
				
			}
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return usuario;	
	}
	
	public void salvaDados(){
		try{			
			Connection conn = ConexaoBanco.getConnection();
			String sql = "INSERT INTO usuario(email_Usuario, senha_Usuario, tipo_Usuario, pessoa_Id_Pessoa, setor_Id_Setor)"
					+ " VALUES("
					+ "'" + getLogin() + "',"
					+ "'" + getSenha() + "',"
					+ "'" + getTipo() + "',"
					+ "'" + getID() + "',"
					+ "'" + getIdSetor() + "'"
					+ " );";
					
			PreparedStatement Statement = conn.prepareStatement(sql); 
			
			Statement.executeUpdate();
			
		}
		
		catch(SQLException e){
			
			e.printStackTrace();
		}
		
	}

	public int getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(int idSetor) {
		this.idSetor = idSetor;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
	public SetorModel getSetor() {
		return setor;
	}
	public void setSetor(SetorModel setor) {
		this.setor = setor;
	}
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
		
}
