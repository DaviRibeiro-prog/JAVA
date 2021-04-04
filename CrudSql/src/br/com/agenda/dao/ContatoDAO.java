
	/*
	 * CRUD SQL E JAVA
	 * POO JAVA
	 * 
	 * NOME: Davi Ribeiro Fernandes Aleixo
	 * DATA: 03/01/2020
	 */



package br.com.agenda.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	/*
	 * CRUD
	 * 
	 * C: CREATE - INSERT - OK	
	 * R: Read	- SELECT - OK
	 * U: Update - UPDATE - OK
	 * D: Delete - DELETE - OK
	 */
	
	
	
	// INSERT
	
	public void insert(Contato contato) {			
		
		String sql = "INSERT INTO contato(nome, idade, datacadastro) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
		
			// Criamos uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
		
			int rowsInsert = pstm.executeUpdate();
			
			if (rowsInsert > 0) {
				mensages(contato, 1);
				
			} else {
				mensages(null, 4);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			// Fechar as conexões
			try {
			
				if (pstm != null) {
					pstm.close();
				}
			
				if (conn != null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// SELECT
	
	public void select(){
		
		String sql = "SELECT * FROM contato";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		// Classe que vai recuperar os dados do banco  ****SELECT****
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
			
				Contato contato = new Contato();
				
				
				// Recuperar o ID
				contato.setId(rset.getInt("id"));
				
				// Recuperar o nome
				contato.setNome(rset.getString("nome"));
				
				// Recuperar a idade
				contato.setIdade(rset.getInt("idade"));
				
				// Recuperar a data de cadastro
				contato.setDataCadastro(rset.getDate("datacadastro"));

									
		
				contatos.add(contato);
				System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
			    String output = "User %d: %s - %d - %s";
		
			    System.out.println(String.format(output, contato.getId(), contato.getNome(), contato.getIdade(), contato.getDataCadastro()));
			    
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if (rset != null) {
					rset.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	// UPDATE
	
	public void update(Contato contato) {
		
		String sql = "UPDATE contato SET nome=?, idade=?, datacadastro=? WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			
			
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			pstm.setInt(4, contato.getId());
			
			int rowsUpdated = pstm.executeUpdate();
			
			if (rowsUpdated > 0) {
			    mensages(contato, 2);
			    
			} else {
				mensages(null, 4);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {		
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	// DELETE
	
	public void delete(Contato contato) {
		
		String sql = "DELETE FROM contato WHERE id=?";
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, contato.getId());
			
			int rowsDeleted = pstm.executeUpdate();
			
			if (rowsDeleted > 0) {
			    mensages(contato, 3);
			    
			} else {
				mensages(null, 4);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {		
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	// DELETE ALL
	
	public void deleteAll() {
		String sql = "DELETE FROM contato";
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			// DELETARÁ TODOS OS DADOS DA TABLE
			
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.execute();
			
			// IRÁ REINICIAR O ID, POIS DELETOU TODOS OS DADOS
			
			sql = "ALTER TABLE contato AUTO_INCREMENT = 1";
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.execute();
			
			int rowsAllDeleted = pstm.executeUpdate();
			
			
			if (rowsAllDeleted == 0) {
			    mensages(null, 6);
			    
			} else {
				mensages(null, 5);
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	// MENSAGES
	
	public void mensages(Contato contato, int number) {
		
		switch (number) {
		
			case 1:
				System.out.println(contato.getNome() + " user was insert successfully!");
				System.out.println("-------------------------------");
				break;
				
			case 2:
			    System.out.println(contato.getNome() + " user was update successfully!");
				System.out.println("-------------------------------");
			    break;
			    
			case 3:
			    System.out.println(contato.getNome() + " user was deleted successfully!");
				System.out.println("--------------------------------");
			    break;
			    
			case 4:
				System.out.println("No users have been modified!");
				System.out.println("----------------------------");
				break;
			
			case 5:
				System.out.println("The table cant be clean!");
				break;
				
			case 6:
				System.out.println("The table was clean!");
				break;
		}
	}
}

