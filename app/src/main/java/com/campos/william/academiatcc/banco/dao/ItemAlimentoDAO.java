package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.ItemAlimento;

import java.util.ArrayList;
import java.util.List;

public class ItemAlimentoDAO {


    private final String TABLE_ITEMALIMENTO = "ItemAlimento";
    private DbGateway gw;

    public ItemAlimentoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(ItemAlimento itemAlimento){
        ContentValues cv = new ContentValues();
        cv.put("idalimento",itemAlimento.getIdAlimento());
        cv.put("iddieta" , itemAlimento.getIdDieta());
        cv.put("quantidade",itemAlimento.getQuantidade());
        cv.put("calorias",itemAlimento.getCalorias());

        return gw.getDatabase().insert(TABLE_ITEMALIMENTO,null,cv) > 0;
    }

    public boolean Update(ItemAlimento itemAlimento){

        ContentValues cv = new ContentValues();
        cv.put("idalimento",itemAlimento.getIdAlimento());
        cv.put("iddieta" , itemAlimento.getIdDieta());
        cv.put("quantidade",itemAlimento.getQuantidade());
        cv.put("calorias",itemAlimento.getCalorias());

        return gw.getDatabase().update(TABLE_ITEMALIMENTO,cv,"iditemalimento=?",new String[]{itemAlimento.getIdItemAlimento() + ""}) > 0;

    }

    public List<ItemAlimento> Select(){
        List<ItemAlimento> itemAlimentos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemAlimento",null);
        while (cursor.moveToNext()){
            ItemAlimento itemAlimento = new ItemAlimento();
              itemAlimento.setIdItemAlimento(cursor.getInt(cursor.getColumnIndex("iditemalimento")));
            itemAlimento.setIdAlimento(cursor.getInt(cursor.getColumnIndex("idalimento")));
            itemAlimento.setIdDieta(cursor.getInt(cursor.getColumnIndex("iddieta")));
            itemAlimento.setQuantidade(cursor.getDouble(cursor.getColumnIndex("quantidade")));
            itemAlimento.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));
            itemAlimentos.add(itemAlimento);
        }
        cursor.close();
        return itemAlimentos;

    }


    public List<ItemAlimento> SelectByDieta(int idDieta){
        List<ItemAlimento> itemAlimentos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemAlimento  WHERE iddieta = "+ idDieta,null);
        while (cursor.moveToNext()){
            ItemAlimento itemAlimento = new ItemAlimento();
            itemAlimento.setIdItemAlimento(cursor.getInt(cursor.getColumnIndex("iditemalimento")));
            itemAlimento.setIdAlimento(cursor.getInt(cursor.getColumnIndex("idalimento")));
            itemAlimento.setIdDieta(cursor.getInt(cursor.getColumnIndex("iddieta")));
            itemAlimento.setQuantidade(cursor.getDouble(cursor.getColumnIndex("quantidade")));
            itemAlimento.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));
            itemAlimentos.add(itemAlimento);
        }
        cursor.close();
        return itemAlimentos;

    }




    public ItemAlimento SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemAlimento ORDER BY iditemalimento DESC",null);
        while (cursor.moveToNext()){
            ItemAlimento itemAlimento = new ItemAlimento();
            itemAlimento.setIdItemAlimento(cursor.getInt(cursor.getColumnIndex("iditemalimento")));
            itemAlimento.setIdAlimento(cursor.getInt(cursor.getColumnIndex("idalimento")));
            itemAlimento.setIdDieta(cursor.getInt(cursor.getColumnIndex("iddieta")));
            itemAlimento.setQuantidade(cursor.getDouble(cursor.getColumnIndex("quantidade")));
            itemAlimento.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));
           cursor.close();
            return itemAlimento;

        }

        return null;

    }


    public ItemAlimento SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemAlimento WHERE iditemalimento = "+ id ,null);

        if(cursor.moveToFirst()){
            ItemAlimento itemAlimento = new ItemAlimento();
            itemAlimento.setIdItemAlimento(cursor.getInt(cursor.getColumnIndex("iditemalimento")));
            itemAlimento.setIdAlimento(cursor.getInt(cursor.getColumnIndex("idalimento")));
            itemAlimento.setIdDieta(cursor.getInt(cursor.getColumnIndex("iddieta")));
            itemAlimento.setQuantidade(cursor.getDouble(cursor.getColumnIndex("quantidade")));
            itemAlimento.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));
            cursor.close();
            return  itemAlimento;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_ITEMALIMENTO,"iditemalimento=?",new String[]{id + ""}) > 0;
    }




}
