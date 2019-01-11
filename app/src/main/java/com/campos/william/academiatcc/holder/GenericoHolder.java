package com.campos.william.academiatcc.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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
