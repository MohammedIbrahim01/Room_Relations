package com.example.abdelazim.room_relations.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Pet {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public long userId; // Relational field
    public String name;

    @Ignore
    public Pet(long userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Pet(int id, long userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
