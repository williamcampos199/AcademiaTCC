package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class ItemBatimentos implements Serializable {
    private int idItemBatimentos;
    private int idBatimentos;
    private int idAerobico;


    public ItemBatimentos() {



    }

    public int getIdItemBatimentos() {
        return idItemBatimentos;
    }

    public void setIdItemBatimentos(int idItemBatimentos) {
        this.idItemBatimentos = idItemBatimentos;
    }

    public int getIdBatimentos() {
        return idBatimentos;
    }

    public void setIdBatimentos(int idBatimentos) {
        this.idBatimentos = idBatimentos;
    }

    public int getIdAerobico() {
        return idAerobico;
    }

    public void setIdAerobico(int idAerobico) {
        this.idAerobico = idAerobico;
    }

    @Override
    public boolean equals(Object obj) {
        return this.idItemBatimentos == ((ItemBatimentos)obj).idItemBatimentos ;
    }


    @Override
    public int hashCode() {
        return this.idItemBatimentos;
    }



}
