package com.example.myapplication.ui.home.tabs;

public class Location {
    private String name;
    private String address;
    private String entrance;
    private Double latitude;
    private Double longitude;
    public Location(String name, String address, String entrance, Double latitude, Double longitude){
        this.name = name;
        this.address = address;
        this.entrance = entrance;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getEntrance() {
        return entrance;
    }
}
