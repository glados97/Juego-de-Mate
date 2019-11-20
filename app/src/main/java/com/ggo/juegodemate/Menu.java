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
    private int n111;
    private int n222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        enviar = (Button) findViewById(R.id.enviar);
        n1 = (EditText) findViewById(R.id.n1);
        n2 = (EditText) findViewById(R.id.n2);

        n11 = n1.getText().toString();
        n111 = Integer.parseInt(n11);
        n22 = n2.getText().toString();
        n222 = Integer.parseInt(n22);

    }

    public void llamarJ(View v){
        Intent intent = new Intent( this, Juego.class);
        intent.putExtra("n111", (n111));
        intent.putExtra("n222",(n222));
        startActivity(intent);
    }
}
