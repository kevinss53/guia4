package com.example.guia4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import Adaptador.adaptad;
import Entidades.Contactos;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {


    public static  List<String> lista = new ArrayList<>();
    public  static  List<Contactos> listacontactos = new ArrayList<>();

   @BindView(R.id.fabadd)
    FloatingActionButton fab;

   @BindView(R.id.listax)
    ListView listaxx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       // fab.setOnClickListener(this);
        ButterKnife.bind(this);

        // por si hay algo en la  lista de datos de contactos
        if(listacontactos.size()>0)
        {
            this.listaxx.setAdapter(new adaptad(this,R.layout.plantilla,listacontactos));
        }


    }

    // utilizamos este metodo para llamar a los metodos cuando finalice la segunda activity
    @Override public void onResume(){ super.onResume();

        if(listacontactos.size()>0)
        {
            this.listaxx.setAdapter(new adaptad(this,R.layout.plantilla,listacontactos));
        }
    // put your code here...
         }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.fabadd:
            {
                Intent segunda = new Intent(this, second_activity.class);
                startActivity(segunda);
                break;
            }
            case R.id.btnprogramador:
            {
                Intent programador = new Intent(this, programador.class);
                startActivity(programador);
                break;

            }
        }

    }
}
