package com.campos.william.academiatcc.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.PerfilAdapter;
import com.campos.william.academiatcc.banco.dao.AlunoDAO;
import com.campos.william.academiatcc.banco.dao.PesoDAO;
import com.campos.william.academiatcc.banco.model.Aluno;
import com.campos.william.academiatcc.banco.model.Peso;
import com.campos.william.academiatcc.helper.Preferencias;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private RecyclerView recyclerView;
    private PerfilAdapter adapter;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        configuraRecycler(view);
        return view;
    }


    private void configuraRecycler( View view){


        //Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_perfil);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        //adiciona o adapter que irá anexar a lista de objetos á lista

        AlunoDAO alunoDAO = new AlunoDAO(getActivity());

        Preferencias preferencias = new Preferencias(getActivity());
        int idaluno = Integer.parseInt(preferencias.getIdentificador());


        PesoDAO pesoDAO = new PesoDAO(getActivity());
        Peso peso = pesoDAO.SelectUltimoRegistro();
        Aluno aluno = alunoDAO.SelectByID(idaluno);
        if(aluno != null ) {
            adapter = new PerfilAdapter(aluno,peso);

            recyclerView.setAdapter(adapter);
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        }





    }





}
