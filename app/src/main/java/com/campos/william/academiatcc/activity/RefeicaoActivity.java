package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.RefeicaoAdapter;
import com.campos.william.academiatcc.banco.dao.AlimentoDAO;
import com.campos.william.academiatcc.banco.dao.DietaDAO;
import com.campos.william.academiatcc.banco.dao.ItemAlimentoDAO;
import com.campos.william.academiatcc.banco.model.Alimento;
import com.campos.william.academiatcc.banco.model.Dieta;
import com.campos.william.academiatcc.banco.model.ItemAlimento;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RefeicaoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private   String refeicao;
    private Button btnCancelar;
    private Button btnSalvar;



    private boolean refeicaofeita;
    private Dieta dieta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicao);

        toolbar   = (Toolbar) findViewById(R.id.toolbar);
        btnCancelar = findViewById(R.id.button_cancelar_treino);
        btnSalvar = findViewById(R.id.button_salvar_treino);

      refeicao = "";

        Intent intent = getIntent();
        if(intent.hasExtra("refeicao")){

            refeicao = intent.getExtras().getString("refeicao");


        }



        toolbar.setTitle(refeicao);
        setSupportActionBar(toolbar);

       dieta = new Dieta();
        dieta.setNome(refeicao);
        dieta.setCalorias(0);
        dieta.setDatadieta("0");
        final DietaDAO dietaDAO = new DietaDAO(this);
        dietaDAO.Insert(dieta);



        configuraRecycler();


       btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DietaDAO dietaDAO1 = new DietaDAO(getBaseContext());
                dieta = dietaDAO1.SelectUltimoRegistro();

                ItemAlimentoDAO itemAlimentoDAO = new ItemAlimentoDAO(getBaseContext());
                List<ItemAlimento> itemAlimentoList = itemAlimentoDAO.SelectByDieta(dieta.getIdDieta());

                double calorias = 0;


                for(ItemAlimento itemAlimento : itemAlimentoList ){

                    calorias += itemAlimento.getCalorias();


                }


                dieta.setCalorias(calorias);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();

                dieta.setDatadieta(dateFormat.format(date));

                dietaDAO.Update(dieta);

                Toast.makeText(getBaseContext(),"Dieta Salva",Toast.LENGTH_LONG).show();


                finish();
            }
        });


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





    }




    private void configuraRecycler(){


        //Configurando o gerenciador de layout para ser uma lista.
        recyclerView = findViewById(R.id.recyclerView_Refeicao);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        //adiciona o adapter que irá anexar a lista de objetos á lista


        AlimentoDAO alimentoDAO = new AlimentoDAO(this);
        List<Alimento> alimentos = alimentoDAO.Select();



        RefeicaoAdapter refeicaoAdapter = new RefeicaoAdapter(alimentos);
        recyclerView.setAdapter(refeicaoAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));






    }



}
