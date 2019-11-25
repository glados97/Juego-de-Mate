package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Conteo extends AppCompatActivity {
    private TextView contar;
    private Button regresar;

    private int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteo);

        contar = (TextView) findViewById(R.id.contar);
        regresar = (Button) findViewById(R.id.regresar);

        Bundle extras = getIntent().getExtras();
        b = extras.getInt("numero");
        contar.setText(Integer.toString(b));

    }

    public void Regresar(View v){
        finish();
    }
}
