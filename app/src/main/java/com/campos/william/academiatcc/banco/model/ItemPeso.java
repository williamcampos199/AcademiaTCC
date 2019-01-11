package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class ItemPeso implements Serializable{

    private int idItemPeso;
    private int idPeso;
    private int idAluno;


    public ItemPeso() {
    }


    public int getIdItemPeso() {
        return idItemPeso;
    }

    public void setIdItemPeso(int idItemPeso) {
        this.idItemPeso = idItemPeso;
    }

    public int getIdPeso() {
        return idPeso;
    }

    public void setIdPeso(int idPeso) {
        this.idPeso = idPeso;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    @Override
    public boolean equals(Object obj) {
        return this.idItemPeso == ((ItemPeso)obj).idItemPeso ;
    }


    @Override
    public int hashCode() {
        return this.idItemPeso;
    }

}
