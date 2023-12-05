package com.campos.william.academiatcc.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.campos.william.academiatcc.R;

public class GenericoCadastroHolder extends RecyclerView.ViewHolder {///RecyclerView.ViewHolder{

    public TextView txtnome;

    public GenericoCadastroHolder(View itemView) {
        super(itemView);

        txtnome = itemView.findViewById(R.id.txtDietaNome);
    }

}
