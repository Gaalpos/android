package com.example.persistenciadatosprueba;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String REQUEST_RESULT = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickSwitch(View view){
        Intent intent= new Intent(this,SecondActivity.class);
        EditText stones = (EditText) findViewById(R.id.stones);
        EditText libras = (EditText) findViewById(R.id.libras);
        String text = stones.getText().toString() + "," + libras.getText().toString();
        intent.putExtra(Intent.EXTRA_TEXT,text);

        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            ((TextView)findViewById(R.id.resFinal)).setText(data.getDoubleExtra(REQUEST_RESULT,
                    0) + " ");
        }

    }
}