package com.NEMT.Niel.Care.Transportation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.NEMT.Niel.Care.Transportation.model.ContactForm;

@Service
public class ContactFormService {
	
	 	@Autowired
	    private JavaMailSender emailSender;
	 	
	    private String email = "nilecaretransportation@gmail.com";
	    
	 

	    public void sendEmail(ContactForm contactForm) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(contactForm.getFormEmail());
	        message.setSubject("CONTACT US:");
	      
	        message.setText(
	                "New Contact Us Form:\n\n" +
	                		"Name: " + contactForm.getFormName() + "\n" +
	                        "Phone: " + contactForm.getFormPhone() + "\n" +	               
	                        "Email: " + contactForm.getFormEmail() + "\n" +
	                        "Message: " + contactForm.getFormMessage()
	        );
	        emailSender.send(message);
	    }
	

}
