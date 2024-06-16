package com.example.ejercicio1a;

import android.provider.BaseColumns;

public class SeriesContract {
    private SeriesContract() {}

    public static final class SeriesEntry implements BaseColumns {
        public static final String TABLE_NAME = "series";
        public static final String TITLE = "title";
        public static final String TEMPOR = "tempor";
        public static final String PAIS = "pais";
        public static final String GENERO = "GENERO";
       public static final String DIRECTOR = "director";
        public static final String YEAR = "year";

    }
}
