package com.example.tarea1dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class Division extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);

        // RECUPERANDO LOS VALORES
        Bundle datos = this.getIntent().getExtras();
        int numero1= datos.getInt("num1");
        int numero2= datos.getInt("num2");
        int resultado =  (numero1 / numero2);
        String result = Integer.toString(resultado);
        String num1 = Integer.toString(numero1);
        String num2 = Integer.toString(numero2);

        Toast.makeText(this,"el resultado de  " +num1+ " y "+num2+" = " +result, Toast.LENGTH_LONG).show();

    }
    public boolean onKeyDown(int KeyCode, KeyEvent evento)
    {
        super.onKeyDown(KeyCode,evento);

        if(KeyCode == KeyEvent.KEYCODE_R)
        {
            Intent regresar = new Intent(this,MainActivity.class);
            startActivity(regresar);

        }

        return false;

    }
}
