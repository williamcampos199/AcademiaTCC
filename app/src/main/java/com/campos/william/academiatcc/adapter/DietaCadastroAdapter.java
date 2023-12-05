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
import com.campos.william.academiatcc.holder.GenericoCadastroHolder;

public class DietaCadastroAdapter extends RecyclerView.Adapter<GenericoCadastroHolder> {

    private String[] dieta;


    public DietaCadastroAdapter(String [] dieta){
        this.dieta = dieta;
    }


    @NonNull
    @Override
    public GenericoCadastroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GenericoCadastroHolder(LayoutInflater.from( parent.getContext())
                                        .inflate(R.layout.item_lista_generico_cadastro,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final GenericoCadastroHolder holder, int position) {

        holder.txtnome.setText(dieta[position]);
        Log.i("TESTE",position + "BindView");

        holder.txtnome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity activity = getActivity(v);
                Intent intent = new Intent (  getActivity(v) , RefeicaoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                String refeicao = holder.txtnome.getText().toString();
                intent.putExtra("refeicao", refeicao);
                activity.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return dieta.length;
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


