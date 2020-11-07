package com.estebangarriga.petagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.estebangarriga.petagram.R;

import com.estebangarriga.petagram.adapter.MiMascotaAdaptador;
import com.estebangarriga.petagram.pojo.Mascota;



import java.util.ArrayList;



public class PerfilFragment extends Fragment {

    private RecyclerView rvMiMascota;
    private MiMascotaAdaptador adaptador;
    private ArrayList<Mascota> mascotas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        //Crear mi recyclerview , y asignarle un un Administrador de layout
        rvMiMascota = (RecyclerView) v.findViewById(R.id.rvMiMascota);
        rvMiMascota.setHasFixedSize(true);
        //LinearLayoutManager llm = new LinearLayoutManager(getContext());
        GridLayoutManager llm = new GridLayoutManager(getContext(),3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMiMascota.setLayoutManager(llm);



        //Inicializar lista de mascotas
        inicializarListaMascotas();

        //Inicializar adaptador
        inicializarAdaptador();

        return v;
    }

    public void inicializarListaMascotas(){
        //Por ahora hardcodeamos la lista con mascotas agregadas por nosotros

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota( "Mascota 1", R.drawable.mascota1,6 ));
        mascotas.add(new Mascota( "Mascota 2", R.drawable.mascota2,1 ));
        mascotas.add(new Mascota( "Mascota 3", R.drawable.mascota3,6 ));
        mascotas.add(new Mascota( "Mascota 4", R.drawable.mascota4,2 ));
        mascotas.add(new Mascota( "Mascota 5", R.drawable.mascota5,4 ));

    }

    public void inicializarAdaptador(){
        adaptador = new MiMascotaAdaptador(mascotas, getActivity());
        rvMiMascota.setAdapter(adaptador);

    }
}