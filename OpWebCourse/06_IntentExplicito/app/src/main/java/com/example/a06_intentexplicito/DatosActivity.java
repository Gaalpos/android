package com.example.a06_intentexplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Bundle extas = getIntent().getExtras();
        int year = extas.getInt("year");
        String user = extas.getString("user");
        Toast.makeText(this, "year: "+year +" User: "+user, Toast.LENGTH_SHORT).show();


        TextView yearView = findViewById(R.id.year);
        TextView userView = findViewById(R.id.user);

        yearView.setText("Year: " + year);
        userView.setText("User: " + user);

    }
}