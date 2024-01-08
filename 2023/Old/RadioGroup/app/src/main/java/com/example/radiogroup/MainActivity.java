package com.example.radiogroup;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        radioGroup = findViewById(R.id.pica);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> onCheckedChanged(group, checkedId));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //Toast.makeText(this, "Has picado", Toast.LENGTH_LONG).show();
        TextView t = findViewById(R.id.respuesta);
        if(R.id.boton1 ==checkedId){

        }else if((R.id.boton1 ==checkedId)){
            t.setText("FUEGO GANA SIEMPRE");
        }else if((R.id.boton2 ==checkedId)){
            t.setText("LO SIENTO");
        }else if((R.id.boton3 ==checkedId)){
            t.setText("FUMATE ESTA");
        }else{
            t.setText("Me molan las bufas");
        }

    }
}
