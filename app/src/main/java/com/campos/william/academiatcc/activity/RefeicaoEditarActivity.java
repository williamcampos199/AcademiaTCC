package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.RefeicaoEditarAdapter;
import com.campos.william.academiatcc.banco.dao.ItemAlimentoDAO;
import com.campos.william.academiatcc.banco.model.Dieta;
import com.campos.william.academiatcc.banco.model.ItemAlimento;

import java.util.List;

public class RefeicaoEditarActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Dieta dieta;
    private   List<ItemAlimento> itemAlimentoList ;
    private Button btnCancelar;
    private Button btnSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicao_editar);

        btnCancelar = findViewById(R.id.button_cancelar_treino);
        btnSalvar = findViewById(R.id.button_salvar_treino);


        Intent intent = getIntent();
        if(intent.hasExtra("dieta")){
            dieta =  (Dieta) intent.getExtras().getSerializable("dieta");
        }




        configuraRecycler();




        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(),"Refeição salva",Toast.LENGTH_SHORT).show();

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
        recyclerView = findViewById(R.id.recyclerView_Refeicao);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        //adiciona o adapter que irá anexar a lista de objetos á lista
        ItemAlimentoDAO itemAlimentoDAO = new ItemAlimentoDAO(this);

        if(dieta != null){
            itemAlimentoList =  itemAlimentoDAO.SelectByDieta(dieta.getIdDieta());
        }





        if(itemAlimentoList != null) {

            RefeicaoEditarAdapter refeicaoAdapter = new RefeicaoEditarAdapter(itemAlimentoList);
            recyclerView.setAdapter(refeicaoAdapter);
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        }




    }




}
