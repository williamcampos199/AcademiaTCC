package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class Alimento implements Serializable{
    private int idAlimento;
    private String nome;
    private double calorias; //REAL (1000 calorias / 1kcal)


    public Alimento() {
    }


    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }


    @Override
    public boolean equals(Object obj) {
        return this.idAlimento == ((Alimento)obj).idAlimento ;
    }


    @Override
    public int hashCode() {
        return this.idAlimento;
    }



}
