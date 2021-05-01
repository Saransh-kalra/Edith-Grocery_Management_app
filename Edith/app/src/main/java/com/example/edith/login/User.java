package com.example.edith.login;

public class User {

    public String email, dietary_preference, profile_pic;

    public User(String email, String dietary_preference) {
        this.email = email;
        this.dietary_preference = dietary_preference;
        this.profile_pic = "https://firebasestorage.googleapis.com/v0/b/edith-f8054.appspot.com/o/default%2Fprofile_logo.png?alt=media&token=7fe1c086-db34-403d-a7c7-1a9fc8d6f83f";
    }

    public User(String email, String dietary_preference, String profile_pic) {
        this.email = email;
        this.dietary_preference = dietary_preference;
        this.profile_pic = profile_pic;
    }

}
