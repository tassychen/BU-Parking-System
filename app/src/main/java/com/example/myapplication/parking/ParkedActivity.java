package com.example.myapplication.parking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.ActivityParkedBinding;
import com.example.myapplication.User;

public class ParkedActivity extends AppCompatActivity {

    private ActivityParkedBinding binding;
    public User user;
    public String PermitName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParkedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}