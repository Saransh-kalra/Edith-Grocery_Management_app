package com.example.edith;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoHome(View view){

        Intent j = new Intent(this, HomeActivity.class);
        startActivity(j);

    }

    public void gotoSignUp(View view){

        Intent j = new Intent(this, SignUp.class);
        startActivity(j);

    }


}
