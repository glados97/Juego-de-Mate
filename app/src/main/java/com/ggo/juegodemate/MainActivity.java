package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button numeros;
    private Button calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeros = (Button) findViewById(R.id.numeros);
        calculadora = (Button) findViewById(R.id.calculadora);
    }

    public void llamarN(View v){
        Intent intent = new Intent( this, Menu.class);
        startActivity(intent);
    }

    public void llamarC(View v){
        Intent intent = new Intent( this, Calculadora.class);
        startActivity(intent);
    }
}
