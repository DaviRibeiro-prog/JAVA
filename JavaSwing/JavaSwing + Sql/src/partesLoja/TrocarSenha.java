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

public class TrocarSenha {

	public JFrame frame;
	ConnectionSql connection = new ConnectionSql();
	private JTextField txtSenha;
	private JLabel lblMudarSenha;
	private JLabel lblSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrocarSenha window = new TrocarSenha();
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
	public TrocarSenha() {
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
		
		txtSenha = new JTextField();
		txtSenha.setBounds(122, 81, 118, 20); 
		frame.getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		ImageIcon imagem = new ImageIcon(getClass().getResource("home.png"));
		JButton buttonVoltar = new JButton(imagem);
		buttonVoltar.setBackground(Color.LIGHT_GRAY);
		buttonVoltar.setBounds(396, 118, 28, 26);
		frame.getContentPane().add(buttonVoltar);
		
		lblMudarSenha = new JLabel("Mudar Senha:");
		lblMudarSenha.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 36));
		lblMudarSenha.setBounds(10, 11, 288, 52);
		frame.getContentPane().add(lblMudarSenha);
		
		lblSenha = new JLabel("Nova Senha:");
		lblSenha.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSenha.setBounds(10, 74, 110, 29);
		frame.getContentPane().add(lblSenha);
		
		JButton mudarSenha = new JButton("Alterar");
		mudarSenha.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		mudarSenha.setBounds(10, 114, 103, 30);
		frame.getContentPane().add(mudarSenha);
		
		// TODO handling code
		
		mudarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement st = null;
				String novaSenha = txtSenha.getText();
				
				if (novaSenha.length() == 0) {												// Se o usuário não tiver entrado com nenhum valor
					 JOptionPane.showMessageDialog(null, "Enter a valid new password!");
					 return;
				}
				
				try {
					conn = connection.connectionMySql();
					st = conn.createStatement();	
					
					st.executeUpdate("update clientes set senha = '" + novaSenha + "' where logado = 1");
	                JOptionPane.showMessageDialog(null, "Your password has been changed successfully!");
					frame.setVisible(false);
					PrincipalCliente framePrincipal = new PrincipalCliente();
					framePrincipal.initialize();						// Inicializa novamente a janela principal para captar as informações de quem foi logado.
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
