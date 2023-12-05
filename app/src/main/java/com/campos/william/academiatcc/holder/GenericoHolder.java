package com.campos.william.academiatcc.holder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.campos.william.academiatcc.R;

public class GenericoHolder extends RecyclerView.ViewHolder {

    public TextView txtGenerico;
    public ImageButton btnEditar;
    public ImageButton btnExcluir;



    public GenericoHolder(View itemView) {
        super(itemView);
        txtGenerico = itemView.findViewById(R.id.nomeCliente);
        btnEditar = itemView.findViewById(R.id.btnEdit);
        btnExcluir = itemView.findViewById(R.id.btnDelete);



    }




}
