package com.example.myapplication.ui.home.tabs;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.User;
import com.example.myapplication.databinding.FragmentPermitBinding;
import com.example.myapplication.ui.dashboard.reservation.CreditPaymentActivity;
import com.example.myapplication.ui.home.HomeFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Map;

public class PermitLocationsTab extends Fragment {

    private MapView mMapView;
    private GoogleMap mMap;
    private LocalTime time;
    private Calendar calendar;
    private FragmentPermitBinding binding;
    private DatabaseReference Database;
    public String permit;
    public String usertype;
    String name;
    String address;
    Double latitude;
    Double longitude;

    public static PermitLocationsTab newInstance() {
        PermitLocationsTab fragment = new PermitLocationsTab();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Database = FirebaseDatabase.getInstance().getReference();
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        Database.child("user").child(uid).child("usertype").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    usertype = task.getResult().getValue().toString();
                }
            }
        });

        Database.child("user").child(uid).child("permit").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    if (task.getResult().getValue() != null){
                        permit = task.getResult().getValue().toString();
                        getPermitLocations(usertype,permit);
                    }
                }
            }
        });





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_permit, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        View zoomControls = rootView.findViewById(0x1);

        if (zoomControls != null && zoomControls.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            // ZoomControl is inside of RelativeLayout
            RelativeLayout.LayoutParams params_zoom = (RelativeLayout.LayoutParams) zoomControls.getLayoutParams();

            // Align it to - parent top|left
            params_zoom.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            params_zoom.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

            // Update margins, set to 10dp
            final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10,
                    getResources().getDisplayMetrics());
            params_zoom.setMargins(margin, margin, margin, margin);
        }

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }


        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                time = LocalTime.now();
                calendar = Calendar.getInstance();
                int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);

                // move the camera to BU
                LatLng bu = new LatLng(42.351139402544476, -71.10977147739284);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bu,14.0f));



            }
        });

        return rootView;
    }

    private void getPermitLocations(String userType, String permit){
        Database.child("permit").child(userType).child(permit).child("restriction").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    if (task.getResult().exists()){
                        getFixedLocations(userType,permit);
                    }
                }
            }
        });
        Database.child("permit").child(userType).child(permit).child("locations").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Map<String,Object> locations = (Map<String, Object>) task.getResult().getValue();
                    for (Map.Entry<String,Object> entry: locations.entrySet()) {
                        addMarker(entry.getKey());
                    }

                }
            }
        });
    }

    private void getFixedLocations(String userType,String permit) {
        Database.child("permit").child(userType).child(permit).child("fixedlocations").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Map<String,Object> locations = (Map<String, Object>) task.getResult().getValue();
                    for (Map.Entry<String,Object> entry: locations.entrySet()) {
                        addMarker(entry.getKey());
                    }
                }
            }
        });
    }


    private void addMarker(String location){
        Database.child("location").child(location).child("name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    name = task.getResult().getValue().toString();
                }
            }
        });
        Database.child("location").child(location).child("address").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    if (task.getResult().exists()) {
                        address = task.getResult().getValue().toString();
                    }
                }
            }
        });
        Database.child("location").child(location).child("latitude").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    latitude = (Double) task.getResult().getValue();
                }
            }
        });
        Database.child("location").child(location).child("longitude").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    longitude = (Double) task.getResult().getValue();
                    mMap.addMarker(new MarkerOptions().position(new LatLng(latitude,longitude)).title(name).snippet("Address:" + address));
                }
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}