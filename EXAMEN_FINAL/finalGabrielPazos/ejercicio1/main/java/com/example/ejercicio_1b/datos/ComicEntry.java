package com.example.ejercicio_1b.datos;

import android.provider.BaseColumns;

public abstract class ComicEntry implements BaseColumns {
    public static final String TABLE_NAME = "comic";
    public static final String TITULO = "titulo";
    public static final String AUTOR = "autor";
    public static final String PAIS = "pais";
    public static final String ANO = "ano";
    public static final String GENERO = "genero";

}
