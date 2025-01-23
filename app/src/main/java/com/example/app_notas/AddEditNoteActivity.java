package com.example.app_notas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddEditNoteActivity extends AppCompatActivity {

    FloatingActionButton btnAtras;
    FloatingActionButton btnGuardar;

    EditText titulo_editable;
    EditText contenido_editable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_note);

        btnAtras = findViewById(R.id.botonFlotanteAtras);
        btnGuardar = findViewById(R.id.botonFlotanteGuardar);
        titulo_editable = findViewById(R.id.titulo_editable);
        contenido_editable = findViewById(R.id.contenido_editable);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(AddEditNoteActivity.this, MainActivity.class);
                startActivity(intento);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = titulo_editable.getText().toString();
                String contenido = contenido_editable.getText().toString();

                Intent resultIntent = new Intent();

                resultIntent.putExtra("titulo", titulo);
                resultIntent.putExtra("contenido", contenido);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}