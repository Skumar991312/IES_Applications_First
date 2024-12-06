package in.skumar.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

  @Autowired
  private JavaMailSender mailSender;


	public boolean senEmail(String subject, String body,String to) {

		boolean isSent=false;

		 try {
	            // Create a MimeMessage
	            MimeMessage mimeMessage = mailSender.createMimeMessage();

	            // Use MimeMessageHelper for setting email properties
	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
	            helper.setTo(to);
	            helper.setSubject(subject);
	            helper.setText(body,true); // 'true' enables HTML content

	            // Send the email
	            mailSender.send(mimeMessage);

	            isSent=true;

	        } catch (Exception e) {
	            e.printStackTrace();
	            // Replace with proper logging
	            return false;
	        }
		 return isSent;
	    }

}
