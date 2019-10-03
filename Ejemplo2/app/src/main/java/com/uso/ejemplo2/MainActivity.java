package com.uso.ejemplo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaracion constante estatica
    public static final int ID_TERCERA = 3;
    public static final int ID_CUARTA = 4;
    public static final String TAG_MENSAJE = "MSJ";

    //Declaracion de constantes
    private final String TAG = "EVENTOS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mensaje de Depuración
        Log.d(TAG, "Ejecutando evento onCreate");
    }

    public boolean onKeyDown(int KeyCode, KeyEvent evento){
        super.onKeyDown(KeyCode, evento);

        //Validamos si se presiono la tecla "N"
        if(KeyCode == KeyEvent.KEYCODE_N){
            //Iniciamos una nueva activity [Normal]
            Intent nuevaActivity = new Intent(this, Segunda.class);
            startActivity(nuevaActivity);
        }else if( KeyCode == KeyEvent.KEYCODE_H){
            //Iniciamos la activity [Hija]
            Intent terceraActivity = new Intent(this, Tercera.class);
            startActivityForResult(terceraActivity,ID_TERCERA);
        }
        return false;
    }

    public void onActivityResult(int RequestCode, int ResultCode, Intent datos){
        super.onActivityResult(RequestCode, ResultCode, datos);

        //Verificar que activity me esta dando una respuesta
        switch (RequestCode){
            case ID_TERCERA:
                //La tercera activity esta notificando

                //Verificamos la ACtivity 3° finalizo de forma correcta
                if(ResultCode == RESULT_OK){
                    //Procesar datos de la activity 3....
                    String mensaje = datos.getStringExtra(TAG_MENSAJE);
                    Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
                }
                break;
            case ID_CUARTA:
                //La Cuarta activity esta notificando
                break;
        }
    }

    //EVENTOS DE LA ACTIVITY
    //=======================================
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "Ejecutando evento onStart");
    }
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "Ejecutando evento onResume");
    }
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Ejecutando evento onPause");
    }
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Ejecutando evento onStop");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Ejecutando evento onDestroy");
    }
    //=======================================
}
