package com.daffo.Smtp_sendMail.portlet;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.rmi.AccessException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Administrator
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Naveen Apps",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Smtp_sendMail Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Smtp_sendMailPortlet extends MVCPortlet {
	public void sendMailMessage(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException, AccessException {
		System.out.println("====sendMailMessage===");
		String mailSubject=ParamUtil.getString(actionRequest,"mailSubject");
		String mailBody=ParamUtil.getString(actionRequest,"editor");
		String senderMailAddress=ParamUtil.getString(actionRequest,"senderEmailAddess");
		String receiverMailAddress=ParamUtil.getString(actionRequest,"receiverEmailAddess");
		System.out.println("1111"+mailBody);
		//System.out.println(senderMailAddress+""+receiverMailAddress);
		/*try {
			MailMessage mailMessage=new MailMessage();
	        mailMessage.setBody(mailBody);
	        mailMessage.setSubject(mailSubject);
	        mailMessage.setFrom(new InternetAddress(senderMailAddress));
	        mailMessage.setTo(new InternetAddress(receiverMailAddress));
			MailServiceUtil.sendEmail(mailMessage);
		    SessionMessages.add(actionRequest,"mail-send-success");
		}
		catch (Exception e) {
		   System.out.println(e);
		}*/
		
		  //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(senderMailAddress,"");  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(receiverMailAddress));    
         message.setSubject(mailSubject);    
         message.setText(mailBody);    
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    
           
  }  
	}
