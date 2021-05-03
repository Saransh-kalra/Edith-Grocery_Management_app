package com.example.edith;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import androidx.fragment.app.Fragment;

public class add_ingredient extends Fragment {

    NumberPicker mNumberPicker;
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    String DatePicked;
    Date date1;
    EditText ingredient_name;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    Button addIngredients;

    @Override
    public void onStart() {
        super.onStart();

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        mDisplayDate = getView().findViewById(R.id.ExpiryDate);
        ingredient_name = getView().findViewById(R.id.ingredient_name);
        addIngredients = getView().findViewById(R.id.addIngredient);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        getActivity(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        addIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference arrayRef = mDatabase.child("Users").child(mAuth.getCurrentUser().getUid()).child("ingredients").push();
                String key = arrayRef.getKey();
                Map<String, Object> map = new HashMap<>();
                map.put(key, new Ingredient(ingredient_name.getText().toString(),mNumberPicker.getValue(),date1));
                arrayRef.updateChildren(map);


                Intent i = new Intent(add_ingredient.this.getActivity(), NavDrawerHomeActivity.class);
                startActivity(i);
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                DatePicked = i + "/" + i1 + "/" + i2;
                date1 = new SimpleDateFormat("MM/dd/yyyy").parse(DatePicked, new ParsePosition(0));
            }
        };

        int minValue = 1;
        int maxValue = 10;
        int step = 1;

        String[] numberValues = new String[maxValue/minValue];

        for (int i = minValue; i <= maxValue; i+= step)
        {
            numberValues[(i/step)-1] = String.valueOf(i);
        }

        mNumberPicker = getView().findViewById(R.id.number_picker);

        mNumberPicker.setMinValue(1);
        mNumberPicker.setMaxValue(10);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_add_ingredient, container, false);
    }

}