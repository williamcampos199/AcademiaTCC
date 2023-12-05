package com.campos.william.academiatcc.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.banco.model.Peso;
import com.campos.william.academiatcc.holder.GenericoHolder;

import java.util.List;

public class PesoAdapter extends RecyclerView.Adapter<GenericoHolder> {
    private List<Peso> pesos;


    public  PesoAdapter(List<Peso> pesos){
        this.pesos = pesos;
    }

    @NonNull
    @Override
    public GenericoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GenericoHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista,parent ,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GenericoHolder holder, int position) {

        Peso peso = pesos.get(position);
        holder.txtGenerico.setText(peso.getValor()+" Kg");


    }

    @Override
    public int getItemCount() {
        return pesos.size();
    }








}
