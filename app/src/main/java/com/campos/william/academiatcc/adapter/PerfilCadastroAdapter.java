package com.campos.william.academiatcc.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.banco.model.Aluno;
import com.campos.william.academiatcc.holder.PerfilHolder;

import java.util.Calendar;

public class PerfilCadastroAdapter extends RecyclerView.Adapter<PerfilHolder> {
    private final Aluno aluno;


    public PerfilCadastroAdapter(Aluno aluno){
        this.aluno = aluno;
    }


    @NonNull
    @Override
    public PerfilHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PerfilHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_perfil,parent ,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final PerfilHolder holder, final int position) {

        holder.txtNomeAluno.setText(aluno.getNome());
        holder.txtObjetivoAluno.setText(aluno.getObjetivo());
        String sexo = aluno.getSexo();

        holder.txtSexoAluno.setText(sexo.equals("M") ? "Masculino": "Feminino");

        String idadeAluno = getIdadeAluno(aluno.getDataNascimento());
        //String idadeAluno = getIdadeAluno("14/08/1992");
        //  Calendar C = Calendar.getInstance();
        // String idadeAluno = getIdadeAluno(C.get(Calendar.DAY_OF_MONTH) +"/"+C.get(Calendar.MONTH) + "/"+C.get(Calendar.YEAR));
        holder.txtIdadeAluno.setText(idadeAluno);
        holder.txtIMCAluno.setText("");
        holder.txtPesoAluno.setText("");






    }

    @Override
    public int getItemCount() {
        return 1;
    }


    public String getIdadeAluno(String nascimento){
        String[] data = nascimento.split("/");

        int dia = Integer.valueOf(data[0]);
        int mes = Integer.valueOf(data[1]);
        int ano = Integer.valueOf(data[2]);


        Calendar c = Calendar.getInstance();
        int anoA = c.get(Calendar.YEAR);
        int mesA = c.get(Calendar.MONTH) + 1;//janeiro = 0;
        int diaA = c.get(Calendar.DAY_OF_MONTH);

        Log.i("DataHoje",diaA+"/"+mesA+"/"+anoA);

        int idade;

        if(mesA >= mes && diaA >= dia){

            idade = anoA - ano;

        }
        else { //caso a pessoa não fez aniversário ainda no ano
            idade = anoA - ano -1;
        }


        return  String.valueOf(idade);
    }



}
