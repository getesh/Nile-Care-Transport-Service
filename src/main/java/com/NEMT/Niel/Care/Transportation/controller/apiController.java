package com.NEMT.Niel.Care.Transportation.controller;
import com.NEMT.Niel.Care.Transportation.model.Booking;
import org.springframework.ui.Model;
import com.NEMT.Niel.Care.Transportation.model.ContactForm;
import com.NEMT.Niel.Care.Transportation.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class apiController {

  
    @Autowired
    ContactFormService contactFormService;
    

 
    @GetMapping("/scroll")
    public String getScroll(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("contactForm", new ContactForm());
        return "scrollTest";
    }
    
    @PostMapping("/sendContactForm")
    public String sendContactForm(@ModelAttribute ContactForm contactForm, Model model) {
        try {
            contactFormService.sendEmail(contactForm);
            model.addAttribute("successMessage", "Thank you for your message! We will get back to you soon.");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Oops! There was an error sending your message. Please try again later.");
            e.printStackTrace(); // Consider using a logging framework instead
        }

        return "contactUsConfermation"; // Redirect to avoid form resubmission
    }
}
