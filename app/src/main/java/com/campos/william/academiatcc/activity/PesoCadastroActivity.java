package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.banco.dao.PesoDAO;
import com.campos.william.academiatcc.banco.model.Peso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class PesoCadastroActivity extends AppCompatActivity {

    private EditText editPeso;
    private Button btnCancelar;
    private Button btnSalvar;
    private Peso pesoEditado;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso_cadastro);



        editPeso = findViewById(R.id.edit_peso_cadastro);


        btnCancelar = findViewById(R.id.button_cancelar_peso);
        btnSalvar = findViewById(R.id.button_salvar_peso);


        Intent intent = getIntent();
        if(intent.hasExtra("peso")){
            pesoEditado = (Peso) intent.getSerializableExtra("peso");
            editPeso.setText(String.valueOf( pesoEditado.getValor()));







        }

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();


            }
        });


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Pegando os valores
              Peso peso = new Peso();
                peso.setValor(Double.parseDouble( editPeso.getText().toString()));


                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date date = new Date();

                peso.setDatapeso(dateFormat.format(date));


                peso.setImc(23);


                //Salvando os dados

              PesoDAO dao = new PesoDAO(getBaseContext());
                boolean sucesso = true;

                if(pesoEditado != null) {
                    peso.setIdPeso(pesoEditado.getIdPeso());
                    sucesso = dao.Update(peso);

                }else {
                   sucesso = dao.Insert(peso);

                }

                if (sucesso){

                    pesoEditado = null;


                    Toast.makeText(getBaseContext(),"Salvou",Toast.LENGTH_LONG).show();





                    finish();

                }
                else {

                    Toast.makeText(getBaseContext(),"Erro ao salvar",Toast.LENGTH_LONG).show();

                }






            }


        });






    }







}
