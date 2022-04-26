package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.work.WorkerParameters
import androidx.work.Worker
import androidx.room.Room
import android.util.Log
import java.lang.Exception

class LoginWorker(
    context: Context,
    params: WorkerParameters
) : Worker(context, params) {
    override fun doWork(): Result {

        // Do the work here--in this case, upload the images.
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "Account.sqlite"
        ).build()
        val userDao = db.userDao()
        val result = userDao.login(inputData.getString("username"), inputData.getString("password"))
        val pref = applicationContext.getSharedPreferences("MyPref", 0) // 0 - for private mode
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putString("current_make", result.make);
        editor.putString("current_model", result.model);
        editor.putString("current_color", result.color);
        editor.putString("current_number", result.number);
        editor.putString("current_state", result.state);
        editor.apply()
        // Indicate whether the work finished successfully with the Result
        return try {
            Log.d("Welcome", result.username)
            Result.success()
        } catch (e: Exception) {
            Log.d("No login", "please")
            Result.failure()
        }
    }
}
