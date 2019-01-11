package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class Aerobico  implements Serializable {

    private int idAerobico;
    private double distancia;
    private String tempo;
    private double velocidade;
    private double calorias;


    public Aerobico() {
    }


    public int getIdAerobico() {
        return idAerobico;
    }

    public void setIdAerobico(int idAerobico) {
        this.idAerobico = idAerobico;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    @Override
    public boolean equals(Object obj) {
        return this.idAerobico == ((Aerobico)obj).idAerobico ;
    }


    @Override
    public int hashCode() {
        return this.idAerobico;
    }


}
