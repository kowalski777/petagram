package com.estebangarriga.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar); //barra de navegacion
        setSupportActionBar(miActionBar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        //listaMascotas.setLayoutManager(glm);
        listaMascotas.setLayoutManager(llm);
        inicializarlistaMascotas();
        inicializaAdaptador();

    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarlistaMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.mascota1, 0, "Mascota 1"));
        mascotas.add(new Mascota(R.drawable.mascota2, 0, "Mascota 2"));
        mascotas.add(new Mascota(R.drawable.mascota3, 0, "Mascota 3"));
        mascotas.add(new Mascota(R.drawable.mascota4, 0, "Mascota 4"));
        mascotas.add(new Mascota(R.drawable.mascota5, 0, "Mascota 5"));
    }




    public void irSegundaActividad(View v){
        Intent intent = new Intent(this, MascotasFavoritas.class);
        startActivity(intent);
    }
}