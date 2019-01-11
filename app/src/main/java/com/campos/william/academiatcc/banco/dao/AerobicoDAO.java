package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.Aerobico;

import java.util.ArrayList;
import java.util.List;

public class AerobicoDAO {


    private final String TABLE_AEROBICO = "Aerobico";
    private DbGateway gw;


    public AerobicoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(Aerobico aerobico){
        ContentValues cv = new ContentValues();
        cv.put("distancia",aerobico.getDistancia());
        cv.put("tempo" , aerobico.getTempo());
        cv.put("velocidade" , aerobico.getVelocidade());
        cv.put("calorias" , aerobico.getCalorias());


        return gw.getDatabase().insert(TABLE_AEROBICO,null,cv) > 0;
    }

    public boolean Update(Aerobico aerobico){

        ContentValues cv = new ContentValues();
        cv.put("distancia",aerobico.getDistancia());
        cv.put("tempo" , aerobico.getTempo());
        cv.put("velocidade" , aerobico.getVelocidade());
        cv.put("calorias" , aerobico.getCalorias());



        return gw.getDatabase().update(TABLE_AEROBICO,cv,"idaerobico=?",new String[]{aerobico.getIdAerobico() + ""}) > 0;

    }

    public List<Aerobico> Select(){
        List<Aerobico> aerobicos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Aerobico",null);
        while (cursor.moveToNext()){
          Aerobico aerobico = new Aerobico();
           aerobico.setIdAerobico(cursor.getInt(cursor.getColumnIndex("idaerobico")));
           aerobico.setDistancia(cursor.getDouble(cursor.getColumnIndex("distancia")));
            aerobico.setTempo(cursor.getString(cursor.getColumnIndex("tempo")));
            aerobico.setVelocidade(cursor.getDouble(cursor.getColumnIndex("velocidade")));
            aerobico.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));


         aerobicos.add(aerobico);
        }
        cursor.close();
        return  aerobicos;

    }

    public Aerobico SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Aerobico ORDER BY idaerobico DESC",null);
        while (cursor.moveToNext()){
            Aerobico aerobico = new Aerobico();
            aerobico.setIdAerobico(cursor.getInt(cursor.getColumnIndex("idaerobico")));
            aerobico.setDistancia(cursor.getDouble(cursor.getColumnIndex("distancia")));
            aerobico.setTempo(cursor.getString(cursor.getColumnIndex("tempo")));
            aerobico.setVelocidade(cursor.getDouble(cursor.getColumnIndex("velocidade")));
            aerobico.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));



            cursor.close();
            return aerobico;

        }

        return null;

    }


    public Aerobico SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Aerobico WHERE idaerobico = "+ id ,null);

        if(cursor.moveToFirst()){
            Aerobico aerobico = new Aerobico();
            aerobico.setIdAerobico(cursor.getInt(cursor.getColumnIndex("idaerobico")));
            aerobico.setDistancia(cursor.getDouble(cursor.getColumnIndex("distancia")));
            aerobico.setTempo(cursor.getString(cursor.getColumnIndex("tempo")));
            aerobico.setVelocidade(cursor.getDouble(cursor.getColumnIndex("velocidade")));
            aerobico.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));

            cursor.close();
            return  aerobico;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_AEROBICO,"idaerobico=?",new String[]{id + ""}) > 0;
    }




}
