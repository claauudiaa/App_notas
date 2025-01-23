package com.example.app_notas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private FloatingActionButton botonAgregar;
    private ArrayList<Nota> notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listView);
        botonAgregar = findViewById(R.id.botonFlotante);

        notas = new ArrayList<Nota>();
        notas.add(new Nota("Primera nota", "Probando el adapter"));
        notas.add(new Nota("COMPRA", "Huevos, tomate, chorizo"));
        notas.add(new Nota("Contraseñas", "GitHub: 1234"));

        listView.setAdapter(new Adaptador(this, R.layout.entrada, notas) {
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_titulo = (TextView) view.findViewById(R.id.texto_titulo);
                    TextView texto_contenido = (TextView) view.findViewById(R.id.texto_contenido);

                    texto_titulo.setText(((Nota) entrada).getTitulo());
                    texto_contenido.setText(((Nota) entrada).getContenido());

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Nota selectedNota = notas.get(position);

                            Intent intent = new Intent(MainActivity.this, ViewNoteActivity.class);

                            intent.putExtra("titulo", selectedNota.getTitulo());
                            intent.putExtra("contenido", selectedNota.getContenido());

                            startActivity(intent);
                        }
                    });

                    botonAgregar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intento = new Intent(MainActivity.this, AddEditNoteActivity.class);
                            startActivityForResult(intento, 1);
                        }
                    });

                }
            }
        });
    }
    
    // Metodo completo de chatgpt
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 1 && resultCode == RESULT_OK) {

                String titulo = data.getStringExtra("titulo");
                String contenido = data.getStringExtra("contenido");

                Nota nuevaNota = new Nota(titulo, contenido);
                notas.add(nuevaNota);

                ((Adaptador) listView.getAdapter()).notifyDataSetChanged();
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