package com.campos.william.academiatcc.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.adapter.PesoAdapter;
import com.campos.william.academiatcc.banco.dao.PesoDAO;
import com.campos.william.academiatcc.banco.model.Peso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PesoCadastroFragment extends Fragment {
private RecyclerView recyclerView;
private PesoAdapter adapter;
private Button btnMais;
private Button btnMenos;
private TextView textViewData;
private  boolean mudarData = true;


  public   PesoCadastroFragment(){

  }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_peso_cadastro, container, false);

        textViewData = view.findViewById(R.id.textView_data);
        btnMais = view.findViewById(R.id.button_mais_data);
        btnMenos = view.findViewById(R.id.button_menos_data);







        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();

       String data =  dateFormat.format(date);
       textViewData.setText(data);

        configuraRecycler(view,data);


       btnMais.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String[] data = textViewData.getText().toString().split("-");

               int dia = Integer.parseInt(data[0]);
               int mes = Integer.parseInt(data[1]);
               int ano = Integer.parseInt(data[2]);

               if(!(mes == 12 && dia ==31)){
                   if (mes == 2) {

                       if (dia < 28)
                           dia++;
                       else {
                           dia = 1;
                           mes++;
                       }


                   } else {
                       if (dia < 31)
                           dia++;
                       else {
                           dia = 1;
                           mes++;
                       }
                   }} else {//mudou o ano


                      ano++;
                      mes = 1;
                      dia = 1;



               }



             textViewData.setText( dia + "-"+mes+"-"+ano);



           }






       });





        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] data = textViewData.getText().toString().split("-");

                int dia = Integer.parseInt(data[0]);
                int mes = Integer.parseInt(data[1]);
                int ano = Integer.parseInt(data[2]);

                if(!(mes ==1 && dia == 1)){

                    if(dia == 1){
                        dia = 31;
                        mes--;
                    }
                    else {
                        dia--;
                    }

                    }
                else {//mudou o ano


                    ano--;
                    mes = 12;
                    dia = 31;



                }



                textViewData.setText( dia + "-"+mes+"-"+ano);



            }






        });




        return view;






    }




    private void configuraRecycler( View view , String data){


        //Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_peso_cadastro);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        //adiciona o adapter que irá anexar a lista de objetos á lista

       PesoDAO dao= new PesoDAO(getActivity());


       List<Peso> pesos = dao.SelectByData(data);
        if(pesos != null) {
            adapter = new PesoAdapter(pesos);

            recyclerView.setAdapter(adapter);

                recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));


        }





    }



}
