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
import com.campos.william.academiatcc.adapter.PerfilCadastroAdapter;
import com.campos.william.academiatcc.banco.dao.AlunoDAO;
import com.campos.william.academiatcc.banco.model.Aluno;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilCadastroFragment extends Fragment {
private RecyclerView recyclerView;
private PerfilCadastroAdapter adapter;


    public PerfilCadastroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil_cadastro, container, false);

        configuraRecycler(view);


        return view;
    }


    private void configuraRecycler( View view){


        //Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_perfil_cadastro);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        //adiciona o adapter que irá anexar a lista de objetos á lista

        AlunoDAO alunoDAO = new AlunoDAO(getActivity());


        Aluno aluno = alunoDAO.SelectUltimoRegistro();
        if(aluno != null) {
            adapter = new PerfilCadastroAdapter(aluno);

            recyclerView.setAdapter(adapter);
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        }





    }







}
