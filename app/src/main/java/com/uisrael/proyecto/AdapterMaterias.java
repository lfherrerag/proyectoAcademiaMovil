package com.uisrael.proyecto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMaterias extends RecyclerView.Adapter<AdapterMaterias.ViewHolderMaterias> {

    List<ConsMaterias>consMateriasList;

    public AdapterMaterias(Materias materias,List<ConsMaterias>consMateriasList){
        this.consMateriasList=consMateriasList;
    }

    @NonNull
    @Override
    public ViewHolderMaterias onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.materias_list,parent,false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);

        return new AdapterMaterias.ViewHolderMaterias(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMaterias holder, int position) {
        holder.txtnomMateria.setText(consMateriasList.get(position).getNomMateria());
    }

    @Override
    public int getItemCount() {
        return consMateriasList.size();
    }

    public class ViewHolderMaterias extends RecyclerView.ViewHolder {
        public TextView txtnomMateria;

        public ViewHolderMaterias(@NonNull View itemView) {
            super(itemView);
            txtnomMateria=itemView.findViewById(R.id.txtnomMateria);
        }
    }
}
