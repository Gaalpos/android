package com.example.joaquinlib1bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.joaquinlib1bt2.datos.Serie;
import com.example.joaquinlib1bt2.datos.SeriesDBHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etTitulo, etNumTemp, etDirector, etPais, etAno, etGenero;
    Button btnInsertar, btnModificar, btnBorrar, btnListar;
    ListView listViewSeries;
    SeriesDBHelper dbHelper;

    List<Serie> listaSeries = new ArrayList<Serie>();
    Serie ultimaSerieSeleccionada = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewSeries = findViewById(R.id.lv_listView);

        etTitulo = findViewById(R.id.et_titulo);
        etNumTemp = findViewById(R.id.et_numTemp);
        etDirector = findViewById(R.id.et_director);
        etPais = findViewById(R.id.et_pais);
        etAno = findViewById(R.id.et_ano);
        etGenero = findViewById(R.id.et_genero);

        btnInsertar = findViewById(R.id.btn_insertar);
        btnModificar = findViewById(R.id.btn_modificar);
        btnBorrar = findViewById(R.id.btn_borrar);
        btnListar = findViewById(R.id.btn_listar);

        btnInsertar.setOnClickListener(v-> insertar());
        btnModificar.setOnClickListener(v-> modificar());
        btnBorrar.setOnClickListener(v-> borrar());
        btnListar.setOnClickListener(v->listar());

        dbHelper = new SeriesDBHelper(this);

        listViewSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    ultimaSerieSeleccionada = listaSeries.get(position);
                } catch (IndexOutOfBoundsException e) {
                    ultimaSerieSeleccionada = null;
                    Toast.makeText(MainActivity.this, "Error al seleccionar la serie", Toast.LENGTH_SHORT).show();
                }
                if (ultimaSerieSeleccionada == null)
                    return;

                // Poblamos los edit text con los datos de la serie seleccionada
                etTitulo.setText(ultimaSerieSeleccionada.getTitulo());
                etNumTemp.setText(ultimaSerieSeleccionada.getNumeroTemporadas());
                etDirector.setText(ultimaSerieSeleccionada.getDirector());
                etPais.setText(ultimaSerieSeleccionada.getPais());
                etAno.setText(ultimaSerieSeleccionada.getAno());
                etGenero.setText(ultimaSerieSeleccionada.getGenero());

            }
        });

        listar();
    }


    private void cargarLista(){
        listaSeries.clear();
        List<Serie> lista = new ArrayList<Serie>();
        Cursor c = dbHelper.getTodasSeries();

        Serie s = null;
        if (c.getCount() == 0)
            return;
        else {
            while (c.moveToNext()){
                s = new Serie(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6));
                lista.add(s);
            }
        }
        c.close();
        listaSeries = lista;
    }

    private void listar(){
        cargarLista();

        ArrayAdapter<String> adaptador = null;
        List<String> lista = new ArrayList<>();

        for (Serie s : listaSeries) {
            lista.add(s.getTitulo() + " - " + s.getNumeroTemporadas() +" - " + s.getDirector() + " - " + s.getPais() + " - " + s.getAno() + " - " + s.getGenero());
        }

        adaptador = new ArrayAdapter<String>(getApplicationContext(), R.layout.lista_fila, lista);

        listViewSeries.setAdapter(adaptador);
    }


    private void insertar(){
        String titulo = etTitulo.getText().toString();
        String numTemp = etNumTemp.getText().toString();
        String director = etDirector.getText().toString();
        String pais = etPais.getText().toString();
        String ano = etAno.getText().toString();
        String genero = etGenero.getText().toString();

        Serie serie = new Serie(null, titulo, numTemp, director, pais, ano, genero);

        dbHelper.insertaSerie(serie);
        listar();
    }

    private void borrar(){
        if(ultimaSerieSeleccionada == null){
            Toast.makeText(this, "Selecciona una serie en la lista", Toast.LENGTH_LONG).show();
            return;
        }
        Serie serie = ultimaSerieSeleccionada;
        String id = serie.getId();

        Cursor c = dbHelper.getSerieById(id);
        if(c.getCount() == 0){
            Toast.makeText(this, "No se encontro la serie "+serie.getTitulo(), Toast.LENGTH_LONG).show();
            return;
        }

        dbHelper.borrarSerie(id);
        ultimaSerieSeleccionada = null;
        Toast.makeText(this, "Se borro la serie "+serie.getTitulo(), Toast.LENGTH_SHORT).show();
        listar();
    }

    private void modificar(){
        if(ultimaSerieSeleccionada == null){
            Toast.makeText(this, "Selecciona una serie en la lista", Toast.LENGTH_LONG).show();
            return;
        }
        Serie serie = ultimaSerieSeleccionada;
        String id = serie.getId();

        Cursor c = dbHelper.getSerieById(id);
        if(c.getCount() == 0){
            Toast.makeText(this, "No se encontro la serie "+serie.getTitulo(), Toast.LENGTH_LONG).show();
            return;
        }

        String titulo = etTitulo.getText().toString();
        String numTemp = etNumTemp.getText().toString();
        String director = etDirector.getText().toString();
        String pais = etPais.getText().toString();
        String ano = etAno.getText().toString();
        String genero = etGenero.getText().toString();

        Serie nuevosDatos = new Serie(id, titulo, numTemp, director, pais, ano, genero);

        dbHelper.actualizaSerie(nuevosDatos, id);
        ultimaSerieSeleccionada = null;
        Toast.makeText(this, "Se actualizo la serie "+serie.getTitulo(), Toast.LENGTH_LONG).show();
        listar();

    }

}