package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class RegisterWorker extends Worker {
    public RegisterWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }
    @NonNull
    @Override
    public Result doWork() {

        // Do the work here--in this case, upload the images.
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Account.sqlite").build();
        UserDao userDao = db.userDao();
        Log.d("Register User",getInputData().getString("username"));
        Log.d("Register Password",getInputData().getString("password"));
        Account john = new Account();
        john.username=getInputData().getString("username");
        john.password=getInputData().getString("password");
        userDao.insertAll(john);
        Log.d("All Usernames",userDao.getAllUsernames().toString());
        // Indicate whether the work finished successfully with the Result
        return Result.success();
    }
}