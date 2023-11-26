package com.gaalpos.a010_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);

    }

    public void tipoAveriaClicked(View view) {
        CheckBox checkBox = (CheckBox) view;
        boolean checked = checkBox.isChecked();
        String tipo = "";
        if (view.getId() == R.id.checkBox) {
            tipo = "Chapa y pintura";
        }
        if (view.getId() == R.id.checkBox2) {
            tipo = "Cristal";
        }
        if (view.getId() == R.id.checkBox3) {
            tipo = "Motor";
        }

        Toast.makeText(this, tipo + " (" + checked + ")", Toast.LENGTH_LONG).show();
    }

    public void tipoAveriaClickedRadioButton(View view) {
        RadioButton radioButton = (RadioButton) view;
        boolean checked = radioButton.isChecked();
        String tipo = "";
        if (view.getId() == R.id.checkBox) {
            tipo = "Chapa y pintura";
        }
        if (view.getId() == R.id.checkBox2) {
            tipo = "Cristal";
        }
        if (view.getId() == R.id.checkBox3) {
            tipo = "Motor";
        }

        //Toast.makeText(this, tipo + " (" + checked + ")", Toast.LENGTH_LONG).show();
    }

    public void conocerOpcion(View view) {
        int id = radioGroup.getCheckedRadioButtonId();
        String tipo = "";
        if (id == R.id.chapa) {
            tipo = "Chapa y pintura";
        }
        if (id == R.id.cristal) {
            tipo = "Cristal";
        }
        if (id == R.id.motor) {
            tipo = "Motor";
        }
        Toast.makeText(this, "Has seleccionado: " + tipo, Toast.LENGTH_SHORT).show();
    }
}