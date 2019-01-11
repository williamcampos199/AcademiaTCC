package com.campos.william.academiatcc.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {

    private Context contexto;
    private SharedPreferences preferences;
    private final String NOME_ARQUIVO = "academia.preferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;
    private String CHAVE_IDENTIFICADOR = "identificadorUsuario";
    private String CHAVE_NOME = "nomeUsuario";


    public Preferencias(Context contextoParametro) {

        contexto = contextoParametro;
        preferences = contexto.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferences.edit();
    }


    public void salvarDados(String identificadorUsuario, String nomeUsuario) {
        editor.putString(CHAVE_IDENTIFICADOR, identificadorUsuario);
        editor.putString(CHAVE_NOME, nomeUsuario);

        editor.commit();
    }

    public String getIdentificador() {

        return preferences.getString(CHAVE_IDENTIFICADOR, null);
    }


    public String getNome() {
        return preferences.getString(CHAVE_NOME, null);
    }


}