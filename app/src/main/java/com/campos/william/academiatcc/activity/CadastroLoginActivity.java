package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.banco.dao.LoginDAO;
import com.campos.william.academiatcc.banco.model.Login;

public class CadastroLoginActivity extends AppCompatActivity {

    private EditText editTextUsuario;
    private EditText editTextSenha;
    private Button btnCancelar;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_login);

        editTextUsuario = findViewById(R.id.edit_cadastrar_usuario);
        editTextSenha = findViewById(R.id.edit_cadastrar_senha);
    btnCadastrar = findViewById(R.id.button_cadastrar_login);
       btnCancelar = findViewById(R.id.button_cancelar_login);


       btnCancelar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });

       btnCadastrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String senha;
               String usuario;

               senha = editTextSenha.getText().toString();
               usuario = editTextUsuario.getText().toString();

               if((!usuario.isEmpty()) && (!senha.isEmpty())){

                   Login login = new Login();

                   LoginDAO dao = new LoginDAO(getBaseContext());

                   login.setUsuario(usuario);
                   login.setSenha(senha);
                   login.setIdAluno(0);

                   Login loginVerificador = dao.SelectByUsuario(usuario);

                   if(loginVerificador != null){
                       Toast.makeText(getBaseContext(),"Usuário já está cadastrado" , Toast.LENGTH_LONG).show();
                       return;
                   }

                   boolean sucesso = dao.Insert(login);

                   if(sucesso) {
                       Toast.makeText(getBaseContext(), "Login com sucesso", Toast.LENGTH_LONG).show();
                       Intent intent = new Intent(CadastroLoginActivity.this, MainActivity.class);

                       Login login2 = dao.SelectUltimoRegistro();

                       intent.putExtra("login", login2);

                       startActivity(intent);

                       finish();
                   }
                   else {
                       Toast.makeText(getBaseContext(), "Não foi possível salvar o login, tente novamente", Toast.LENGTH_LONG).show();
                   }

               }
               else {
                   Toast.makeText(getBaseContext(),"Digite o Usuario e senha a ser salvo" , Toast.LENGTH_LONG);
               }

           }
       });

    }
}
