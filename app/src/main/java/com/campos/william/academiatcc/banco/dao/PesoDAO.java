package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.Peso;

import java.util.ArrayList;
import java.util.List;

public class PesoDAO {

    private final String TABLE_PESO = "Peso";
    private DbGateway gw;

    public PesoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(Peso peso){
        ContentValues cv = new ContentValues();
        cv.put("valor",peso.getValor());
        cv.put("datapeso" , peso.getDatapeso());
        cv.put("imc", peso.getImc());

        return gw.getDatabase().insert(TABLE_PESO,null,cv) > 0;
    }

    public boolean Update(Peso peso){

        ContentValues cv = new ContentValues();
        cv.put("valor",peso.getValor());
        cv.put("datapeso" , peso.getDatapeso());
        cv.put("imc", peso.getImc());

        return gw.getDatabase().update(TABLE_PESO,cv,"idpeso=?",new String[]{peso.getIdPeso() + ""}) > 0;

    }

    public List<Peso> Select(){
        List<Peso> pesos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Peso",null);
        while (cursor.moveToNext()){
            Peso peso = new Peso();
            peso.setIdPeso(cursor.getInt(cursor.getColumnIndex("idpeso")));
           peso.setValor(cursor.getDouble(cursor.getColumnIndex("valor")));
           peso.setDatapeso(cursor.getString(cursor.getColumnIndex("datapeso")));
            peso.setImc(cursor.getDouble(cursor.getColumnIndex("imc")));

           pesos.add(peso);
        }
        cursor.close();
        return  pesos;

    }

    public Peso SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Peso ORDER BY idpeso DESC",null);
        while (cursor.moveToNext()){
            Peso peso = new Peso();
            peso.setIdPeso(cursor.getInt(cursor.getColumnIndex("idpeso")));
            peso.setValor(cursor.getDouble(cursor.getColumnIndex("valor")));
            peso.setDatapeso(cursor.getString(cursor.getColumnIndex("datapeso")));
            peso.setImc(cursor.getDouble(cursor.getColumnIndex("imc")));

            cursor.close();
            return peso;

        }

        return null;

    }

    public List<Peso> SelectByData(String datapeso){
        List<Peso> pesos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Peso WHERE datapeso = ?",new String[]{datapeso});
            while (cursor.moveToNext()) {
                Peso peso = new Peso();
                peso.setIdPeso(cursor.getInt(cursor.getColumnIndex("idpeso")));
                peso.setValor(cursor.getDouble(cursor.getColumnIndex("valor")));
                peso.setDatapeso(cursor.getString(cursor.getColumnIndex("datapeso")));
                peso.setImc(cursor.getDouble(cursor.getColumnIndex("imc")));


                pesos.add(peso);

            }

        cursor.close();
        return pesos;

    }




    public Peso SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Peso WHERE idpeso = "+ id ,null);

        if(cursor.moveToFirst()){
            Peso peso = new Peso();
            peso.setIdPeso(cursor.getInt(cursor.getColumnIndex("idpeso")));
            peso.setValor(cursor.getDouble(cursor.getColumnIndex("valor")));
            peso.setDatapeso(cursor.getString(cursor.getColumnIndex("datapeso")));
            peso.setImc(cursor.getDouble(cursor.getColumnIndex("imc")));
            cursor.close();
            return peso;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_PESO,"idpeso=?",new String[]{id + ""}) > 0;
    }






}
