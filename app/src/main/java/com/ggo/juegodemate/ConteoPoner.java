package com.ggo.juegodemate;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
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
    private String[] images_todo;
    private Button add;
    private int cantidad_rows;
    private int n2,m2,n,m, lectura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteo_poner);
        Bundle extras = getIntent().getExtras();
        numero = extras.getInt("numero");
        //numero_text = (TextView) findViewById(R.id.numero);
        //numero_text.setText(Integer.toString(numero));
        tabla = (LinearLayout) findViewById(R.id.tabla);
        images_todo = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t"};
        set_table();
        n = 0;
        n2=0;
        m=1;
        m2=1;
        lectura = 1;
        add = (Button) findViewById(R.id.add);
    }

    public void add_count(View v){
        if(lectura<=numero){
        if(!(n==0 && m==1)){
            rows[n2].remove_backgroun(m2);
        }

        rows[n].select(m);
        n2= n;
        m2= m;

        if(m==4){
            m=1;
            n++;}
        else{
            m++;
        }}
        lectura++;

    }

    public void set_table(){
        int cantidad_rows = (numero/4);
        if(!(cantidad_rows*4 >= numero)){
            cantidad_rows++;
        }

        rows = new RowComponent[cantidad_rows];
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
        RowComponent component = new RowComponent(this);
        component.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)component.getLayoutParams();
        layoutParams.height = dpToPx(80);
        component.setLayoutParams(layoutParams);
        return component;
    }

    public void insert_images(int cantidad_rows){
        int resID;
        for(int i = 0; i<cantidad_rows; i++){
            for(int j = 1; j<5;j++){
                if(count<numero){
                    resID = getResources().getIdentifier(images_todo[logo_random()], "drawable", getPackageName());
                }else{
                    resID = getResources().getIdentifier("empty", "drawable", getPackageName());
                }
                rows[i].setImage(j,resID);
                count++;
            }
        }
    }


    public int logo_random(){
        return (new Random().nextInt(20) );
    }

    public int dpToPx(int dp) {
        float density = this.getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }

}
