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
}
