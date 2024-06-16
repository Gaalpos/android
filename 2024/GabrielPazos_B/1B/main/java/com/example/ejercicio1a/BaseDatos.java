package com.example.ejercicio1a;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "series.db";
    private static final int DATABASE_VERSION = 1;

    public BaseDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_SERIES_TABLE = "CREATE TABLE " +
                SeriesContract.SeriesEntry.TABLE_NAME + " (" +
                SeriesContract.SeriesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SeriesContract.SeriesEntry.TITLE + " TEXT NOT NULL, " +
                SeriesContract.SeriesEntry.TEMPOR + " TEXT NOT NULL, " +
                SeriesContract.SeriesEntry.DIRECTOR + " TEXT NOT NULL, " +
                SeriesContract.SeriesEntry.YEAR + " TEXT NOT NULL, " +
                SeriesContract.SeriesEntry.PAIS + " TEXT NOT NULL, " +
                SeriesContract.SeriesEntry.GENERO+ " TEXT NOT NULL " +
                ")";
        db.execSQL(SQL_CREATE_SERIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SeriesContract.SeriesEntry.TABLE_NAME);
        onCreate(db);
    }
}
