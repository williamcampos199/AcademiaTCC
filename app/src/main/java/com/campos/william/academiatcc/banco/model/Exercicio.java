package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class Exercicio implements Serializable {
    private int idExercicio;
    private String tipo;
    private String nome;
    private String repetições;
    private String obs;

    public Exercicio() {
    }


    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRepetições() {
        return repetições;
    }

    public void setRepetições(String repetições) {
        this.repetições = repetições;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }


    @Override
    public boolean equals(Object obj) {
        return this.idExercicio == ((Exercicio)obj).idExercicio ;
    }


    @Override
    public int hashCode() {
        return this.idExercicio;
    }
}
