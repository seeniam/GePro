package sistema.model;

import java.sql.*;

public class ConexaoBanco {
	
	private static String usuarioBanco = "root";
	private static String senhaBanco   = "";
	private static String ipServidor   = "localhost";
	private static String porta        = "3306";
	private static String nomeBanco    = "mydb";
	
	public static Connection getConnection() throws SQLException {
	    Connection conn = null;	       
	    conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                ipServidor +
                ":" + porta + "/", 
                usuarioBanco,
                senhaBanco);
	    
	    conn.setCatalog(nomeBanco);
	    System.out.println("Connected to database");
	    return conn;
	}
	
	public static void main (String[] args) {
		try {
			Connection conn = ConexaoBanco.getConnection();
			Statement query = conn.createStatement();
			String sql = "SELECT nome_setor, id_Setor, sigla_Setor "
					+ "FROM setor "
					+ "where sigla_Setor = 'DAI'";
			ResultSet resultado = query.executeQuery(sql);
			System.out.println("\n aki eh o result - rs " + resultado);
			if(resultado.next()){
				System.out.println("Setor.nome");
			}
			else{
				System.out.println("Setor não encontrado");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Erro - Conexão com o banco!");
			e.printStackTrace();
		}
	}
	
}
