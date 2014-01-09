package com.cdl.utility;



import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;


public class SendEmail {
	private static final Logger logger = Logger.getLogger(SendEmail.class);
	String msg = "Hello this is temp email sent from info mail id.";
	String emails = "kush@cdl-it.com";
	String subject = "Temp subject";
	boolean flag = false;
	public boolean send(String to, String sub, String msg){
		logger.info( "Set Property ");
		emails = to;
		subject = sub;
		
		try{
			Properties prop=new Properties();
//			prop.load(new FileInputStream(new File("../../email.properties")));
			String host = "mail.cdl-it.com";
			final String user = "info@cdl-it.com";
			final String pass = "info203";
			
//			prop = new Properties();
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.socketFactory.port", "465");
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.port", "465");
	
			Session s=Session.getDefaultInstance(prop,
			new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(user,pass);	
				
				}	}		
			);
		
		
			//int result = "";
			logger.info( "In Try Blocak ");
			Message m= new MimeMessage(s);
			m.setFrom(new InternetAddress("info@cdl-it.com"));
			logger.info( "Email +++++"+emails);
			m.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emails));
			m.setSubject(subject);
			
			logger.error("#####"+msg);
			m.setContent(msg,"text/plain");
			Transport.send(m);
			logger.info( "Email  SuccessFully Sent to:"+ emails +"Order Id:");
			
			flag = true;	
		}catch(Exception e ){
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	
	public boolean sendwithCC(String[] to,String cc, String sub, String msg){
		logger.info( "Set Property ");
		subject = sub;
		
		InternetAddress[] addressTo = new InternetAddress[to.length];
        for (int i = 0; i < to.length; i++){
            try {
				addressTo[i] = new InternetAddress(to[i]);
			} catch (AddressException e) {
				e.printStackTrace();
			}
        }
		
		try{
			Properties prop=new Properties();
			String host = "mail.cdl-it.com";
			final String user = "info@cdl-it.com";
			final String pass = "info203";
			
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.socketFactory.port", "465");
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.port", "465");
	
			Session s=Session.getDefaultInstance(prop,
			new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(user,pass);	
				
				}	}		
			);
		
		
			logger.info( "In Try Blocak from Send Email");
			Message m= new MimeMessage(s);
			//m.setHeader("Content-Type", "text/html");
			m.setFrom(new InternetAddress("info@cdl-it.com"));
			
			m.setRecipients(Message.RecipientType.TO,addressTo );
			m.setRecipients(Message.RecipientType.CC,InternetAddress.parse(cc));
			m.setSubject(subject);
			
			m.setContent(msg,"text/html");
			Transport.send(m);
			
			
			flag = true;	
		}catch(Exception e ){
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public static void main(String[] args){
		SendEmail mail = new SendEmail();
		//mail.send();
	}

}
