package com.example.a001_helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView2);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Has hecho click", Toast.LENGTH_SHORT).show();
    }
//    public void initSecActivity(View view) {
//        Toast.makeText(this, "Has hecho click", Toast.LENGTH_SHORT).show();
//
//    }

    /*
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG ciclo vida", "Ciclovida: onStart");
        i++;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG ciclo vida", "Ciclovida: onResume");
        i++;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG ciclo vida", "Ciclovida: onPause");
        i++;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG ciclo vida", "Ciclovida: onStop");
        i--;
    }
    */


}