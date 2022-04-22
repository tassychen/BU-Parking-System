package com.example.myapplication.parking;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityVehicleParkedBinding;

public class VehicleParkedActivity extends AppCompatActivity {

    private ActivityVehicleParkedBinding binding;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVehicleParkedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}