package com.example.myapplication.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PermitDao {
    @Query("SELECT * FROM permit")
    List<Location> getAll();

    @Query("SELECT * FROM permit WHERE permitID IN (:permitIDs)")
    List<Location> loadAllByID(String[] permitIDs);

}
