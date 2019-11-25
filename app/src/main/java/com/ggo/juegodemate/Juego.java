package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Juego extends AppCompatActivity {
    private int n1;
    private int n2;
    private int num1;
    private int num2;
    private TextView sor;
    private TextView numero1;
    private int n11;
    private TextView signo;
    private TextView numero2;
    private int n22;
    private Button revisar;
    private EditText respuesta;
    private String r;
    private int rr;
    private int s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        sor = (TextView) findViewById(R.id.sor);
        numero1 = (TextView) findViewById(R.id.numero1);
        signo = (TextView) findViewById(R.id.signo);
        numero2 = (TextView) findViewById(R.id.numero2);
        revisar = (Button) findViewById(R.id.revisar);
        respuesta = (EditText) findViewById(R.id.respuesta);

        Bundle extras = getIntent().getExtras();
        n1 = extras.getInt("n111");
        n2 = extras.getInt("n222");

        Operacion(n1, n2);

    }

    public void Operacion(int n1, int n2){
        respuesta.setText("");
        do {
            num1 = (int) (Math.random() *(n2+1));
        }while(num1<n1);

        Contar(num1);

        do{
            num2 = (int)(Math.random() * (n2+1));
        }while(num2<n1);

        Contar(num2);

        if (num1 >= num2) {
            numero1.setText(Integer.toString(num1));
            numero2.setText(Integer.toString(num2));
        }
        else{
            numero1.setText(Integer.toString(num2));
            numero2.setText(Integer.toString(num1));
        }

        s = (int) (Math.random() * 2);

        if (s == 0) {
            signo.setText("                +");
            sor.setText("Suma");
        }

        if (s == 1) {
            signo.setText("                -");
            sor.setText("Resta");
        }



    }

    public void Res(View v){
        r =(String.valueOf((respuesta.getText().toString())));

        if (num1 >= num2) {
            if (s == 0) {
                rr = num1 + num2;
            }

            if (s == 1) {
                rr = num1 - num2;
            }
        }
        else{
            if (s == 0) {
                rr = num2 + num1;
            }

            if (s == 1) {
                rr = num2 - num1;
            }
        }

        String rrr =  Integer.toString(rr);
        Log.d("aquirr", Integer.toString(rr));
        Log.d("aquir", (r));
        if (rrr.equals(r)){
            Toast.makeText(getBaseContext(), "Correcto", Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(this, Juego.class);
            Operacion(n1,n2);
        }
        else{
            Toast.makeText(getBaseContext(), "Vuelve a intentar!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Calculadora(View v){
        Intent intent = new Intent(this, Calculadora.class);
        onPause();
        startActivity(intent);
    }

    public void Contar(int b){
        Intent intent = new Intent(this, ConteoPoner.class);
        onPause();
        intent.putExtra("numero", (b));
        startActivity(intent);
    }
}
