package com.example.abdelazim.room_relations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.abdelazim.room_relations.models.Pet;
import com.example.abdelazim.room_relations.models.User;
import com.example.abdelazim.room_relations.models.UserWithPets;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        database = AppDatabase.getInstance(getApplicationContext());

//        insertData();

        List<User> userList = database.userDao().getAllUsers();
        List<Pet> petList = database.petDao().getAllPets();
        List<UserWithPets> userWithPetsList = database.userWithPetsDao().loadUsersWithPets();

        Log.d("WWW", "users: ");
        for (int i = 0; i < userList.size(); i++) {

            Log.d("WWW", "user name: " + userList.get(i).getName() + " user id: " + userList.get(i).getId());
        }
        Log.d("WWW", "******");
        Log.d("WWW", "pets: ");
        for (int i = 0; i < petList.size(); i++) {

            Log.d("WWW", "user id: " + petList.get(i).getUserId() + " pet name: " + petList.get(i).getName() + " pet id: " + petList.get(i).getId());
        }
        Log.d("WWW", "******");
        Log.d("WWW", "users with pets: ");
        for (int i = 0; i < userWithPetsList.size(); i++) {

            UserWithPets currentUserWithPets = userWithPetsList.get(i);
            Log.d("WWW", "user name: " + currentUserWithPets.user.getName() + " user id: " + currentUserWithPets.user.getId());

            for (int j = 0; j < currentUserWithPets.pets.size(); j++) {

                Pet currentPet = currentUserWithPets.pets.get(j);
                Log.d("WWW", "user id: " + currentPet.getUserId() + " pet name: " + currentPet.getName() + " pet id: " + currentPet.getId());
            }
            Log.d("WWW", "**");
        }
    }

    private void insertData() {

        long userId = database.userDao().insert(new User("mohamed"));
        database.petDao().insert(new Pet(userId, "a"));
        database.petDao().insert(new Pet(userId, "b"));
        database.petDao().insert(new Pet(userId, "c"));

        long userId2 = database.userDao().insert(new User("ahmed"));
        database.petDao().insert(new Pet(userId2, "h"));
        database.petDao().insert(new Pet(userId2, "j"));
        database.petDao().insert(new Pet(userId2, "k"));
    }
}
