package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.List;

public class TestWorker extends Worker {
    public TestWorker(
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
        Account john = new Account();
        john.username="John";
        john.password="god";
        john.uid=3;
        john.permit="Orange";
        userDao.insertAll(john);
        List<Account> accd= userDao.getAll();
        Log.d("user list", accd.toString());
        // Indicate whether the work finished successfully with the Result
        return Result.success();
    }
}