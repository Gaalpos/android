package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements  AdapterView.OnItemSelectedListener{

    Spinner spinner;


     static ArrayList<String> pueblaSpinner(){
         ArrayList<String> lista = new ArrayList<>();
         lista.add("Valladares");
         lista.add("Beade");
         lista.add("Matama");
         return  lista;
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pueblaSpinner());
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });//spinner.setOnItemClickListener(gestionaClick);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = findViewById(R.id.seleccion);
        textView.setText(parent.getItemAtPosition(position) .toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




    /*
    private final AdapterView.OnItemClickListener gestionaClick(){
         public void onItemClick(AdapterView parent, view v, int position, long id)
    }
 */
}
