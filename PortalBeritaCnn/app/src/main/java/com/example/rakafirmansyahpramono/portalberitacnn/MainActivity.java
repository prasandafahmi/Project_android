package com.example.rakafirmansyahpramono.portalberitacnn;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Judul, Edisi, Penulis;
    private String setJudul, setEdisi, setPenulis;
    private DBBerita DbBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button simpan = findViewById(R.id.save);
        Judul = findViewById(R.id.Judul);
        Edisi = findViewById(R.id.Edisi);
        Penulis = findViewById(R.id.Penulis);

        DbBerita = new DBBerita(getBaseContext());

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData();
                saveData();
                Toast.makeText(getApplicationContext(), "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                clearData();
            }
        });

        Button viewData = findViewById(R.id.readData);
        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewData.class));
            }
        });
    }

    private void setData() {
        setJudul = Judul.getText().toString();
        setEdisi = Edisi.getText().toString();
        setPenulis = Penulis.getText().toString();
    }

    private void saveData() {

        SQLiteDatabase create = DbBerita.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBBerita.MyColumns.Judul, setJudul);
        values.put(DBBerita.MyColumns.Edisi, setEdisi);
        values.put(DBBerita.MyColumns.Penulis, setPenulis);

        create.insert(DBBerita.MyColumns.NamaTabel, null, values);
    }

    private void clearData() {
        Judul.setText("");
        Edisi.setText("");
        Penulis.setText("");
    }
    public void API(View R) {
        Intent intent = new Intent(MainActivity.this, tampilan_API.class);
        startActivity(intent);
    }
}