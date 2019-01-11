package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class Login implements Serializable {
    private int idLogin;
    private int idAluno;
    private String usuario;
    private String senha;


    public Login(){


    }


    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public boolean equals(Object obj) {
        return this.idLogin == ((Login)obj).idLogin ;
    }


    @Override
    public int hashCode() {
        return this.idLogin;
    }




}
