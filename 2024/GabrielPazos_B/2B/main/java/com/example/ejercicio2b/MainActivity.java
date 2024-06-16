package com.example.ejercicio2b;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button abrir, guardar;
    TextView textViewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abrir = findViewById(R.id.abrirArchivo);
        guardar = findViewById(R.id.save);
        textViewContent = findViewById(R.id.textViewContent);

        abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirArchivo();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });
    }

    private void abrirArchivo() {
        try {
            Resources res = getResources();
            InputStream inputStream = res.openRawResource(R.raw.archivo);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            textViewContent.setText(stringBuilder.toString());
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardar() {
        String content = textViewContent.getText().toString();
        File documentsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(documentsDir, "nuevo-archivo.txt");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
            showToast("Archivo guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            showToast("Error al guardar el archivo.");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}