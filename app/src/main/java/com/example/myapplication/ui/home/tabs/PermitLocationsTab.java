package com.example.myapplication.ui.home.tabs;

import com.example.myapplication.MainActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.databinding.FragmentPermitBinding;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class PermitLocationsTab extends Fragment {

    MapView mMapView;
    private GoogleMap mMap;
    private String userType;
    private String permitType;
    private LatLng agganis;
    private LatLng langsam;
    private LatLng buick;
    private LatLng cfa;
    private LatLng essex;
    private LatLng lowerbridge;
    private LatLng upperbridge;
    private LatLng cas;
    private LatLng warren;
    private LatLng fiveseventyfive;
    private LatLng rafik;
    private LatLng kenmore;
    private LatLng seventhirtysevenfifty;
    private LatLng sevensixtysix;
    private LatLng eightninety;
    private LatLng orange1;
    private LatLng orange2;
    private LatLng orange3;
    private LatLng orange4;
    private LatLng granby;
    MarkerOptions Agganis;
    MarkerOptions Langsam;
    MarkerOptions Buick;
    MarkerOptions CFA;
    MarkerOptions Essex;
    MarkerOptions LowerBridge;
    MarkerOptions UpperBridge;
    MarkerOptions CAS;
    MarkerOptions Warren;
    MarkerOptions FiveSeventyFive;
    MarkerOptions Rafik;
    MarkerOptions Kenmore;
    MarkerOptions SevenThirty_SevenFifty;
    MarkerOptions SevenSixtySix;
    MarkerOptions EightNinety;
    MarkerOptions Orange1;
    MarkerOptions Orange2;
    MarkerOptions Orange3;
    MarkerOptions Orange4;
    MarkerOptions Granby;
    LocalTime time;
    Calendar calendar;
    private FragmentPermitBinding binding;

    public static PermitLocationsTab newInstance() {
        PermitLocationsTab fragment = new PermitLocationsTab();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_permit, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        userType = "Student";
        permitType = "Orange";

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }


        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                // Time now
                //time = LocalTime.now();
                time = LocalTime.of(12,0);

                // Day of week
                calendar = Calendar.getInstance();
                int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);

                // move the camera to BU
                LatLng bu = new LatLng(42.351139402544476, -71.10977147739284);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bu,14.0f));

                // initializing locations of lots
                agganis = new LatLng(42.352355809859226, -71.11772127450622);
                langsam = new LatLng(42.35331905254574, -71.1228019601163);
                buick = new LatLng(42.35210382678141, -71.11502725640673);
                cfa = new LatLng(42.35153882813562, -71.1138312447708);
                essex = new LatLng(42.349960881193674, -71.11125763128003);
                lowerbridge = new LatLng(42.35165834340202, -71.1102084564067);
                upperbridge = new LatLng(42.35143293081643, -71.10983037360717);
                cas = new LatLng(42.350765458988604, -71.104642052697);
                warren = new LatLng(42.34939648328429, -71.10392795826158);
                fiveseventyfive = new LatLng(42.34957384140391, -71.09867751593434);
                rafik = new LatLng(42.349783603220565, -71.09967648895285);
                kenmore = new LatLng(42.349473070577055, -71.09761386778928);
                seventhirtysevenfifty = new LatLng(42.34986499037443, -71.106231908515);
                sevensixtysix = new LatLng(42.3501319315078, -71.10809568709799);
                eightninety = new LatLng(42.35077184298448, -71.11552617175231);
                orange1 = new LatLng(42.34774843721593, -71.1058815527099);
                orange2 = new LatLng(42.3479953595156, -71.10395584477165);
                orange3 = new LatLng(42.34788127817424, -71.10331807360758);
                orange4 = new LatLng(42.34880365168017, -71.10709471778706);
                granby = new LatLng(42.348908184482376, -71.09799848954573);


                // initializing markers
                Agganis = new MarkerOptions().position(agganis).title("Agganis Arena").snippet("Address: 925 Commonwealth Avenue \nentrance on Harry Agganis Way");
                Langsam = new MarkerOptions().position(langsam).title("Langsam Garage").snippet("Address: 142 Gardner Street");
                Buick = new MarkerOptions().position(buick).title("Buick Street Lot").snippet("Address: 25 Buick Street");
                CFA = new MarkerOptions().position(cfa).title("CFA Lot").snippet("Address: 855 Commonwealth Avenue \nentrance on Harry Agganis Way");
                Essex = new MarkerOptions().position(essex).title("Essex Street Garage & Lot").snippet("Address: 148 Essex Street");
                LowerBridge = new MarkerOptions().position(lowerbridge).title("Lower Bridge Lot").snippet("Address: 3 University Road");
                UpperBridge = new MarkerOptions().position(upperbridge).title("Upper Bridge Lot").snippet("Address: 1 University Road");
                CAS = new MarkerOptions().position(cas).title("CAS Lot").snippet("Address: 240 Bay State Road");
                Warren = new MarkerOptions().position(warren).title("Warren Towers Garage").snippet("Address: 700 Commonwealth Avenue \nentrance on Hinsdale Mall");
                FiveSeventyFive = new MarkerOptions().position(fiveseventyfive).title("575 Commonwealth Avenue");
                Rafik = new MarkerOptions().position(rafik).title("Rafik B. Hariri Building Garage").snippet("Address: 595 Commonwealth Avenue");
                Kenmore = new MarkerOptions().position(kenmore).title("Kenmore Lot").snippet("Address: 549 Commonwealth Avenue");
                SevenThirty_SevenFifty = new MarkerOptions().position(seventhirtysevenfifty).title("730/750 Commonwealth Avenue");
                SevenSixtySix = new MarkerOptions().position(sevensixtysix).title("766 Commonwealth Avenue");
                EightNinety = new MarkerOptions().position(eightninety).title("890 Commonwealth Avenue").snippet("entrance on Dummer Street");
                Orange1 = new MarkerOptions().position(orange1).title("Street Parking").snippet("Address: 29-47 Buswell Street \nSpaces: 22");
                Orange2 = new MarkerOptions().position(orange2).title("Street Parking").snippet("Address: 2 -22 Buswell Street \nSpaces: 17");
                Orange3 = new MarkerOptions().position(orange3).title("Street Parking").snippet("Address: 46 Mountfort Street \nSpaces: 3");
                Orange4 = new MarkerOptions().position(orange4).title("Street Parking").snippet("Address: 830-824 Mountfort Street \nSpaces: 9");
                Granby = new MarkerOptions().position(granby).title("Granby Lot").snippet("Address: 665 Commonwealth Avenue");

                displayMarkers(time, day_of_week);
            }
        });

        return rootView;
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

    public void displayMarkers(LocalTime time, int day_of_week){
        // display markers at currently valid lots based on permit, time & day

        if (userType == null){
            allMarkers();
        } else if (userType.equals("Student")){
            if (permitType.equals("Flex")){
                studentFlex(time, day_of_week);
            } else if (permitType.equals("Commuter")){
                studentCommuter(time, day_of_week);
            } else if (permitType.equals("Evening")){
                studentEvening(time, day_of_week);
            } else if (permitType.equals("Orange")){
                studentOrange();
            } else if (permitType.equals("Langsam")){
                studentLangsam();
            }
        } else if (userType.equals("Employee")){
            if (permitType.equals("Flex")){
                employeeFlex();
            } else if (permitType.equals("Commuter")){
                employeeCommuter();
            } else if (permitType.equals("Off-peak commuter")){
                employeeOffPeakCommuter(time, day_of_week);
            } else if (permitType.equals("Carpool")){
                employeeCarpool();
            }
        } else if (userType.equals("Guest")) {
            if (permitType.equals("Agganis Arena Event")) {
                guestAgganis();
            } else if (permitType.equals("Red Sox")) {
                guestRedSox();
            } else if (permitType.equals("Non-Event")) {
                guestNonEvent(time,day_of_week);
            }
        }
    }

    /* START OF HELPER FUNCTIONS TO DISPLAY MARKERS*/
    public void allMarkers(){
        List<MarkerOptions> allMarkers = Arrays.asList(Agganis,Langsam,Buick,CFA,Essex,LowerBridge,UpperBridge,CAS,Warren,FiveSeventyFive,Rafik,Kenmore,SevenThirty_SevenFifty,SevenSixtySix,EightNinety,Orange1,Orange2,Orange3,Orange4,Granby);
        for (MarkerOptions marker : allMarkers){
            mMap.addMarker(marker);
        }
    }
    public void employeeCommuter() {
        List<MarkerOptions> allMarkers = Arrays.asList(Agganis, Langsam, Buick, CFA, Essex, LowerBridge, UpperBridge, CAS, Warren, FiveSeventyFive, Rafik, Kenmore, SevenThirty_SevenFifty, SevenSixtySix, EightNinety);
        for (MarkerOptions marker : allMarkers) {
            mMap.addMarker(marker);
        }
    }
    public void employeeFlex() {
        List<MarkerOptions> allMarkers = Arrays.asList(Agganis,Langsam,Buick,CFA,Essex,LowerBridge,UpperBridge,CAS,Warren,FiveSeventyFive,Rafik,Kenmore,SevenThirty_SevenFifty,SevenSixtySix,EightNinety);
        for (MarkerOptions marker : allMarkers){
            mMap.addMarker(marker);
        }
    }
    public void employeeOffPeakCommuter(LocalTime time, int day){
        if (day > 5 || time.isAfter(LocalTime.of(2,30,0))){
            List<MarkerOptions> allMarkers = Arrays.asList(Agganis,Langsam,Buick,CFA,Essex,LowerBridge,UpperBridge,CAS,Warren,FiveSeventyFive,Rafik,Kenmore,SevenThirty_SevenFifty,SevenSixtySix,EightNinety);
            for (MarkerOptions marker : allMarkers) {
                mMap.addMarker(marker);
            }
        }
    }
    public void employeeCarpool(){
        List<MarkerOptions> allMarkers = Arrays.asList(Agganis,Langsam,Essex,CAS,Warren,Rafik);
        for (MarkerOptions marker : allMarkers) {
            mMap.addMarker(marker);
        }
    }
    public void studentFlex(LocalTime time, int day){
        if (day > 5 || time.isAfter(LocalTime.of(15,0,0))) {
            // weekends or after 3pm
            List<MarkerOptions> allMarkers = Arrays.asList(Agganis, Langsam, Essex, CAS, Warren, Rafik);
            for (MarkerOptions marker : allMarkers) {
                mMap.addMarker(marker);
            }
        } else {
            List<MarkerOptions> allMarkers = Arrays.asList(Agganis,Langsam,Essex);
            for (MarkerOptions marker : allMarkers){
                mMap.addMarker(marker);
            }
        }
    }
    public void studentCommuter(LocalTime time, int day){
        if (day > 5 || time.isAfter(LocalTime.of(15,0,0))) {
            // weekends or after 3pm
            List<MarkerOptions> allMarkers = Arrays.asList(Agganis,Langsam,Essex,CAS,Warren,Rafik,Buick,FiveSeventyFive,SevenThirty_SevenFifty,UpperBridge,LowerBridge,CFA);
            for (MarkerOptions marker : allMarkers) {
                mMap.addMarker(marker);
            }
        } else {
            List<MarkerOptions> allMarkers = Arrays.asList(Agganis,Langsam,Essex);
            for (MarkerOptions marker : allMarkers){
                mMap.addMarker(marker);
            }
        }


    }
    public void studentEvening(LocalTime time, int day){
        if (day > 5 || time.isAfter(LocalTime.of(15,0,0))) {
            // weekends or after 3pm
            List<MarkerOptions> allMarkers = Arrays.asList(Agganis,Langsam,Buick,CFA,Essex,LowerBridge,UpperBridge,CAS,Warren,FiveSeventyFive,Rafik,Kenmore,SevenThirty_SevenFifty,SevenSixtySix,EightNinety);
            for (MarkerOptions marker : allMarkers){
                mMap.addMarker(marker);
            }
        }
    }
    public void studentLangsam(){
        mMap.addMarker(Langsam);
    }
    public void studentOrange(){
        List<MarkerOptions> allMarkers = Arrays.asList(Orange1,Orange2,Orange3,Orange4);
        for (MarkerOptions marker : allMarkers){
            mMap.addMarker(marker);
        }
    }
    public void guestAgganis(){
        List<MarkerOptions> allMarkers = Arrays.asList(Agganis,Langsam,Buick,CFA,Essex);
        for (MarkerOptions marker : allMarkers){
            mMap.addMarker(marker);
        }
    }
    public void guestRedSox(){
        List<MarkerOptions> allMarkers = Arrays.asList(Warren,FiveSeventyFive,Rafik,Kenmore,SevenSixtySix,Granby);
        for (MarkerOptions marker : allMarkers){
            mMap.addMarker(marker);
        }
    }
    public void guestNonEvent(LocalTime time, int day_of_week){
        List<MarkerOptions> allMarkers = new ArrayList<>();
        if(time.isAfter(LocalTime.of(15,0)) || day_of_week == 6){
            Agganis.snippet("Address: 925 Commonwealth Avenue \nentrance on Harry Agganis Way \nPrice: $12 flat rate \nOpen to public");
            Langsam.snippet("Address: 142 Gardner Street \nPrice: $12 flat rate \nShort term overnight parking permitted \nOpen to public");
            Kenmore.snippet("Address: 549 Commonwealth Avenue \nPrice: $12 flat rate \nOpen to public");
        } else if (day_of_week == 7){
            Agganis.snippet("Address: 925 Commonwealth Avenue \nentrance on Harry Agganis Way\n Price: $25 max for over 3 hours \nOpen to public");
            Langsam.snippet("Address: 142 Gardner Street \nPrice:  \n Short term overnight parking permitted \nOpen to public");
            Kenmore.snippet("Address: 549 Commonwealth Avenue \nPrice: $12 flat rate \nOpen to public");
        } else {
            Agganis.snippet("Address: 925 Commonwealth Avenue \nentrance on Harry Agganis Way \nPrice: $25 max for over 3 hours \nOpen to public");
            Langsam.snippet("Address: 142 Gardner Street \nPrice:  \nShort term overnight parking permitted \nOpen to public");
            Kenmore.snippet("Address: 549 Commonwealth Avenue \nPrice: $13 per half hour, $17 max \nOpen to public");
        }


        if (time.isAfter(LocalTime.of(7,0))&& time.isBefore(LocalTime.of(23,0))) {
            Collections.addAll(allMarkers,Agganis,Langsam);
        }
        if (day_of_week <= 5 && time.isAfter(LocalTime.of(7,0))&& time.isBefore(LocalTime.of(23,0))) {
            Collections.addAll(allMarkers,Kenmore);
        }
        for (MarkerOptions marker : allMarkers) {
            mMap.addMarker(marker);
        }
    }
    /* END OF HELPER FUNCTIONS TO DISPLAY MARKERS*/
}