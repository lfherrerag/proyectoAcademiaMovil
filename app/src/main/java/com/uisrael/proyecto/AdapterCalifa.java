package com.uisrael.proyecto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCalifa extends RecyclerView.Adapter<AdapterCalifa.ViewHolderCalifica> {

    List<ConsCalifica>calificaList;

    public AdapterCalifa(Calificaciones calificaciones,List<ConsCalifica>calificaList){
        this.calificaList=calificaList;
    }


    @NonNull
    @Override
    public AdapterCalifa.ViewHolderCalifica onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.califica_list,parent,false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);

        return new AdapterCalifa.ViewHolderCalifica(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCalifa.ViewHolderCalifica holder, int position) {
        holder.txvmateria.setText(calificaList.get(position).getMateria());
        holder.txvprimerp.setText(calificaList.get(position).getPrimer_Parcial());
        holder.txvsegundop.setText(calificaList.get(position).getSegundo_Parcial());
        holder.txvNotaf.setText(calificaList.get(position).getNota_Final());
    }

    @Override
    public int getItemCount() {
        return calificaList.size();
    }

    public class ViewHolderCalifica extends RecyclerView.ViewHolder {
        public TextView txvmateria,txvprimerp,txvsegundop,txvNotaf;
        public ViewHolderCalifica(@NonNull View itemView) {
            super(itemView);
            txvmateria=itemView.findViewById(R.id.txvmateria);
            txvprimerp=itemView.findViewById(R.id.txvprimerp);
            txvsegundop=itemView.findViewById(R.id.txvsegundop);
            txvNotaf=itemView.findViewById(R.id.txvNotaf);
        }
    }
}
