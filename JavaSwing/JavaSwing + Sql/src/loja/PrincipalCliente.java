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

import partesLoja.TrocarNome;
import partesLoja.TrocarNumero;
import partesLoja.TrocarSenha;
import partesLoja.TrocarSexo;
import sql.ConnectionSql;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PrincipalCliente {

	ConnectionSql conn = new ConnectionSql();
	public JFrame frame;

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
	
	private void inicializarInformacoes(JLabel nome, JLabel senha, JLabel numero, JLabel sexo) {
		PreparedStatement st = null;
		ResultSet select = null;
		Connection connection = null;
		
		try {
			connection = conn.connectionMySql();
			
			st = (PreparedStatement) connection.prepareStatement("SELECT * FROM clientes where logado = 1;");
			
			select = st.executeQuery();
		 
			if (select.next() ) {
				nome.setText("Nome: " + select.getString(1));		// getString(1) - Pegando a informação da coluna 1 do banco de dados (nome)
				senha.setText("Senha: " + select.getString(2));		// coluna 2 (Senha)
				numero.setText("Número: " + select.getString(3));	// coluna 3 (Número)
				sexo.setText("Sexo: " + select.getString(4));		// coluna 4 (Sexo)
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

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 384, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		ImageIcon imagem2 = new ImageIcon(getClass().getResource("Imagens/home.png"));
		JButton buttonSairConta = new JButton(imagem2);
		buttonSairConta.setBounds(330, 252, 28, 26);
		frame.getContentPane().add(buttonSairConta);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNome.setBounds(10, 129, 278, 29);
		frame.getContentPane().add(lblNome);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setBackground(Color.WHITE);
		lblSenha.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSenha.setBounds(10, 169, 280, 29);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblNumber = new JLabel("NUMBER");
		lblNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNumber.setBounds(10, 249, 276, 29);
		frame.getContentPane().add(lblNumber);
		
		JLabel lblSexo = new JLabel("SEXO");
		lblSexo.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSexo.setBounds(10, 209, 214, 29);
		frame.getContentPane().add(lblSexo);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu menu = new JMenu();
		menu = new JMenu("Menu"); 
		menuBar.add(menu);
		
		JMenuItem mudarNome = new JMenuItem("Mudar Nome"); 
		JMenuItem mudarSenha = new JMenuItem("Mudar Senha");  
		JMenuItem mudarSexo = new JMenuItem("Mudar Sexo");  
		JMenuItem mudarNumero = new JMenuItem("Mudar Número");
		
		menu.add(mudarNome);
		menu.add(mudarSenha);
		menu.add(mudarSexo);
		menu.add(mudarNumero);
	
		inicializarInformacoes(lblNome, lblSenha, lblNumber, lblSexo);		// CHAMADA DO MÉTODO QUE IRÁ INICIALIZAR AS INFORMAÇÕES DA CONTA
		
		JLabel lblPrincipal = new JLabel("P\u00E1gina Principal");
		lblPrincipal.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 36));
		lblPrincipal.setBounds(10, 11, 288, 52);
		frame.getContentPane().add(lblPrincipal);
		
		JLabel lblInformaes = new JLabel("Informa\u00E7\u00F5es:");
		lblInformaes.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 26));
		lblInformaes.setBounds(10, 74, 288, 52);
		frame.getContentPane().add(lblInformaes);
		
		// TODO handling code
		
		
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
		
		
		
		// MENU ITENS
		
		
		mudarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrocarNome frameCliente = new TrocarNome();
				frameCliente.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		
		mudarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrocarSenha frameCliente = new TrocarSenha();
				frameCliente.frame.setVisible(true);
				frame.setVisible(false);
	
			}
		});
		
		
		mudarSexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrocarSexo frameCliente = new TrocarSexo();
				frameCliente.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		
		mudarNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrocarNumero frameCliente = new TrocarNumero();
				frameCliente.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
	
		
	}
}
