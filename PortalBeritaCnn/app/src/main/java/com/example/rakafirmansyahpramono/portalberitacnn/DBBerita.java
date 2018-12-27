package com.example.rakafirmansyahpramono.portalberitacnn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBBerita extends SQLiteOpenHelper {

    static abstract class MyColumns implements BaseColumns {
        static final String NamaTabel = "Berita";
        static final String Judul = "Judul";
        static final String Edisi = "Edisi";
        static final String Penulis = "Penulis";
    }

    private static final String NamaDatabse = "Berita.db";
    private static final int VersiDatabase = 14;

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + MyColumns.NamaTabel +
            "(" + MyColumns.Judul + " TEXT PRIMARY KEY, " + MyColumns.Edisi + " TEXT NOT NULL, " + MyColumns.Penulis +
            " TEXT NOT NULL)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + MyColumns.NamaTabel;

    DBBerita(Context context) {
        super(context, NamaDatabse, null, VersiDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}