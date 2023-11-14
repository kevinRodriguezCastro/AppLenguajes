package com.cifpceuta.applenguajes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private EditText lenguaje;
    private Button btnAñadir;
    ArrayList<Lenguaje> lenguajes;
    ImageButton btnBorrar;
    Adaptador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);
        lenguaje = (EditText) findViewById(R.id.etLenguaje);
        btnAñadir = (Button) findViewById(R.id.btnAñadir);
        lenguajes = new ArrayList<>();
        // android.R.layout.simple_spinner_dropdown_item
        adapter = new Adaptador(this,lenguajes);
        //adapter = new ArrayAdapter<>(this,R.layout.lista_lenguajes,R.id.txt,lenguajes);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // lenguajes.remove(lenguajes.get(position));
               // adapter.notifyDataSetChanged();
            }
        });
        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               añadirLenguaje(v);
            }
        });

    }
    public void añadirLenguaje(View v){
        lenguajes.add(new Lenguaje(lenguaje.getText().toString()));
        lenguajes.sort(new Comparator<Lenguaje>() {
            public int compare(Lenguaje obj1, Lenguaje obj2) {
                return obj1.getNombre().compareTo(obj2.getNombre());
            }
        });
        adapter.setLenguajes(lenguajes);
        adapter.notifyDataSetChanged();
    }
}