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
import com.estebangarriga.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.estebangarriga.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{
    //ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);
        //listaMascotas.setLayoutManager(glm);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);

    }
}
