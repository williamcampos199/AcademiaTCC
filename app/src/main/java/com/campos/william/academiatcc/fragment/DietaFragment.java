package com.campos.william.academiatcc.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.AlimentoAdapter;
import com.campos.william.academiatcc.adapter.DietaAdapter;
import com.campos.william.academiatcc.banco.dao.AlimentoDAO;
import com.campos.william.academiatcc.banco.dao.DietaDAO;
import com.campos.william.academiatcc.banco.model.Alimento;
import com.campos.william.academiatcc.banco.model.Dieta;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DietaFragment extends Fragment {

    private RecyclerView recyclerView;
    private DietaAdapter adapter;

    public DietaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dieta, container, false);

        configuraRecycler(view);

        return view;


    }



    private void configuraRecycler( View view){


        //Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_dieta);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        //adiciona o adapter que irá anexar a lista de objetos á lista

       DietaDAO dao = new DietaDAO(getActivity());



      List<Dieta> listDieta = dao.Select();
        if(listDieta != null) {
            adapter = new DietaAdapter(listDieta);

            recyclerView.setAdapter(adapter);
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        }





    }






}
