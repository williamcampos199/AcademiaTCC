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
import com.campos.william.academiatcc.adapter.AlimentoAdapter;
import com.campos.william.academiatcc.banco.dao.AlimentoDAO;
import com.campos.william.academiatcc.banco.model.Alimento;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlimentosFragment extends Fragment {

    private RecyclerView recyclerView;
    private AlimentoAdapter adapter;

    private static boolean atualizou = true;

    public AlimentosFragment() {
        // Required empty public constructor
    }


    @Override
    public void onStart() {
        super.onStart();

        if(!atualizou) {


            atualizarAlimento();

        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alimentos, container, false);

        configuraRecycler(view);


        return view;
    }


    private void configuraRecycler( View view){


        //Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_alimentos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        //adiciona o adapter que irá anexar a lista de objetos á lista

        AlimentoDAO dao = new AlimentoDAO(getActivity());



        List<Alimento> listAlimento = dao.Select();
        if(listAlimento != null) {
            adapter = new AlimentoAdapter(listAlimento);

            recyclerView.setAdapter(adapter);
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        }





    }


    public void atualizarAlimento(){

        AlimentoDAO dao = new AlimentoDAO(getActivity());
        Alimento alimentoEditado = AlimentoDAO.getUltimoAlimentoEditado();
        if ( alimentoEditado != null) {
            Alimento alimento = alimentoEditado;
            adapter.atualizarDieta(alimento);

            atualizou = true;
            AlimentoDAO.setUltimoAlimentoEditado(null);
            return;

        } else  {
            Alimento alimento = dao.SelectUltimoRegistro();
            adapter.adicionarDieta(alimento);
            atualizou = true;
        }

    }





public  void setAtualizou( boolean atualizou){
        this.atualizou = atualizou;

}



}
