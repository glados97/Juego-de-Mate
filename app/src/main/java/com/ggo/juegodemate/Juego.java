package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Juego extends AppCompatActivity {
    private int n1;
    private int n2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        Bundle extras = getIntent().getExtras();
        n1 = Integer.parseInt (extras.getString("n1"));
        n2 = Integer.parseInt (extras.getString("n2"));
    }
}
