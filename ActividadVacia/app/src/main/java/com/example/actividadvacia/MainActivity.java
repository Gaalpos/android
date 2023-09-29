package com.example.actividadvacia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button miboton;
    Button miboton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miboton = findViewById(R.id.boton);
        miboton.setOnClickListener(view -> lanzarActividad(view));
        miboton = findViewById(R.id.boton2);
        miboton.setOnClickListener(view -> mandarMensaje(view));

    }

    public void lanzarActividad(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://github.com/Gaalpos"));
        startActivity(intent);
    }


    public void mandarMensaje(View view){
        CharSequence textMessage = "tonto si lo lees";
        String phoneNumber="+34651179086";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);

       // sendIntent.setData(Uri.parse("smsto:" + phoneNumber));
        sendIntent.putExtra("address","+34651179086");
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
        sendIntent.setType("text/plain");

// Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }

    }


    public void mandarMensaje4(View view){
        CharSequence textMessage = "perdiste ";
        Uri uri = Uri.parse("smsto:"+"+34651179086");

        Intent sendIntent = new Intent(Intent.ACTION_SENDTO,uri);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
        startActivity(sendIntent);


    }
}