package com.campos.william.academiatcc.adapter;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.banco.dao.DietaDAO;
import com.campos.william.academiatcc.banco.dao.ItemAlimentoDAO;
import com.campos.william.academiatcc.banco.model.Alimento;
import com.campos.william.academiatcc.banco.model.ItemAlimento;
import com.campos.william.academiatcc.holder.RefeicaoHolder;

import java.util.List;

public class RefeicaoAdapter extends RecyclerView.Adapter<RefeicaoHolder> {


    private final List<Alimento> alimentos;


    public RefeicaoAdapter(List<Alimento> alimentos){
        this.alimentos = alimentos;
    }


    @NonNull
    @Override
    public RefeicaoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RefeicaoHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_refeicao,parent ,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final RefeicaoHolder holder, final int position) {

        holder.txtAlimento.setText(alimentos.get(position).getNome());
        holder.txtCalorias.setText(alimentos.get(position).getCalorias() +" calorias");
        holder.txtQuantidade.setText("Quantidade");
        holder.txtQuantidadeAlimento.setText("1");


        holder.btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int quantidade = Integer.parseInt(holder.txtQuantidadeAlimento.getText().toString());
                if(quantidade > 0){
                    quantidade --;
                }
                holder.txtQuantidadeAlimento.setText(quantidade + "");


            }
        });

        holder.btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantidade = Integer.parseInt(holder.txtQuantidadeAlimento.getText().toString());
                quantidade ++;
                holder.txtQuantidadeAlimento.setText(quantidade + "");


            }
        });

        final Alimento alimento = alimentos.get(position);

        holder.chkAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ItemAlimento itemAlimento = new ItemAlimento();

               double calorias = Double.parseDouble(holder.txtCalorias.getText().toString().replace(" calorias",""));
                int quantidade =  Integer.parseInt(holder.txtQuantidadeAlimento.getText().toString());

                DietaDAO dietaDAO = new DietaDAO(getActivity(v));
                int idDieta = dietaDAO.SelectUltimoRegistro().getIdDieta();


                if(holder.chkAlimento.isChecked()){




                    itemAlimento.setIdAlimento(alimento.getIdAlimento());
                    itemAlimento.setQuantidade(quantidade);
                    itemAlimento.setCalorias(quantidade * calorias );
                    itemAlimento.setIdDieta(idDieta);
                    ItemAlimentoDAO itemAlimentoDAO = new ItemAlimentoDAO(getActivity(v));
                    itemAlimentoDAO.Insert(itemAlimento);
                }


            }
        });


    }

    @Override
    public int getItemCount() {
        return alimentos != null ? alimentos.size() : 0;
    }





    private AppCompatActivity getActivity(View  view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }

        return null;
    }





}
