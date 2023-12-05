package com.campos.william.academiatcc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.activity.RefeicaoActivity;
import com.campos.william.academiatcc.activity.TreinoCadastroActivity;
import com.campos.william.academiatcc.holder.GenericoCadastroHolder;

public class TreinoCadastroAdapter  extends RecyclerView.Adapter<GenericoCadastroHolder>{


    private String[] treino;


    public TreinoCadastroAdapter(String [] treino){
        this.treino = treino;
    }


    @NonNull
    @Override
    public GenericoCadastroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GenericoCadastroHolder(LayoutInflater.from( parent.getContext())
                .inflate(R.layout.item_lista_generico_cadastro,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final GenericoCadastroHolder holder, int position) {

        holder.txtnome.setText(treino[position]);
        Log.i("TESTE",position + "BindView");

        holder.txtnome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity activity = getActivity(v);
                Intent intent = new Intent (  getActivity(v) , TreinoCadastroActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                String treinoExercicio = holder.txtnome.getText().toString();
                intent.putExtra("treino", treinoExercicio);
                activity.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return treino.length;
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
