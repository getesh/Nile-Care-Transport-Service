package com.NEMT.Niel.Care.Transportation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private String email = "nilecaretransportation@gmail.com";


    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String name, String emailAddress, String phone, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email); // Replace with your email address
        message.setSubject("Nile Care Transport Service");
        message.setText("Name: " + name + "\n" +
                "Email: " + emailAddress + "\n" +
                "Phone: " + phone + "\n" +
                "Message: " + text + "\n");
        mailSender.send(message);
    }
}
