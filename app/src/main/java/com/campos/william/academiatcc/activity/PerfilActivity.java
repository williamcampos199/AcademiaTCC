package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.DietaCadastroTabAdapter;
import com.campos.william.academiatcc.adapter.PerfilCadastroTabAdapter;
import com.campos.william.academiatcc.banco.dao.AlunoDAO;
import com.campos.william.academiatcc.banco.model.Aluno;
import com.campos.william.academiatcc.banco.model.Peso;
import com.campos.william.academiatcc.helper.Preferencias;
import com.campos.william.academiatcc.helper.SlidingTabLayout;

public class PerfilActivity extends AppCompatActivity {
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private PerfilCadastroTabAdapter tabAdapter;
    private boolean perfilCadastrado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.includeperfil).setVisibility(View.VISIBLE);
        slidingTabLayout =   findViewById(R.id.stl_tabs_perfil_cadastro);
        viewPager = findViewById(R.id.vp_pagina_perfil_cadastro);


        //Configurar sliding tabs

        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorAccent));



        //Configurar Adapter

        tabAdapter = new PerfilCadastroTabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);

        slidingTabLayout.setViewPager(viewPager);







         FloatingActionButton fab = findViewById(R.id.fab);




       fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(slidingTabLayout.getTabSelecionada() == 1){
                    Intent intent = new Intent(PerfilActivity.this, PesoCadastroActivity.class);
                    startActivity(intent);
                }
                if(slidingTabLayout.getTabSelecionada() == 0){
                    Intent intent = new Intent(PerfilActivity.this, PerfilCadastroActivity.class);

                    AlunoDAO dao = new AlunoDAO(getBaseContext());
                    Preferencias preferencias = new Preferencias(getBaseContext());
                    int idAluno = Integer.parseInt(preferencias.getIdentificador() );

                    Aluno aluno = dao.SelectByID(idAluno);


                    if(aluno!= null)
                    intent.putExtra("perfil",aluno);
                    startActivity(intent);
                }





               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);













    }

}
