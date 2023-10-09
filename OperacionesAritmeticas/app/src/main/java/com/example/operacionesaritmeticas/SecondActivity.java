
package com.example.operacionesaritmeticas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    static TextView textView1;
    static TextView textView2;
    Button sumar;

    Integer resultado=0;

    public void mostrar(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView1=findViewById(R.id.num1);
        textView2=findViewById(R.id.num2);

        Bundle llegar = getIntent().getExtras();
        String texto1 = llegar.getString("num1");
        String texto2 = llegar.getString("num2");
        textView1.setText(texto1);
        textView2.setText(texto2);
    }

    public void sumar (View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.REQUEST_RESULT, String.valueOf(resultado));
        setResult(RESULT_OK,returnIntent);
        finish();

    }
}