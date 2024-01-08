package com.example.inflandolayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botonLeft;
    Button botonRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonLeft = findViewById(R.id.botonIzquierdo);
        botonLeft.setOnClickListener(view -> clickIzquierdo(view));

    }

    public void clickIzquierdo(View view){
        setContentView(R.layout.activity_main_2);
        botonRight   = findViewById(R.id.botonDerecho);
        botonRight.setOnClickListener(v -> clickDerecho(view));

    }

    public void clickDerecho(View view){
        setContentView(R.layout.activity_main);
        botonLeft = findViewById(R.id.botonIzquierdo);
        botonLeft.setOnClickListener(v -> clickIzquierdo(view));
    }
}