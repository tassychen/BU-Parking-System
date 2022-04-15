package com.example.myapplication.database;

import androidx.room.Dao;
import androidx.room.Query;

import com.google.type.LatLng;

import java.util.List;

@Dao
public interface LocationDao {
    @Query("SELECT * FROM location")
    List<Location> getAll();

    @Query("SELECT * FROM location WHERE name IN (:names)")
    List<Location> loadAllByName(String[] names);

    @Query("SELECT latitude,longitude FROM location WHERE name IN (:names)")
    List<LatLngTuple> getLatLngByName (String[] names);

    public class LatLngTuple{
        public Float latitude;
        public Float longitude;

        public Float getLatitude() {
            return latitude;
        }

        public Float getLongitude() {
            return longitude;
        }
    }

    @Query("SELECT address FROM location WHERE name IN (:names)")
    List<String> getAddressByName (String[] names);

}
