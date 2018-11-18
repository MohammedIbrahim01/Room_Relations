package com.example.abdelazim.room_relations.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.abdelazim.room_relations.models.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    List<User> getAllUsers();

    @Insert
    long insert(User user);
}
