package com.example.myapplication.parking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;


import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityCheckInBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CheckInActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private ActivityCheckInBinding binding;
    private String location;
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
    private String[] locations = {"Agganis Arena", "Buick Street Lot", "CAS Lot", "CFA Lot", "Essex Street Garage & Lot", "Granby Lot", "Kenmore Lot", "Langsam Garage",
            "Lower Bridge Lot", "Rafik B. Hariri Building Garage", "Upper Bridge Lot", "Warren Towers Garage","2 - 22 Buswell Street", "29 - 47 Buswell Street",
            "46 Mountfort Street", "575 Commonwealth Avenue", "730/750 Commonwealth Avenue", "766 Commonwealth Avenue", "830-824 Mountfort Street","890 Commonwealth Avenue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCheckInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                location = (String) parentView.getItemAtPosition(position);
                addMarker(location);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        Button button = binding.park;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CrowdActivity.class);
                //intent.putExtra("location", location);
                startActivity(intent);
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);

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
    }

    public void addMarker(String location) {
        mMap.clear();

        switch (location){
            case "Agganis Arena": mMap.addMarker(Agganis).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(agganis,16.0f));
                break;
            case "Buick Street Lot": mMap.addMarker(Buick).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(buick,16.0f));
                break;
            case "CAS Lot": mMap.addMarker(CAS).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cas,16.0f));
                break;
            case "CFA Lot": mMap.addMarker(CFA).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cfa,16.0f));
                break;
            case "Essex Street Garage & Lot": mMap.addMarker(Essex).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(essex,16.0f));
                break;
            case "Granby Lot": mMap.addMarker(Granby).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(granby,16.0f));
                break;
            case "Kenmore Lot": mMap.addMarker(Kenmore).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(kenmore,16.0f));
                break;
            case "Langsam Garage": mMap.addMarker(Langsam).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(langsam,16.0f));
                break;
            case "Lower Bridge Lot": mMap.addMarker(LowerBridge).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lowerbridge,16.0f));
                break;
            case "Rafik B. Hariri Building Garage": mMap.addMarker(Rafik).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(rafik,16.0f));
                break;
            case "Upper Bridge Lot": mMap.addMarker(UpperBridge).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(upperbridge,16.0f));
                break;
            case "Warren Towers Garage": mMap.addMarker(Warren).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(warren,16.0f));
                break;
            case "2 -22 Buswell Street": mMap.addMarker(Orange2).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(orange2,16.0f));
                break;
            case "29 -47 Buswell Street": mMap.addMarker(Orange1).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(orange1,16.0f));
                break;
            case "46 Mountfort Street": mMap.addMarker(Orange3).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(orange3,16.0f));
                break;
            case "575 Commonwealth Avenue": mMap.addMarker(FiveSeventyFive).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(fiveseventyfive,16.0f));
                break;
            case "730/750 Commonwealth Avenue": mMap.addMarker(SevenThirty_SevenFifty).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(seventhirtysevenfifty,16.0f));
                break;
            case "766 Commonwealth Avenue": mMap.addMarker(SevenSixtySix).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sevensixtysix,16.0f));
                break;
            case "830-824 Mountfort Street": mMap.addMarker(Orange4).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(orange4,16.0f));
                break;
            case "890 Commonwealth Avenue": mMap.addMarker(EightNinety).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(eightninety,16.0f));
                break;
        }


    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // move the camera to BU
        LatLng bu = new LatLng(42.351139402544476, -71.10977147739284);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bu,14.0f));
    }
}



