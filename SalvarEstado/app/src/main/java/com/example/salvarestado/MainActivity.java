package com.example.salvarestado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String KEY_COUNTER = "CONTADOR";
    private int mContador =0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void contador(View View){
        mContador++;
        TextView textView = findViewById(R.id.resultado);
        textView.setText("contador: " + Integer.toString(mContador));
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, mContador);
    }
    //metodo para gaurdar valores
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        mContador = savedInstanceState.getInt(KEY_COUNTER);
        TextView textView= findViewById(R.id.resultado);
        textView.setText("contador: " + Integer.toString(mContador));
    }
}