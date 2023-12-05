package com.campos.william.academiatcc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.campos.william.academiatcc.R;
import com.campos.william.academiatcc.banco.dao.LoginDAO;
import com.campos.william.academiatcc.banco.model.Login;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUsuario;
    private EditText editTextSenha;
    private TextView textViewCadastrar;
    private Button btnLogar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsuario = findViewById(R.id.edit_login_usuario);
        editTextSenha = findViewById(R.id.edit_login_senha);
        textViewCadastrar = findViewById(R.id.textView_cadastrar_login);
        btnLogar = findViewById(R.id.button_logar);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senha = editTextSenha.getText().toString();
                String usuario = editTextUsuario.getText().toString();

                if((senha.isEmpty()) || (usuario.isEmpty()) ){//Preencha o login e senha

                    Toast.makeText(getApplicationContext(),"Preencha o login e senha",Toast.LENGTH_LONG).show();
                    return;
                }


                LoginDAO dao= new LoginDAO(getBaseContext());
                Login login ;
                login = dao.SelectByUsuario(usuario);
                if(login == null) {//usuario não existe

                    //Toast.makeText(getApplicationContext(),"Usuario não existe",Toast.LENGTH_LONG).show();
                    return;
                }

                if(!senha.equals(login.getSenha())){//senha incorreta

                    Toast.makeText(getApplicationContext(),"Senha incorreta",Toast.LENGTH_LONG).show();

                }

                Toast.makeText(getBaseContext(),"Login com sucesso",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);

                intent.putExtra("login",login);

                startActivity(intent);


                finish();

            }




        });


        textViewCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroLoginActivity.class);
                startActivity(intent);


            }
        });




    }
}
