package com.example.ejercicio_1b.datos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;

public class Comic {
    String id;
    String titulo;
    String autor;
    String pais;
    String ano;
    String genero;

    public Comic(String id, String titulo,  String autor, String pais, String ano, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.pais = pais;
        this.ano = ano;
        this.genero = genero;
    }
    @SuppressLint("Range")
    public Comic(Cursor cursor){
        id = cursor.getString(cursor.getColumnIndex(ComicEntry._ID));
        titulo = cursor.getString(cursor.getColumnIndex(ComicEntry.TITULO));
        autor = cursor.getString(cursor.getColumnIndex(ComicEntry.AUTOR));
        pais = cursor.getString(cursor.getColumnIndex(ComicEntry.PAIS));
        ano = cursor.getString(cursor.getColumnIndex(ComicEntry.ANO));
        genero = cursor.getString(cursor.getColumnIndex(ComicEntry.GENERO));
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

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
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
        values.put(ComicEntry._ID, id);
        values.put(ComicEntry.TITULO, titulo);
        values.put(ComicEntry.AUTOR, autor);
        values.put(ComicEntry.PAIS, pais);
        values.put(ComicEntry.ANO, ano);
        values.put(ComicEntry.GENERO, genero);
        return values;
    }


}
