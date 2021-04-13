package partesLoja;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import loja.PrincipalCliente;
import sql.ConnectionSql;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class TrocarNumero {

	public JFrame frame;
	ConnectionSql connection = new ConnectionSql();
	private JTextField txtNumero;
	private JLabel lblMudarNumero;
	private JLabel lblNumero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrocarNumero window = new TrocarNumero();
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
	public TrocarNumero() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 188);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(140, 81, 118, 20); 
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		ImageIcon imagem = new ImageIcon(getClass().getResource("home.png"));
		JButton buttonVoltar = new JButton(imagem);
		buttonVoltar.setBackground(Color.LIGHT_GRAY);
		buttonVoltar.setBounds(396, 118, 28, 26);
		frame.getContentPane().add(buttonVoltar);
		
		lblMudarNumero = new JLabel("Mudar N\u00FAmero:");
		lblMudarNumero.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 36));
		lblMudarNumero.setBounds(10, 11, 288, 52);
		frame.getContentPane().add(lblMudarNumero);
		
		lblNumero = new JLabel("Novo N\u00FAmero:");
		lblNumero.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNumero.setBounds(10, 74, 120, 29);
		frame.getContentPane().add(lblNumero);
		
		JButton mudarNumero = new JButton("Alterar");
		mudarNumero.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		mudarNumero.setBounds(10, 114, 103, 30);
		frame.getContentPane().add(mudarNumero);
		
		// TODO handling code
		
		mudarNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement st = null;
				String novoNumero = txtNumero.getText();
				
				if (novoNumero.length() < 10) {												// Se o usuário não tiver entrado com nenhum valor
					 JOptionPane.showMessageDialog(null, "Enter a valid new number!");
					 return;
				}
				
				try {
					conn = connection.connectionMySql();
					st = conn.createStatement();	
					
					st.executeUpdate("update clientes set numero = '" + novoNumero + "' where logado = 1");
					
	                JOptionPane.showMessageDialog(null, "Your number has been changed successfully!");
					frame.setVisible(false);
					PrincipalCliente framePrincipal = new PrincipalCliente();
					
					framePrincipal.initialize();															// Inicializa novamente a janela principal para captar as informações de quem foi logado.
					framePrincipal.frame.setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
					
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
						if (st != null) {
							st.close();
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalCliente framePrincipal = new PrincipalCliente();
				JOptionPane.showMessageDialog(null, "Returning to the home page..."); 
				
				framePrincipal.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
	}
}
