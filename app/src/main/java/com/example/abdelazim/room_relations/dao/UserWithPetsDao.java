package com.example.abdelazim.room_relations.dao;

import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.example.abdelazim.room_relations.models.UserWithPets;

import java.util.List;

public interface UserWithPetsDao {

    @Query("SELECT * FROM User")
    @Transaction
    List<UserWithPets> loadUsersWithPets();
}
