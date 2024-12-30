package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {
	
	@Autowired
    private JavaMailSender mailSender;

    public void sendPasswordResetEmail(String userEmail,String subject, String resetUrl) {
    	System.out.println("calling");
    	boolean isSent = false;
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(userEmail);
			
			/*
			 * helper.setSubject("Password Reset Request");
			 * helper.setText("<html><body><h3>Password Reset Request</h3>" +
			 * "<p>Click <a href='" + resetUrl +
			 * "'>here</a> to reset your password.</p></body></html>", true);
			 */
            
            helper.setSubject(subject);
            helper.setText(resetUrl,true);
            
            mailSender.send(message);
            isSent = true;
            System.out.println("Password reset email sent to " + userEmail);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
