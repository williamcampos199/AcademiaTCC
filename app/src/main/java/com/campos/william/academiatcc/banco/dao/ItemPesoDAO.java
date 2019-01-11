package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.ItemPeso;

import java.util.ArrayList;
import java.util.List;

public class ItemPesoDAO {


    private final String TABLE_ITEMPESO = "ItemPeso";
    private DbGateway gw;


    public ItemPesoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(ItemPeso itemPeso){
        ContentValues cv = new ContentValues();
        cv.put("idpeso",itemPeso.getIdPeso());
        cv.put("idaluno",itemPeso.getIdAluno());




        return gw.getDatabase().insert(TABLE_ITEMPESO,null,cv) > 0;
    }

    public boolean Update(ItemPeso itemPeso){
        ContentValues cv = new ContentValues();
        cv.put("idpeso",itemPeso.getIdPeso());
        cv.put("idaluno",itemPeso.getIdAluno());




        return gw.getDatabase().update(TABLE_ITEMPESO,cv,"iditempeso=?",new String[]{itemPeso.getIdItemPeso() + ""}) > 0;

    }

    public List<ItemPeso> Select(){
        List<ItemPeso> itemPesos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemPeso",null);
        while (cursor.moveToNext()){
            ItemPeso itemPeso = new ItemPeso();
           itemPeso.setIdItemPeso(cursor.getInt(cursor.getColumnIndex("iditempeso")));
            itemPeso.setIdPeso(cursor.getInt(cursor.getColumnIndex("idpeso")));
            itemPeso.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));



            itemPesos.add(itemPeso);
        }
        cursor.close();
        return  itemPesos;

    }

    public ItemPeso SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemPeso ORDER BY iditempeso DESC",null);
        while (cursor.moveToNext()){
            ItemPeso itemPeso = new ItemPeso();
            itemPeso.setIdItemPeso(cursor.getInt(cursor.getColumnIndex("iditempeso")));
            itemPeso.setIdPeso(cursor.getInt(cursor.getColumnIndex("idpeso")));
            itemPeso.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));



            cursor.close();
            return itemPeso;

        }

        return null;

    }


    public ItemPeso SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemPeso WHERE iditempeso = "+ id ,null);

        if(cursor.moveToFirst()){
            ItemPeso itemPeso = new ItemPeso();
            itemPeso.setIdItemPeso(cursor.getInt(cursor.getColumnIndex("iditempeso")));
            itemPeso.setIdPeso(cursor.getInt(cursor.getColumnIndex("idpeso")));
            itemPeso.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));




            cursor.close();
            return  itemPeso;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_ITEMPESO,"iditempeso=?",new String[]{id + ""}) > 0;
    }




}
