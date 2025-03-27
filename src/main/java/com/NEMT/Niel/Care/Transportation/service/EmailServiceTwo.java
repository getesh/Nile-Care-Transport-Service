package com.NEMT.Niel.Care.Transportation.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceTwo {

    @Autowired
    private JavaMailSender emailSender;
    private String email = "nilecaretransportation@gmail.com";

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}

