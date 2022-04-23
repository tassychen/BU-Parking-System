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
        userDao.login(getInputData().getString("username"),getInputData().getString("password"));
        Log.d("All Usernames",userDao.getAllUsernames().toString());
        // Indicate whether the work finished successfully with the Result
        return Result.success();
    }
}