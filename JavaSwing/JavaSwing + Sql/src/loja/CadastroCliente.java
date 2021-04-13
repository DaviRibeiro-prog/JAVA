package loja;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import sql.ConnectionSql;

import java.awt.Color;

public class CadastroCliente {

	ConnectionSql conn = new ConnectionSql();
	protected JFrame frame;
	private JTextField nome;
	private JTextField senha;
	private JTextField number;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente window = new CadastroCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CadastroCliente() {
			initialize();

	}


	private void initialize()  {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 456, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblCadastroCliente = new JLabel("Cadastro: Cliente");
		lblCadastroCliente.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 36));
		lblCadastroCliente.setBounds(12, 0, 344, 84);
		frame.getContentPane().add(lblCadastroCliente);
		
		JLabel f = new JLabel("Nome:");
		f.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		f.setBounds(22, 95, 77, 29);
		frame.getContentPane().add(f);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSenha.setBounds(22, 135, 77, 29);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNmero.setBounds(12, 175, 77, 29);
		frame.getContentPane().add(lblNmero);
		
		JLabel lblMasculino = new JLabel("Masculino");
		lblMasculino.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblMasculino.setBounds(10, 215, 89, 29);
		frame.getContentPane().add(lblMasculino);
		
		JLabel lblFeminino = new JLabel("Feminino");
		lblFeminino.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblFeminino.setBounds(126, 218, 89, 23);
		frame.getContentPane().add(lblFeminino);
		
		JRadioButton botao1 = new JRadioButton("");
		botao1.setBackground(Color.WHITE);
		botao1.setForeground(Color.BLACK);
		botao1.setBounds(95, 218, 21, 23);
		frame.getContentPane().add(botao1);
		
		JRadioButton botao2 = new JRadioButton("");
		botao2.setBackground(Color.WHITE);
		botao2.setBounds(208, 219, 21, 23);
		frame.getContentPane().add(botao2);
		
		JButton buttonCadastro = new JButton("Sing-Up");
		buttonCadastro.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		buttonCadastro.setBounds(12, 259, 103, 30);
		frame.getContentPane().add(buttonCadastro);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		buttonLogin.setBounds(126, 259, 103, 30);
		frame.getContentPane().add(buttonLogin);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(99, 95, 127, 20);
		frame.getContentPane().add(nome);
		
		senha = new JTextField();
		senha.setColumns(10);
		senha.setBounds(99, 140, 127, 20);
		frame.getContentPane().add(senha);
		
		number = new JTextField();
		number.setColumns(10);
		number.setBounds(99, 182, 127, 20);
		frame.getContentPane().add(number);
		
		ButtonGroup bg1 = new ButtonGroup();

		bg1.add(botao1);
		bg1.add(botao2);
		
		ImageIcon imagem1 = new ImageIcon(getClass().getResource("Imagens/baby-book.png"));
		JLabel lblImagem1 = new JLabel(imagem1);
		lblImagem1.setBounds(254, 9, 127, 75);
		frame.getContentPane().add(lblImagem1);
		
		
		// TODO handling code
		
		// METHOD TO REGISTER
		
		buttonCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String firstName = nome.getText();
                String mobileNumber = number.getText();
				String password = senha.getText();
				char sexo = ' ';
				
				Connection connection = null;
				Statement sta = null;
				
				if (botao1.isSelected()) {sexo = 'M'; } else {sexo = 'F'; };
                
				// SYSTEM (Ifs) FOR WRONG REGISTERED VALUES
				
                if (mobileNumber.length() != 10) {
                    JOptionPane.showMessageDialog(null, "Enter a valid mobile number!");       
                    return;
                    
                } else if (firstName.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Enter a valid name!");
                	return;
                    
                } else if (password.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Enter a valid passworld!");
                	return;
                	
                } else if (botao1.isSelected() == false && botao2.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "Enter a valid gender!");
                	return;
                	
                }

                try {
                	
                	connection = conn.connectionMySql();

                    String query = "INSERT INTO clientes values('" + firstName + "','" + password + "','" + mobileNumber + "','" + sexo + "',false)";

                    sta = connection.createStatement();
                 
                    try {									// SE JÁ TIVER UMA CONTA COM O MESMO NOME (PRIMARY KEY), ENTÃO AO INVÉS DE DAR UM ERRO NO CONSOLE, ELE MANDA UMA MENSAGEM COM RETURN (2*)
                    	sta.executeUpdate(query);
	                    JOptionPane.showMessageDialog(null,"Welcome, " + firstName + ". Your account has been successfully created!");
	                    
	                    LoginCliente windowLogin = new LoginCliente();
	                    
	                    frame.setVisible(false);
	                    windowLogin.frame.setVisible(true);
	                    
                    } catch (Exception idJaExiste) {											// (2*)
                    	 JOptionPane.showMessageDialog(null, "This account alredy exist!");
               
                    } 
                    
                
                } catch (SQLException e2) {
                	e2.printStackTrace();
                	
        		} finally {
        			
        			// CLOSE THE CONNECTIONS
        			
        			try {
        			
        				if (sta != null) {
        					sta.close();
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
		
		// METHOD TO RETURN TO THE HOME PAGE (LOGIN)
		
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginCliente loginCliente = new LoginCliente();
				
				frame.setVisible(false);
				loginCliente.frame.setVisible(true);
			}
		});
	}
}
