package com.estebangarriga.petagram.presentador;

import android.content.Context;

import com.estebangarriga.petagram.db.ConstructorMascotas;
import com.estebangarriga.petagram.fragment.IRecyclerViewFragmentView;
import com.estebangarriga.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();

    }

    @Override
    public void  obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        constructorMascotas.obtenerDatos();
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();


    }
}
