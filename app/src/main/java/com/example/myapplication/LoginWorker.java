package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.List;

public class LoginWorker extends Worker {
    public LoginWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }

    @Override
    public Result doWork() {

        // Do the work here--in this case, upload the images.
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Account.sqlite").build();
        UserDao userDao = db.userDao();
        Account result=userDao.login(getInputData().getString("username"),getInputData().getString("password"));

        // Indicate whether the work finished successfully with the Result
        try {
            Log.d("Welcome",result.username.toString());
            return Result.success();
        } catch (Exception e) {
            Log.d("No login","please");
            return Result.failure();
        }



    }
}