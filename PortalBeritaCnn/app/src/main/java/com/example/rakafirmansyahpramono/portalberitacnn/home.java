package com.example.rakafirmansyahpramono.portalberitacnn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void home(View R) {
        Intent intent = new Intent(home.this, home.class);
        startActivity(intent);
    }
    public void folder(View R) {
        Intent intent = new Intent(home.this, MainActivity.class);
        startActivity(intent);
    }
    public void browser(View R) {
        Intent intent = new Intent(home.this, tampilan_API.class);
        startActivity(intent);
    }
    public void login(View R) {
        Intent intent = new Intent(home.this, LoginActivity.class);
        startActivity(intent);
    }
}
