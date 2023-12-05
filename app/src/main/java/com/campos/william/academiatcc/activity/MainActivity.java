package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.TabAdapter;
import com.campos.william.academiatcc.banco.model.Login;
import com.campos.william.academiatcc.helper.SlidingTabLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    private int idLogin;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar   =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.includemain).setVisibility(View.VISIBLE);
        slidingTabLayout =   findViewById(R.id.stl_tabs);
        viewPager = findViewById(R.id.vp_pagina);

        Intent intent = getIntent();
        if(intent.hasExtra("login")){
            Login login =  (Login) intent.getSerializableExtra("login");
            idLogin = login.getIdLogin();
        }
        configurarTabs();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_aerobico) {
            abrirActivityAerobico();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public  void  abrirActivityAerobico(){
        Intent intent = new Intent(MainActivity.this , AerobicoActivity.class );
        startActivity(intent);
    }

    public void configurarTabs(){

        //Configurar sliding tabs

        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorAccent));

        //Configurar Adapter

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);

        slidingTabLayout.setViewPager(viewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                int tabSelecionada = slidingTabLayout.getTabSelecionada();

                switch(tabSelecionada){
                    case 0:
                        intent = new Intent(MainActivity.this, PerfilActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, TreinoActivity.class );
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this,DietaActivity.class);
                        startActivity(intent);
                        break;
                }

            }
        });

    }





}
