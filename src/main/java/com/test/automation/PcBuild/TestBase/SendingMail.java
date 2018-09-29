package com.test.automation.PcBuild.TestBase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class SendingMail {

	// Get the session object

	public static void sendMail() {
		
		
		  final String user="narkeharit@gmail.com";//change accordingly  
		  final String password="8983008300";//change accordingly  
		  Date date = new Date();
		  String d=date.toString();
		  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		  String currentdate = dateFormat.format(date);
		  

		  String to="haritnarke@gmail.com";//change accordingly  
		  
		   //Get the session object  
		   Properties props = new Properties();  
		   
		   props.put("mail.username",user );
		   props.put("mail.password",password );
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587"); 

		   	Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(user,password);  
		      }  
		    });  
		  
		   //Compose the message  
		    try {  
		    	
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(user));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		    // message.addRecipient(Message.RecipientType.CC,new InternetAddress("madhurivyawahare@gmail.com"));  
		     
		     message.setSubject("Lowest Price for Gaming PC build as on "+d);  
		     
		     
		     
		     BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText("This is lowest price for the Gaming PC parts as on "+d+" . \nPlease Refer to attached sheet.\n\n\nThanks And Regards,\nHarit");

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = "C:\\Users\\madhav\\eclipse-workspace\\PcBuild\\src\\main\\java\\com\\test\\automation\\PcBuild\\DataFolder\\LowestPriceLists_"+currentdate+".xlsx";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

		     
		    //send the message  
		     Transport.send(message);
		  
		     System.out.println("message sent successfully...");  
		   
		     } catch (MessagingException e) {e.printStackTrace();}  
		 }
}
