package com.example.app_notas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public abstract class Adaptador extends BaseAdapter {
    private ArrayList<?> entrada_nota;
    private int R_layout_IdView;
    private Context contexto;

    public Adaptador(Context contexto, int r_layout_IdView, ArrayList<?> entrada_nota) {
        this.contexto = contexto;
        R_layout_IdView = r_layout_IdView;
        this.entrada_nota = entrada_nota;
    }

    public abstract void onEntrada(Object entrada, View view);

    @Override
    public int getCount() {
        return entrada_nota.size();
    }

    @Override
    public Object getItem(int posicion) {
        return entrada_nota.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }

    public View getView(int posicion, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R_layout_IdView, parent, false);
        }
        onEntrada(entrada_nota.get(posicion), view);
        return view;
    }
}
