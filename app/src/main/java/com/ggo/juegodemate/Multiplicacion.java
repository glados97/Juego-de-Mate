package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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

    public void empezar(View v){

        if(check_number()){
            Intent intent = new Intent( this, JuegoMultiplicacion.class);
            intent.putExtra("numero", Integer.valueOf(String.valueOf(numero.getText())));
            startActivity(intent);
            finish();
        }else{
            error("Solo se puede un número del 1-10.");
        }

    }

    public boolean check_number(){
        int num = Integer.valueOf(String.valueOf(numero.getText()));
        if (num > 0 && num < 11){
            return true;
        }else{
            return false;
        }
    }

    public void error(String mensaje){
        Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG).show();
    }



}
