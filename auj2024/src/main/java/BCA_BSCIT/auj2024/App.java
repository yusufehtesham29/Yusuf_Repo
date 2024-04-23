package BCA_BSCIT.auj2024;

import java.util.Properties;

import java.io.File;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator; //Authenticator class to authenticate mail id and password and other associated details 
import javax.mail.Message; //It will normally models an email message.
import javax.mail.MessagingException; //To handle the exception generated from message class
import javax.mail.PasswordAuthentication; //It will check username and password of the associated account
import javax.mail.Session; //When our JVM wants to communicate with host then session object will hold the info. regarding the communication
import javax.mail.Transport; //Mechanism to send message 
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage; //Multipurpose Internet Mail Extensions - Means its will tell format of msg.
import javax.mail.internet.MimeMultipart;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hey Dear...Welcome to our mailing application" );
        sendMail();
    }
    private static void sendMail() {
    	String msg = "Just checking dear, our mailing system";
    	String from = "yusufehtesham21@gmail.com";
    	String to = "mallickamar604@gmail.com";
    	String subject = "Our First Mail";
    	
    	//List out the different parameters for gmail
    	String host = "smtp.gmail.com";
    	String port = "465";
    	String ssl = "true";
    	String auth = "true";
    	
    	//Get system properties
    	Properties properties = System.getProperties();
    	
    	properties.put("mail.smtp.host", host);
    	properties.put("mail.smtp.port", port);
    	properties.put("mail.smtp.ssl.enable", ssl);
    	properties.put("mail.smtp.auth", auth);
    	
    	Session session = Session.getInstance(properties, new Authenticator() {
    		
    				
    					@Override
    					protected PasswordAuthentication getPasswordAuthentication() {
    						return new PasswordAuthentication("yusufehtesham21@gmail.com", "bkuq wpqa snlo pzaj");
    					}
    					
    	});
    	session.setDebug(true);
    	
    	
    	//compose message
    	MimeMessage messageObject = new MimeMessage(session);
    	Address[] add = new Address[3];
    	
    	
    	try {
    			add[0] = new InternetAddress("yusufehtesham21@gmail.com");
    			add[1] = new InternetAddress("mallickamar604@gmail.com");
    			add[2] = new InternetAddress("msdhoni07@gmail.com");
    			
    				messageObject.setFrom(from);
    				messageObject.addRecipients(Message.RecipientType.TO, add);
    				messageObject.setSubject(subject);
    				
    				MimeMultipart mimeMultipart = sendAttachments(msg);
    				
    				messageObject.setContent(mimeMultipart);
    				
    				Transport.send(messageObject);
    				System.out.println("Mail sent successfully");
    	} catch (MessagingException e) {
    		e.printStackTrace();
    	

    	}
}
    
    	private static MimeMultipart sendAttachments(String msg) {
    		File file = new File("C:\\Users\\HP\\Documents\\YUSUF's resume.pdf");
    				
    				MimeMultipart mimeMultipart = new MimeMultipart();
    				
    				MimeBodyPart textContent = new MimeBodyPart();
    				MimeBodyPart fileContent = new MimeBodyPart();
    				
    				try {
    					
    					textContent.setText(msg);
    					fileContent.attachFile(file);
    					
    					mimeMultipart.addBodyPart(textContent);
    					mimeMultipart.addBodyPart(fileContent);
    					
    				} catch(Exception e) {
    					e.printStackTrace();
    				}
    				return mimeMultipart;
    				}
    				}
    	
