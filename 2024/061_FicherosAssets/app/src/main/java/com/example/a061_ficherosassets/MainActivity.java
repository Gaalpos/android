package com.example.a061_ficherosassets;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    EditText mEditText;
     Button mButton;
    Button mButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imageView);
        mButton = findViewById(R.id.buttonLeer);
        mButton.setOnClickListener(view -> abrirAssets(view));
        mButton2 = findViewById(R.id.verImagen);
        mButton.setOnClickListener(view -> loadImageFromAsset(view));
    }

    private void loadImageFromAsset(View view) {

        try {
            InputStream ims = this.getAssets().open("image.png");
            image.setImageDrawable(Drawable.createFromStream(ims, null));
        }
        catch(IOException ex) {
            return;
        }
    }

    private void abrirAssets(View view) {
        mEditText = findViewById(R.id.editTextText);
        try {
            mEditText.setText(getText(getAssets().open("mi_texto.txt")));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private String getText(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        try {;
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new
                        InputStreamReader(inputStream);
                BufferedReader bufferedReader = new
                        BufferedReader(inputStreamReader);
                String newLine = null;
                while ((newLine = bufferedReader.readLine())
                        != null ) {
                    stringBuilder.append(newLine+"\n");
                }
                inputStream.close();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}