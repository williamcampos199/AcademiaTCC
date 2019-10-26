package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.banco.dao.AlunoDAO;
import com.campos.william.academiatcc.banco.model.Aluno;
import com.campos.william.academiatcc.banco.model.Login;

public class PerfilCadastroActivity extends AppCompatActivity {
    private EditText editNome;
    private EditText editNascimento;
    private EditText editObjetivo;
    private EditText editInicio;
    private EditText editAltura;
    private Button btnCancelar;
    private Button btnSalvar;
    private RadioGroup radioGroupSexo;
    private Aluno alunoEditado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_cadastro);

        editNome = findViewById(R.id.edit_nome_perfil);
        editInicio = findViewById(R.id.edit_nome_perfil);
        editNascimento = findViewById(R.id.edit_nascimento_perfil);
        editInicio = findViewById(R.id.edit_inicio_perfil);
        editObjetivo = findViewById(R.id.edit_objetivo_perfil);
        editAltura = findViewById(R.id.edit_altura_perfil);
        btnSalvar = findViewById(R.id.button_salvar_perfil);
        btnCancelar = findViewById(R.id.button_cancelar_perfil);
        radioGroupSexo = findViewById(R.id.radioGroup_sexo);

        RadioButton rb;

        Intent intent = getIntent();
        if(intent.hasExtra("perfil")){
            alunoEditado = (Aluno) intent.getSerializableExtra("perfil");
            if(!alunoEditado.getNome().equals("sem nome")){
                editNome.setText(alunoEditado.getNome());
                editNascimento.setText(alunoEditado.getDataNascimento());
                editAltura.setText(alunoEditado.getAltura()+"");
                editObjetivo.setText(alunoEditado.getObjetivo());
                editInicio.setText(alunoEditado.getDataInicio());

            if(alunoEditado.getSexo().equals("M"))
                rb = (RadioButton) findViewById(R.id.rb_masculino);
            else
                rb = (RadioButton) findViewById(R.id.rb_feminino);
                rb.setChecked(true);
            }
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
                salvarAluno();

            }
        });

    }

    public void salvarAluno(){
        //Pegando os valores
        Aluno aluno = new Aluno();
        aluno.setNome(editNome.getText().toString());
        aluno.setDataInicio(editInicio.getText().toString());
        aluno.setObjetivo(editObjetivo.getText().toString());
        aluno.setDataNascimento(editNascimento.getText().toString());
        aluno.setAltura(Double.parseDouble(editAltura.getText().toString()));
        aluno.setIdTreino(0); //Sem treino ainda
        aluno.setSexo( radioGroupSexo.getCheckedRadioButtonId() == R.id.rb_masculino ? "M" : "F");

        if(!aluno.getDataNascimento().contains("/")){
            String dia = aluno.getDataNascimento().substring(0,1);
            String mes = aluno.getDataNascimento().substring(2,3);
            String ano = aluno.getDataNascimento().substring(4,7);

            aluno.setDataNascimento(dia + "/"+mes+"/"+ano);
        }

        if(!aluno.getDataInicio().contains("/")){
            String dia = aluno.getDataInicio().substring(0,1);
            String mes = aluno.getDataInicio().substring(2,3);
            String ano = aluno.getDataInicio().substring(4,7);

            aluno.setDataInicio(dia + "/"+mes+"/"+ano);
        }
        //Salvando os dados

        AlunoDAO dao = new AlunoDAO(getBaseContext());
        boolean sucesso;
        aluno.setIdAluno(alunoEditado.getIdAluno());
        sucesso = dao.Update(aluno);

        if (sucesso){
            alunoEditado = null;

            Toast.makeText(getBaseContext(),"Salvou o Perfil",Toast.LENGTH_LONG).show();
            finish();
        }
        else {
            Toast.makeText(getBaseContext(),"Erro ao Salvar perfil",Toast.LENGTH_LONG).show();

        }

    }

}
