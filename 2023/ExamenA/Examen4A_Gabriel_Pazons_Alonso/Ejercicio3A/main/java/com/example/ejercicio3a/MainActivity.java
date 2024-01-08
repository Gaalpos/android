package com.example.ejercicio3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private GridLayout gridLayout;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.gridLayout);
        resetButton = findViewById(R.id.resetButton);

        generateButtons();

        resetButton.setOnClickListener(v -> {
            gridLayout.removeAllViews();
            generateButtons();
        });

    }

    private void generateButtons() {
        for (int i = 0; i < 24; i++) {
            Button button = new Button(this);
            button.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setText(randomLetter());
            button.setOnClickListener(v -> button.setText("77"));
            gridLayout.addView(button);
        }
    }

    private String randomLetter() {
        Random random = new Random();
        int asciiG = (int) 'G';
        int asciiS = (int) 'S';
        int randomAscii = asciiG + random.nextInt(asciiS - asciiG + 1);
        return Character.toString((char) randomAscii);
    }
}