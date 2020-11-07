package com.estebangarriga.petagram.fragment;

import com.estebangarriga.petagram.adapter.MascotaAdaptador;
import com.estebangarriga.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
