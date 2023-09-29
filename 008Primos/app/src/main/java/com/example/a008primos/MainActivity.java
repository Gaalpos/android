package com.example.a008primos;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    TextView mTextView;

    Button mButton;

    static final Integer[] primo = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89 , 97};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText=findViewById(R.id.numero);
        mTextView=findViewById(R.id.resultado);

        mButton = findViewById(R.id.boton);
        mButton.setOnClickListener(view -> calculaPrimo(view));


        /*


        mButton.setOnClickListener(new view.){
                @Override
                public void onClick(View view){
                    calculaPrimo(view);
        }
        });
          */
    }


    public void calculaPrimo(View view) {

        //recoger el numero de posicion
        Integer numero= Integer.parseInt(String.valueOf(mEditText.getText()));

        //encontrar el primo para esa posicion en una lista

        //setear el resultado
        if (numero < primo.length){
            mTextView.setText(primo[numero].toString());
        }else{
            mTextView.setText("Te has salido del parchis");
        }

    }
}