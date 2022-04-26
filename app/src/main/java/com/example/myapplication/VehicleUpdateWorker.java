package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.work.Worker;
import androidx.work.WorkerParameters;


public class VehicleUpdateWorker extends Worker {
    public VehicleUpdateWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {


        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Account.sqlite").build();
        UserDao userDao = db.userDao();
        userDao.updateVehicleReg(getInputData().getString("name"),getInputData().getString("make"),getInputData().getString("model"),getInputData().getString("color"),getInputData().getString("number"),getInputData().getString("state"));
        Log.d("model",userDao.findByName(getInputData().getString("name")).model);
    return Result.success();

    }
}