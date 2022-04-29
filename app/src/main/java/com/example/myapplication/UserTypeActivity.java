package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication.parking.Crowd;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalTime;

public class UserTypeActivity extends AppCompatActivity {
    private RadioGroup userTypeGroup;
    private RadioButton userTypeButton;
    private Button submit;
    private DatabaseReference Database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
        userTypeGroup =(RadioGroup)findViewById(R.id.radioGroup);

        submit = (Button)findViewById(R.id.confirm);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = userTypeGroup.getCheckedRadioButtonId();
                userTypeButton = (RadioButton)findViewById(selectedId);
                String userType = (String)userTypeButton.getText();
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                writeNewUser(uid,userType);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void writeNewUser (String uid, String userType){
        Database = FirebaseDatabase.getInstance().getReference();
        Database.child("user").child(uid).child("usertype").setValue(userType);
        Database.child("user").child(uid).child("parked").setValue(false);
    }
}