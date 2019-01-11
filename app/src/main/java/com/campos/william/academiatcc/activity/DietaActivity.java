package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.DietaCadastroTabAdapter;
import com.campos.william.academiatcc.adapter.TabAdapter;
import com.campos.william.academiatcc.banco.dao.AlimentoDAO;
import com.campos.william.academiatcc.banco.model.Alimento;
import com.campos.william.academiatcc.helper.SlidingTabLayout;

public class DietaActivity extends AppCompatActivity {

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
   private  DietaCadastroTabAdapter tabAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        findViewById(R.id.includedieta).setVisibility(View.VISIBLE);
        slidingTabLayout =   findViewById(R.id.stl_tabs_dieta_cadastro);
        viewPager = findViewById(R.id.vp_pagina_dieta_cadastro);

        //Configurar sliding tabs

        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorAccent));



        //Configurar Adapter

    tabAdapter = new DietaCadastroTabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);

        slidingTabLayout.setViewPager(viewPager);








        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show(); */
/*

                Intent intent = new Intent(DietaActivity.this,AlimentoCadastroActivity.class);
                startActivity(intent);
*/



                if(slidingTabLayout.getTabSelecionada() == 0){//Dieta(Refeição)


                }else if(slidingTabLayout.getTabSelecionada() == 1){//Alimentos

                    Intent intent = new Intent(DietaActivity.this,AlimentoCadastroActivity.class);
                    startActivity(intent);



                }





            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }


    public DietaCadastroTabAdapter getTabAdapter() {
        return tabAdapter;
    }








}
