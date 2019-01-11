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
import com.campos.william.academiatcc.banco.dao.ItemExercicioDAO;
import com.campos.william.academiatcc.banco.model.Exercicio;
import com.campos.william.academiatcc.banco.model.ItemExercicio;
import com.campos.william.academiatcc.holder.TreinoDiaHolder;

import java.util.List;

public class TreinoDiaAdapter extends RecyclerView.Adapter<TreinoDiaHolder>{



    private final List<Exercicio> exercicios;


    public TreinoDiaAdapter(List<Exercicio> exercicios){
        this.exercicios = exercicios;
    }


    @NonNull
    @Override
    public TreinoDiaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TreinoDiaHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_treino,parent ,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final TreinoDiaHolder holder, final int position) {


        final Exercicio exercicio = exercicios.get(position);

        holder.textViewExercicio.setText(exercicio.getNome());
        holder.textViewRepeticoes.setText(exercicio.getRepetições());
        holder.textViewObs.setText(exercicio.getObs());







        holder.checkBoxExercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ItemExercicio itemExercicio = new ItemExercicio();


             /*   DietaDAO dietaDAO = new DietaDAO(getActivity(v));
                int idDieta = dietaDAO.SelectUltimoRegistro().getIdDieta();
*/

                if(holder.checkBoxExercicio.isChecked()){




               itemExercicio.setIdExercicio(exercicio.getIdExercicio());
               itemExercicio.setDia("");
               itemExercicio.setIdTreino(0);


                    ItemExercicioDAO itemExercicioDAO = new ItemExercicioDAO (getActivity(v));
                    itemExercicioDAO.Insert(itemExercicio);
                }


            }
        });


    }

    @Override
    public int getItemCount() {
        return exercicios != null ? exercicios.size() : 0;
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
