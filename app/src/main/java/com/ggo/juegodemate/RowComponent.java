package com.ggo.juegodemate;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RowComponent extends LinearLayout {

    private LinearLayout uno;
    private LinearLayout dos;
    private LinearLayout tres;
    private LinearLayout cuatro;

    public RowComponent(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.custom_row, this);
        initComponents();
    }

    private void initComponents() {
        uno = (LinearLayout) findViewById(R.id.uno);

        dos = (LinearLayout) findViewById(R.id.dos);

        tres = (LinearLayout) findViewById(R.id.tres);

        cuatro = (LinearLayout) findViewById(R.id.cuatro);
    }

    public void setImage(int numero, ImageView v){

        switch (numero) {
            case 1:
                uno.addView(v);
                break;
            case 2:
                dos.addView(v);
                break;
            case 3:
                tres.addView(v);
                break;
            case 4:
                cuatro.addView(v);
                break;
            default:
                break;
        }
    }


    public void remove_backgroun(int numero){

        switch (numero) {
            case 1:
                uno.setBackgroundColor(0);
                break;
            case 2:
                dos.setBackgroundColor(0);
                break;
            case 3:
                tres.setBackgroundColor(0);
                break;
            case 4:
                cuatro.setBackgroundColor(0);
                break;
            default:
                break;
        }
    }



    public void select(int numero){

        switch (numero) {
            case 1:
                uno.setBackgroundColor(Color.parseColor("34D2AF"));
                break;
            case 2:
                dos.setBackgroundColor(Color.parseColor("34D2AF"));
                break;
            case 3:
                tres.setBackgroundColor(Color.parseColor("34D2AF"));
                break;
            case 4:
                cuatro.setBackgroundColor(Color.parseColor("34D2AF"));
                break;
            default:
                break;
        }
    }


}


