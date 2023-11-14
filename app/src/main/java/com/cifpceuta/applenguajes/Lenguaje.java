package com.cifpceuta.applenguajes;

import android.widget.Button;
import android.widget.ImageButton;

public class Lenguaje {
    private ImageButton borrar;
    private String nombre;

    public Lenguaje(String nombre) {
        this.nombre = nombre;
    }

    public ImageButton getBorrar() {
        return borrar;
    }

    public void setBorrar(ImageButton borrar) {
        this.borrar = borrar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
