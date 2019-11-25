package com.ggo.juegodemate;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class RowComponent extends LinearLayout {

    private LinearLayout uno;
    private LinearLayout dos;
    private LinearLayout tres;
    private LinearLayout cuatro;
    private ImageView uno_img, dos_img, tres_img, cuatro_img;
    private String[] images_todo;


    public RowComponent(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.custom_row, this);
        this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        initComponents();
    }

    private void initComponents() {
        uno = (LinearLayout) findViewById(R.id.uno);

        dos = (LinearLayout) findViewById(R.id.dos);

        tres = (LinearLayout) findViewById(R.id.tres);

        cuatro = (LinearLayout) findViewById(R.id.cuatro);

        uno_img = (ImageView) findViewById(R.id.img1);
        dos_img = (ImageView) findViewById(R.id.img2);
        tres_img = (ImageView) findViewById(R.id.img3);
        cuatro_img = (ImageView) findViewById(R.id.img4);

        images_todo = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t"};


    }

    public void setImage(int numero, int resID){

        switch (numero) {
            case 1:
                uno_img.setImageResource(resID);
                break;
            case 2:
                dos_img.setImageResource(resID);
                break;
            case 3:
                tres_img.setImageResource(resID);
                break;
            case 4:
                cuatro_img.setImageResource(resID);
                break;
            default:
                break;
        }
    }


    public void remove_backgroun(int numero){

        switch (numero) {
            case 1:
                uno.setBackgroundResource(R.drawable.custom_border);
                break;
            case 2:
                dos.setBackgroundResource(R.drawable.custom_border);
                break;
            case 3:
                tres.setBackgroundResource(R.drawable.custom_border);
                break;
            case 4:
                cuatro.setBackgroundResource(R.drawable.custom_border);
                break;
            default:
                break;
        }
    }

    public void select(int numero){

        switch (numero) {
            case 1:
                uno.setBackgroundColor(Color.parseColor("#34D2AF"));
                break;
            case 2:
                dos.setBackgroundColor(Color.parseColor("#34D2AF"));
                break;
            case 3:
                tres.setBackgroundColor(Color.parseColor("#34D2AF"));
                break;
            case 4:
                cuatro.setBackgroundColor(Color.parseColor("#34D2AF"));
                break;
            default:
                break;
        }
    }

}


