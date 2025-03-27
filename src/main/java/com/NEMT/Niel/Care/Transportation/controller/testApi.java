package com.NEMT.Niel.Care.Transportation.controller;

import com.NEMT.Niel.Care.Transportation.model.TestModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class testApi {

    @GetMapping("/test")
    public String getName(Model model){

        model.addAttribute("testModel", new TestModel());
        return "testModel";

    }
    @PostMapping("/test")
    public String postName(@ModelAttribute TestModel testModel, Model model){
        System.out.println("Code Reached Here");
        try{
            System.out.println("Name: " + testModel.getName());
            model.addAttribute("name", testModel.getName());
            model.addAttribute("successMessage", "Thank you for Booking! We will get back to you soon.");

        } catch (Exception e) {
            model.addAttribute("errorMessage", "Oops! There was an error sending Ride Request. Please try again later.");
            e.printStackTrace(); // Print the error for debugging
        }
        return "emailForm";
    }

}
