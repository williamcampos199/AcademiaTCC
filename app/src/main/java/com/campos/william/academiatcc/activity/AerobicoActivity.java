package com.campos.william.academiatcc.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.AerobicoCadastroTabAdapter;
import com.campos.william.academiatcc.adapter.DietaCadastroTabAdapter;
import com.campos.william.academiatcc.helper.SlidingTabLayout;

public class AerobicoActivity extends AppCompatActivity {

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private AerobicoCadastroTabAdapter tabAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aerobico);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        slidingTabLayout =   findViewById(R.id.stl_tabs_aerobico_cadastro);
        viewPager = findViewById(R.id.vp_pagina_aerobico_cadastro);
        */
        //Configurar sliding tabs

        slidingTabLayout.setDistributeEvenly(true);
        //slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorAccent));
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorAccent));



        //Configurar Adapter

        tabAdapter = new AerobicoCadastroTabAdapter(getSupportFragmentManager());////(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);

        slidingTabLayout.setViewPager(viewPager);







    }

}
