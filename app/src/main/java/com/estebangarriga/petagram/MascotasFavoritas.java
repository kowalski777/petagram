package com.estebangarriga.petagram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.estebangarriga.petagram.adapter.MascotaAdaptador;
import com.estebangarriga.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaContactos;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

       //Incluir mi action bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);
        //listaContactos.setLayoutManager(glm);
        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializaAdaptador();
    }

    public void inicializaAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.mascota1, ' ', "Mascota 1"));
        mascotas.add(new Mascota(R.drawable.mascota2, ' ', "Mascota 2"));
        mascotas.add(new Mascota(R.drawable.mascota3, ' ', "Mascota 3"));
        mascotas.add(new Mascota(R.drawable.mascota4, ' ', "Mascota 4"));
        mascotas.add(new Mascota(R.drawable.mascota5, ' ', "Mascota 5"));
    }
}