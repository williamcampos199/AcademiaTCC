package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.DietaCadastroTabAdapter;
import com.campos.william.academiatcc.adapter.PerfilCadastroTabAdapter;
import com.campos.william.academiatcc.banco.dao.AlunoDAO;
import com.campos.william.academiatcc.banco.model.Aluno;
import com.campos.william.academiatcc.banco.model.Peso;
import com.campos.william.academiatcc.fragment.PerfilFragment;
import com.campos.william.academiatcc.fragment.PesoCadastroFragment;
import com.campos.william.academiatcc.helper.Preferencias;
import com.campos.william.academiatcc.helper.SlidingTabLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PerfilActivity extends AppCompatActivity {
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private PerfilCadastroTabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        findViewById(R.id.includeperfil).setVisibility(View.VISIBLE);
        slidingTabLayout =   findViewById(R.id.stl_tabs_perfil_cadastro);
        viewPager = findViewById(R.id.vp_pagina_perfil_cadastro);

        setSupportActionBar(toolbar);
        configurarTabs();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void configurarTabs(){
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
                int tabSelecionada = slidingTabLayout.getTabSelecionada();
                Intent intent;

                switch (tabSelecionada){
                    case 0:
                        intent = new Intent(PerfilActivity.this, PerfilCadastroActivity.class);

                        intent.putExtra("perfil", retornarAluno());
                        startActivity(intent);
                    break;
                    case 1:
                        intent = new Intent(PerfilActivity.this, PesoCadastroActivity.class);

                        startActivity(intent);
                        break;
                }

            }
        });

    }

    public Aluno retornarAluno(){
        AlunoDAO dao = new AlunoDAO(getBaseContext());
        Preferencias preferencias = new Preferencias(getBaseContext());
        int idAluno = Integer.parseInt(preferencias.getIdentificador());

        return dao.SelectByID(idAluno);
    }


}
