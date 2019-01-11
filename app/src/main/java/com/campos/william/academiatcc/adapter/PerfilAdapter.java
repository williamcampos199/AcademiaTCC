package com.campos.william.academiatcc.adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.activity.RefeicaoEditarActivity;
import com.campos.william.academiatcc.banco.dao.DietaDAO;
import com.campos.william.academiatcc.banco.dao.PesoDAO;
import com.campos.william.academiatcc.banco.model.Aluno;
import com.campos.william.academiatcc.banco.model.Dieta;
import com.campos.william.academiatcc.banco.model.Peso;
import com.campos.william.academiatcc.holder.GenericoHolder;
import com.campos.william.academiatcc.holder.PerfilHolder;

import java.util.Calendar;
import java.util.List;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilHolder> {


    private final Aluno aluno;
    private final Peso peso ;



    public PerfilAdapter(Aluno aluno, Peso peso){
        this.aluno = aluno;
        this.peso = peso;
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


        if(peso!=null){
            double altura = aluno.getAltura();
            double pesoAluno = peso.getValor();
            double imc = pesoAluno/ (altura * altura);

            holder.txtIMCAluno.setText( "IMC "+String.format("%.2f",imc));
            holder.txtPesoAluno.setText(peso.getValor()+"kg");
        }else {
            holder.txtIMCAluno.setText("");
            holder.txtPesoAluno.setText("");
        }







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
