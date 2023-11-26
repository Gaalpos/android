package com.example.a027timeclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextClock textClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textClock = findViewById(R.id.reloj);
        textClock.setOnClickListener(v -> pillarHora());
        Button button = findViewById(R.id.boton);
        button.setOnClickListener(view -> tokecito());

    }

    public void pillarHora(){
        TextView textView = findViewById(R.id.hora);
        textView.setText(textClock.getText().toString());

    }

    public void tokecito(){
        EditText editText = findViewById(R.id.ponHora);
        String pon = editText.getText().toString();
        //Toast.makeText(this, "VER FORMATO DE HORA"+pon, Toast.LENGTH_LONG).show();
        textClock.setText(pon);
    }
}