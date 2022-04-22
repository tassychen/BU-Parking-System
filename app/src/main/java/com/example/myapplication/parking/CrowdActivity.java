package com.example.myapplication.parking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class CrowdActivity extends AppCompatActivity {
    private RadioGroup crowdGroup;
    private RadioButton crowdButton;
    private Button submit;
    private ActivityCrowdBinding binding;
    private String crowd;
    private DatabaseReference Database;
    private LocalTime time;
    private Calendar calendar;
    private String location;
    private Integer entryNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCrowdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        crowdGroup =(RadioGroup)findViewById(R.id.radioGroup);

        Database = FirebaseDatabase.getInstance().getReference();

        location = getIntent().getStringExtra("location");
        time = LocalTime.now();
        calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = crowdGroup.getCheckedRadioButtonId();
                crowdButton = (RadioButton)findViewById(selectedId);
                crowd = (String) crowdButton.getText();
                writeNewCrowd(entryNumber,location,time,dayOfWeek,crowd);
                Intent intent = new Intent(getApplicationContext(), VehicleParkedActivity.class);
                intent.putExtra("location", location);
                intent.putExtra("time", time);
                startActivity(intent);
            }
        });
    }

    public void writeNewCrowd(Integer entryNumber, String location, LocalTime time,Integer dayOfWeek, String crowd){
        Crowd crowdedness = new Crowd(location,time,dayOfWeek,crowd);
        Database.child("crowd").push().setValue(crowdedness);
    }

}