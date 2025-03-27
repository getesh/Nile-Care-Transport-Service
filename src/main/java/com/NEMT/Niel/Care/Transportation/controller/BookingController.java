package com.NEMT.Niel.Care.Transportation.controller;

import com.NEMT.Niel.Care.Transportation.model.Booking;
import com.NEMT.Niel.Care.Transportation.model.TestModel;
import com.NEMT.Niel.Care.Transportation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.util.Date;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookRide")
    public String bookride(Model model) {
        model.addAttribute("booking", new Booking());
        return "bookRide";
    }
    @PostMapping("/book-ride")
    public String bookRidePost(@ModelAttribute Booking booking, Model model) {
      

        try {
        	bookingService.sendBookingEmail(booking);
        	model.addAttribute("delay", 3000);
            model.addAttribute("successMessage", "Thank you for Booking! We will get back to you soon.");
            model.addAttribute("booking_date", booking.getDate());
            model.addAttribute("booking_time", booking.getTime());
            model.addAttribute("booking_wheelchair", booking.isWheelchair());
            model.addAttribute("booking_roundTrip", booking.isRoundTrip());
            
            model.addAttribute("booking_passengers", booking.getPassengers());
            model.addAttribute("booking_name", booking.getName());
            model.addAttribute("booking_phone", booking.getPhone());
            model.addAttribute("booking_email", booking.getEmail());
            
            model.addAttribute("pickupAdress", booking.getPickupStreet() +  " , " + booking.getPickupCity() + " , " + booking.getPickupState() + " , " + booking.getPickupZip());
            model.addAttribute("dropOfAddress", booking.getDropoffStreet() +  " , " + booking.getDropoffCity() + " , " + booking.getDropoffState() + " , " + booking.getDropoffZip());
            
            
            
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Oops! There was an error sending Ride Request. Please try again later.");
            e.printStackTrace(); // Print the error for debugging
        }
        System.out.println("Code Reached Here Two");

        return "emailForm";
    }
    
    @GetMapping("/booking")
    public String showBookingForm(
            @RequestParam(value = "booking_date", required = false) String bookingDate,
            @RequestParam(value = "booking_time", required = false) String bookingTime,
            @RequestParam(value = "booking_wheelchair", required = false) Boolean bookingWheelchair,
            @RequestParam(value = "booking_roundTrip", required = false) Boolean bookingRoundTrip,
            @RequestParam(value = "booking_passengers", required = false) Integer bookingPassengers,
            @RequestParam(value = "booking_name", required = false) String bookingName,
            @RequestParam(value = "booking_phone", required = false) String bookingPhone,
            @RequestParam(value = "booking_email", required = false) String bookingEmail,
            @RequestParam(value = "pickupAdress", required = false) String pickupAddress,
            @RequestParam(value = "dropOfAddress", required = false) String dropoffAddress,
            Model model) {

        // Populate model attributes if parameters are present
        if (bookingDate != null) model.addAttribute("booking_date", bookingDate);
        if (bookingTime != null) model.addAttribute("booking_time", bookingTime);
        if (bookingWheelchair != null) model.addAttribute("booking_wheelchair", bookingWheelchair);
        if (bookingRoundTrip != null) model.addAttribute("booking_roundTrip", bookingRoundTrip);
        if (bookingPassengers != null) model.addAttribute("booking_passengers", bookingPassengers);
        if (bookingName != null) model.addAttribute("booking_name", bookingName);
        if (bookingPhone != null) model.addAttribute("booking_phone", bookingPhone);
        if (bookingEmail != null) model.addAttribute("booking_email", bookingEmail);
        if (pickupAddress != null) model.addAttribute("pickupAdress", pickupAddress);
        if (dropoffAddress != null) model.addAttribute("dropOfAddress", dropoffAddress);
        model.addAttribute("booking", new Booking());

        return "bookRide";
    }
  
}

