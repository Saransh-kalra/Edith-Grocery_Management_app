package com.example.notification;

//import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.app.FragmentManager;
import android.support.v4.app.INotificationSideChannel;
import androidx.core.app.NotificationCompat;
import androidx.appcompat.app.AppCompatActivity;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

//import android.app.TimePickerDialog;


public abstract class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Calendar now = Calendar.getInstance();
    TimePickerDialog  alertTime;
    DatePickerDialog dpd;
    EditText  eTitle, etContent;

    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button notificationButton = findViewById(R.id.notificationButton);
        eTitle = findViewById(R.id.eTitle);
        etContent = findViewById(R.id.etContent);

        Button cancelNotificationButton  = findViewById(R.id.cancelNotificationButton);

        dpd = DatePickerDialog.newInstance(
                MainActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        alertTime = TimePickerDialog.newInstance(
                MainActivity.this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                false
        );

        cancelNotificationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NotifyMe.cancel(getApplicationContext(), "test");
            }
        });

        notificationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                dpd.show(getSupportFragmentManager(), "Datepickerdialog");
            }
        };

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            now.set(Calendar.YEAR, year);
            now.set(Calendar.MONTH, month);
            now.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            alertTime.show(getSupportFragmentManager(), "TimePickerDialog");
        }
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        now.set(Calendar.HOUR_OF_DAY, hourOfDay);
        now.set(Calendar.MINUTE, minute);
        now.set(Calendar.SECOND, second);

        NotifyMe notifyMe = new NotifyMe.Builder(getApplicationContext())
                .title(eTitle.getText().toString())
                .content(etContent.getText().toString())
                .color(255,255,255,255)
                .led_color(255,255,255,255)
                .time(now)
                .addActoin(new Intent(), "Dismiss/Cancel", true, false)
                .addAction(new Intent(), "Item Finished")
                .large_icon(R.mipmap.ic_launcher_round)
                .build();
    }
}




  /*  private void alarmNotification() {
        Intent myIntent = new Intent(this, NotifyService.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        pendingIntent = PendingIntent.getService(this, 0, myIntent, 0);

        Calendar expiryDateCalendar = Calendar.getInstance();
        expiryDateCalendar.set(Calendar.HOUR, 0); // automatically set to midnight
        expiryDateCalendar.add(Calendar.DAY_OF_YEAR, 114);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, expiryDateCalendar.getTimeInMillis(), 1000 * 60 * 60 * 24, pendingIntent);
        Toast.makeText(MainActivity.this, "Set Expiry Notification", Toast.LENGTH_LONG).show();

    }
}*/



