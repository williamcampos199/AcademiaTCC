package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class Treino implements Serializable {


    private int idTreino;
    private String descricao;

    public int getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object obj) {
        return this.idTreino == ((Treino)obj).idTreino ;
    }


    @Override
    public int hashCode() {
        return this.idTreino;
    }




}
