package com.campos.william.academiatcc.holder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.campos.william.academiatcc.R;

public class TreinoDiaHolder extends RecyclerView.ViewHolder{
    public TextView textViewExercicio;
    public TextView textViewObs;
    public TextView textViewRepeticoes;
    public CheckBox checkBoxExercicio;


    public TreinoDiaHolder(View itemView) {
        super(itemView);
        textViewExercicio = itemView.findViewById(R.id.textView_exercicio_treino);
        textViewObs = itemView.findViewById(R.id.textView_obs_treino);
        textViewRepeticoes = itemView.findViewById(R.id.textView_repeticoes_treino);
        checkBoxExercicio = itemView.findViewById(R.id.checkBox_treino);

    }
}
