package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Juego extends AppCompatActivity {
    private int n1;
    private int n2;
    //private int num1;
    //private int num2;
    private TextView sor;
    private TextView numero1;
    private int n11;
    private TextView signo;
    private TextView numero2;
    private int n22;
    private Button revisar;
    private EditText respuesta;
    private int r;
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
        int range = n1 - n2 + 1;
        numero1.setText(Integer.toString((int)(Math.random() * range) + n1));
        numero2.setText(Integer.toString((int)(Math.random() * range) + n1));

        s = (int)(Math.random() * 2);

        if(s == 0){
            signo.setText("+");
        }

        if (s == 1){
            signo.setText("-");
        }
    }

    public void Res(View v){
        r =Integer.valueOf(String.valueOf((respuesta)));
        n11 =Integer.valueOf(String.valueOf((numero1)));
        n22=Integer.valueOf(String.valueOf((numero2)));

        if(s == 0){
            rr = n11 + n22;
        }

        if (s == 1){
            rr = n11 - n22;
        }

        if (rr == r){
            Toast.makeText(getBaseContext(), "Correcto", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Juego.class);
        }
        else{
            Toast.makeText(getBaseContext(), "Vuelve a intentar!", Toast.LENGTH_SHORT).show();
        }
    }

}
