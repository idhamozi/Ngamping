package com.example.midterm.models;

public class GroundCampData {

    String name,location,ticket,description,imageUri;

    public GroundCampData(String name, String location, String ticket, String description, String imageUri) {
        this.name = name;
        this.location = location;
        this.ticket = ticket;
        this.description = description;
        this.imageUri = imageUri;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
