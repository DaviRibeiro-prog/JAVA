package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalcularMedia {

	private JFrame frame;
	private JTextField nome;
	private JTextField nota1;
	private JTextField nota3;
	private JTextField nota4;
	private JTextField nota2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcularMedia window = new CalcularMedia();
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
	public CalcularMedia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel kaka = new JLabel("Nome do Aluno");
		kaka.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		kaka.setBounds(27, 11, 124, 32);
		frame.getContentPane().add(kaka);
		
		nome = new JTextField();
		nome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nome.setBounds(161, 14, 198, 20);
		frame.getContentPane().add(nome);
		nome.setColumns(10);
		
		JLabel ddd = new JLabel("Nota 2");
		ddd.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		ddd.setBounds(27, 119, 81, 45);
		frame.getContentPane().add(ddd);
		
		JLabel g = new JLabel("Nota 3");
		g.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		g.setBounds(181, 73, 100, 41);
		frame.getContentPane().add(g);
		
		JLabel gaaa = new JLabel("Nota 4");
		gaaa.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		gaaa.setBounds(181, 125, 100, 32);
		frame.getContentPane().add(gaaa);
		
		JLabel resultado = new JLabel("Aguardando...");
		resultado.setFont(new Font("Myanmar Text", Font.BOLD, 17));
		resultado.setBounds(37, 215, 342, 35);
		frame.getContentPane().add(resultado);
		
		JButton botao = new JButton("Responder");
		botao.setFont(new Font("Tahoma", Font.ITALIC, 16));
		botao.setBounds(27, 181, 124, 23);
		frame.getContentPane().add(botao);
		
		JLabel fff = new JLabel("Nota 1");
		fff.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		fff.setBounds(27, 78, 81, 30);
		frame.getContentPane().add(fff);
		
		nota1 = new JTextField();
		nota1.setBounds(85, 82, 86, 20);
		frame.getContentPane().add(nota1);
		nota1.setColumns(10);
		
		nota3 = new JTextField();
		nota3.setBounds(255, 82, 86, 20);
		frame.getContentPane().add(nota3);
		nota3.setColumns(10);
		
		nota4 = new JTextField();
		nota4.setColumns(10);
		nota4.setBounds(255, 130, 86, 20);
		frame.getContentPane().add(nota4);
		
		nota2 = new JTextField();
		nota2.setColumns(10);
		nota2.setBounds(85, 130, 86, 20);
		frame.getContentPane().add(nota2);
		
		
		// TODO handling code
		
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float n1 = Float.parseFloat(nota1.getText());
				float n2 = Float.parseFloat(nota2.getText());
				float n3 = Float.parseFloat(nota3.getText());
				float n4 = Float.parseFloat(nota4.getText());
	
				float media = (n1 + n2 + n3 + n4) / 4;
				
				resultado.setText("Média de " + nome.getText() + " é: " + media);
				
			}
		});
		
	}
}
