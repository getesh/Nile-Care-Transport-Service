package com.NEMT.Niel.Care.Transportation.model;

public class BookingRequest {
    private String pickupStreet;
    private String pickupCity;
    private String pickupState;
    private String pickupZip;
    private String dropoffStreet;
    private String dropoffCity;
    private String dropoffState;
    private String dropoffZip;
    private String date;
    private String time;
    private String phone;
    private String email;
    private String name;
    private boolean roundTrip = true;
    private String additionalMessage;
    private boolean wheelchair; 

    // Getters and Setters (omitted for brevity)

    public boolean isWheelchair() {
		return wheelchair;
	}

	public void setWheelchair(boolean wheelchair) {
		this.wheelchair = wheelchair;
	}

	public BookingRequest() {} 

    public String getPickupStreet() {
        return pickupStreet;
    }

    public void setPickupStreet(String pickupStreet) {
        this.pickupStreet = pickupStreet;
    }

    public String getPickupCity() {
        return pickupCity;
    }

    public void setPickupCity(String pickupCity) {
        this.pickupCity = pickupCity;
    }

    public String getPickupState() {
        return pickupState;
    }

    public void setPickupState(String pickupState) {
        this.pickupState = pickupState;
    }

    public String getPickupZip() {
        return pickupZip;
    }

    public void setPickupZip(String pickupZip) {
        this.pickupZip = pickupZip;
    }

    public String getDropoffStreet() {
        return dropoffStreet;
    }

    public void setDropoffStreet(String dropoffStreet) {
        this.dropoffStreet = dropoffStreet;
    }

    public String getDropoffCity() {
        return dropoffCity;
    }

    public void setDropoffCity(String dropoffCity) {
        this.dropoffCity = dropoffCity;
    }

    public String getDropoffState() {
        return dropoffState;
    }

    public void setDropoffState(String dropoffState) {
        this.dropoffState = dropoffState;
    }

    public String getDropoffZip() {
        return dropoffZip;
    }

    public void setDropoffZip(String dropoffZip) {
        this.dropoffZip = dropoffZip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRoundTrip() {
        return roundTrip;
    }

    public void setRoundTrip(boolean roundTrip) {
        this.roundTrip = roundTrip;
    }

    public String getAdditionalMessage() {
        return additionalMessage;
    }

    public void setAdditionalMessage(String additionalMessage) {
        this.additionalMessage = additionalMessage;
    }

 
}
