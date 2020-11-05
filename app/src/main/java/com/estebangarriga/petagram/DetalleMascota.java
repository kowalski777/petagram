package com.estebangarriga.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetalleMascota extends AppCompatActivity {

    private TextView tvNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        Bundle parametros = getIntent().getExtras();
        String nombre       = parametros.getString(getResources().getString(R.string.pnombre));//nombre
        tvNombre   = (TextView) findViewById(R.id.tvNombre);
        tvNombre.setText(nombre);

    }
}