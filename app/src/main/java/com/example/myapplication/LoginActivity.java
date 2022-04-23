package com.example.myapplication;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.myapplication.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());









        Button login = binding.loginButton;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username = (EditText) findViewById(R.id.editTextTextPersonName);
                EditText password = (EditText) findViewById(R.id.editTextTextPassword);

                Constraints.Builder builder = new Constraints.Builder()
                        .setRequiredNetworkType(NetworkType.CONNECTED);
                Data.Builder data = new Data.Builder();
                data.putString("username", username.getText().toString());
                data.putString("password", password.getText().toString());
                OneTimeWorkRequest testWorkRequest =
                        new OneTimeWorkRequest.Builder(LoginWorker.class)
                                .addTag("Login")
                                .setInputData(data.build())
                                .setConstraints(builder.build())
                                .build();
                WorkManager.getInstance(getApplicationContext()).enqueue(testWorkRequest);

                /*
                while(true) {
                    WorkManager instance = WorkManager.getInstance(getApplicationContext());
                    ListenableFuture<List<WorkInfo>> status = instance.getWorkInfosByTag("Login");
                    List<WorkInfo> workInfoList = null;

                    try {
                        workInfoList = status.get();
                    }
                    catch (Exception e) {
                        Log.d("Tag","Not Found");
                    }

                    WorkInfo first=workInfoList.get(0);
                    if(first.toString().equalsIgnoreCase("SUCCEEDED")) {
                        Log.d("Login Result","Succeeded");
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    }
                    else if(first.toString().equalsIgnoreCase("FAILED")) {
                        Log.d("Login Result","Failed");
                        break;
                    }
                    else if(first.toString().equalsIgnoreCase("RUNNING")) {
                        Log.d("Login Result","Running");
                    }

                }
                */




            }
        });
        Button register = binding.registerButton;
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username = (EditText) findViewById(R.id.editTextTextPersonName);
                EditText password = (EditText) findViewById(R.id.editTextTextPassword);

                Constraints.Builder builder = new Constraints.Builder()
                        .setRequiredNetworkType(NetworkType.CONNECTED);
                Data.Builder data = new Data.Builder();
                data.putString("username", username.getText().toString());
                data.putString("password", password.getText().toString());
                OneTimeWorkRequest regWorkRequest =
                        new OneTimeWorkRequest.Builder(RegisterWorker.class)
                                .addTag("Register")
                                .setInputData(data.build())
                                .setConstraints(builder.build())
                                .build();
                WorkManager.getInstance(getApplicationContext()).enqueue(regWorkRequest);
            }});}}

                /*
                while(true) {
                    WorkManager instance = WorkManager.getInstance(getApplicationContext());
                    ListenableFuture<List<WorkInfo>> status = instance.getWorkInfosByTag("Register");
                    List<WorkInfo> workInfoList = null;

                    try {
                        workInfoList = status.get();
                    }
                    catch (Exception e) {
                        Log.d("Tag","Not Found");
                    }

                    WorkInfo first=workInfoList.get(0);
                    if(first.toString().equalsIgnoreCase("SUCCEEDED")) {
                        Log.d("Registration Result","Succeeded");
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    }
                    else if(first.toString().equalsIgnoreCase("FAILED")) {
                        Log.d("Registration Result","Failed");
                        break;
                    }
                    else if(first.toString().equalsIgnoreCase("RUNNING")) {
                        Log.d("Registration Result","Running");
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }



                while(true){
                if(workInfo.State==WorkInfo.State.SUCCEEDED){

                }
                else if(WorkInfo.State==WorkInfo.State.FAILED){
                    Log.d("Registration", "Failed");
                });
            */




