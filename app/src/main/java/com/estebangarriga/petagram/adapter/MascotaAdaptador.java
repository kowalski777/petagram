package com.estebangarriga.petagram.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.estebangarriga.petagram.R;
import com.estebangarriga.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> Arrmascotas;
    Activity activity;
    static int likesM1;
    static int likesM2;
    static int likesM3;
    static int likesM4;
    static int likesM5;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.Arrmascotas = mascotas;
        this.activity = activity;
    }

    //Inflar el layout y lo pasara al viewholder para que el obtenga los views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = Arrmascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());


        mascotaViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener(){
            private TextView M3; private TextView M4; private TextView M5;
            @Override
            public void onClick(View v){
                if(mascota.getNombre() == "Mascota 1"){
                    likesM1++;
                    Toast.makeText(activity, "Diste un like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    TextView m1 = mascotaViewHolder.itemView.findViewById(R.id.tvlike);
                    m1.setText(""+likesM1);
                }
                if(mascota.getNombre() == "Mascota 2"){
                    likesM2++;
                    Toast.makeText(activity, "Diste un like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    TextView m2 = mascotaViewHolder.itemView.findViewById(R.id.tvlike);
                    m2.setText(""+likesM2);
                }
                if(mascota.getNombre() == "Mascota 3"){
                    likesM3++;
                    Toast.makeText(activity, "Diste un like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    M3 = mascotaViewHolder.itemView.findViewById(R.id.tvlike);
                    M3.setText(""+likesM3);
                }
                if(mascota.getNombre() == "Mascota 4"){
                    likesM4++;
                    Toast.makeText(activity, "Diste un like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    M4 = mascotaViewHolder.itemView.findViewById(R.id.tvlike);
                    M4.setText(""+likesM4);
                }
                if(mascota.getNombre() == "Mascota 5"){
                    likesM5++;
                    Toast.makeText(activity, "Diste un like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    M5 = mascotaViewHolder.itemView.findViewById(R.id.tvlike);
                    M5.setText(""+likesM5);
                }
            }
        });
    }


    @Override
    public int getItemCount() { // Cantidad de elementos que contiene mi lista
        return Arrmascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton btnLikeCV;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto      =(ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV   =(TextView) itemView.findViewById(R.id.tvNombreCV);
            btnLikeCV    =(ImageButton) itemView.findViewById(R.id.btnLike);
        }

      /*
        public static int[] MiClase(){
            megusta[0] = likesM1;
            megusta[1] = likesM2;
            megusta[2] = likesM3;
            megusta[3] = likesM4;
            megusta[4] = likesM5;
            return megusta;
        }
        */


    }


}