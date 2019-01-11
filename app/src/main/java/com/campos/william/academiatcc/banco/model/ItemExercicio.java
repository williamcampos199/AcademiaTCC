package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class ItemExercicio implements Serializable{
    private int idItemExercicio;
    private int idTreino;
    private int idExercicio;
    private String dia;


    public ItemExercicio() {
    }

    public int getIdItemExercicio() {
        return idItemExercicio;
    }

    public void setIdItemExercicio(int idItemExercicio) {
        this.idItemExercicio = idItemExercicio;
    }

    public int getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }

    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public boolean equals(Object obj) {
        return this.idItemExercicio == ((ItemExercicio)obj).idItemExercicio ;
    }


    @Override
    public int hashCode() {
        return this.idItemExercicio;
    }


}
