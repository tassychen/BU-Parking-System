package com.example.myapplication
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private var binding: ActivityLoginBinding? = null
    private val workManager=WorkManager.getInstance(application)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        var pref = applicationContext.getSharedPreferences("MyPref", 0) // 0 - for private mode
        var editor: SharedPreferences.Editor = pref.edit()


        val login = binding!!.loginButton
        login.setOnClickListener {
            val username = findViewById<View>(R.id.editTextTextPersonName) as EditText
            val password = findViewById<View>(R.id.editTextTextPassword) as EditText
            val builder = Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
            val data = Data.Builder()
            data.putString("username", username.text.toString())
            data.putString("password", password.text.toString())
            val loginWorkRequest = OneTimeWorkRequest.Builder(LoginWorker::class.java)
                    .addTag("Login")
                    .setInputData(data.build())
                    .setConstraints(builder.build())
                    .build()
            workManager.enqueue(loginWorkRequest)
            workManager.getWorkInfoByIdLiveData(loginWorkRequest.id).observe(this){ workInfo ->
                if(workInfo?.state == WorkInfo.State.SUCCEEDED) {
                    Log.d("Login Result","Succeeded");
                    Log.d("Login Result",workInfo?.state.toString());


                    editor.putString("current_username", username.toString());
                    editor.commit()

                    val intent = Intent(this, MainActivity::class.java);
                    startActivity(intent);



                }
                else if(workInfo?.state==WorkInfo.State.FAILED){
                    findViewById<View>(R.id.badregmsg).visibility=(View.GONE);
                    findViewById<View>(R.id.goodregmsg).visibility=(View.GONE);
                    findViewById<View>(R.id.badlogmsg).visibility=(View.VISIBLE);

                }
            }
        }
        val register = binding!!.registerButton
        register.setOnClickListener {
            val username = findViewById<View>(R.id.editTextTextPersonName) as EditText
            val password = findViewById<View>(R.id.editTextTextPassword) as EditText
            val builder = Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
            val data = Data.Builder()
            data.putString("username", username.text.toString())
            data.putString("password", password.text.toString())
            val regWorkRequest = OneTimeWorkRequest.Builder(RegisterWorker::class.java)
                    .addTag("Register")
                    .setInputData(data.build())
                    .setConstraints(builder.build())
                    .build()

            workManager.enqueue(regWorkRequest)
            workManager.getWorkInfoByIdLiveData(regWorkRequest.id).observe(this){ workInfo ->

                if(workInfo?.state == WorkInfo.State.SUCCEEDED) {
                    Log.d("Registration Result","Succeeded")
                    findViewById<View>(R.id.badlogmsg).visibility=(View.GONE);
                    findViewById<View>(R.id.badregmsg).visibility=(View.GONE);
                    findViewById<View>(R.id.goodregmsg).visibility=(View.VISIBLE);

                    //Log.d("Registration Result",workInfo?.state.toString());


                }
                else if(workInfo?.state==WorkInfo.State.FAILED){
                    findViewById<View>(R.id.badlogmsg).visibility=(View.GONE);
                    findViewById<View>(R.id.goodregmsg).visibility=(View.GONE);
                    findViewById<View>(R.id.badregmsg).visibility=(View.VISIBLE);

                }
            }
        }
    }
}
