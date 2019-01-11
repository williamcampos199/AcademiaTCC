package com.campos.william.academiatcc.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.DietaCadastroAdapter;
import com.campos.william.academiatcc.adapter.TreinoCadastroAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TreinoCadastroFragment extends Fragment {

    private RecyclerView recyclerView;



    public TreinoCadastroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


   View view =  inflater.inflate(R.layout.fragment_treino_cadastro, container, false);

   configuraRecycler(view);

   return view;


    }



    private void configuraRecycler( View view){


        //Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView)  view.findViewById(R.id.recyclerView_treino_cadastro);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        //adiciona o adapter que irá anexar a lista de objetos á lista

        String dias [] = {"Segunda-feira","Terça-Feira","Quarta-feira","Quinta-feira","Sexta-feira","Sábado"};



        TreinoCadastroAdapter treinoCadastroAdapter= new TreinoCadastroAdapter(dias);
        recyclerView.setAdapter(treinoCadastroAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));






    }



}
