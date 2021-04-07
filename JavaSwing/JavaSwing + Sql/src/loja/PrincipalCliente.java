package loja;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PrincipalCliente {

	ConnectionSql conn = new ConnectionSql();
	protected JFrame frame;
	private JTextField novaSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalCliente window = new PrincipalCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public PrincipalCliente() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton buttonMudarSenha = new JButton("Trocar Senha");
		buttonMudarSenha.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 18));
		buttonMudarSenha.setBounds(10, 11, 143, 36);
		frame.getContentPane().add(buttonMudarSenha);
		
		
		novaSenha = new JTextField();
		novaSenha.setBounds(169, 15, 161, 36);
		frame.getContentPane().add(novaSenha);
		novaSenha.setColumns(10);
		
		ImageIcon imagem2 = new ImageIcon(getClass().getResource("Imagens/home.png"));
		JButton buttonSairConta = new JButton(imagem2);
		buttonSairConta.setBounds(396, 224, 28, 26);
		frame.getContentPane().add(buttonSairConta);
		
		
		
		JButton buttonInformacoes = new JButton("Informa\u00E7\u00F5es");
		buttonInformacoes.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 18));
		buttonInformacoes.setBounds(10, 65, 143, 36);
		frame.getContentPane().add(buttonInformacoes);
		
		JLabel lblNome = new JLabel("");
		lblNome.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNome.setBounds(20, 125, 121, 29);
		frame.getContentPane().add(lblNome);
		
		JLabel lblSenha = new JLabel("");
		lblSenha.setBackground(Color.WHITE);
		lblSenha.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSenha.setBounds(20, 165, 250, 29);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblNumber = new JLabel("");
		lblNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNumber.setBounds(20, 205, 278, 29);
		frame.getContentPane().add(lblNumber);
		
		JLabel lblSexo = new JLabel("");
		lblSexo.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSexo.setBounds(151, 125, 214, 29);
		frame.getContentPane().add(lblSexo);
		
	
		
		// TODO handling code
		
		// METHOD TO CHANGE THE PASSWORLD
		
		buttonMudarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Connection connection = null;
			    Statement update = null;
			    
				String senha = novaSenha.getText();
				
				if (senha.length() == 0) {											// SE O USUÁRIO NÃO DIGITAR NADA
                    JOptionPane.showMessageDialog(null, "Invalid Password!");
                    return;
				}
				
				try {
					
					connection = conn.connectionMySql();
					String query = "update clientes set senha = '" + senha + "' where logado = 1;";
					
					update = connection.createStatement();
				
					update.executeUpdate(query);
					lblSenha.setText("Senha: " + senha);
                    JOptionPane.showMessageDialog(null, "Your password has been changed successfully!");
					
				} catch (SQLException e2) {
                	e2.printStackTrace();
                	
        		} finally {
        			
        			// CLOSE THE CONNECTIONS
        			
        			try {
        			
        				if (update != null) {
        					update.close();
        				}
        			
        				if (connection != null) {
        					connection.close();
        				}
        				
        			} catch (SQLException e2) {
        				e2.printStackTrace();
        			}
        		}
			}
		});
		
		// METHOD TO LOGOFF
		
		buttonSairConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginCliente windowLoginCliente = new LoginCliente();
				Connection connection = null;
				Statement st = null;
				
				try {
					connection = conn.connectionMySql();
					
					String query = "update clientes set logado = 0 where logado = 1;";		// "logado" se tornara falso (0) nas informações do cliente (no banco de dados) que ESTAVA online (1)
					
					st = connection.createStatement();
					
					st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Signing out of your account...");
					
                    frame.setVisible(false);
                    windowLoginCliente.frame.setVisible(true);
                    
				}catch (SQLException e2) {
                	e2.printStackTrace();
                	
        		} finally {
        			
        			// CLOSE THE CONNECTIONS
        			
        			try {
        			
        				if (st != null) {
        					st.close();
        				}
        			
        				if (connection != null) {
        					connection.close();
        				}
        				
        			} catch (SQLException e2) {
        				e2.printStackTrace();
        			}
        		}
			}
		});
		
		// METHOD TO SHOW THE INFORMATIONS ABOUT THE ACCOUNT
		
		buttonInformacoes.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				PreparedStatement st = null;
				ResultSet select = null;
				Connection connection = null;
				
				try {
					connection = conn.connectionMySql();
					
					st = (PreparedStatement) connection.prepareStatement("SELECT * FROM clientes where logado = 1;");
					
					select = st.executeQuery();
				 
					if (select.next() ) {
						lblNome.setText("Nome: " + select.getString(1));		// getString(1) - Pegando a informação da coluna 1 do banco de dados (nome)
						lblSenha.setText("Senha: " + select.getString(2));		// coluna 2 (Senha)
						lblNumber.setText("Número: " + select.getString(3));	// coluna 3 (Número)
						lblSexo.setText("Sexo: " + select.getString(4));		// coluna 4 (Sexo)
					}
					
				}catch (SQLException e2) {
                	e2.printStackTrace();
                	
        		} finally {
        			
        			// CLOSE THE CONNECTIONS
        			
        			try {
        			
        				if (select != null) {
        					select.close();
        				}
        			
        				if (connection != null) {
        					connection.close();
        				}
        				
        				if (st != null) {
        					st.close();
        				}
        				
        			} catch (SQLException e2) {
        				e2.printStackTrace();
        			}
        		}
			}
		});

	}

}
