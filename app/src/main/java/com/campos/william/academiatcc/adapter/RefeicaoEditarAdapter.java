package com.campos.william.academiatcc.adapter;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.banco.dao.AlimentoDAO;
import com.campos.william.academiatcc.banco.model.Alimento;
import com.campos.william.academiatcc.banco.model.ItemAlimento;
import com.campos.william.academiatcc.holder.RefeicaoHolder;

import java.util.List;

public class RefeicaoEditarAdapter extends RecyclerView.Adapter<RefeicaoHolder> {

    private final List<ItemAlimento>  itemAlimentos;


    public RefeicaoEditarAdapter(List<ItemAlimento> itemAlimentos){
        this.itemAlimentos = itemAlimentos;
    }




    @NonNull
    @Override
    public RefeicaoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RefeicaoHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_refeicao,parent ,false));

    }


    @Override
    public void onBindViewHolder(@NonNull final RefeicaoHolder holder, final int position) {

        AlimentoDAO alimentoDAO = new AlimentoDAO(getActivity( holder.itemView));
        Alimento alimento = alimentoDAO.SelectByID(itemAlimentos.get(position).getIdAlimento());

        holder.txtAlimento.setText(alimento.getNome());
        holder.txtCalorias.setText(alimento.getCalorias() + " calorias");
        holder.txtQuantidade.setText("Quantidade");
        holder.txtQuantidadeAlimento.setText("1");


        holder.btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int quantidade = Integer.parseInt(holder.txtQuantidadeAlimento.getText().toString());
                if (quantidade > 0) {
                    quantidade--;
                }
                holder.txtQuantidadeAlimento.setText(quantidade + "");


            }
        });

        holder.btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantidade = Integer.parseInt(holder.txtQuantidadeAlimento.getText().toString());
                quantidade++;
                holder.txtQuantidadeAlimento.setText(quantidade + "");


            }
        });




    }




    @Override
    public int getItemCount() {
        return itemAlimentos != null ? itemAlimentos.size() : 0;
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
