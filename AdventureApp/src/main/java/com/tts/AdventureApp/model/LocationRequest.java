package com.tts.AdventureApp.model;

public class LocationRequest {
    private String address;
    private String city;
    private String state;

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}