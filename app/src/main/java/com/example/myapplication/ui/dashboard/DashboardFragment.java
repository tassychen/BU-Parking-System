package com.example.myapplication.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentDashboardBinding;
import com.example.myapplication.User;
import com.example.myapplication.ui.dashboard.reservation.CreditPaymentActivity;
import com.example.myapplication.ui.dashboard.reservation.EmployeeReservationActivity;
import com.example.myapplication.ui.dashboard.reservation.StudentReservationActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    public User user;
    public String PermitName;
    private DatabaseReference Database;
    private String userType;
    private String permit;
    private String userId;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Database = FirebaseDatabase.getInstance().getReference();
        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        Database.child("user").child(userId).child("usertype").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    if (task.getResult().exists()) {
                        userType = task.getResult().getValue().toString();
                    }
                }
            }
        });

        Database.child("user").child(userId).child("permit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    if (task.getResult().exists()) {
                        if (task.getResult().exists()){
                            permit = task.getResult().getValue().toString();
                            dashboardViewModel.setPermit(userType,permit);
                        }
                    }
                }
            }
        });

        Button button = binding.button;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database.child("user").child(userId).child("usertype").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                        }
                        else {
                            userType = task.getResult().getValue().toString();
                            Intent intent;
                            if (userType.equals("Student")){
                                intent = new Intent(getContext(), StudentReservationActivity.class);
                            } else {
                                intent = new Intent(getContext(), EmployeeReservationActivity.class);
                            }
                            startActivity(intent);
                        }
                    }
                });

            }
        });

        final TextView permitName = binding.permitName;
        final TextView permitInfo = binding.permitInfo;
        final TextView lot = binding.lot;
        final TextView permitLots = binding.permitLots;
        dashboardViewModel.getPermitName().observe(getViewLifecycleOwner(), permitName::setText);
        dashboardViewModel.getPermitInfo().observe(getViewLifecycleOwner(), permitInfo::setText);
        dashboardViewModel.getlot().observe(getViewLifecycleOwner(), lot::setText);
        dashboardViewModel.getPermitLots().observe(getViewLifecycleOwner(), permitLots::setText);
        return root;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}