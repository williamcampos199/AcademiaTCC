package com.campos.william.academiatcc.adapter;

import android.annotation.SuppressLint;
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
import com.campos.william.academiatcc.activity.RefeicaoEditarActivity;
import com.campos.william.academiatcc.banco.dao.DietaDAO;
import com.campos.william.academiatcc.banco.model.Dieta;
import com.campos.william.academiatcc.holder.GenericoHolder;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class DietaAdapter  extends RecyclerView.Adapter<GenericoHolder>{

    private final List<Dieta> dietas;


    public DietaAdapter(List<Dieta> dietas){
        this.dietas = dietas;
    }


    @NonNull
    @Override
    public GenericoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return new GenericoHolder(LayoutInflater.from(parent.getContext())
                             .inflate(R.layout.item_lista,parent ,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final GenericoHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.txtGenerico.setText(dietas.get(position).getNome());

        holder.btnEditar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dieta  dieta =  dietas.get(position);
                Activity activity = getActivity(v);
                Intent intent =  new Intent(getActivity(v), RefeicaoEditarActivity.class);
                intent.putExtra("dieta",dieta);
                activity.startActivity(intent);


            }
        });

        holder.btnExcluir.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = v;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Confirmação")
                        .setMessage("Tem certeza que deseja excluir esta Dieta")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Dieta dieta = dietas.get(position);
                                DietaDAO dao = new DietaDAO(view.getContext());
                                boolean sucesso = dao.Delete(dieta.getIdDieta());
                                if(sucesso){
                                    removerDieta(dieta);
                                    Snackbar.make(view , "Excluiu!",Snackbar.LENGTH_LONG)
                                            .setAction("Action",null).show();
                                }else {

                                    Snackbar.make(view , "Erro ao excluir a Dieta!",Snackbar.LENGTH_LONG)
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
        return dietas != null ? dietas.size() : 0;
    }


    public void adicionarDieta(Dieta dieta){
        dietas.add(dieta);
        notifyItemInserted(getItemCount());
    }

    public void atualizarDieta(Dieta dieta){

        dietas.set(dietas.indexOf(dieta) ,dieta);
        notifyItemChanged(dietas.indexOf(dieta));
    }

    public void removerDieta(Dieta dieta){
        int position = dietas.indexOf(dieta);
        dietas.remove(dieta);
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
