package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {



    private final String TABLE_ALUNO = "Aluno";
    private DbGateway gw;


    public AlunoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(Aluno aluno){
        ContentValues cv = new ContentValues();
        cv.put("nome", aluno.getNome());
        cv.put("idtreino",aluno.getIdTreino());
        cv.put("datanascimento" , aluno.getDataNascimento());
        cv.put("objetivo",aluno.getObjetivo());
        cv.put("datainicio",aluno.getDataInicio());
        cv.put("altura", aluno.getAltura());
        cv.put("sexo",aluno.getSexo());




        return gw.getDatabase().insert(TABLE_ALUNO,null,cv) > 0;
    }

    public boolean Update(Aluno aluno){
        ContentValues cv = new ContentValues();
        cv.put("nome", aluno.getNome());
        cv.put("idtreino",aluno.getIdTreino());
        cv.put("datanascimento" , aluno.getDataNascimento());
        cv.put("objetivo",aluno.getObjetivo());
        cv.put("datainicio",aluno.getDataInicio());
        cv.put("altura", aluno.getAltura());
        cv.put("sexo",aluno.getSexo());


        return gw.getDatabase().update(TABLE_ALUNO,cv,"idaluno=?",new String[]{aluno.getIdAluno() + ""}) > 0;

    }

    public List<Aluno> Select(){
        List<Aluno> alunos= new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Aluno",null);
        while (cursor.moveToNext()){
           Aluno aluno= new Aluno();
           aluno.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));
           aluno.setIdTreino(cursor.getInt(cursor.getColumnIndex("idtreino")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setDataNascimento(cursor.getString(cursor.getColumnIndex("datanascimento")));
            aluno.setObjetivo(cursor.getString(cursor.getColumnIndex("objetivo")));
            aluno.setDataInicio(cursor.getString(cursor.getColumnIndex("datainicio")));
            aluno.setAltura(cursor.getDouble(cursor.getColumnIndex("altura")));
            aluno.setSexo(cursor.getString(cursor.getColumnIndex("sexo")));

            alunos.add(aluno);
        }
        cursor.close();
        return  alunos;

    }

    public Aluno SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Aluno ORDER BY idaluno DESC",null);
        while (cursor.moveToNext()){
            Aluno aluno= new Aluno();
            aluno.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));
            aluno.setIdTreino(cursor.getInt(cursor.getColumnIndex("idtreino")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setDataNascimento(cursor.getString(cursor.getColumnIndex("datanascimento")));
            aluno.setObjetivo(cursor.getString(cursor.getColumnIndex("objetivo")));
            aluno.setDataInicio(cursor.getString(cursor.getColumnIndex("datainicio")));
            aluno.setAltura(cursor.getDouble(cursor.getColumnIndex("altura")));
            aluno.setSexo(cursor.getString(cursor.getColumnIndex("sexo")));

            cursor.close();
            return aluno;

        }

        return null;

    }


    public Aluno SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Aluno WHERE idaluno = "+ id ,null);

        if(cursor.moveToFirst()){
            Aluno aluno= new Aluno();
            aluno.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));
            aluno.setIdTreino(cursor.getInt(cursor.getColumnIndex("idtreino")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setDataNascimento(cursor.getString(cursor.getColumnIndex("datanascimento")));
            aluno.setObjetivo(cursor.getString(cursor.getColumnIndex("objetivo")));
            aluno.setDataInicio(cursor.getString(cursor.getColumnIndex("datainicio")));
            aluno.setAltura(cursor.getDouble(cursor.getColumnIndex("altura")));
            aluno.setSexo(cursor.getString(cursor.getColumnIndex("sexo")));

            cursor.close();
            return  aluno;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_ALUNO,"idaluno=?",new String[]{id + ""}) > 0;
    }







}
