package com.example.myapplication.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentNotificationsBinding;
import com.example.myapplication.parking.CheckInActivity;
import com.example.myapplication.ui.dashboard.reservation.VehicleActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView color = binding.color;
        final TextView number = binding.number;
        final TextView make = binding.make;
        final TextView model = binding.model;
        final TextView state = binding.state;
        notificationsViewModel.getColor().observe(getViewLifecycleOwner(), color::setText);
        notificationsViewModel.getNumber().observe(getViewLifecycleOwner(), number::setText);
        notificationsViewModel.getMake().observe(getViewLifecycleOwner(), make::setText);
        notificationsViewModel.getModel().observe(getViewLifecycleOwner(), model::setText);
        notificationsViewModel.getState().observe(getViewLifecycleOwner(), state::setText);

        Button update = binding.update;
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVehicleActivity();
            }
        });

        return root;
    }

    public void openVehicleActivity(){
        Intent intent = new Intent(getContext(), VehicleActivity.class);
        intent.putExtra("update", true);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}