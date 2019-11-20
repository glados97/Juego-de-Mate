package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {
    private TextView numero;

    private Button borrar;
    private Button c;
    private Button porciento;
    private Button division;
    private Button por;
    private Button mas;
    private Button menos;
    private Button punto;
    private Button igual;

    private Button nueve;
    private Button ocho;
    private Button siete;
    private Button seis;
    private Button cinco;
    private Button cuatro;
    private Button tres;
    private Button dos;
    private Button uno;
    private Button cero;

    private String operacion = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        numero = (TextView) findViewById(R.id.numero);

        borrar = (Button) findViewById(R.id.borrar);
        c = (Button) findViewById(R.id.c);
        porciento = (Button) findViewById(R.id.porciento);
        division = (Button) findViewById(R.id.division);
        por = (Button) findViewById(R.id.por);
        mas = (Button) findViewById(R.id.mas);
        menos = (Button) findViewById(R.id.menos);
        punto = (Button)findViewById(R.id.punto);
        igual = (Button) findViewById(R.id.igual);

        uno = (Button) findViewById(R.id.uno);
        dos = (Button) findViewById(R.id.dos);
        tres = (Button) findViewById(R.id.tres);
        cuatro = (Button) findViewById(R.id.cuatro);
        cinco = (Button) findViewById(R.id.cinco);
        seis = (Button) findViewById(R.id.seis);
        siete = (Button) findViewById(R.id.siete);
        ocho = (Button) findViewById(R.id.ocho);
        nueve = (Button) findViewById(R.id.nueve);
        cero = (Button) findViewById(R.id.cero);
    }

    public void Uno(View v){
        operacion += "1";
        Log.d("aqui","aqui");
        numero.setText(operacion+" ");
    }
    public void Dos(View v){
        operacion += "2";
        numero.setText(operacion);
    }
    public void Tres(View v){
        operacion += "3";
        numero.setText(operacion);
    }
    public void Cuatro(View v){
        operacion += "4";
        numero.setText(operacion);
    }
    public void Cinco(View v){
        operacion += "5";
        numero.setText(operacion);
    }
    public void Seis(View v){
        operacion += "6";
        numero.setText(operacion);
    }
    public void Siete(View v){
        operacion += "7";
        numero.setText(operacion);
    }
    public void Ocho(View v){
        operacion += "8";
        numero.setText(operacion);
    }
    public void Nueve(View v){
        operacion += "9";
        numero.setText(operacion);
    }
    public void Cero(View v){
        operacion += "0";
        numero.setText(operacion);
    }


    public void Borrar(View v){
        operacion = " ";
        numero.setText(operacion);
    }
    public void C(View v){
        operacion = " ";
        numero.setText(operacion);
    }
    public void Porciento(View v){
        operacion += "%";
        numero.setText(operacion);
    }
    public void Division(View v){
        operacion += "/";
        numero.setText(operacion);
    }
    public void Por(View v){
        operacion += "*";
        numero.setText(operacion);
    }
    public void Mas(View v){
        operacion += "+";
        numero.setText(operacion);
    }
    public void Menos(View v){
        operacion += "-";
        numero.setText(operacion);
    }

    public void Punto(View v){
        operacion += ".";
        numero.setText(operacion);
    }

    public void Igual(View v){
        ///rollo
        numero.setText(operacion);
    }





}
