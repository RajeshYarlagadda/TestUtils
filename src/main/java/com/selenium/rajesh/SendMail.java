package com.selenium.rajesh;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendMail {
	public static void main(String[] args) {
		List<String> to = new ArrayList<String>();
//		to.add("iotemail@yes.my");
		to.add("rajesh.yarlagadda@asia.xchanging.com");
		File file = new File("F:/Work files/TestGmail.java");
		sendMail("",to,"Test Attachment", "test body", file);
	}
	
    private static void sendMail(String from, List<String> to, String subject, String body, File attachment){
    	String host = null, port = null, user = null, password = null;
    	Properties props = null;
    	FileDataSource dataSource = null;
    	String fileName = "F:/Work files/TestGmail.java";
    	
    	try {
    		host = "10.26.60.84";
    		port = "25";
    		from = "noreply@hrms.my";
    		
    		props = new Properties();
//    		props.setProperty("mail.smtp.host", host);
//    		props.setProperty("mail.smtp.port", port);
    		 
    		props.put("mail.smtp.host", "smtp.gmail.com");
    		props.put("mail.smtps.auth", "true");
    		props.put("mail.smtp.starttls.enable", "true");
    	    props.put("mail.smtp.port", "456");

    		Session session = Session.getDefaultInstance(props, null);
    		MimeMessage message = new MimeMessage(session);        
    		message.setFrom(new InternetAddress(from));
    		
    		InternetAddress[] internetAddress = new InternetAddress[to.size()];
			System.out.println("To user list size = " +to.size());
			for(int cnt=0;cnt<to.size();cnt++){
				String toAddr = to.get(cnt);
				internetAddress[cnt]= new InternetAddress(toAddr);
				System.out.println(" to user = " +toAddr);
				
			}
    		message.addRecipients(Message.RecipientType.TO, internetAddress);
    		message.setSubject(subject);
    		    		
    		BodyPart mimeBodyPart = new MimeBodyPart();
    		Multipart multipart = new MimeMultipart("alternative");
    		mimeBodyPart.setContent(body, "text/html");
    		multipart.addBodyPart(mimeBodyPart);
    		if(null!=attachment && 0!=attachment.length()){
    			MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
    			dataSource = new FileDataSource(attachment);
    			mimeBodyPart2.setDataHandler(new DataHandler(dataSource));
    			mimeBodyPart2.setFileName(dataSource.getName());
    			multipart.addBodyPart(mimeBodyPart2);
    		}
    		
    		
    		message.setContent(multipart);
    		message.saveChanges();
    		
//    		Transport.send(message);
    		Transport tr  = session.getTransport("smtps");
    		tr.connect("smtp.gmail.com", "xchanging.sup@gmail.com", "Xchanging1234");
    		tr.sendMessage(message, message.getAllRecipients());
    		System.out.println("Mail sent !!!!");
    	
		} catch (Exception e) {
			System.out.println(e);
		}
    	
    }
}
