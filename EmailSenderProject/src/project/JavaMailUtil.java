package project;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JavaMailUtil {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sender = "testemailforjava16@gmail.com";
	String senderPassword = "******";

	
	public void sendEmail(String title, String text) {	
		try {
			ResultSet users = DAO.retriveUsers();
			
			while (users.next()) {
				Properties prop = new Properties();
				prop.put("mail.smtp.auth", true);
				prop.put("mail.smtp.starttls.enable", "true");
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.port", "587");
				
				Session session = Session.getInstance(prop, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(sender, senderPassword);
					}		
				});
				
				Message message = prepareMessage(session, sender, users.getString(2), text, title);
				
				Transport.send(message);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error!");
			e.printStackTrace();
			return;
		} 
		
		 JOptionPane.showMessageDialog(null, "Email successfully sent!");
	}

	
	private static Message prepareMessage(Session session, String sender, String recepient, String text, String title) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject(title);
			message.setText(text);
			return message;
			
		} catch (Exception e) {
			Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
		
	}
}


