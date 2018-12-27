package com.example.rakafirmansyahpramono.portalberitacnn;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Pembuka extends AppCompatActivity {

    private int waktu_loading=3000;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_pembuka);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent intent = new Intent(Pembuka.this, home.class);
                startActivity(intent);
                finish();

            }
        },waktu_loading);
    }
}
