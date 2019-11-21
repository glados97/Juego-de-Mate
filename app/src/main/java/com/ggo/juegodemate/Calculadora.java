package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {
    private TextView numero;

    private Button borrar;
    private Button c;
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

    private String operacion = "";
    double num1 = 0;
    double num2 = 0;
    double resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        numero = (TextView) findViewById(R.id.numero);

        borrar = (Button) findViewById(R.id.borrar);
        c = (Button) findViewById(R.id.c);
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
        operacion = "";
        numero.setText(operacion);
    }
    public void C(View v){
        operacion = "";
        numero.setText(operacion);
    }
    public void Division(View v){
        operacion += " / ";
        numero.setText(operacion);
    }
    public void Por(View v){
        operacion += " * ";
        numero.setText(operacion);
    }
    public void Mas(View v){
        operacion += " + ";
        numero.setText(operacion);
    }
    public void Menos(View v){
        operacion += " - ";
        numero.setText(operacion);
    }

    public void Punto(View v){
        operacion += ".";
        numero.setText(operacion);
    }

    public void Igual(View v){
        Log.d("aqui", operacion);
        String[] array = operacion.split(" ");
        for ( int i = 0; i<array.length;i++){
            if (array[i].equals("+") || array[i].equals("-") || array[i].equals("*") || array[i].equals("/")){
                if (num2!=0){
                    if(array[i]=="+"){
                        resultado = num1 + num2;
                        num2 = 0;
                        num1 = resultado;
                    }

                    if(array[i]=="-"){
                        resultado = num1 - num2;
                        num2 = 0;
                        num1 = resultado;
                    }

                    if(array[i]=="*"){
                        resultado = num1 * num2;
                        num2 = 0;
                        num1 = resultado;
                    }

                    if(array[i]=="/"){
                        resultado = num1 / num2;
                        num2 = 0;
                        num1 = resultado;
                    }
                }
                else{
                    if(array[i]=="+"){
                        i++;
                        Log.d("aqui", String.valueOf(i));
                        num2 =  Double.parseDouble(array[i]);
                        Log.d("aqui", String.valueOf(num2));
                        Log.d("num2", String.valueOf(num2));
                        resultado = num1 + num2;
                        num1 = resultado;
                    }

                    if(array[i]=="-"){
                        i++;
                        num2 =  Double.parseDouble(array[i]);
                        Log.d("num2", String.valueOf(num2));
                        resultado = num1 - num2;
                        num2 = 0;
                        num1 = resultado;
                    }

                    if(array[i]=="*"){
                        i++;
                        num2 =  Double.parseDouble(array[i]);
                        Log.d("num2", String.valueOf(num2));
                        resultado = num1 * num2;
                        num2 = 0;
                        num1 = resultado;
                    }

                    if(array[i]=="/"){
                        i++;
                        num2 =  Double.parseDouble(array[i]);
                        Log.d("num2", String.valueOf(num2));
                        resultado = num1 / num2;
                        num2 = 0;
                        num1 = resultado;
                    }
                }
            }
            else {
                Log.d("entre", String.valueOf(i));
                if (num1 == 0) {
                    num1 = Double.parseDouble(array[i]);
                    Log.d("num1", String.valueOf(num1));
                }
                else {
                    if (num1 != 0) {
                        num2 = Double.parseDouble(array[i]);
                        Log.d("num2", String.valueOf(num2));
                    }
                }

            }
        }
        numero.setText( String.valueOf(resultado));
    }

    public void Regresar(View v){
        Intent intent = new Intent(this, Juego.class);
        startActivity(intent);
    }



}
