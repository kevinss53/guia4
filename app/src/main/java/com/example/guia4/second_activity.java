package com.example.guia4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.inmite.android.lib.validations.form.FormValidator;
import eu.inmite.android.lib.validations.form.annotations.MinLength;
import eu.inmite.android.lib.validations.form.annotations.NotEmpty;
import eu.inmite.android.lib.validations.form.callback.SimpleErrorPopupCallback;

import static  com.example.guia4.MainActivity.listacontactos;
import  Entidades.Contactos;
import static com.example.guia4.MainActivity.lista;


public class second_activity extends AppCompatActivity implements View.OnClickListener {


    // varianles
    String organizacion;
    String nombre;
    String numero;

    @BindView(R.id.edtNombre)
    @NotEmpty(messageId = R.string.Validarnomnre, order = 1)
    EditText edtNombre;

    @BindView(R.id.edtTel)
    @NotEmpty(messageId =R.string.ValidarTelefono, order = 2)
    @MinLength(value = 8, messageId = R.string.Tamanio,order=3)
    EditText edtTel;

    @BindView(R.id.edtOrg)
    @NotEmpty(messageId =R.string.ValidarOrganizacion, order = 4)
    EditText edtOrg;

    @BindView(R.id.btnGuardar)
    Button btnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnGuardar:{
                if(FormValidator.validate(this, new SimpleErrorPopupCallback(this))){

                    nombre = edtNombre.getText().toString();
                    organizacion = edtOrg.getText().toString();
                    numero = edtTel.getText().toString();
                    Contactos c = new Contactos();

                    c.setNombre(nombre);
                    c.setOrganizacion(organizacion);
                    c.setNumero(numero);
                    listacontactos.add(c);
                    int numero = listacontactos.size();
                    finish();
                }
            }
            break;
        }

    }
}
