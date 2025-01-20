package com.example.app_notas;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton botonAgregar;
    private ArrayList<Nota> notas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        botonAgregar = findViewById(R.id.botonFlotante);

        ArrayList<Nota> notas = new ArrayList<Nota>();
        notas.add(new Nota("Primera nota", "Probando el adapter"));
        notas.add(new Nota("COMPRA", "Huevos, tomate, chorizo"));
        notas.add(new Nota("Contraseñas", "GitHub: 1234"));

        recyclerView.setAdapter(new Adaptador(this, R.layout.entrada, notas) {
            @Override
            public void onEntrada(Object entrada, View view) {

            }
        }
    }

    public class Nota {
        private String titulo;
        private String contenido;

        public Nota(String titulo, String contenido) {
            this.titulo = titulo;
            this.contenido = contenido;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getContenido() {
            return contenido;
        }

        public void setContenido(String contenido) {
            this.contenido = contenido;
        }
    }
}