package com.example.a06_intentexplicito;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inciciarActivity(View view) {

        Intent intentDatos = new Intent(this, DatosActivity.class);
        intentDatos.putExtra("year",2001);
        intentDatos.putExtra("user","Gaalpos");

        startActivity(intentDatos);

    }
}