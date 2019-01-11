package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.ItemDieta;

import java.util.ArrayList;
import java.util.List;


public class ItemDietaDAO {


    private final String TABLE_ITEMDIETA = "ItemDieta";
    private DbGateway gw;


    public ItemDietaDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(ItemDieta itemDieta){
        ContentValues cv = new ContentValues();
        cv.put("iddieta",itemDieta.getIdDieta());
        cv.put("idaluno",itemDieta.getIdAluno());




        return gw.getDatabase().insert(TABLE_ITEMDIETA,null,cv) > 0;
    }

    public boolean Update(ItemDieta itemDieta){
        ContentValues cv = new ContentValues();
        cv.put("iddieta",itemDieta.getIdDieta());
        cv.put("idaluno",itemDieta.getIdAluno());




        return gw.getDatabase().update(TABLE_ITEMDIETA,cv,"iditemdieta=?",new String[]{itemDieta.getIdItemDieta() + ""}) > 0;

    }

    public List<ItemDieta> Select(){
        List<ItemDieta> itemDietas = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemDieta",null);
        while (cursor.moveToNext()){
           ItemDieta itemDieta = new ItemDieta();
            itemDieta.setIdItemDieta(cursor.getInt(cursor.getColumnIndex("iditemdieta")));
            itemDieta.setIdDieta(cursor.getInt(cursor.getColumnIndex("iddieta")));
            itemDieta.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));



            itemDietas.add(itemDieta);
        }
        cursor.close();
        return  itemDietas;

    }

    public ItemDieta SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemDieta ORDER BY iditemdieta DESC",null);
        while (cursor.moveToNext()){
            ItemDieta itemDieta = new ItemDieta();
            itemDieta.setIdItemDieta(cursor.getInt(cursor.getColumnIndex("iditemdieta")));
            itemDieta.setIdDieta(cursor.getInt(cursor.getColumnIndex("iddieta")));
            itemDieta.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));



            cursor.close();
            return itemDieta;

        }

        return null;

    }


    public ItemDieta SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemDieta WHERE iditemdieta = "+ id ,null);

        if(cursor.moveToFirst()){
            ItemDieta itemDieta = new ItemDieta();
            itemDieta.setIdItemDieta(cursor.getInt(cursor.getColumnIndex("iditemdieta")));
            itemDieta.setIdDieta(cursor.getInt(cursor.getColumnIndex("iddieta")));
            itemDieta.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));





            cursor.close();
            return  itemDieta;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_ITEMDIETA,"iditemdieta=?",new String[]{id + ""}) > 0;
    }





}
