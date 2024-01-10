package com.example.a056_almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String NAME = "NAME";
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = (TextView)findViewById(R.id.textView2);
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String name = sharedPreferences.getString(NAME,null);
        if (name==null) {
            textView.setText("HOLA PIROLA");
        } else {
            textView.setText("Welcome back manolin  " + name + "!");
        }
        editTextName = findViewById(R.id.escribir);

        //lsitener para el boton
        Button button = findViewById(R.id.guardar);
        button.setOnClickListener((view -> saveName(view)));

    }

    private void saveName(View view) {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString(NAME,editTextName.getText().toString());
        editor.commit();
    }
}