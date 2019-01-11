package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class ItemDieta implements Serializable {
    private int idItemDieta;
    private int idDieta;
    private int idAluno;


    public ItemDieta() {
    }

    public int getIdItemDieta() {
        return idItemDieta;
    }

    public void setIdItemDieta(int idItemDieta) {
        this.idItemDieta = idItemDieta;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }


    @Override
    public boolean equals(Object obj) {
        return this.idItemDieta == ((ItemDieta)obj).idItemDieta ;
    }


    @Override
    public int hashCode() {
        return this.idItemDieta;
    }





}
