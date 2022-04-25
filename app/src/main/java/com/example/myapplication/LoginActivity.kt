package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import com.example.myapplication.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private var binding: ActivityLoginBinding? = null
    private val workManager=WorkManager.getInstance(application)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val login = binding!!.loginButton
        login.setOnClickListener {
            val username = findViewById<View>(R.id.editTextTextPersonName) as EditText
            val password = findViewById<View>(R.id.editTextTextPassword) as EditText
            val builder = Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
            val data = Data.Builder()
            data.putString("username", username.text.toString())
            data.putString("password", password.text.toString())
            val testWorkRequest = OneTimeWorkRequest.Builder(LoginWorker::class.java)
                    .addTag("Login")
                    .setInputData(data.build())
                    .setConstraints(builder.build())
                    .build()
            workManager.enqueue(testWorkRequest)
            workManager.getWorkInfosByTagLiveData("Login").observe(this){ workInfos ->
                //Log.d("Workstatus",workInfo[0].state.toString());
                val workInfo=workInfos[0]
                if(workInfo?.state == WorkInfo.State.SUCCEEDED) {
                    Log.d("Login Result","Succeeded");
                    val intent = Intent(this, MainActivity::class.java);
                    startActivity(intent);

                }
                else if(workInfo?.state==WorkInfo.State.FAILED){
                    var failmsg="Bad Login";
                    val mySnackbar = Snackbar.make(findViewById(R.id.editTextTextPassword), failmsg, 3)
                    mySnackbar.show()
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
            WorkManager.getInstance(applicationContext).enqueue(regWorkRequest)
            Thread.sleep(1_000)
            Log.d("Status of Registration",(WorkManager.getInstance(applicationContext).getWorkInfosByTag("Login").toString()));

        }
    }
}
