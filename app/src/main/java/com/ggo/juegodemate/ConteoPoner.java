package com.ggo.juegodemate;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class ConteoPoner extends AppCompatActivity {

    private int numero;
    private TextView numero_text;
    private RowComponent [] rows;
    private int count = 0;
    private LinearLayout tabla;
    private ImageView[] logos = new ImageView[numero];
    private String[] images_todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteo_poner);
        Bundle extras = getIntent().getExtras();
        numero = extras.getInt("numero");
        numero_text = (TextView) findViewById(R.id.numero);
        numero_text.setText(Integer.toString(numero));
        tabla = (LinearLayout) findViewById(R.id.tabla);
        String[] images_todo = { "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t"};
        set_table();
    }


    public void set_table(){
        int cantidad_rows = (numero/4);
        if(!(cantidad_rows*4 <= numero)){
            cantidad_rows++;
        }

        instert_components(cantidad_rows);
        insert_images(cantidad_rows);
    }


    public void instert_components(int cantidad_rows){
        for(int i = 0; i<cantidad_rows;i++){
            rows[i] = createComponent();
            tabla.addView(rows[i]);
        }
    }

    public RowComponent createComponent(){
        return new RowComponent(this);
    }

    public void insert_images(int cantidad_rows){
        for(int i = 0; i<cantidad_rows; i++){
            for(int j = 1; j<5;j++){
                if(count<=numero){
                    int resID = getResources().getIdentifier(images_todo[logo_random()], "drawable", getPackageName());
                    logos[count].setImageResource(resID);
                    rows[i].setImage(j,logos[count]);
                    count++;
                }
            }
        }
    }


    public int logo_random(){
        return (new Random().nextInt(20 - 1 + 1) + 1);
    }

}
