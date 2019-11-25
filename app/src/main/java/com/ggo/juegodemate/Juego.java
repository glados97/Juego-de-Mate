package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

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
    private KonfettiView konfettiView;
    private CountDownTimer ayuda;
    private ImageView help;


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
        help = (ImageView) findViewById(R.id.hint);
        Bundle extras = getIntent().getExtras();
        n1 = extras.getInt("n111");
        n2 = extras.getInt("n222");
        konfettiView = findViewById(R.id.konfettiView);
        help.setImageResource(android.R.color.transparent);
        Operacion(n1, n2);
        countdown();

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
            signo.setText("+");
            sor.setText("Suma");
        }

        if (s == 1) {
            signo.setText("-");
            sor.setText("Resta");
        }



    }

    public void calculadora(){
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


    public boolean check_number(){
        if (String.valueOf(sumaresta()).equals(respuesta.getText().toString())){
            return true;}
        else{
            return false;
        }
    }

    public int sumaresta(){

        if (num1 >= num2) {
            if (s == 0) {
                return num1 + num2;
            }

            if (s == 1) {
                return num1 - num2;
            }
        }
        else{
            if (s == 0) {
                return num2 + num1;
            }

            if (s == 1) {
                return num2 - num1;
            }
        }
        return 0;
    }

    public void responder(View v){
        if(check_number()){
            ayuda.cancel();
            error("Correcto!");
            cheers(konfettiView);
            new CountDownTimer(4000, 1000) {

                public void onTick(long millisUntilFinished) {}

                public void onFinish() {
                    finish();
                }
            }.start();
        }else{
            error("Respuesta incorrecta, intentalo de nuevo");
        }
    }

    public void countdown(){
        ayuda = new CountDownTimer(13000, 1000) {

            public void onTick(long millisUntilFinished) {}

            public void onFinish() {
                error("¿Ocupas ayuda?");
                help();
            }
        }.start();
    }

    public void cheers(KonfettiView konfettiView){
        konfettiView.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5f))
                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                .streamFor(300, 2000L);
    }

    public void help(){
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculadora();
            }});
        help.setImageResource(R.drawable.ic_help_black_24dp);
    }

    public void error(String mensaje){
        Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG).show();
    }



}
