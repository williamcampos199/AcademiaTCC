package com.campos.william.academiatcc.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.DietaCadastroAdapter;
import com.campos.william.academiatcc.adapter.DietaCadastroTabAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DietaCadastroFragment extends Fragment {

    private RecyclerView recyclerView;

    public DietaCadastroFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dieta_cadastro, container, false);


        configuraRecycler(view);





        return  view;
    }



    private void configuraRecycler( View view){


        //Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView)  view.findViewById(R.id.recyclerView_dieta_cadastro);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        //adiciona o adapter que irá anexar a lista de objetos á lista

        String dietas [] = {"Café da Manhã","Lanche da Manhã","Almoço","Lanche da Tarde","Janta","Ceia"};

        for(int i =0; i< dietas.length ; i++){
            Log.i("TESTE",i + "opaa");
        }

       DietaCadastroAdapter dietaCadastroAdapter = new DietaCadastroAdapter(dietas);
        recyclerView.setAdapter(dietaCadastroAdapter);
       recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));






    }




}
