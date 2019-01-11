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
import com.campos.william.academiatcc.banco.dao.AlimentoDAO;
import com.campos.william.academiatcc.banco.model.Alimento;

public class AlimentoCadastroActivity extends AppCompatActivity {

    private EditText editAlimento;
    private EditText editCalorias;
    private EditText editQuantidade;
    private Button btnCancelar;
    private Button btnSalvar;
    private Alimento  alimentoEditado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimento_cadastro);

        editAlimento = findViewById(R.id.edit_alimento_cadastro);
        editCalorias = findViewById(R.id.edit_calorias_cadastro);

        btnCancelar = findViewById(R.id.button_cancelar_alimento);
        btnSalvar = findViewById(R.id.button_salvar_alimento);


        Intent intent = getIntent();
        if(intent.hasExtra("alimento")){
        alimentoEditado = (Alimento) intent.getSerializableExtra("alimento");
        editAlimento.setText(alimentoEditado.getNome());
        editCalorias.setText(alimentoEditado.getCalorias() + "");






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
                Alimento alimento = new Alimento();
             alimento.setNome(editAlimento.getText().toString());
             alimento.setCalorias( Double.parseDouble( editCalorias.getText().toString() ) );


             //Salvando os dados

                AlimentoDAO dao = new AlimentoDAO(getBaseContext());
                boolean sucesso;

                if(alimentoEditado != null) {
                    alimento.setIdAlimento(alimentoEditado.getIdAlimento());
                    sucesso = dao.Update(alimento);
                }else {
                    sucesso = dao.Insert(alimento);

                }

                if (sucesso){

                    alimentoEditado = null;


                    Toast.makeText(getBaseContext(),"Salvou o Alimento",Toast.LENGTH_LONG).show();





                    finish();

                }
                else {

                    Toast.makeText(getBaseContext(),"Erro ao salvar , consulte os logs!" ,Toast.LENGTH_LONG).show();


                }






            }


        });
    }
}
