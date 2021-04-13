package partesLoja;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import loja.PrincipalCliente;
import sql.ConnectionSql;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;

public class TrocarSexo {

	public JFrame frame;
	ConnectionSql connection = new ConnectionSql();
	private JLabel lblMudarSexo;
	private JLabel lblSexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrocarSexo window = new TrocarSexo();
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
	public TrocarSexo() {
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
		
		ImageIcon imagem = new ImageIcon(getClass().getResource("home.png"));
		JButton buttonVoltar = new JButton(imagem);
		buttonVoltar.setBackground(Color.LIGHT_GRAY);
		buttonVoltar.setBounds(396, 118, 28, 26);
		frame.getContentPane().add(buttonVoltar);
		
		lblMudarSexo = new JLabel("Mudar Sexo:");
		lblMudarSexo.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 36));
		lblMudarSexo.setBounds(10, 11, 288, 52);
		frame.getContentPane().add(lblMudarSexo);
		
		lblSexo = new JLabel("Novo Sexo:");
		lblSexo.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSexo.setBounds(10, 75, 110, 29);
		frame.getContentPane().add(lblSexo);
		
		JButton mudarSexo = new JButton("Alterar");
		mudarSexo.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		mudarSexo.setBounds(10, 114, 103, 30);
		frame.getContentPane().add(mudarSexo);
		
		JRadioButton botao1 = new JRadioButton("Masculino");
		botao1.setFont(new Font("Tahoma", Font.BOLD, 14));
		botao1.setBackground(Color.WHITE);
		botao1.setBounds(108, 80, 93, 23);
		frame.getContentPane().add(botao1);
		
		JRadioButton botao2 = new JRadioButton("Feminino");
		botao2.setFont(new Font("Tahoma", Font.BOLD, 14));
		botao2.setBackground(Color.WHITE);
		botao2.setBounds(205, 80, 121, 23);
		frame.getContentPane().add(botao2);
		
		ButtonGroup bg1 = new ButtonGroup();

		bg1.add(botao1);
		bg1.add(botao2);
		
		
		// TODO handling code
		
		mudarSexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement st = null;
				char novoSexo = ' ';
				
				
				if (botao1.isSelected()) {
					novoSexo = 'M'; 
					
				} else if (botao2.isSelected()) {
					novoSexo = 'F'; 
				
				} else if (botao1.isSelected() == false && botao2.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "Enter a valid gender!");
                	return;
                }
			
				
				try {
					conn = connection.connectionMySql();
					st = conn.createStatement();
					
					st.executeUpdate("update clientes set sexo = '" + novoSexo + "' where logado = 1");
	                JOptionPane.showMessageDialog(null, "Your gender has been changed successfully!");
					frame.setVisible(false);
					PrincipalCliente framePrincipal = new PrincipalCliente();
					framePrincipal.initialize();								// Inicializa novamente a janela principal para captar as informações de quem foi logado.
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

