package com.ggo.juegodemate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class JuegoMultiplicacion extends AppCompatActivity {

    private TextView num1;
    private TextView num2;
    private Button send_ans;
    private ImageView help;
    private ImageView hide;
    private EditText ans;
    private KonfettiView konfettiView;
    private CountDownTimer ayuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_multiplicacion);
        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);
        send_ans = (Button) findViewById(R.id.resultado);
        ans = (EditText) findViewById(R.id.numero_respuesta);
        help = (ImageView) findViewById(R.id.hint);
        Bundle extras = getIntent().getExtras();
        num1.setText(String.valueOf( extras.getInt("numero")));
        num2.setText( String.valueOf(new Random().nextInt(10 - 1 + 1) + 1) );
        konfettiView = findViewById(R.id.konfettiView);
        help.setImageResource(android.R.color.transparent);
        countdown();
    }

    public void error(String mensaje){
        Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG).show();
    }

    public int multiplicacion(){
        return Integer.valueOf((String) num2.getText()) * Integer.valueOf((String) num1.getText());
    }

    public boolean check_number(){
        if (String.valueOf(multiplicacion()).equals(ans.getText().toString())){
            return true;}
        else{
            return false;
        }
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
        ayuda = new CountDownTimer(2000, 10) {

            public void onTick(long millisUntilFinished) {}

            public void onFinish() {
                error("¿Ocupas ayuda?");
                help();
            }
        }.start();
    }

    public void calculadora(){
        Intent intent = new Intent(this, Calculadora.class);
        onPause();
        startActivity(intent);
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


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("¿Deseas salir de la actividad?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                        //close();


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();

    }

}
