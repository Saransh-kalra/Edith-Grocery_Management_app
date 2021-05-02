package com.example.edith;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Calendar;

import androidx.fragment.app.Fragment;

public class add_ingredient extends Fragment {

    NumberPicker mNumberPicker;
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    public void onStart() {
        super.onStart();

        mDisplayDate = getView().findViewById(R.id.ExpiryDate);

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