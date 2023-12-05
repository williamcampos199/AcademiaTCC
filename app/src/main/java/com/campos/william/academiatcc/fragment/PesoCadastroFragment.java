package com.campos.william.academiatcc.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.activity.PerfilActivity;
import com.campos.william.academiatcc.activity.PesoCadastroActivity;
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
    private int pesoId;
    private TextView textViewPeso;
    private ImageButton btnEditar;
    private ImageButton btnExcluir;
    private AlertDialog alerta;

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_peso_cadastro, container, false);

        textViewData = view.findViewById(R.id.textView_data);
        btnMais = view.findViewById(R.id.button_mais_data);
        btnMenos = view.findViewById(R.id.button_menos_data);
        textViewPeso = view.findViewById(R.id.textView_peso);
        btnEditar = view.findViewById(R.id.button_editar_peso);
        btnExcluir = view.findViewById(R.id.button_excluir_peso);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();

        String data =  dateFormat.format(date);
        textViewData.setText(data);
        carregarPeso(data);


        btnMais.setOnClickListener(new View.OnClickListener() {
               @Override
            public void onClick(View v) {
                proximaData();
            }

        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    anteriorData();
                }

        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Peso peso = new Peso();
                peso.setIdPeso(pesoId);
                peso.setDatapeso(textViewData.getText().toString());
                peso.setValor(Double.parseDouble(textViewPeso.getText().toString().replace(" Kg", "")));

                Intent intentPeso = new Intent(v.getContext(), PesoCadastroActivity.class);
                intentPeso.putExtra("peso", peso);
                startActivity(intentPeso);
            }
        });

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletarPeso();
            }
        });
        return view;

    }

    private void carregarPeso(String data){
        btnEditar.setVisibility(View.INVISIBLE);
        btnExcluir.setVisibility(View.INVISIBLE);
        textViewPeso.setVisibility(View.INVISIBLE);

        PesoDAO pesoDAO = new PesoDAO(getActivity());
        List<Peso> pesos = pesoDAO.SelectByData(data);

        if(pesos.isEmpty()) return;

        Peso peso = pesos.get(0);
        pesoId = peso.getIdPeso();
        textViewPeso.setText(peso.getValor() + " Kg");

        btnEditar.setVisibility(View.VISIBLE);
        btnExcluir.setVisibility(View.VISIBLE);
        textViewPeso.setVisibility(View.VISIBLE);

    }

    private void proximaData(){

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

            }
            else {
                if (dia < 31)
                    dia++;
                else {
                    dia = 1;
                    mes++;
                }
            }
        }
        else {//mudou o ano
            ano++;
            mes = 1;
            dia = 1;
        }

        textViewData.setText( dia + "-"+mes+"-"+ano);
        carregarPeso(textViewData.getText().toString());

    }

    public void anteriorData(){
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
        carregarPeso(textViewData.getText().toString());

    }

    public void  deletarPeso(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Exclusão de Peso");

        builder.setMessage("Deseja excluir esse Peso");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                PesoDAO pesoDAO = new PesoDAO(getActivity());
                pesoDAO.Delete(pesoId);
                Toast.makeText(getActivity(),"positivo" + which, Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity(), "Peso Deletado",Toast.LENGTH_SHORT).show();
                textViewPeso.setVisibility(View.INVISIBLE);
                btnEditar.setVisibility(View.INVISIBLE);
                btnExcluir.setVisibility(View.INVISIBLE);
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alerta = builder.create();

        alerta.show();

    }

}
