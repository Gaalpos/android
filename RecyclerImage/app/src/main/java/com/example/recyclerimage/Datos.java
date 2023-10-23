package com.example.recyclerimage;

import java.util.ArrayList;
import java.util.List;

public class Datos {

    String nombre;
    String descripcion;




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

    public static List<Datos> poblarDatos(){
        List<Datos> lista = new ArrayList<>();
        for(int i=0;i<15;i++){
            Datos datos = new Datos("pais"+i,"descripcion:"+i );
            lista.add(datos);
        }
        return lista;
    }
}
