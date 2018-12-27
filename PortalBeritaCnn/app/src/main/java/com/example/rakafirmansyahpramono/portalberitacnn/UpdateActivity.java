package com.example.rakafirmansyahpramono.portalberitacnn;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    private DBBerita MyDatabase;
    private EditText NewJudul, NewEdisi, NewPenulis;
    private String  getNewJudul, getNewEdisi, getNewPenulis;
    private Button Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        MyDatabase = new DBBerita(getBaseContext());
        NewJudul = findViewById(R.id.new_Judul);
        NewEdisi = findViewById(R.id.new_Edisi);
        NewPenulis = findViewById(R.id.new_Penulis);
        Update = findViewById(R.id.new_data);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpdateData();
                startActivity(new Intent(UpdateActivity.this, ViewData.class));
                finish();
            }
        });
    }

    private void setUpdateData(){
        getNewJudul = NewJudul.getText().toString();
        getNewEdisi = NewEdisi.getText().toString();
        getNewPenulis = NewPenulis.getText().toString();

        String GetJudul = getIntent().getExtras().getString("SendJudul");

        SQLiteDatabase database = MyDatabase.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBBerita.MyColumns.Judul, getNewJudul);
        values.put(DBBerita.MyColumns.Edisi, getNewEdisi);
        values.put(DBBerita.MyColumns.Penulis, getNewPenulis);

        String selection = DBBerita.MyColumns.Judul + " LIKE ?";
        String[] selectionArgs = {GetJudul};
        database.update(DBBerita.MyColumns.NamaTabel, values, selection, selectionArgs);
        Toast.makeText(getApplicationContext(), "Berhasil Diubah", Toast.LENGTH_SHORT).show();
    }
}
