package com.example.c026calendarpicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements CalendarView.OnDateChangeListener {

    CalendarView calendarView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendario);
        calendarView.setOnDateChangeListener((view, year, month, dayOffMOnth) -> onSelectedDayChange(view, year, month, dayOffMOnth));;
        button = findViewById(R.id.boton);
        button.setOnClickListener(v -> onClickListener());
    }
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        TextView textView = findViewById(R.id.fecha);
        month = month+1;
        String fecha = dayOfMonth+ " - "+month+" - "+year;
        textView.setText(fecha);
    }

    public void onClickListener(){
        EditText edittext = findViewById(R.id.data);
        String data = edittext.getText().toString();

        String parts[] = data.split("/");
        int day = Integer.parseInt(parts[2]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[0]);

        Calendar calendar= Calendar.getInstance();
        calendar.set(calendar.YEAR, year);
        calendar.set(calendar.MONTH, month-1);
        calendar.set(calendar.DAY_OF_MONTH, day);

        long milliTime = calendar.getTimeInMillis();
        calendarView.setDate(milliTime, true, true);

        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
       //calendarView.setDate();


    }
}