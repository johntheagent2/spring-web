package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.controller.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void senEmail(Email email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getSender());
        message.setTo(email.getReceiver());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());

        mailSender.send(message);
        System.out.println("Email sent successfully");
    }
}
