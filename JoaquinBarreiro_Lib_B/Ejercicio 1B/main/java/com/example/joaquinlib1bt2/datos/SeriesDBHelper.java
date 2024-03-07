package com.example.joaquinlib1bt2.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SeriesDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Series.db";
    public SeriesDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + SerieEntry.TABLE_NAME + " ("
                + SerieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SerieEntry.TITULO + " TEXT NOT NULL,"
                + SerieEntry.NUMERO_TEMPORADAS + " TEXT NOT NULL,"
                + SerieEntry.DIRECTOR + " TEXT NOT NULL,"
                + SerieEntry.PAIS + " TEXT NOT NULL,"
                + SerieEntry.ANO + " TEXT NOT NULL,"
                + SerieEntry.GENERO + " TEXT NOT NULL )"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        return;
    }

    // Operaciones basicas ---------------------------------------

    // Insertar
    public long insertaSerie(Serie serie){
        SQLiteDatabase db = getWritableDatabase();

        return db.insert(
                SerieEntry.TABLE_NAME,
                null,
                serie.toContentValues()
        );
    }

    // Modificar
    public int actualizaSerie(Serie serie, String serieID){
        return getWritableDatabase().update(
                SerieEntry.TABLE_NAME,
                serie.toContentValues(),
                SerieEntry._ID + " LIKE ?",
                new String[]{serieID}
        );
    }

    // Listar
    public Cursor getTodasSeries(){
        return getReadableDatabase()
                .query(
                        SerieEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                );
    }

    public Cursor getSerieById(String serieID){
        Cursor c = getReadableDatabase().query(
                SerieEntry.TABLE_NAME,
                null,
                SerieEntry._ID + " LIKE ?",
                new String[]{serieID},
                null,
                null,
                null
        );
        return c;
    }

    // Borrar
    public int borrarSerie(String serieID){
        return getWritableDatabase().delete(
                SerieEntry.TABLE_NAME,
                SerieEntry._ID + " LIKE ?",
                new String[]{serieID}
        );
    }

}
