package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class Batimentos  implements Serializable {

    private int idBatimentos;
    private int valor;

    public Batimentos() {
    }

    public int getIdBatimentos() {
        return idBatimentos;
    }

    public void setIdBatimentos(int idBatimentos) {
        this.idBatimentos = idBatimentos;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        return this.idBatimentos == ((Batimentos)obj).idBatimentos ;
    }


    @Override
    public int hashCode() {
        return this.idBatimentos;
    }


}
