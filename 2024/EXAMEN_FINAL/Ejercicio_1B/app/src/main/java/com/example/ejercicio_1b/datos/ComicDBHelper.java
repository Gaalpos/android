package com.example.ejercicio_1b.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ComicDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "comic.db";
    public ComicDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ComicEntry.TABLE_NAME + " ("
                + ComicEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ComicEntry.TITULO + " TEXT NOT NULL,"
                + ComicEntry.AUTOR + " TEXT NOT NULL,"
                + ComicEntry.PAIS + " TEXT NOT NULL,"
                + ComicEntry.ANO + " TEXT NOT NULL,"
                + ComicEntry.GENERO + " TEXT NOT NULL )"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        return;
    }

    public long insertaComic(Comic serie){
        SQLiteDatabase db = getWritableDatabase();

        return db.insert(
                ComicEntry.TABLE_NAME,
                null,
                serie.toContentValues()
        );
    }

    public int actualizaComic(Comic serie, String serieID){
        return getWritableDatabase().update(
                ComicEntry.TABLE_NAME,
                serie.toContentValues(),
                ComicEntry._ID + " LIKE ?",
                new String[]{serieID}
        );
    }

    // Listar
    public Cursor getComics(){
        return getReadableDatabase()
                .query(
                        ComicEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                );
    }

    public Cursor getComicById(String serieID){
        Cursor c = getReadableDatabase().query(
                ComicEntry.TABLE_NAME,
                null,
                ComicEntry._ID + " LIKE ?",
                new String[]{serieID},
                null,
                null,
                null
        );
        return c;
    }

    // Borrar
    public int borrarComic(String serieID){
        return getWritableDatabase().delete(
                ComicEntry.TABLE_NAME,
                ComicEntry._ID + " LIKE ?",
                new String[]{serieID}
        );
    }

}
