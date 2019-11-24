package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultioConteo extends AppCompatActivity {
    private Button cont;
    private Button multi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multio_conteo);

        cont = (Button) findViewById(R.id.cont);
        multi = (Button) findViewById(R.id.multi);
    }

    public void llamarC(View v) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void llamarM(View v) {
        Intent intent = new Intent(this, Multiplicacion.class);
        startActivity(intent);

    }
}
