package com.example.midterm.models;

public class GroundCampData {

    String name,location,ticket;

    public GroundCampData(String name, String location, String ticket) {
        this.name = name;
        this.location = location;
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
