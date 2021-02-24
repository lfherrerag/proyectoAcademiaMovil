package com.uisrael.proyecto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

public class AdapterTareas extends RecyclerView.Adapter<AdapterTareas.ViewHolderTareas> {

    List<ConsTareas>tareasList;

    public AdapterTareas(Tareas tareas,List<ConsTareas>tareasList){
        this.tareasList=tareasList;
    }
    @NonNull
    @Override
    public ViewHolderTareas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.tarea_list,parent,false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);

        return new ViewHolderTareas(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTareas holder, int position) {
        holder.txtMateria.setText(tareasList.get(position).getMateria());
        holder.txtDetalle.setText(tareasList.get(position).getDetalle());
        holder.txtFechai.setText(tareasList.get(position).getFechai());
        holder.txtFechaf.setText(tareasList.get(position).getFechaf());
    }

    @Override
    public int getItemCount() {
        return tareasList.size();
    }

    public class ViewHolderTareas extends RecyclerView.ViewHolder {
        public TextView txtMateria, txtDetalle,txtFechai,txtFechaf;

        public ViewHolderTareas(@NonNull View itemView) {
            super(itemView);
            txtMateria=itemView.findViewById(R.id.txtMateria);
            txtDetalle=itemView.findViewById(R.id.txtDetalle);
            txtFechai=itemView.findViewById(R.id.txtFechai);
            txtFechaf=itemView.findViewById(R.id.txtFechaf);

        }
    }
}
