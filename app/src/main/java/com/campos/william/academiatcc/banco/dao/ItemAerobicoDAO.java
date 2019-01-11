package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.ItemAerobico;

import java.util.ArrayList;
import java.util.List;

public class ItemAerobicoDAO {

    private final String TABLE_ITEMAEROBICO = "ItemAerobico";
    private DbGateway gw;


    public ItemAerobicoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(ItemAerobico itemAerobico){
        ContentValues cv = new ContentValues();
        cv.put("idaerobico",itemAerobico.getIdAerobico());
        cv.put("idaluno",itemAerobico.getIdAluno());




        return gw.getDatabase().insert(TABLE_ITEMAEROBICO,null,cv) > 0;
    }

    public boolean Update(ItemAerobico itemAerobico){
        ContentValues cv = new ContentValues();
        cv.put("idaerobico",itemAerobico.getIdAerobico());
        cv.put("idaluno",itemAerobico.getIdAluno());




        return gw.getDatabase().update(TABLE_ITEMAEROBICO,cv,"iditemaerobico=?",new String[]{itemAerobico.getIdItemAerobico() + ""}) > 0;

    }

    public List<ItemAerobico> Select(){
        List<ItemAerobico> itemAerobicos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemAerobico",null);
        while (cursor.moveToNext()){
           ItemAerobico itemAerobico = new ItemAerobico();
           itemAerobico.setIdItemAerobico(cursor.getInt(cursor.getColumnIndex("iditemaerobico")));
          itemAerobico.setIdAerobico(cursor.getInt(cursor.getColumnIndex("idaerobico")));
          itemAerobico.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));



       itemAerobicos.add(itemAerobico);
        }
        cursor.close();
        return  itemAerobicos;

    }

    public ItemAerobico SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemAerobico ORDER BY iditemaerobico DESC",null);
        while (cursor.moveToNext()){
            ItemAerobico itemAerobico = new ItemAerobico();
            itemAerobico.setIdItemAerobico(cursor.getInt(cursor.getColumnIndex("iditemaerobico")));
            itemAerobico.setIdAerobico(cursor.getInt(cursor.getColumnIndex("idaerobico")));
            itemAerobico.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));


            cursor.close();
            return itemAerobico;

        }

        return null;

    }


    public ItemAerobico SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemAerobico WHERE iditemaerobico = "+ id ,null);

        if(cursor.moveToFirst()){
            ItemAerobico itemAerobico = new ItemAerobico();
            itemAerobico.setIdItemAerobico(cursor.getInt(cursor.getColumnIndex("iditemaerobico")));
            itemAerobico.setIdAerobico(cursor.getInt(cursor.getColumnIndex("idaerobico")));
            itemAerobico.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));




            cursor.close();
            return  itemAerobico;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_ITEMAEROBICO,"iditemaerobico=?",new String[]{id + ""}) > 0;
    }






}
