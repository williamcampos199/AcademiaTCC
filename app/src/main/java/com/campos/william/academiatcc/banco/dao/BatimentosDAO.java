package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.Batimentos;

import java.util.ArrayList;
import java.util.List;

public class BatimentosDAO {


    private final String TABLE_BATIMENTOS = "Batimentos";
    private DbGateway gw;


    public BatimentosDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(Batimentos batimentos){
        ContentValues cv = new ContentValues();
        cv.put("valor",batimentos.getValor());



        return gw.getDatabase().insert(TABLE_BATIMENTOS,null,cv) > 0;
    }

    public boolean Update(Batimentos batimentos){
        ContentValues cv = new ContentValues();
        cv.put("valor",batimentos.getValor());





        return gw.getDatabase().update(TABLE_BATIMENTOS,cv,"idbatimentos=?",new String[]{batimentos.getIdBatimentos() + ""}) > 0;

    }

    public List<Batimentos> Select(){
        List<Batimentos> batimentosList = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Batimentos",null);
        while (cursor.moveToNext()){
          Batimentos batimentos = new Batimentos();
          batimentos.setIdBatimentos(cursor.getInt(cursor.getColumnIndex("idbatimentos")));
        batimentos.setValor(cursor.getInt(cursor.getColumnIndex("valor")));


            batimentosList.add(batimentos);
        }
        cursor.close();
        return  batimentosList;

    }

    public Batimentos SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Batimentos ORDER BY idbatimentos DESC",null);
        while (cursor.moveToNext()){
            Batimentos batimentos = new Batimentos();
            batimentos.setIdBatimentos(cursor.getInt(cursor.getColumnIndex("idbatimentos")));
            batimentos.setValor(cursor.getInt(cursor.getColumnIndex("valor")));



            cursor.close();
            return batimentos;

        }

        return null;

    }


    public Batimentos SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Batimentos WHERE idbatimento = "+ id ,null);

        if(cursor.moveToFirst()){
            Batimentos batimentos = new Batimentos();
            batimentos.setIdBatimentos(cursor.getInt(cursor.getColumnIndex("idbatimentos")));
            batimentos.setValor(cursor.getInt(cursor.getColumnIndex("valor")));


            cursor.close();
            return  batimentos;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_BATIMENTOS,"idbatimentos=?",new String[]{id + ""}) > 0;
    }




}
