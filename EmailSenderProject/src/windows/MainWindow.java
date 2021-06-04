package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import project.JavaMailUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MainWindow {

	private JFrame frame;
	private JTextField txtTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lbl1 = new JLabel("Title:");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl1.setBounds(10, 81, 43, 26);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Text:");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl2.setBounds(10, 133, 43, 26);
		frame.getContentPane().add(lbl2);
		
		txtTitle = new JTextField();
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTitle.setBounds(54, 77, 342, 37);
		frame.getContentPane().add(txtTitle);
		txtTitle.setColumns(10);
		
		JButton buttonSend = new JButton("Send Email");
		buttonSend.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonSend.setBounds(269, 227, 127, 23);
		frame.getContentPane().add(buttonSend);
		
		JTextArea txtText = new JTextArea();
		txtText.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtText.setBounds(54, 136, 342, 80);
		frame.getContentPane().add(txtText);
		txtText.setLineWrap(true);
		txtText.setWrapStyleWord(true);
		
		JLabel lblNewLabel = new JLabel("Automatic Sender");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(95, 22, 243, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JButton buttonUsers = new JButton("Users");
		buttonUsers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonUsers.setBounds(54, 227, 83, 23);
		frame.getContentPane().add(buttonUsers);
		

		
		// TODO

		buttonSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JavaMailUtil javaMailUtil = new JavaMailUtil();

				buttonSend.setText("Sending...");
				JOptionPane.showMessageDialog(null, "Sending... Wait the alert!");
				
				javaMailUtil.sendEmail(txtTitle.getText(), txtText.getText());
				buttonSend.setText("Send Email");
			}
		});
	
	}
}
