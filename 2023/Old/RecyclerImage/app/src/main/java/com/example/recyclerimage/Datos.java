package com.example.recyclerimage;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

public class Datos {

    String nombre;
    String descripcion;

    Image imagen;
    Image avatar;

    public Datos(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Image getImagen(){
        return imagen;
    }


    public static List<Datos> poblarDatos(){
        List <Datos> lista = new ArrayList<>();
        for (int i =1; i <16;i++){
            int avatar = R.drawable.avatar_1;
            Datos datos = new Datos("pais"+i, "descripcion"+i, avatar+i);
            lista.add(datos);
        }
    }

    /*
    public static List<Datos> poblarDatos(){
        List<Datos> lista = new ArrayList<>();
        String nom;
        for(int i=0;i<15;i++){
            nom="avatar_"+String.valueOf(i)+".xml";
            //Datos datos = new Datos("pais"+i,"descripcion:"+i );
            Datos datos = new Datos("Pais: "+i, "Descripcion"+i,
                    context.getPackage() );
            lista.add(datos);
        }
        return lista;
    }
    */

}
