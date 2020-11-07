package com.estebangarriga.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.estebangarriga.petagram.pojo.Mascota;
import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " +ConstantesBaseDatos.TABLE_MASCOTAS
                                                       +"("
                                                       +ConstantesBaseDatos.TABLE_MASCOTA_ID       +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                       +ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE   +" TEXT, "
                                                       +ConstantesBaseDatos.TABLE_MASCOTA_FOTO     +" INTEGER, "
                                                       +ConstantesBaseDatos.TABLE_MASCOTA_LIKES    +" INTEGER"
                                                       +")";

        String queryCrearLikeMascota = "CREATE TABLE " +ConstantesBaseDatos.TABLE_LIKES_MASCOTAS
                                                            +"( "
                                                            +ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID              +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                            +ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA       +" INTEGER, "
                                                            +ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES     +" INTEGER, "
                                                            +"FOREIGN KEY (" +ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA +") "
                                                            +"REFERENCES "+ ConstantesBaseDatos.TABLE_MASCOTAS  +"("+ConstantesBaseDatos.TABLE_MASCOTA_ID+") "
                                                            +")";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearLikeMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS);
        onCreate(db);
    }
    public ArrayList<Mascota> obtenerTodaslasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " +ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setLikes(registros.getInt(3));
            mascotas.add(mascotaActual);
         }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS, null, contentValues);
        db.close();
    }
    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+")"+
                        " FROM " +ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                        " WHERE "+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA +" ="+mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

            if(registros.moveToNext()){
                likes = registros.getInt(0);
            }
            return likes;
    }
}
