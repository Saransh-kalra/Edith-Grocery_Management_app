package com.example.edith.login;

import com.example.edith.Ingredient;

import java.util.ArrayList;

public class User {

    public String email, dietary_preference, profile_pic;
    public ArrayList<Ingredient> ingredients;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String email, String dietary_preference, String profile_pic) {
        this.email = email;
        this.dietary_preference = dietary_preference;
        this.profile_pic = profile_pic;
        this.ingredients = new ArrayList<Ingredient>();
    }

}
