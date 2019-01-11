package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class ItemAlimento implements Serializable{

    private int idItemAlimento;
    private int idAlimento;
    private int idDieta;
    private double quantidade;
    private double calorias; // calorias do alimento * quantidade

    public ItemAlimento() {
    }


    public int getIdItemAlimento() {
        return idItemAlimento;
    }

    public void setIdItemAlimento(int idItemAlimento) {
        this.idItemAlimento = idItemAlimento;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }


    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }


    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    @Override
    public boolean equals(Object obj) {
        return this.idItemAlimento == ((ItemAlimento)obj).idItemAlimento ;
    }


    @Override
    public int hashCode() {
        return this.idItemAlimento;
    }

}
