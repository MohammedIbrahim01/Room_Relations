package com.example.abdelazim.room_relations;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.abdelazim.room_relations.dao.PetDao;
import com.example.abdelazim.room_relations.dao.UserDao;
import com.example.abdelazim.room_relations.dao.UserWithPetsDao;
import com.example.abdelazim.room_relations.models.Pet;
import com.example.abdelazim.room_relations.models.User;

@Database(entities = {User.class, Pet.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String NAME_DATABASE = "room_relations_database";
    private static final Object LOCK = new Object();
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {

                sInstance = Room.databaseBuilder(context, AppDatabase.class, NAME_DATABASE)
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return sInstance;
    }

    public abstract PetDao petDao();

    public abstract UserDao userDao();

    public abstract UserWithPetsDao userWithPetsDao();
}
