package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Account{

    @PrimaryKey
    @NonNull
    @ColumnInfo(name= "Username")
    public String username;

    @ColumnInfo(name = "Password")
    public String password;

    @ColumnInfo(name = "Permit")
    public String permit;

    @ColumnInfo(name = "Make")
    public String make;

    @ColumnInfo(name = "Model")
    public String model;

    @ColumnInfo(name = "Color")
    public String color;

    @ColumnInfo(name = "Number")
    public String number;

    @ColumnInfo(name = "State")
    public String state;
}
