package com.campos.william.academiatcc.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.campos.william.academiatcc.R;

public class GenericoCadastroHolder extends  RecyclerView.ViewHolder{

    public TextView txtnome;

    public GenericoCadastroHolder(View itemView) {
        super(itemView);

        txtnome = itemView.findViewById(R.id.txtDietaNome);
    }

}
