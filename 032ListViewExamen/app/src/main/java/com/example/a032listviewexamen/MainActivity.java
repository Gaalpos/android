package com.example.a032listviewexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;

    ArrayList<Equipo> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ArrayList<Equipo>) Equipo.createTeam();
        //preparamos objetos a cargar
        ArrayList<Equipo> elementos = crearTeam();
        SpinnerAdapter adaptador = new Adapter(this,0,elementos);

        Spinner sp = findViewById(R.id.spinner);

        //creamos un adaptador, indicando el contexto, tiramos de un elemento prefabricado del sistema y cargamos de nuestro array de elementos
        sp.setAdapter(adaptador);
        sp.setSelection(0,false);

        //preparando un listener
        sp.setOnItemSelectedListener(this);
    }


    public ArrayList<Equipo> crearTeam(){
        ArrayList<Equipo> clubs = new ArrayList<>();
        Equipo club1 = new Equipo(R.drawable.Baskonia , "Barcelona Handball", "Barcelona", "España", "1942");
        clubs.add(club1);
        Equipo club2 = new Equipo(R.drawable.Crvena , "Montpellier Handball", "Montpellier", "Francia", "1982");
        clubs.add(club2);
        Equipo club3 = new Equipo(R.drawable.Maccabi , "Telekom Veszprém", "Veszprem", "Hungria", "1977");
        clubs.add(club3);
        Equipo club4 = new Equipo(R.drawable.Panathinaikos , "THW Kiel", "Kiel", "Alemania", "1904");
        clubs.add(club4);
        Equipo club5 = new Equipo(R.drawable.Zalgiris, "KS Vive Handball", "Kielce", "Polonia", "1965");
        clubs.add(club5);
        return clubs;
    }


/*
    //@Override
    public void onItemSelected(AdapterView<?> adapterView, View view , int i , long l){
        //su codigo aquí
        ImageView imageView = findViewById(R.id.logo);
        TextView textView = findViewById(R.id.equipo);
        //pillamos el team en la posicion 1
        Equipo club = (Equipo) adapterView.getItemAtPosition(i);

        //con los getters aporpiaos seteamos el nombre y el logo
        textView.setText(club.getNombre().toString());
        imageView.setImageResource(club.getImagen());
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        TextView textView = findViewById(R.id.equipo);
        textView.setText("No Seleccionado");
    }

*/
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}