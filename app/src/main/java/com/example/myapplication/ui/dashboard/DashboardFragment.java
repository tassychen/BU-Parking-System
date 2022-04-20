package com.example.myapplication.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentDashboardBinding;
import com.example.myapplication.User;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    public User user;
    public String PermitName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button button = binding.button;

        dashboardViewModel.setPermit("Orange");

        final TextView permitName = binding.permitName;
        final TextView permitInfo = binding.permitInfo;
        final TextView permitLots = binding.permitLots;
        dashboardViewModel.getPermitName().observe(getViewLifecycleOwner(), permitName::setText);
        dashboardViewModel.getPermitInfo().observe(getViewLifecycleOwner(), permitInfo::setText);
        dashboardViewModel.getPermitLots().observe(getViewLifecycleOwner(), permitLots::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}