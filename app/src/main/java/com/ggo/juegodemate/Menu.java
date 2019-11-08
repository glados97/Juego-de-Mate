package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu extends AppCompatActivity {
    private Button enviar;
    private EditText n1;
    private EditText n2;
    private String n11;
    private String n22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        enviar = (Button) findViewById(R.id.enviar);
        n1 = (EditText) findViewById(R.id.n1);
        n2 = (EditText) findViewById(R.id.n2);

        n11 =(String.valueOf((n1)));
        n22 =(String.valueOf((n2)));

    }

    public void llamarJ(View v){
        Intent intent = new Intent( this, Juego.class);
        intent.putExtra("n1", (n11));
        intent.putExtra("n2",(n22));
        startActivity(intent);
    }
}
