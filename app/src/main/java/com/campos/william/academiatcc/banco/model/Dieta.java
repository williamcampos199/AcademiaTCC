package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class Dieta  implements Serializable{

    private int idDieta;
    private String nome;
    private String datadieta;
    private double calorias;

    public Dieta() {
    }


    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatadieta() {
        return datadieta;
    }

    public void setDatadieta(String datadieta) {
        this.datadieta = datadieta;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    @Override
    public boolean equals(Object obj) {
        return this.idDieta == ((Dieta)obj).idDieta ;
    }


    @Override
    public int hashCode() {
        return this.idDieta;
    }
}
