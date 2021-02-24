package com.uisrael.proyecto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ListaViewHolder> {

List<Lalista> lalistas;

public Adapter(Listado listado, List<Lalista> lalistas){
    this.lalistas=lalistas;
}

    @NonNull
    @Override
    public Adapter.ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View vista=LayoutInflater.from(parent.getContext()).inflate(R.layout.prueba_lista,parent,false);
    RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
    vista.setLayoutParams(layoutParams);

        return new ListaViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ListaViewHolder holder, int position) {

        holder.tvNombre.setText(lalistas.get(position).getNombre());
        //holder.tvApellido.setText(lalistas.get(position).getApellido());

    }

    @Override
    public int getItemCount() {
        return lalistas.size();
    }

    public class ListaViewHolder extends RecyclerView.ViewHolder {

    TextView tvNombre,tvApellido;
        public ListaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre=itemView.findViewById(R.id.tvNombre);
            //tvApellido=itemView.findViewById(R.id.tvApellido);

        }
    }
}