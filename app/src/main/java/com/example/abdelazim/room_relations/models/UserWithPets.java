package com.example.abdelazim.room_relations.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

// Note: No annotation required for this class
public class UserWithPets {

    @Embedded
    public User user;

    @Relation(parentColumn = "id", entityColumn = "useId", entity = Pet.class)
    public List<Pet> pets; // or use simply 'List pets;'


   /* Alternatively you can use projection to fetch a specific column (i.e. only name of the pets) from related Pet table. You can uncomment and try below;

   @Relation(parentColumn = "id", entityColumn = "userId", entity = Pet.class, projection = "name")
   public List<String> pets;
   */
}
