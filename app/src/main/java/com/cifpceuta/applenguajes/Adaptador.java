package com.cifpceuta.applenguajes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<Lenguaje> {
    private Activity context;
    private ArrayList<Lenguaje> lenguajes;

    public Adaptador(Activity c,ArrayList<Lenguaje> lenguajes){
        super(c,R.layout.lista_lenguajes,lenguajes);
        context = c;
        this.lenguajes = lenguajes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View fila =  inflater.inflate(R.layout.lista_lenguajes,parent,false);

        Lenguaje l = lenguajes.get(position);
        ImageButton btnBorrar;
        TextView nombre;

        btnBorrar = (ImageButton) fila.findViewById(R.id.btnBorrar);
        nombre = (TextView) fila.findViewById(R.id.txt);

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lenguajes.remove(l);
                actualizar();
            }
        });

        nombre.setText(l.getNombre());
        return fila;
    }
    public void actualizar(){
        this.notifyDataSetChanged();
    }

    public void setLenguajes(ArrayList<Lenguaje> lenguajes) {
        this.lenguajes = lenguajes;
    }
}
