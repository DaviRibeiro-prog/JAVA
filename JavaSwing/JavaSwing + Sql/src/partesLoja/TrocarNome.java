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

public class TrocarNome {

	public JFrame frame;
	ConnectionSql connection = new ConnectionSql();
	private JTextField txtNome;
	private JLabel lblMudarNome;
	private JLabel lblNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrocarNome window = new TrocarNome();
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
	public TrocarNome() {
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
		
		txtNome = new JTextField();
		txtNome.setBounds(118, 81, 118, 20); 
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		ImageIcon imagem = new ImageIcon(getClass().getResource("home.png"));
		JButton buttonVoltar = new JButton(imagem);
		buttonVoltar.setBackground(Color.LIGHT_GRAY);
		buttonVoltar.setBounds(396, 118, 28, 26);
		frame.getContentPane().add(buttonVoltar);
		
		lblMudarNome = new JLabel("Mudar Nome:");
		lblMudarNome.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 36));
		lblMudarNome.setBounds(10, 11, 288, 52);
		frame.getContentPane().add(lblMudarNome);
		
		lblNome = new JLabel("Novo Nome:");
		lblNome.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNome.setBounds(10, 74, 110, 29);
		frame.getContentPane().add(lblNome);
		
		JButton mudarNome = new JButton("Alterar");
		mudarNome.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		mudarNome.setBounds(10, 114, 103, 30);
		frame.getContentPane().add(mudarNome);
		
		// TODO handling code
		
		mudarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String novoNome = txtNome.getText();
				Connection conn = null;
				Statement st = null;
				
				if (novoNome.length() == 0) {												// Se o usuário não tiver entrado com nenhum valor
					 JOptionPane.showMessageDialog(null, "Enter a valid new name!");
					 return;
				}
				
				try {
					conn = connection.connectionMySql();
					st = conn.createStatement();
					
					st.executeUpdate("update clientes set nome = '" + novoNome + "' where logado = 1");
	                JOptionPane.showMessageDialog(null, "Your name has been changed successfully!");
					frame.setVisible(false);
					PrincipalCliente framePrincipal = new PrincipalCliente();
					framePrincipal.initialize();								// Inicializa novamente a janela principal para captar as informações de quem foi logado.
					framePrincipal.frame.setVisible(true);
					
				} catch (Exception e1) {
					 JOptionPane.showMessageDialog(null, "This account alredy exist!");
					
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

