package com.designpatternfinal.springweb.Service;

import com.designpatternfinal.springweb.model.Subscribers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class MailService{
    @Autowired
    private JavaMailSender mailSender;

    public void update(Subscribers subscriber, String updateText){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("caophat113@gmail.com");
        message.setTo(subscriber.getEmail());
        message.setSubject("NEW UPDATE FROM RESTAURANTLY");
        message.setText(updateText);
        mailSender.send(message);
    }

}
