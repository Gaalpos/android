package com.example.ejercicio1a;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextTitle, editTextTempor, editTextPais, editTextYear, editTextGenero, editTextDirector;

    Button buttonSave, buttonDelete, buttonModify;

    ListView listViewSeries;
    ArrayAdapter<String> adapter;
    ArrayList<String> listaSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSave = findViewById(R.id.save);
        buttonDelete = findViewById(R.id.delete);
        buttonModify = findViewById(R.id.modify);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextTempor = findViewById(R.id.editTextTempor);
        editTextDirector = findViewById(R.id.editTextDirector);
        editTextYear = findViewById(R.id.editTextYear);
        editTextPais = findViewById(R.id.editTextPais);
        editTextGenero = findViewById(R.id.editTextGenero);

        listViewSeries = findViewById(R.id.series);

        listaSeries = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaSeries);
        listViewSeries.setAdapter(adapter);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString();
                String tempor = editTextTempor.getText().toString();
                listaSeries.add(title);
                listaSeries.add(tempor);
                adapter.notifyDataSetChanged();
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = listViewSeries.getCheckedItemPosition();
                if (position != ListView.INVALID_POSITION) {
                    listaSeries.remove(position * 6);
                    listaSeries.remove(position * 6);
                    listaSeries.remove(position * 6);
                    listaSeries.remove(position * 6);
                    listaSeries.remove(position * 6);
                    listaSeries.remove(position * 6);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        buttonModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = listViewSeries.getCheckedItemPosition();
                if (position != ListView.INVALID_POSITION) {
                    listaSeries.set(position * 6,editTextTitle.getText().toString());
                    listaSeries.set(position * 6 + 1,editTextTempor.getText().toString());
                    listaSeries.set(position * 6 + 2, editTextDirector.getText().toString());
                    listaSeries.set(position * 6 + 3, editTextPais.getText().toString());
                    listaSeries.set(position * 6 + 4, editTextYear.getText().toString());
                    listaSeries.set(position * 6 + 5, editTextGenero.getText().toString());
                    adapter.notifyDataSetChanged();
                }
            }
        });


        listViewSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedTitle = listaSeries.get(position);
                String selectedTempor = listaSeries.get(position);
                String selectedDirector = listaSeries.get(position);
                String selectedPais = listaSeries.get(position);
                String selectedYear = listaSeries.get(position);
                String selectedGenero = listaSeries.get(position);
                editTextTitle.setText("titulo: "+ selectedTitle);
                editTextTempor.setText("temporadas: "+selectedTempor);
                editTextDirector.setText("temporadas: "+selectedDirector);
                editTextPais.setText("temporadas: "+selectedPais);
                editTextYear.setText("temporadas: "+selectedYear);
                editTextGenero.setText("temporadas: "+selectedGenero);

            }
        });

    }
}
