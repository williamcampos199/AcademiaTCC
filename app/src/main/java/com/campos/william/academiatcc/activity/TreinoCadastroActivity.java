package com.campos.william.academiatcc.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.TreinoDiaAdapter;
import com.campos.william.academiatcc.banco.dao.ExercicioDAO;
import com.campos.william.academiatcc.banco.model.Exercicio;

import java.util.List;

public class TreinoCadastroActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btnSalvar;
    private Button btnCancelar;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino_cadastro);


        btnCancelar = findViewById(R.id.button_cancelar_treino);
        btnSalvar = findViewById(R.id.button_salvar_treino);
        spinner = findViewById(R.id.spinner2);

        configuraRecycler();


       btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }




    private void configuraRecycler(){


        //Configurando o gerenciador de layout para ser uma lista.
        recyclerView = findViewById(R.id.recyclerView_treino_dia);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        //adiciona o adapter que irá anexar a lista de objetos á lista


       ExercicioDAO exercicioDAO = new ExercicioDAO(this);
        List<Exercicio> exercicios = exercicioDAO.Select();



        TreinoDiaAdapter treinoDiaAdapter = new TreinoDiaAdapter(exercicios);
        recyclerView.setAdapter(treinoDiaAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));






    }

}
