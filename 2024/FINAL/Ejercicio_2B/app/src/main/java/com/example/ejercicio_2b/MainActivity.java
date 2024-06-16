package com.example.ejercicio_2b;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView textViewMostarTexto;
    Button botonCargar, botonGuardar;

    private final String[] PERMISSIONS_STORAGE = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private final String RUTA_SD ="Documents/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewMostarTexto = findViewById(R.id.tv_display);

        botonCargar = findViewById(R.id.btn_volcado);
        botonGuardar = findViewById(R.id.btn_guardar);

        botonCargar.setOnClickListener(v-> cargar());
        botonGuardar.setOnClickListener(v-> guardar());
    }

    private String getText(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String newLine = null;
                while ((newLine = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(newLine+"\n");
                }
                inputStream.close();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    public void writeFile(String texto) {
        String nombreArchivo = "mi_fichero_externo";

        nombreArchivo= RUTA_SD+nombreArchivo+".txt";
        if (isExternalStorageWritable()) {
            checkStoragePermission();
            try {
                File textFile = new File(Environment.getExternalStorageDirectory(), nombreArchivo);
                FileOutputStream fileOutputStream = new FileOutputStream(textFile);
                fileOutputStream.write(texto.getBytes());
                fileOutputStream.close();
                Toast.makeText(this, "Escrito correctamente en fichero externo", Toast.LENGTH_LONG).show();
            } catch (java.io.IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Error escribiendo fichero", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "No se puede escribir en Almacenamiento Externo", Toast.LENGTH_LONG).show();
        }
    }
    public void checkStoragePermission() {
        int permission = ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE,101);
        }
    }
    public boolean isExternalStorageWritable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return true;
        }
        return false;
    }
    private void cargar() {
        String texto = getText(this.getResources().openRawResource(R.raw.mi_fichero_raw));
        textViewMostarTexto.setText(texto);
    }
    private void guardar() {
        String texto = textViewMostarTexto.getText().toString();
        writeFile(texto);

    }


}