package com.NEMT.Niel.Care.Transportation.controller;

import com.NEMT.Niel.Care.Transportation.model.Booking;
import com.NEMT.Niel.Care.Transportation.service.BookingService;
import com.NEMT.Niel.Care.Transportation.service.EmailService;
import com.NEMT.Niel.Care.Transportation.service.EmailServiceTwo;
import org.springframework.ui.Model;
import com.NEMT.Niel.Care.Transportation.model.ContactForm;
import com.NEMT.Niel.Care.Transportation.service.ContactFormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;

@Controller
public class apiController {


    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private BookingService bookingService;

    @Autowired
    EmailServiceTwo emailServiceTwo;
    
    @Autowired
    EmailService emailService;
    
    @Autowired
    ContactFormService contactFormService;
    



    @GetMapping("")
    public String getIndex() {
        return "index";
    }
    @GetMapping("/fra")
    public String getLayout() {
        return "home";
    }


    @GetMapping("/home")
    public String home() {
        return "index";
    }
    @GetMapping("/services")
    public String getService() {
        return "services";
    }
    @GetMapping("/aboutUs")
    public String getAbout() {
        return "aboutUs";
    }
    @GetMapping("/scroll")
    public String getScroll(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("contactForm", new ContactForm());
        return "scrollTest";
    }

    @GetMapping("/book")
    public String bookRide() {
        return "book";
    }
    @GetMapping("/form")
    public String form() {
        return "emailForm";
    }
    
    @PostMapping("/sendContactForm")
    public String sendContactForm(@ModelAttribute ContactForm contactForm, Model model) {
        try {
            System.out.println("Contact form reached here");
            System.out.println("Email: " + contactForm.getFormEmail());
            
            contactFormService.sendEmail(contactForm);
            model.addAttribute("successMessage", "Thank you for your message! We will get back to you soon.");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Oops! There was an error sending your message. Please try again later.");
            e.printStackTrace(); // Consider using a logging framework instead
        }

        return "contactUsConfermation"; // Redirect to avoid form resubmission
    }
    
//
//    @PostMapping("/sendEmail")
//    public String sendEmail(@RequestParam String email, @RequestParam String subject,
//                            @RequestParam String message, Model model) {
//        System.out.println("Attempt to send email");
//        emailServiceTwo.sendEmail(email, subject, message);
//        System.out.println("Email Sent Sucss");
//        model.addAttribute("message", "Email sent successfully!");
//        return "emailResult"; // return a view name
//    }
//    
//  
//
//    @PostMapping("/register/save")
//    public String processContactForm(@ModelAttribute("contactForm") ContactForm contactForm, Model model) {
//
//        // 1. Process the form data (e.g., validation, data storage)
//        System.out.println("Name: " + contactForm.getName());
//        System.out.println("Email: " + contactForm.getEmail());
//        System.out.println("Message: " + contactForm.getMessage());
//
//        // 2. Send the email
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("nilecaretransportation@gmail.com"); // Replace with your email address
//        message.setSubject("New Contact Form Submission");
//        message.setText("Name: " + contactForm.getName() + "\n" +
//                "Email: " + contactForm.getEmail() + "\n" +
//                "Phone: " + contactForm.getPhone() + "\n" +
//                "Message: " + contactForm.getMessage());
//
//        try {
//            mailSender.send(message);
//            model.addAttribute("successMessage", "Thank you for your message! We will get back to you soon.");
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "Oops! There was an error sending your message. Please try again later.");
//            e.printStackTrace(); // Print the error for debugging
//        }
//
//        model.addAttribute("contactForm", new ContactForm()); // Reset the form after submission (important)
//        return "contact"; // Return to the contact form page
//    }
//
}
