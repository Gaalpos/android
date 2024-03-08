package com.example.ejercicio_1b.datos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;

public class Serie {
    String id;
    String titulo;
    String numeroTemporadas;
    String director;
    String pais;
    String ano;
    String genero;

    public Serie(String id, String titulo, String numeroTemporadas, String director, String pais, String ano, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.director = director;
        this.pais = pais;
        this.ano = ano;
        this.genero = genero;
    }
    @SuppressLint("Range")
    public Serie(Cursor cursor){
        id = cursor.getString(cursor.getColumnIndex(SerieEntry._ID));
        titulo = cursor.getString(cursor.getColumnIndex(SerieEntry.TITULO));
        numeroTemporadas = cursor.getString(cursor.getColumnIndex(SerieEntry.NUMERO_TEMPORADAS));
        director = cursor.getString(cursor.getColumnIndex(SerieEntry.DIRECTOR));
        pais = cursor.getString(cursor.getColumnIndex(SerieEntry.PAIS));
        ano = cursor.getString(cursor.getColumnIndex(SerieEntry.ANO));
        genero = cursor.getString(cursor.getColumnIndex(SerieEntry.GENERO));
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getNumeroTemporadas() {
        return numeroTemporadas;
    }
    public void setNumeroTemporadas(String numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(SerieEntry._ID, id);
        values.put(SerieEntry.TITULO, titulo);
        values.put(SerieEntry.NUMERO_TEMPORADAS, numeroTemporadas);
        values.put(SerieEntry.DIRECTOR, director);
        values.put(SerieEntry.PAIS, pais);
        values.put(SerieEntry.ANO, ano);
        values.put(SerieEntry.GENERO, genero);
        return values;
    }


}
