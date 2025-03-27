package com.NEMT.Niel.Care.Transportation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.NEMT.Niel.Care.Transportation.model.ContactForm;
import com.NEMT.Niel.Care.Transportation.service.ContactFormService;

@Controller
public class ContcatUsController {
	
	@Autowired
    ContactFormService contactFormService;
	

//    @GetMapping("/scroll")
//    public String contactForm(Model model) {
//    	
//        model.addAttribute("contactForm", new ContactForm()); // Add contactForm to the model
//        
//        return "scrollTest";
//    }
//
//    @PostMapping("/sendContactForm")
//    public String sendContactForm(@ModelAttribute ContactForm contactForm, Model model) {
//        try {
//            System.out.println("Contact form reached here");
//            contactFormService.sendEmail(contactForm);
//            model.addAttribute("successMessage", "Thank you for your message! We will get back to you soon.");
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "Oops! There was an error sending your message. Please try again later.");
//            e.printStackTrace(); // Consider using a logging framework instead
//        }
//
//        return "redirect:/contact"; // Redirect to avoid form resubmission
//    }

}
