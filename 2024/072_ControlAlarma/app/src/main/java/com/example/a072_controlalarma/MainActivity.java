package com.example.a072_controlalarma;

import static android.os.Build.VERSION_CODES.O;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Context mContexto = getApplicationContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAlarma(11, 15);
    }

    public void setAlarma(int hora, int minutos) {

        AlarmManager alarmMgr;
        PendingIntent alarmintent;
        /*configurar calendario*/
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hora);
        calendar.set(Calendar.MINUTE, minutos);
        /*Crear alarma*/
        Intent intent = new Intent(mContexto, Alarma.class);
        alarmintent = PendingIntent.getBroadcast(mContexto, O, intent,  PendingIntent.FLAG_IMMUTABLE);
        alarmMgr = (AlarmManager) mContexto.getSystemService(Context.ALARM_SERVICE);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmintent);
    }
}
