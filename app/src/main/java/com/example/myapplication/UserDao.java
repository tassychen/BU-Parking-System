package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface UserDao {
    @Query("SELECT * FROM Account")
    List<Account> getAll();

    @Query("SELECT username FROM Account")
    List<String> getAllUsernames();

    @Query("SELECT * FROM Account WHERE username LIKE :name LIMIT 1")
    Account findByName(String name);

    @Query("SELECT * FROM Account WHERE username LIKE :name and password like :password LIMIT 1")
     Account login(String name, String password);

    @Query("UPDATE Account set make=:make,model=:model,color=:color,number=:number,state=:state WHERE username LIKE :name")
    void updateVehicleReg(String name,String make,String model,String color,String number,String state);

    @Insert
    void insertAll(Account... accounts);

    @Delete
    void delete(Account account);
}
