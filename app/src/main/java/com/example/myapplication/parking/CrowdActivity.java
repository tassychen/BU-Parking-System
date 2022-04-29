package com.example.myapplication.parking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityCrowdBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimeZone;

public class CrowdActivity extends AppCompatActivity {
    private RadioGroup crowdGroup;
    private RadioButton crowdButton;
    private String crowd;
    private DatabaseReference Database;
    private LocalTime time;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.myapplication.databinding.ActivityCrowdBinding binding = ActivityCrowdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        crowdGroup = findViewById(R.id.radioGroup);

        Database = FirebaseDatabase.getInstance().getReference();

        location = getIntent().getStringExtra("location");
        time = LocalTime.now();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("est"));
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(view -> {
            int selectedId = crowdGroup.getCheckedRadioButtonId();
            crowdButton = findViewById(selectedId);
            crowd = (String) crowdButton.getText();
            writeNewCrowd(location,time,dayOfWeek,crowd);
            Intent intent = new Intent(getApplicationContext(), VehicleParkedActivity.class);
            intent.putExtra("location", location);
            intent.putExtra("time", time);
            startActivity(intent);
        });
    }

    public void writeNewCrowd(String location, LocalTime time,Integer dayOfWeek, String crowd){
        Crowd crowdedness = new Crowd(location,time,dayOfWeek,crowd);
        Database.child("crowd").push().setValue(crowdedness);
    }

}