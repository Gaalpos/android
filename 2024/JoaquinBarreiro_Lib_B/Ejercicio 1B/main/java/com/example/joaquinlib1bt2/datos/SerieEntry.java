package com.example.joaquinlib1bt2.datos;

import android.provider.BaseColumns;

public abstract class SerieEntry implements BaseColumns {
    public static final String TABLE_NAME = "serie";

    public static final String TITULO = "titulo";
    public static final String NUMERO_TEMPORADAS = "numeroTemporadas";
    public static final String DIRECTOR = "director";
    public static final String PAIS = "pais";
    public static final String ANO = "ano";
    public static final String GENERO = "genero";

}
