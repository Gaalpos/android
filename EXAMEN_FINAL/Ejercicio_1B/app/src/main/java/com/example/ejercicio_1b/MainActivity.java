package com.example.ejercicio_1b;

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
import java.util.ArrayList;
import java.util.List;

import com.example.ejercicio_1b.datos.Comic;
import com.example.ejercicio_1b.datos.ComicDBHelper;

public class MainActivity extends AppCompatActivity {

    EditText etTitulo, etAutor, etPais, etAno, etGenero;
    Button btnInsertar, btnModificar, btnBorrar, btnListar;
    ListView listViewComics;
    ComicDBHelper dbHelper;

    List<Comic> listaComics = new ArrayList<Comic>();
    Comic ultimoComic = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewComics = findViewById(R.id.lv_listView);

        etTitulo = findViewById(R.id.et_titulo);
        etAutor = findViewById(R.id.et_autor);
        etPais = findViewById(R.id.et_pais);
        etAno = findViewById(R.id.et_ano);
        etGenero = findViewById(R.id.et_genero);

        btnInsertar = findViewById(R.id.btn_insertar);
        btnModificar = findViewById(R.id.btn_modificar);
        btnBorrar = findViewById(R.id.btn_borrar);
        btnListar = findViewById(R.id.btn_listar);

        btnInsertar.setOnClickListener(v -> insertar());
        btnModificar.setOnClickListener(v -> modificar());
        btnBorrar.setOnClickListener(v -> borrar());
        btnListar.setOnClickListener(v -> listar());

        dbHelper = new ComicDBHelper(this);

        listViewComics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    ultimoComic = listaComics.get(position);
                } catch (IndexOutOfBoundsException e) {
                    ultimoComic = null;
                    Toast.makeText(MainActivity.this, "Error al seleccionar el comic", Toast.LENGTH_SHORT).show();
                }
                if (ultimoComic == null)
                    return;

                etTitulo.setText(ultimoComic.getTitulo());
                etAutor.setText(ultimoComic.getAutor());
                etPais.setText(ultimoComic.getPais());
                etAno.setText(ultimoComic.getAno());
                etGenero.setText(ultimoComic.getGenero());

            }
        });

        listar();
    }


    private void cargarLista() {
        listaComics.clear();
        List<Comic> lista = new ArrayList<Comic>();
        Cursor c = dbHelper.getComics();

        Comic s = null;
        if (c.getCount() == 0)
            return;
        else {
            while (c.moveToNext()) {
                s = new Comic(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                lista.add(s);
            }
        }
        c.close();
        listaComics = lista;
    }

    private void listar() {
        cargarLista();
        ArrayAdapter<String> adaptador = null;
        List<String> lista = new ArrayList<>();
        for (Comic s : listaComics) {
            lista.add(s.getTitulo()  + " - " + s.getAutor() + " - " + s.getPais() + " - " + s.getAno() + " - " + s.getGenero());
        }
        adaptador = new ArrayAdapter<String>(getApplicationContext(), R.layout.lista_fila, lista);
        listViewComics.setAdapter(adaptador);
    }


    private void insertar() {
        String titulo = etTitulo.getText().toString();
        String autor = etAutor.getText().toString();
        String pais = etPais.getText().toString();
        String ano = etAno.getText().toString();
        String genero = etGenero.getText().toString();

        Comic Comic = new Comic(null, titulo, autor, pais, ano, genero);

        dbHelper.insertaComic(Comic);
        listar();
    }

    private void borrar() {
        if (ultimoComic == null) {
            Toast.makeText(this, "Selecciona un comic", Toast.LENGTH_LONG).show();
            return;
        }
        Comic serie = ultimoComic;
        String id = serie.getId();

        Cursor c = dbHelper.getComicById(id);
        if (c.getCount() == 0) {
            Toast.makeText(this, "No se encontro el comic " + serie.getTitulo(), Toast.LENGTH_LONG).show();
            return;
        }

        dbHelper.borrarComic(id);
        ultimoComic = null;
        Toast.makeText(this, "Se borro la serie " + serie.getTitulo(), Toast.LENGTH_SHORT).show();
        listar();
    }

    private void modificar() {
        if (ultimoComic == null) {
            Toast.makeText(this, "Selecciona una serie en la lista", Toast.LENGTH_LONG).show();
            return;
        }
        Comic serie = ultimoComic;
        String id = serie.getId();

        Cursor c = dbHelper.getComicById(id);
        if (c.getCount() == 0) {
            Toast.makeText(this, "No se encontro el comic " + serie.getTitulo(), Toast.LENGTH_LONG).show();
            return;
        }

        String titulo = etTitulo.getText().toString();

        String autor = etAutor.getText().toString();
        String pais = etPais.getText().toString();
        String ano = etAno.getText().toString();
        String genero = etGenero.getText().toString();

        Comic nuevosDatos = new Comic(id, titulo, autor, pais, ano, genero);

        dbHelper.actualizaComic(nuevosDatos, id);
        ultimoComic = null;
        Toast.makeText(this, "Se actualizo el comic " + serie.getTitulo(), Toast.LENGTH_LONG).show();
        listar();

    }
}
