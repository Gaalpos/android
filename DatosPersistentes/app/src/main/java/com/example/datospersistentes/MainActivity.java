package com.example.datospersistentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String KEY_COUNTER = "CONTADOR";
    private int mContador =0;
    static  final String KEY_NAME = "NOMBRE";
    TextView textView;
    EditText editText;
    String texto="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // codigo para recuperar un valuor de un fichero de preferencias
     //  SharedPreferences settings = getPreferences(MODE_PRIVATE);
        SharedPreferences mias = getSharedPreferences("MIFICHERO", MODE_PRIVATE);
        int defaultConter = 0;
        mContador = mias.getInt(KEY_COUNTER, defaultConter);
        String defaultText="";
        texto = mias.getString(KEY_NAME, defaultText);
        editText = findViewById(R.id.caja);
        editText.setText(texto);
        textView = findViewById(R.id.resultado);
        textView.setText("Contaodr: "+ Integer.toString(mContador));
    }

    public void contador(View View){
        mContador++;
        TextView textView = findViewById(R.id.resultado);
        textView.setText("contador: " + Integer.toString(mContador));
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, mContador);
    }
    //metodo para gaurdar valores
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        mContador = savedInstanceState.getInt(KEY_COUNTER);
        TextView textView= findViewById(R.id.resultado);
        textView.setText("contador: " + Integer.toString(mContador));
    }

    @Override
    protected  void onPause(){
        super.onPause();
       // SharedPreferences settings = getPreferences(MODE_PRIVATE);
        SharedPreferences misPreferencias = getSharedPreferences("MIFICHERO", MODE_PRIVATE);
        SharedPreferences.Editor editor = misPreferencias.edit();
        editor.putInt(KEY_COUNTER, mContador);
        editText = findViewById(R.id.caja);
        texto= editText.getText().toString();
        editor.putString(KEY_NAME,texto);
        //solo escribe con llamada al metodo commit
        editor.commit();
    }
}