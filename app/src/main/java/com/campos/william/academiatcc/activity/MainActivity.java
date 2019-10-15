package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.TabAdapter;
import com.campos.william.academiatcc.banco.dao.AlimentoDAO;
import com.campos.william.academiatcc.banco.dao.AlunoDAO;
import com.campos.william.academiatcc.banco.dao.LoginDAO;
import com.campos.william.academiatcc.banco.dao.TreinoDAO;
import com.campos.william.academiatcc.banco.model.Alimento;
import com.campos.william.academiatcc.banco.model.Aluno;
import com.campos.william.academiatcc.banco.model.Login;
import com.campos.william.academiatcc.banco.model.Treino;
import com.campos.william.academiatcc.helper.Preferencias;
import com.campos.william.academiatcc.helper.SlidingTabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int idLogin;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar   = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.includemain).setVisibility(View.VISIBLE);
        slidingTabLayout =   findViewById(R.id.stl_tabs);
        viewPager = findViewById(R.id.vp_pagina);

        Intent intent = getIntent();
        if(intent.hasExtra("login")){
            Login login =  (Login) intent.getSerializableExtra("login");
            idLogin = login.getIdLogin();
        }
        Aluno aluno = new Aluno();
        AlunoDAO alunoDAO = new AlunoDAO(getBaseContext());

        LoginDAO loginDAO = new LoginDAO(getBaseContext());
        Login login = loginDAO.SelectByID(idLogin);
        Preferencias preferencias = new Preferencias(getBaseContext());

      /*  if(login!= null) {
            aluno = alunoDAO.SelectByID(login.getIdAluno());
            preferencias.salvarDados(aluno.getIdAluno()+"",aluno.getNome());

            if(aluno.getNome().equals("sem nome")){
                Intent intent1 = new Intent(MainActivity.this, PerfilCadastroActivity.class);
                intent1.putExtra("perfil",aluno);
                startActivity(intent1);
            }
        }*/

        //Configurar sliding tabs

        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorAccent));


        //Configurar Adapter

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);

        slidingTabLayout.setViewPager(viewPager);

/*        for(int i =0;i< 10;i++) {

            Alimento alimento = new Alimento();
            alimento.setNome("Banana");
            alimento.setCalorias(200);

            AlimentoDAO dao = new AlimentoDAO(getBaseContext());
            dao.Insert(alimento);
            Alimento alimento2 = new Alimento();
            alimento2.setNome("Maça");
            alimento2.setCalorias(100);


            Alimento alimento3 = new Alimento();
            alimento3.setNome("Banana");
            alimento3.setCalorias(200);

            dao.Insert(alimento3);
            boolean sucesso = dao.Insert(alimento2);
            if (sucesso) {
                Log.i("INSERT", "Alimento Salvo");
            }


        }*/


/*

        TreinoDAO treinoDAO = new TreinoDAO(getBaseContext());
        Treino treino = new Treino();
        treino.setDescricao("sem treino");
     //   treinoDAO.Insert(treino);


        List<Treino> treinos = treinoDAO.Select();
        Log.i("TREINO",treino.getIdTreino() + " descricao " + treino.getDescricao());


*/




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/


       if (slidingTabLayout.getTabSelecionada() == 0 ){
           //Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
           Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
           startActivity(intent);

       }else
         if(slidingTabLayout.getTabSelecionada() == 1){//Treino

             Intent intent = new Intent(MainActivity.this,TreinoActivity.class);
             startActivity(intent);



         }else if(slidingTabLayout.getTabSelecionada() == 2){//Dieta

           Intent intent = new Intent(MainActivity.this,DietaActivity.class);
           startActivity(intent);



         }

            }
        });
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


}
