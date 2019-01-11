package com.campos.william.academiatcc.banco.model;

import java.io.Serializable;

public class Aluno implements Serializable{

private int idAluno;
private int idTreino;
private String nome;
private String dataNascimento; //Idade ANo atual - data de nascimento
private String objetivo;
private String dataInicio;
private double altura;
private String Sexo;


    public Aluno() {


    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }


    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    @Override
    public boolean equals(Object obj) {
        return this.idAluno == ((Aluno)obj).idAluno ;
    }


    @Override
    public int hashCode() {
        return this.idAluno;
    }



}
