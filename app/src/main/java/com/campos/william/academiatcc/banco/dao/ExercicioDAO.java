package com.campos.william.academiatcc.banco.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.Exercicio;


import java.util.ArrayList;
import java.util.List;

public class ExercicioDAO {



    private final String TABLE_EXERCICIO = "Exercicio";
    private DbGateway gw;


    public ExercicioDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(Exercicio exercicio){
        ContentValues cv = new ContentValues();
        cv.put("tipo",exercicio.getTipo());
        cv.put("nome",exercicio.getNome());
        cv.put("repeticoes",exercicio.getRepetições());
        cv.put("obs",exercicio.getObs());


        return gw.getDatabase().insert(TABLE_EXERCICIO,null,cv) > 0;
    }

    public boolean Update(Exercicio exercicio){

        ContentValues cv = new ContentValues();
        cv.put("tipo",exercicio.getTipo());
        cv.put("nome",exercicio.getNome());
        cv.put("repeticoes",exercicio.getRepetições());
        cv.put("obs",exercicio.getObs());



        return gw.getDatabase().update(TABLE_EXERCICIO,cv,"idexercicio=?",new String[]{exercicio.getIdExercicio()+ ""}) > 0;

    }

    public List<Exercicio> Select(){
        List<Exercicio> exercicios = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Exercicio",null);
        while (cursor.moveToNext()){
             Exercicio exercicio = new Exercicio();
            exercicio.setIdExercicio(cursor.getInt(cursor.getColumnIndex("idexercicio")));
            exercicio.setTipo(cursor.getString(cursor.getColumnIndex("tipo")));
           exercicio.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            exercicio.setRepetições(cursor.getString(cursor.getColumnIndex("repeticoes")));
            exercicio.setObs(cursor.getString(cursor.getColumnIndex("obs")));


           exercicios.add(exercicio);
        }
        cursor.close();
        return  exercicios;

    }

    public Exercicio SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Exercicio ORDER BY idexercicio DESC",null);
        while (cursor.moveToNext()){
            Exercicio exercicio = new Exercicio();
            exercicio.setIdExercicio(cursor.getInt(cursor.getColumnIndex("idexercicio")));
            exercicio.setTipo(cursor.getString(cursor.getColumnIndex("tipo")));
            exercicio.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            exercicio.setRepetições(cursor.getString(cursor.getColumnIndex("repeticoes")));
            exercicio.setObs(cursor.getString(cursor.getColumnIndex("obs")));

            cursor.close();
            return  exercicio;

        }

        return null;

    }


    public Exercicio SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Exercicio WHERE idexercicio = "+ id ,null);

        if(cursor.moveToFirst()){
            Exercicio exercicio = new Exercicio();
            exercicio.setIdExercicio(cursor.getInt(cursor.getColumnIndex("idexercicio")));
            exercicio.setTipo(cursor.getString(cursor.getColumnIndex("tipo")));
            exercicio.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            exercicio.setRepetições(cursor.getString(cursor.getColumnIndex("repeticoes")));
            exercicio.setObs(cursor.getString(cursor.getColumnIndex("obs")));

            cursor.close();
            return  exercicio;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_EXERCICIO,"idexercicio=?",new String[]{id + ""}) > 0;
    }


   


}
