package com.example.persistenciadatosprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(getIntent() != null && getIntent().hasExtra(Intent.EXTRA_TEXT)) {

            TextView textview = (TextView) findViewById(R.id.n1);
            TextView textview2 = (TextView) findViewById(R.id.n2);

            Intent intent = getIntent();
            String text = intent.getStringExtra(Intent.EXTRA_TEXT).toString();

            String[] numeros = text.split(",");
            textview.setText(numeros[0]+" ");
            textview2.setText(numeros[1]+" ");
        }
    }


    public void convertir(View view) {
        TextView textView1 = findViewById(R.id.n1);
        TextView textView2 = findViewById(R.id.n2);

        // 1 stones = 14 libras
        // si hay mas de 13.99 libras, contar una stone mas

        double stones = Double.parseDouble(textView1.getText().toString());
        double libras = Double.parseDouble(textView2.getText().toString());

        // 1 stones = 14 libras
        // si hay mas de 13.99 libras, contar una stone mas
        // 1 stone = 6.35 kg
        // 1 libra = 0.453 kg

        if (libras >= 14) {
            stones += libras / 14;
            libras = libras % 14;
        }

        double stonesEnKg = stones * 6.35;
        double librasEnKg = libras * 0.453;

        double resultado = stonesEnKg + librasEnKg;
        resultado = Math.round(resultado * 1000.0) / 1000.0;

        ((TextView) findViewById(R.id.resultado)).setText(String.valueOf(resultado));
    }

    public void volver(View view) {

        double n = Double.parseDouble(((TextView) findViewById(R.id.resultado)).getText().toString());
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.REQUEST_RESULT, n);
        setResult(RESULT_OK, returnIntent);
        finish();

    }
}