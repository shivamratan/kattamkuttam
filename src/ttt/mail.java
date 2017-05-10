package ttt;
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
public class mail 
{
	public static void sendMail(String content)
	 {
		 String to="shivamratan61@gmail.com";
	     String userid="rohansachan413@gmail.com";
	     String password="9839fucker661351ttt";
	     String host="smtp.gmail.com";
	     String port="465";
	     try
	     {
	         
	    
	       Properties props = System.getProperties();
	             //wrapping all the information
	       props.put("mail.smtps.host",host);
	       props.put("mail.smtps.user",userid);
	       props.put("mail.smtps.password",password);
	       props.put("mail.smtps.port",port);
	       props.put("mail.smtps.auth",true);
	             //creating session to send message
	         Session ses=Session.getDefaultInstance(props,null);
	            //converting emailid's to internet address 
	         InternetAddress toAddress=new InternetAddress(to);
	         InternetAddress fromAddress=new InternetAddress(userid);
	             //creating e-mail structure
	         MimeMessage message=new MimeMessage(ses);
	           message.setSubject("Test mail from gui package");
	           message.setFrom(fromAddress);
	           message.setRecipient(Message.RecipientType.TO, toAddress);
	          message.setContent(content,"text/html;charset=utf-8");
	          
	         
	          
	             //setting carrier transport 
	          Transport trans=ses.getTransport("smtps");
	           trans.connect(host,userid,password);
	           trans.sendMessage(message,message.getAllRecipients());
	           trans.close();
	     }
	     catch(Exception e)
	     {
	         System.out.println(e);
	     } 
	     
	         
	      
	 }  
	public static void attachsendMail(String content,String path)
	 {
		 String to="shivamratan61@gmail.com";
	     String userid="rohansachan413@gmail.com";
	     String password="9839fucker661351ttt";
	     String host="smtp.gmail.com";
	     String port="465";
	     try
	     {
	         
	    
	       Properties props = System.getProperties();
	             //wrapping all the information
	       props.put("mail.smtps.host",host);
	       props.put("mail.smtps.user",userid);
	       props.put("mail.smtps.password",password);
	       props.put("mail.smtps.port",port);
	       props.put("mail.smtps.auth",true);
	             //creating session to send message
	         Session ses=Session.getDefaultInstance(props,null);
	            //converting emailid's to internet address 
	         InternetAddress toAddress=new InternetAddress(to);
	         InternetAddress fromAddress=new InternetAddress(userid);
	             //creating e-mail structure
	         MimeMessage message=new MimeMessage(ses);
	           message.setSubject("Test mail from gui package");
	           message.setFrom(fromAddress);
	           message.setRecipient(Message.RecipientType.TO, toAddress);
	        //  message.setContent(content,"text/html;charset=utf-8");
	          
	           
	           //sending attachment with mail
	           
	           MimeBodyPart mbp1 = new MimeBodyPart();
	           mbp1.setText(content);
	           
	           MimeBodyPart mbp2 = new MimeBodyPart();
	           
	           FileDataSource f=new FileDataSource(path);
	           mbp2.setDataHandler(new DataHandler(f));
	           mbp2.setFileName(f.getName());
	           
	           Multipart multi=new MimeMultipart(); 
	           multi.addBodyPart(mbp1);
	           multi.addBodyPart(mbp2);
	        
	           message.setContent(multi);
	          
	             //setting carrier transport 
	          Transport trans=ses.getTransport("smtps");
	           trans.connect(host,userid,password);
	           trans.sendMessage(message,message.getAllRecipients());
	           trans.close();
	     }
	     catch(Exception e)
	     {
	         System.out.println(e);
	     } 
	     
	         
	      
	 } 
}
