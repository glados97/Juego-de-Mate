package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;

public class Multiplicacion extends AppCompatActivity {

    private Button empezar;
    private ImageView dado;
    private EditText numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicacion);
        empezar = (Button) findViewById(R.id.empezar_multi);
        dado = (ImageView) findViewById(R.id.dado);
        numero = (EditText) findViewById(R.id.numero);
    }


    public void random(View v){
        numero.setText( String.valueOf(new Random().nextInt(10 - 1 + 1) + 1) );
    }



}
