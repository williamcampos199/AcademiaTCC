package com.campos.william.academiatcc.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.campos.william.academiatcc.R;

public class PerfilHolder extends RecyclerView.ViewHolder {

    public TextView txtNomeAluno;
    public TextView txtSexoAluno;
    public TextView txtIdadeAluno;
    public TextView txtObjetivoAluno;
    public TextView txtPesoAluno;
    public TextView txtIMCAluno;



    public PerfilHolder(View itemView) {
        super(itemView);
        txtNomeAluno = itemView.findViewById(R.id.textView_nome_aluno);
        txtSexoAluno = itemView.findViewById(R.id.textView_sexo_aluno);
        txtIdadeAluno = itemView.findViewById(R.id.textView_idade_aluno);
        txtObjetivoAluno = itemView.findViewById(R.id.textView_objetivo_aluno);
        txtPesoAluno = itemView.findViewById(R.id.textView_peso_aluno);
        txtIMCAluno = itemView.findViewById(R.id.textView_imc_aluno);


    }
}
