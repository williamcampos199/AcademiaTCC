package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class ItemAerobico implements Serializable {

    private int idItemAerobico;
    private int idAluno;
    private int idAerobico;


    public ItemAerobico() {

    }


    public int getIdItemAerobico() {
        return idItemAerobico;
    }

    public void setIdItemAerobico(int idItemAerobico) {
        this.idItemAerobico = idItemAerobico;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdAerobico() {
        return idAerobico;
    }

    public void setIdAerobico(int idAerobico) {
        this.idAerobico = idAerobico;
    }



    @Override
    public boolean equals(Object obj) {
        return this.idItemAerobico == ((ItemAerobico)obj).idItemAerobico ;
    }


    @Override
    public int hashCode() {
        return this.idItemAerobico;
    }




}
