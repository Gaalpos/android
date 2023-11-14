package com.example.a033gridbotones;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
//import android.widget.GridLayout;
import androidx.gridlayout.widget.GridLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    GridLayout g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g= (GridLayout) findViewById(R.id.rejilla);
        addhijos();
     //   recorrer();
    }

    public void recorrer(){
        View v;
        GridLayout g= (GridLayout) findViewById(R.id.rejilla);

        for(int i=0; i<g.getChildCount();i++){
            v=g.getChildAt(i);
           System.out.println("Objeto: "+v.toString());
           // Log.i("Objeto: ",v.toString());
        }

    }

    public void addhijos(){
        GridLayout g = (GridLayout)   findViewById(R.id.rejilla);
        Button b;
        for(int i=0; i<25;i++){
            b = new Button(this);
            b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            b.setText("btn: "+i);
            b.setId(View.generateViewId());
            b.setOnClickListener(this);
            g.addView(b,i);
        }
    }

    @Override
    public void onClick(View view) {

        if(view.getClass().getSimpleName().equals("Button")){
            Button b = (Button) view;
            b.setBackgroundColor(rgb(200, 50, 12));
        }


    }
}