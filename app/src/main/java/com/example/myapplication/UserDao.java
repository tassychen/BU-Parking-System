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

    @Query("SELECT * FROM Account WHERE uid IN (:userIds)")
    List<Account> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Account WHERE username LIKE :name LIMIT 1")
    Account findByName(String name);

    @Query("SELECT * FROM Account WHERE username LIKE :name and password like :password LIMIT 1")
     Account login(String name, String password);

    @Insert
    void insertAll(Account... accounts);

    @Delete
    void delete(Account account);
}
