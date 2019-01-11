package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.TabAdapter;
import com.campos.william.academiatcc.adapter.TreinoCadastroTabAdapter;
import com.campos.william.academiatcc.helper.SlidingTabLayout;

public class TreinoActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino);
        toolbar   =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.includetreino).setVisibility(View.VISIBLE);
        slidingTabLayout =   findViewById(R.id.stl_tabs_treino_cadastro);
        viewPager = findViewById(R.id.vp_pagina_treino_cadastro);

        //Configurar sliding tabs

        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorAccent));


        //Configurar Adapter

        final TreinoCadastroTabAdapter tabAdapter= new TreinoCadastroTabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);

        slidingTabLayout.setViewPager(viewPager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/


                if(slidingTabLayout.getTabSelecionada() == 0){//Treino

                    //Intent intent = new Intent(TreinoActivity.this, );
                   // startActivity(intent);



                }else if(slidingTabLayout.getTabSelecionada() == 1){//Exercicio

                    Intent intent = new Intent(TreinoActivity.this, ExercicioCadastroActivity.class );
                    startActivity(intent);



                }

            }
        });



    }

}
