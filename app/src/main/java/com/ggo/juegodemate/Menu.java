package com.ggo.juegodemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    private Button enviar;
    private EditText n1;
    private EditText n2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        enviar = (Button) findViewById(R.id.enviar);
        n1 = (EditText) findViewById(R.id.n1);
        n2 = (EditText) findViewById(R.id.n2);
        n2.setText("");
        n1.setText("");
    }

    public void llamarJ(View v){
        String n11 = n1.getText().toString();
        int n111 = Integer.parseInt(n11);
        String n22 = n2.getText().toString();
        int n222 = Integer.parseInt(n22);

        if(n111<n222){
            Intent intent = new Intent( this, Juego.class);
            intent.putExtra("n111", (n111));
            intent.putExtra("n222",(n222));
            startActivity(intent);
        }
        else{
            Toast.makeText(getBaseContext(), "Revisa el rango, hay un error", Toast.LENGTH_SHORT).show();
        }


    }
}
