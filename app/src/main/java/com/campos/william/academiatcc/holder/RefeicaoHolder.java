package com.campos.william.academiatcc.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.campos.william.academiatcc.R;

public class RefeicaoHolder extends RecyclerView.ViewHolder{

    public TextView txtAlimento;
    public TextView txtCalorias;
    public TextView txtQuantidade;
    public TextView txtQuantidadeAlimento;
    public Button  btnMais;
    public Button  btnMenos;
    public CheckBox chkAlimento;

    public RefeicaoHolder(View itemView) {
        super(itemView);
        txtAlimento = itemView.findViewById(R.id.textView_alimento);
        txtCalorias = itemView.findViewById(R.id.textView_calorias);
        txtQuantidade = itemView.findViewById(R.id.textView_quantidade);
        txtQuantidadeAlimento = itemView.findViewById(R.id.textView_quantidade_alimentos);
        btnMais = itemView.findViewById(R.id.button_mais_alimento);
        btnMenos = itemView.findViewById(R.id.button_menos_alimento);
        chkAlimento = itemView.findViewById(R.id.checkBox_alimento);


    }
}
