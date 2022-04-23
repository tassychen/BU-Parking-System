package com.example.myapplication;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version=1,entities = {Account.class})
public abstract class AppDatabase extends RoomDatabase {
    abstract UserDao userDao();
}