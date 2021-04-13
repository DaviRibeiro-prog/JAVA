package loja;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import sql.ConnectionSql;

import java.awt.Color;


public class LoginCliente {

	ConnectionSql conn = new ConnectionSql();
	public JFrame frame;
	private JPasswordField passwordCliente;
	private JTextField nomeCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCliente window = new LoginCliente();
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
	public LoginCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 508, 278);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Login: Cliente");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 36));
		lblNewLabel.setBounds(26, 21, 302, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		buttonLogin.setBounds(26, 186, 89, 30);
		frame.getContentPane().add(buttonLogin);
		
		JButton buttonCadastro = new JButton("Sing-Up");
		buttonCadastro.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		buttonCadastro.setBounds(125, 186, 103, 30);
		frame.getContentPane().add(buttonCadastro);
		
		passwordCliente = new JPasswordField();
		passwordCliente.setBounds(112, 139, 127, 20);
		frame.getContentPane().add(passwordCliente);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_1.setBounds(36, 92, 54, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		nomeCliente = new JTextField();
		nomeCliente.setBounds(112, 99, 127, 20);
		frame.getContentPane().add(nomeCliente);
		nomeCliente.setColumns(10);
		nomeCliente.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(33, 132, 68, 29);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		ImageIcon imagem = new ImageIcon(getClass().getResource("Imagens/business-and-trade.png"));
		JLabel lblNewLabel_2 = new JLabel(imagem);
		lblNewLabel_2.setBounds(218, 6, 103, 82);
		frame.getContentPane().add(lblNewLabel_2);
		
		// TODO handling code
		
		// METHOD TO LOGOFF AND TO RETURN TO THE HOME PAGE (LOGIN)
		
		buttonCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente cadastroCliente = new CadastroCliente();
				
				frame.setVisible(false);
				cadastroCliente.frame.setVisible(true);
			}
		});
		
		
		// LOGIN ACCOUNT METHOD
			
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = nomeCliente.getText();
	            @SuppressWarnings("deprecation")
				String password = passwordCliente.getText();
	            
	            Connection connection = null;
	            PreparedStatement st = null;
	            ResultSet rs = null;
	            
	               try {
	                	
	                    connection = conn.connectionMySql();
	                    st = (PreparedStatement) connection.prepareStatement("Select nome, senha from clientes where nome=? and senha=?");
	                    String query = "update clientes set logado = true where nome = '" + userName + "';";
	                       
	                    st.setString(1, userName);
	                    st.setString(2, password);
	                    
	                    Statement update = connection.createStatement();
	                    rs = st.executeQuery();
	                    
	                    if (rs.next()) {												// Se houver uma conta no banco de dados com o "userName" e "password" digitados, então ele retorna true, se não (2*)
	                    	PrincipalCliente principalCliente = new PrincipalCliente();
	                    	
	                 
	                        JOptionPane.showMessageDialog(null, "You have successfully logged in!");       
	                        
	                        
	                        update.executeUpdate(query);					// A variável "logado" da pessoa referente ao nome que foi digitado (que esta correto), será colocada como true (1), quer dizer que a pessoa esta online
	                        frame.setVisible(false);						// FECHA A JANELA ATUAL
	                        principalCliente.initialize();					// Inicializa novamente a janela principal para captar as informações de quem foi logado.
	                        principalCliente.frame.setVisible(true);		// ABRE A JANELA PRINCIPAL
                 
	                    } else {																	// (2*) Se uma das informações estiverem falsas, então aparece uma mensagem de erro
	                        JOptionPane.showMessageDialog(null, "Wrong Username & Password!");
	                        
	                    }             
	                    
				} catch (SQLException e2) {
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
        				
        				if (rs != null) {
        					rs.close();
        				}
        				
        			} catch (SQLException e2) {
        				e2.printStackTrace();
        			}
        		}
			};	
		});
			
		
			
		

	}
}
