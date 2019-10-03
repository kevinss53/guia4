package com.example.tarea1dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // inicializamos el proceso RANDOM de java
    Random aleatorios = new Random(System.currentTimeMillis());

    // generamos los numero aleatorios
    int numero1 = aleatorios.nextInt(10);
    int numero2 = aleatorios.nextInt(10);
    int resultado = 0;

    // convirtiendo a String
    String num1 = Integer.toString(numero1);
    String num2 = Integer.toString(numero2);



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"numeros generados "+num1+ "  y " +num2,Toast.LENGTH_LONG).show();

    }


    public boolean onKeyDown(int KeyCode, KeyEvent evento)
    {
        super.onKeyDown(KeyCode,evento);

        if(KeyCode == KeyEvent.KEYCODE_S)
        {
            // enviando los valores
            Intent suma = new Intent(this,Suma.class);
            suma.putExtra("num1",numero1);
            suma.putExtra("num2",numero2);

           startActivity(suma);
        }
        else if( KeyCode == KeyEvent.KEYCODE_R )
        {
            Intent resta = new Intent(this,Resta.class);

            // enviando los valores
            Intent suma = new Intent(this,Suma.class);
            resta.putExtra("num1",numero1);
            resta.putExtra("num2",numero2);


            startActivity(resta);
        }
        else if( KeyCode == KeyEvent.KEYCODE_M )
        {
            Intent multiplicacion = new Intent(this,Multiplicacion.class);
            // enviando los valores
            Intent suma = new Intent(this,Suma.class);
            multiplicacion.putExtra("num1",numero1);
            multiplicacion.putExtra("num2",numero2);


            startActivity(multiplicacion);
        }
        else if( KeyCode == KeyEvent.KEYCODE_D )
        {
            Intent division = new Intent(this,Division.class);

            // enviando los valores
            Intent suma = new Intent(this,Suma.class);
            division.putExtra("num1",numero1);
            division.putExtra("num2",numero2);

            startActivity(division);
        }


        return  false;

    }



}
