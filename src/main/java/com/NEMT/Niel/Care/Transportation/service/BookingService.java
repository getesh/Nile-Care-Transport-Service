package com.NEMT.Niel.Care.Transportation.service;

import com.NEMT.Niel.Care.Transportation.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
	
    private String email = "nilecaretransportation@gmail.com";

    @Autowired
    private JavaMailSender mailSender;

    public void sendBookingEmail(Booking booking) {
    	System.out.print("Mail send try");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("New Ride Booking");
        message.setText(
                "New ride booking details:\n\n" +
                        "Pick-up Location:\n" +
                        "Address: " + booking.getPickupStreet() + ", " + booking.getPickupCity() + ", " + booking.getPickupState() + ", " + booking.getPickupZip() + "\n\n" +
                        "Drop-off Location:\n" +
                        "Address: " + booking.getDropoffStreet() + ", " + booking.getDropoffCity() + ", " + booking.getDropoffState() + ", " + booking.getDropoffZip() + "\n\n" +
                        "Date: " + booking.getDate() + "\n" +
                        "Time: " + booking.getTime() + "\n" +
                        "Phone: " + booking.getPhone() + "\n" +
                        "Name: " + booking.getName() + "\n" +
                        "Email: " + booking.getEmail() + "\n" +
                        "Number Of passengers: " + booking.getPassengers() + "\n" +
                        "Round Trip: " + (booking.isRoundTrip() ? "Yes" : "No") + "\n" +
                        "Wheelchair: " + (booking.isWheelchair() ? "Yes" : "No") + "\n" +
                        "pickupInstructions: " + booking.getPickupInstructions() + "\n" +
                        "dropoffInstructions: " + booking.getDropoffInstructions() + "\n" +
                        "Additional Message: " + booking.getAdditionalMessage()
        );
        
        mailSender.send(message);
      
    }
}

