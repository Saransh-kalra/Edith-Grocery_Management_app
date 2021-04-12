package com.example.edith.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.edith.NavDrawerHomeActivity;
import com.example.edith.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    EditText Email, Password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //MainOnCreate
        FirebaseApp.initializeApp(this);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

    }

    public void registeruser(View view){

        String email = Email.getText().toString();
        String password = Password.getText().toString();
        System.out.println("Email --" + email +"Paswd--" + password);
        mAuth.createUserWithEmailAndPassword(email,password);

        Intent i = new Intent(this, NavDrawerHomeActivity.class);
        startActivity(i);


    }

}
