package com.example.recycledview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List <Datos> list = Datos.poblarDatos();
        /*
        list.add("Germany");
        list.add("Spain");
        list.add("Argentina");
        list.add("Portugal");
        list.add("Hungria");
        list.add("Japon");
        list.add("Bulgaria");
        list.add("Montenegro");
        list.add("Papua Nueva Guinea");
        */

       RecyclerView recyclerView = findViewById(R.id.reciclaje);
       recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        // para cargar la lista en cada elemento.xml
        MiAdaptador miAdaptador = new MiAdaptador(list);

        recyclerView.setAdapter(miAdaptador);

    }


}