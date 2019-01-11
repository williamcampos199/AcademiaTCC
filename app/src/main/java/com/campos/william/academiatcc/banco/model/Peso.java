package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class Peso implements Serializable {

    private int idPeso;
    private double valor;
    private String datapeso;
    private double imc;

    public Peso() {
    }


    public int getIdPeso() {
        return idPeso;
    }

    public void setIdPeso(int idPeso) {
        this.idPeso = idPeso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDatapeso() {
        return datapeso;
    }

    public void setDatapeso(String datapeso) {
        this.datapeso = datapeso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    @Override
    public boolean equals(Object obj) {
        return this.idPeso == ((Peso)obj).idPeso ;
    }


    @Override
    public int hashCode() {
        return this.idPeso;
    }




}
