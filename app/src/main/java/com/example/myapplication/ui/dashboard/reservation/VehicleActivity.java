package com.example.myapplication.ui.dashboard.reservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Vehicle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VehicleActivity extends AppCompatActivity {

    Button Button;
    private DatabaseReference Database;
    private Boolean update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        update = getIntent().getBooleanExtra("update",false);

        EditText eColor = findViewById(R.id.color);
        EditText eMake = findViewById(R.id.make);
        EditText eModel = findViewById(R.id.model);
        EditText eNumber = findViewById(R.id.number);
        EditText eState = findViewById(R.id.state);
        Button = findViewById(R.id.submit);


        Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String color = eColor.getText().toString();
                String make = eMake.getText().toString();
                String model = eModel.getText().toString();
                String number = eNumber.getText().toString();
                String state = eState.getText().toString();
                Database = FirebaseDatabase.getInstance().getReference();
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                writeNewVehicle(uid,color,make,model,number,state);
                if (update) {
                    openMainActivity();
                } else {
                    openPaymentActivity();
                }

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void writeNewVehicle (String uid, String color, String make, String model, String number, String state){
        Database.child("user").child(uid).child("vehicle").child("color").setValue(color);
        Database.child("user").child(uid).child("vehicle").child("make").setValue(make);
        Database.child("user").child(uid).child("vehicle").child("model").setValue(model);
        Database.child("user").child(uid).child("vehicle").child("number").setValue(number);
        Database.child("user").child(uid).child("vehicle").child("state").setValue(state);
    }

    public void openPaymentActivity(){
        Intent intent = new Intent(this, CreditPaymentActivity.class);
        startActivity(intent);
    }
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}