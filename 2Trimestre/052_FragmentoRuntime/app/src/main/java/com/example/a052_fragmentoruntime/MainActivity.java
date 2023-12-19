package com.example.a052_fragmentoruntime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    Button button;
View view;
    Fragmento1 miFragmento1;
    Fragmento2 miFragmento2;
    int shownInFragment = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creamos los fragmentos
        miFragmento1 = new Fragmento1();
        miFragmento2 = new Fragmento2();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contenedor, miFragmento1);
        fragmentTransaction.commit();
        shownInFragment = 1;
        button = findViewById(R.id.button);
        button.setOnClickListener( v -> cambiaFragmento(view));

    }

   public void cambiaFragmento(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (shownInFragment == 1) {
            fragmentTransaction.replace(R.id.contenedor, miFragmento2);
            fragmentTransaction.commit();
            shownInFragment = 2;
        } else {
            fragmentTransaction.replace(R.id.contenedor, miFragmento1);
            fragmentTransaction.commit();
            shownInFragment = 1;
        }
    }
}