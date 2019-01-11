package com.campos.william.academiatcc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.activity.ExercicioCadastroActivity;
import com.campos.william.academiatcc.banco.dao.ExercicioDAO;
import com.campos.william.academiatcc.banco.model.Exercicio;
import com.campos.william.academiatcc.holder.GenericoHolder;

import java.util.List;

public class ExercicioCadastroAdapter extends RecyclerView.Adapter<GenericoHolder> {

    private final List<Exercicio> exercicios;


    public ExercicioCadastroAdapter(List<Exercicio> exercicios){
        this.exercicios =  exercicios;
    }


    @NonNull
    @Override
    public GenericoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GenericoHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista,parent ,false));

    }

    @Override
    public void onBindViewHolder(@NonNull GenericoHolder holder, final int position) {

        holder.txtGenerico.setText(exercicios.get(position).getNome());

        holder.btnEditar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
               Exercicio exercicio =  exercicios.get(position);
                Activity activity = getActivity(v);
                Intent intent = new Intent (  getActivity(v) , ExercicioCadastroActivity.class);
                intent.putExtra("exercicio",exercicio);
                activity.startActivity(intent);


            }
        });

        holder.btnExcluir.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = v;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Confirmação")
                        .setMessage("Tem certeza que deseja excluir este exercicio")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               Exercicio exercicio = exercicios.get(position);
                               ExercicioDAO dao = new ExercicioDAO(view.getContext());
                                boolean sucesso = dao.Delete( exercicio.getIdExercicio());
                                if(sucesso){
                                    removerExercicio(exercicio);
                                    Snackbar.make(view , "Excluiu!",Snackbar.LENGTH_LONG)
                                            .setAction("Action",null).show();
                                }else {

                                    Snackbar.make(view , "Erro ao excluir o exercicio!",Snackbar.LENGTH_LONG)
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
        return exercicios != null ? exercicios.size() : 0;
    }


    public void adicionarExercicio(Exercicio exercicio){
        exercicios.add(exercicio);
        notifyItemInserted(getItemCount());
    }

    public void atualizarExercicio(Exercicio exercicio){

        exercicios.set(exercicios.indexOf(exercicio) ,exercicio);
        notifyItemChanged(exercicios.indexOf(exercicio));
    }

    public void removerExercicio(Exercicio exercicio){
        int position = exercicios.indexOf(exercicio);
       exercicios.remove(exercicio);
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
