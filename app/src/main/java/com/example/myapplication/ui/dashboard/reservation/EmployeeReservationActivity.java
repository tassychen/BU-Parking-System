package com.example.myapplication.ui.dashboard.reservation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EmployeeReservationActivity extends AppCompatActivity {
    private RadioGroup permitTypeGroup;
    private RadioButton permitTypeButton;
    private Button submit;
    private String Permit;
    private DatabaseReference Database;
    private Boolean vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_reservation);
        permitTypeGroup =(RadioGroup)findViewById(R.id.radioGroup);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Database = FirebaseDatabase.getInstance().getReference();
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        submit = (Button)findViewById(R.id.confirm);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = permitTypeGroup.getCheckedRadioButtonId();
                permitTypeButton = (RadioButton)findViewById(selectedId);
                Permit = (String) permitTypeButton.getText();
                writePermit(userId,Permit);

                Database.child("user").child(userId).child("vehicle").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                        }
                        else {
                            vehicle = task.getResult().exists();
                            if (vehicle) {
                                openPaymentActivity();
                            } else {
                                openVehicleActivity();
                            }
                        }
                    }
                });


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
    public void openPaymentActivity(){
        // Show user type selection screen
        Intent intent = new Intent(this, CreditPaymentActivity.class);
        intent.putExtra("permit", Permit);
        startActivity(intent);
    }

    public void openVehicleActivity(){
        Intent intent = new Intent(this, VehicleActivity.class);
        intent.putExtra("permit", Permit);
        intent.putExtra("update", false);
        startActivity(intent);
    }

    public void writePermit(String uid, String permit){
        Database.child("user").child(uid).child("permit").setValue(permit);
    }
}