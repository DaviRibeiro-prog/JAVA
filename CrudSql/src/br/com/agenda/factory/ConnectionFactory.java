	
/*
	 * CRUD SQL E JAVA
	 * POO JAVA
	 * 
	 * NOME: Davi Ribeiro Fernandes Aleixo
	 * DATA: 03/01/2020
	 */


package br.com.agenda.factory;



import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	
	// Nome do usuário mySQL
	private static final String USERNAME = "root";
	
	// Senha do banco
	private static final String PASSWORD = "";
	
	// Caminho do banco de dados, porta, nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crudtest?useTimezone=true&serverTimezone=UTC";
			
	/*
	 * Conexão com o banco de dados
	 */
	
	public static Connection createConnectionToMySQL() throws Exception {		
		// Cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		// Recuperar uma conexão com o banco de dados
		Connection conn = createConnectionToMySQL();
		
		// Testar se a conexão é nula, para não sobrecarregar o sistema
		if (conn != null) {
			System.out.println("Conexão criada!");
			conn.close();
		}
	}

}
