package com.campos.william.academiatcc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.activity.AlimentoCadastroActivity;
import com.campos.william.academiatcc.banco.dao.AlimentoDAO;
import com.campos.william.academiatcc.banco.model.Alimento;
import com.campos.william.academiatcc.holder.GenericoHolder;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;

public class AlimentoAdapter extends RecyclerView.Adapter<GenericoHolder> {
    private final List<Alimento> alimentos;


    public AlimentoAdapter(List<Alimento> alimentos){
        this.alimentos = alimentos;
    }


    @NonNull
    @Override
    public GenericoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GenericoHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista,parent ,false));

    }

    @Override
    public void onBindViewHolder(@NonNull GenericoHolder holder, final int position) {

        holder.txtGenerico.setText(alimentos.get(position).getNome());

        holder.btnEditar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Alimento alimento =  alimentos.get(position);
                Activity activity = (Activity) getActivity(v);
                Intent intent = new Intent (  getActivity(v) , AlimentoCadastroActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("alimento",alimento);
                activity.startActivity(intent);


            }
        });

        holder.btnExcluir.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = v;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Confirmação")
                        .setMessage("Tem certeza que deseja excluir este alimento")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               Alimento alimento = alimentos.get(position);
                                AlimentoDAO dao = new AlimentoDAO(view.getContext());
                                boolean sucesso = dao.Delete( alimento.getIdAlimento());
                                if(sucesso){
                                    removerDieta(alimento);
                                    Snackbar.make(view , "Excluiu!",Snackbar.LENGTH_LONG)
                                            .setAction("Action",null).show();
                                }else {

                                    Snackbar.make(view , "Erro ao excluir o alimento!",Snackbar.LENGTH_LONG)
                                            .setAction("Action",null).show();
                                }


                            }
                        })
                        .setNegativeButton("Cancelar",null)
                        .create()
                        .show();
            }
        });








    }

    @Override
    public int getItemCount() {
        return alimentos != null ? alimentos.size() : 0;
    }


    public void adicionarDieta(Alimento alimento){
        alimentos.add(alimento);
        notifyItemInserted(getItemCount());
    }

    public void atualizarDieta(Alimento alimento){

                alimentos.set(alimentos.indexOf(alimento) ,alimento);
        notifyItemChanged(alimentos.indexOf(alimento));
    }

    public void removerDieta(Alimento alimento){
        int position = alimentos.indexOf(alimento);
        alimentos.remove(alimento);
        notifyItemRemoved(position);

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
