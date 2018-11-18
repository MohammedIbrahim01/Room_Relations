package com.example.abdelazim.room_relations.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.abdelazim.room_relations.models.Pet;

import java.util.List;

@Dao
public interface PetDao {

    @Query("SELECT * FROM pet")
    List<Pet> getAllPets();

    @Insert
    void insert(Pet pet);
}
