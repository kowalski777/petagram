package com.estebangarriga.petagram;

public class Mascota {
    private int foto;
    private int likes = 0;
    private String nombre;



    public Mascota(int foto, int likes, String nombre){
        this.foto = foto;
        this.likes = likes;
        this.nombre = nombre;
    }
    public int getFoto() {
        return foto;
    }
    public void setFoto(int foto) {
        this.foto = foto;
    }
    public String getNombre() {
        return nombre;
    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}