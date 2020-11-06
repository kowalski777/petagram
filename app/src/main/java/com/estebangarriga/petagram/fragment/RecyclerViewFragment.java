package com.estebangarriga.petagram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.estebangarriga.petagram.R;
import com.estebangarriga.petagram.adapter.MascotaAdaptador;
import com.estebangarriga.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);
        //listaMascotas.setLayoutManager(glm);
        listaMascotas.setLayoutManager(llm);
        inicializarlistaMascotas();
        inicializaAdaptador();

        return v;
    }

    public void inicializarlistaMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.mascota1, 0, "Mascota 1"));
        mascotas.add(new Mascota(R.drawable.mascota2, 0, "Mascota 2"));
        mascotas.add(new Mascota(R.drawable.mascota3, 0, "Mascota 3"));
        mascotas.add(new Mascota(R.drawable.mascota4, 0, "Mascota 4"));
        mascotas.add(new Mascota(R.drawable.mascota5, 0, "Mascota 5"));
    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }
}
