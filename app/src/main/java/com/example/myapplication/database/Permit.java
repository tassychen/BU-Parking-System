package com.example.myapplication.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Permit {
    @PrimaryKey @NonNull
    public String permitID;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "userType")
    public String userType;

    @ColumnInfo(name = "paymentFreq")
    public String paymentFreq;

    @ColumnInfo(name = "dayWeekPrice")
    public Integer dayWeekPrice;

    @ColumnInfo(name = "fallPrice")
    public Integer fallPrice;

    @ColumnInfo(name = "summerPrice")
    public Integer summerPrice;

    @ColumnInfo(name = "springPrice")
    public Integer springPrice;
}
