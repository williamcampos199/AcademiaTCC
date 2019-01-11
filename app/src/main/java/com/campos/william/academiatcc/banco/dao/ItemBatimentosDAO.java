package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.ItemBatimentos;

import java.util.ArrayList;
import java.util.List;

public class ItemBatimentosDAO {



    private final String TABLE_ITEMBATIMENTOS = "ItemBatimentos";
    private DbGateway gw;


    public ItemBatimentosDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(ItemBatimentos itemBatimentos){
        ContentValues cv = new ContentValues();
        cv.put("idbatimentos",itemBatimentos.getIdBatimentos());
        cv.put("idaerobico",itemBatimentos.getIdAerobico());




        return gw.getDatabase().insert(TABLE_ITEMBATIMENTOS,null,cv) > 0;
    }

    public boolean Update(ItemBatimentos itemBatimentos){
        ContentValues cv = new ContentValues();
        cv.put("idbatimentos",itemBatimentos.getIdBatimentos());
        cv.put("idaerobico",itemBatimentos.getIdAerobico());




        return gw.getDatabase().update(TABLE_ITEMBATIMENTOS,cv,"iditembatimentos=?",new String[]{itemBatimentos.getIdItemBatimentos() + ""}) > 0;

    }

    public List<ItemBatimentos> Select(){
        List<ItemBatimentos> itemBatimentos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemBatimentos",null);
        while (cursor.moveToNext()){
           ItemBatimentos itemBatimento = new ItemBatimentos();
          itemBatimento.setIdItemBatimentos(cursor.getInt(cursor.getColumnIndex("iditembatimentos")));
           itemBatimento.setIdBatimentos(cursor.getInt(cursor.getColumnIndex("idbatimentos")));
            itemBatimento.setIdAerobico(cursor.getInt(cursor.getColumnIndex("idaerobico")));



            itemBatimentos.add(itemBatimento);
        }
        cursor.close();
        return  itemBatimentos;

    }

    public ItemBatimentos SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemBatimentos ORDER BY iditembatimentos DESC",null);
        while (cursor.moveToNext()){
            ItemBatimentos itemBatimento = new ItemBatimentos();
            itemBatimento.setIdItemBatimentos(cursor.getInt(cursor.getColumnIndex("iditembatimentos")));
            itemBatimento.setIdBatimentos(cursor.getInt(cursor.getColumnIndex("idbatimentos")));
            itemBatimento.setIdAerobico(cursor.getInt(cursor.getColumnIndex("idaerobico")));



            cursor.close();
            return itemBatimento;

        }

        return null;

    }


    public ItemBatimentos SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemBatimentos WHERE iditembatimentos = "+ id ,null);

        if(cursor.moveToFirst()){
            ItemBatimentos itemBatimento = new ItemBatimentos();
            itemBatimento.setIdItemBatimentos(cursor.getInt(cursor.getColumnIndex("iditembatimentos")));
            itemBatimento.setIdBatimentos(cursor.getInt(cursor.getColumnIndex("idbatimentos")));
            itemBatimento.setIdAerobico(cursor.getInt(cursor.getColumnIndex("idaerobico")));




            cursor.close();
            return  itemBatimento;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_ITEMBATIMENTOS,"iditembatimentos=?",new String[]{id + ""}) > 0;
    }






}
