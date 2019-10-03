package com.uso.ejemplo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import java.security.Key;

import static com.uso.ejemplo2.MainActivity.TAG_MENSAJE;

public class Tercera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);
    }

    public boolean onKeyDown(int KeyCode, KeyEvent evento){
        super.onKeyDown(KeyCode, evento);

        //Validar si se presiono la tecle "F"
        if(KeyCode   == KeyEvent.KEYCODE_F){
            //Creamos el Intent para enviar un mensaje al padre
            Intent mensajePadre = new Intent();
            mensajePadre.putExtra(TAG_MENSAJE, "Saludos desde la tercera activity =]");
            setResult(RESULT_OK, mensajePadre);
            //Finalizamos la activity
            finish();
        }

        return false;
    }
}
