package com.estebangarriga.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import com.estebangarriga.petagram.R;
import com.estebangarriga.petagram.pojo.Mascota;
import java.util.ArrayList;

public class ConstructorMascotas {

    private static final  int LIKE =1;
    private Context context;
    public ConstructorMascotas(Context context) {
    this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarAlgunaMascota(db);
        return db.obtenerTodaslasMascotas();

    }

    public void insertarAlgunaMascota(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Mascota 1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.mascota1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKES, 4);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Mascota 2");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.mascota2);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKES, 5);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Mascota 3");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.mascota3);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKES, 5);
        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);

    }

    public int obtenerLikesMascota (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);



    }

}
