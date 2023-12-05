package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.banco.dao.AlimentoDAO;
import com.campos.william.academiatcc.banco.dao.ExercicioDAO;
import com.campos.william.academiatcc.banco.model.Alimento;
import com.campos.william.academiatcc.banco.model.Exercicio;

public class ExercicioCadastroActivity extends AppCompatActivity {

    private Spinner spnTipo;
    private EditText editNome;
    private EditText editRepeticoes;
    private EditText editObs;
    private Button btnCancelar;
    private Button btnSalvar;
    private Exercicio exercicioEditado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio_cadastro);

        spnTipo = findViewById(R.id.spinner);
        editNome = findViewById(R.id.edit_nome_exercicio);
        editRepeticoes = findViewById(R.id.edit_repeticoes_exercicio);
        editObs = findViewById(R.id.edit_obs_exercicio);
        btnCancelar = findViewById(R.id.button_cancelar_exercicio);
        btnSalvar = findViewById(R.id.button_salvar_exercicio);

        Intent intent = getIntent();
        if(intent.hasExtra("exercicio")){
            exercicioEditado = (Exercicio) intent.getSerializableExtra("exercicio");
            editNome.setText(exercicioEditado.getNome());
            editRepeticoes.setText(exercicioEditado.getRepetições());
            editObs.setText(exercicioEditado.getObs());
            spnTipo.setSelection(getIndex(spnTipo,exercicioEditado.getTipo()));






        }





        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Pegando os valores
                Exercicio exercicio = new Exercicio();
                exercicio.setTipo(spnTipo.getSelectedItem().toString());
                exercicio.setNome(editNome.getText().toString());
                exercicio.setRepetições(editRepeticoes.getText().toString());
                exercicio.setObs(editObs.getText().toString());


                //Salvando os dados

                ExercicioDAO dao = new ExercicioDAO(v.getContext());
                boolean sucesso;

                if(exercicioEditado != null) {
                    exercicio.setIdExercicio(exercicioEditado.getIdExercicio());
                    sucesso = dao.Update(exercicio);
                }else {
                    sucesso = dao.Insert(exercicio);

                }

                if (sucesso){

                    exercicioEditado = null;


                    Toast.makeText(getBaseContext(),"Salvou o Exercicio",Toast.LENGTH_LONG).show();


                    finish();

                }
                else {

                    Toast.makeText(getBaseContext(),"Erro ao Salvar o Exercicio",Toast.LENGTH_LONG).show();

                }








            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }



    private int getIndex(Spinner spinner , String myString){

        int index =0;
        for(int i =0;i < spinner.getCount() ; i++){
            if(spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                index = i;
                break;

            }


        }

        return  index;


    }



}
