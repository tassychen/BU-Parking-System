package com.example.myapplication.parking;

import com.google.firebase.database.IgnoreExtraProperties;

import java.time.LocalTime;
import java.util.Calendar;

@IgnoreExtraProperties
public class Crowd {
    public String location;
    public LocalTime time;
    public Integer dayOfWeek;
    public String crowd;

    public Crowd() {

    }

    public Crowd(String location, LocalTime time, Integer dayOfWeek, String crowd){
        this.location = location;
        this.time = time;
        this.dayOfWeek = dayOfWeek;
        this.crowd = crowd;
    }
}
