package com.estebangarriga.petagram.contacto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.estebangarriga.petagram.R;

public class FormularioContacto extends AppCompatActivity {

    EditText etNombreContacto, etMailContacto, etMensajeContacto;
    Button btnEnviarContacto;
    String  sPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_contacto);


        //Incluir mi action bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNombreContacto = (EditText) findViewById(R.id.etNombreContacto);
        etMailContacto = (EditText) findViewById(R.id.etMailContacto);
        etMensajeContacto = (EditText) findViewById(R.id.etMensajeContacto);
        btnEnviarContacto = (Button) findViewById(R.id.tvEmail);


    }

    public void enviarMail(View v){
        String email = btnEnviarContacto.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("menssage/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }


}

