package com.ggo.juegodemate;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class Conteo extends AppCompatActivity {

    private int numero;
    private TextView numero_text;
    private RowComponent [] rows;
    private int count = 0;
    private LinearLayout tabla;
    private String[] images_todo;
    private Button add;
    private int cantidad_rows;
    private int n2,m2,n,m, lectura;
    private TextToSpeech mTTS;
    private CountDownTimer ayuda;
    private EditText ans;
    private KonfettiView konfettiView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteo_poner);
        Bundle extras = getIntent().getExtras();
        numero = extras.getInt("numero");
        konfettiView = findViewById(R.id.konfettiView);
        ans = (EditText) findViewById(R.id.numero);
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
        final Locale locSpanish = new Locale("spa", "MEX");

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS)
                    mTTS.setLanguage(locSpanish);
        }});

        add = (Button) findViewById(R.id.add);
    }

    public void add_count(View v){

        add.setEnabled(false);

        new CountDownTimer(700, 100) {

            public void onTick(long millisUntilFinished) {}

            public void onFinish() {
                add.setEnabled(true);
            }
        }.start();

        if(lectura<=numero){
        if(!(n==0 && m==1)){
            rows[n2].remove_backgroun(m2);
        }

        rows[n].select(m);
        mTTS.speak(String.valueOf(lectura), TextToSpeech.QUEUE_ADD, null);

        n2= n;
        m2= m;

        if(m==4){
            m=1;
            n++;}
        else{
            m++;
        }}else{
            mTTS.speak(String.valueOf(numero), TextToSpeech.QUEUE_ADD, null);

        }
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

    public void responder(View v){
        if(check_number()){
            error("Correcto!");
            cheers(konfettiView);
            new CountDownTimer(4000, 1000) {

                public void onTick(long millisUntilFinished) {}

                public void onFinish() {
                    finish();
                }
            }.start();
        }else{
            error("Respuesta incorrecta, intentalo de nuevo");
        }
    }

    public void cheers(KonfettiView konfettiView){
        konfettiView.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5f))
                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                .streamFor(300, 2000L);
    }

    public boolean check_number(){
        if (String.valueOf(numero).equals(ans.getText().toString())){
            return true;}
        else{
            return false;
        }
    }

    public void error(String mensaje){
        Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG).show();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("¿Deseas saltarte está actividad de conteo?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                        //close();


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();

    }


}
