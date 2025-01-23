package com.example.app_notas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewNoteActivity extends AppCompatActivity {

    FloatingActionButton btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        btnAtras = findViewById(R.id.botonFlotanteAtras);

        Intent intent = getIntent();
        String titulo_detalle = intent.getStringExtra("titulo");
        String contenido_detalle = intent.getStringExtra("contenido");

        TextView textoTitulo = findViewById(R.id.texto_titulo_detalle);
        TextView textoContenido = findViewById(R.id.texto_contenido_detalle);

        textoTitulo.setText(titulo_detalle);
        textoContenido.setText(contenido_detalle);


        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(ViewNoteActivity.this, MainActivity.class);
                startActivity(intento);
            }
        });


    }
}