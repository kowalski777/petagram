package com.estebangarriga.petagram.contacto;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.estebangarriga.petagram.R;


public class About extends AppCompatActivity {

    //ImageView fotoPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar); //barra de navegacion
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         /*
         Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
         setSupportActionBar(miActionBar);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        */
         //fotoPerfil = (ImageView) findViewById(R.id.);
         //fotoPerfil.setImageResource(R.drawable.icono_persona);



    }

}