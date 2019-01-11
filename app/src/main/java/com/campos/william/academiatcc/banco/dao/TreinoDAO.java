package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.Treino;

import java.util.ArrayList;
import java.util.List;

public class TreinoDAO {


    private final String TABLE_TREINO = "Treino";
    private DbGateway gw;

    public TreinoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(Treino treino){
        ContentValues cv = new ContentValues();
        cv.put("descricao",treino.getDescricao());


        return gw.getDatabase().insert(TABLE_TREINO,null,cv) > 0;
    }

    public boolean Update(Treino treino){

        ContentValues cv = new ContentValues();
        cv.put("descricao",treino.getDescricao());


        return gw.getDatabase().update(TABLE_TREINO,cv,"idtreino=?",new String[]{treino.getIdTreino() + ""}) > 0;

    }

    public List<Treino> Select(){
        List<Treino> treinos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Treino",null);
        while (cursor.moveToNext()){
           Treino treino = new Treino();
           treino.setIdTreino(cursor.getInt(cursor.getColumnIndex("idtreino")));
            treino.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));

           treinos.add(treino);
        }
        cursor.close();
        return  treinos;

    }

    public  Treino SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Treino ORDER BY idtreino DESC",null);
        while (cursor.moveToNext()){
            Treino treino = new Treino();
            treino.setIdTreino(cursor.getInt(cursor.getColumnIndex("idtreino")));
            treino.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
            cursor.close();
            return treino;

        }

        return null;

    }


    public Treino SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Treino WHERE idtreino = "+ id ,null);

        if(cursor.moveToFirst()){
            Treino treino = new Treino();
            treino.setIdTreino(cursor.getInt(cursor.getColumnIndex("idtreino")));
            treino.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
            cursor.close();
            return treino;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_TREINO,"idtreino=?",new String[]{id + ""}) > 0;
    }





}
