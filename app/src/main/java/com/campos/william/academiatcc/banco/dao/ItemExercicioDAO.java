package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.ItemExercicio;

import java.util.ArrayList;
import java.util.List;

public class ItemExercicioDAO {



    private final String TABLE_ITEMEXERCICIO = "ItemExercicio";
    private DbGateway gw;


    public ItemExercicioDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(ItemExercicio itemExercicio){
        ContentValues cv = new ContentValues();
        cv.put("idtreino",itemExercicio.getIdTreino());
        cv.put("idexercicio",itemExercicio.getIdExercicio());
        cv.put("dia",itemExercicio.getDia());




        return gw.getDatabase().insert(TABLE_ITEMEXERCICIO,null,cv) > 0;
    }

    public boolean Update(ItemExercicio itemExercicio){
        ContentValues cv = new ContentValues();
        cv.put("idtreino",itemExercicio.getIdTreino());
        cv.put("idexercicio",itemExercicio.getIdExercicio());
        cv.put("dia",itemExercicio.getDia());




        return gw.getDatabase().update(TABLE_ITEMEXERCICIO,cv,"iditemexercicio=?",new String[]{itemExercicio.getIdItemExercicio() + ""}) > 0;

    }

    public List<ItemExercicio> Select(){
        List<ItemExercicio> itemExercicios= new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemExercicio",null);
        while (cursor.moveToNext()){
           ItemExercicio itemExercicio = new ItemExercicio();
           itemExercicio.setIdItemExercicio(cursor.getInt(cursor.getColumnIndex("iditemexercicio")));
          itemExercicio.setIdExercicio(cursor.getInt(cursor.getColumnIndex("idexercicio")));
       itemExercicio.setIdTreino(cursor.getInt(cursor.getColumnIndex("idtreino")));
       itemExercicio.setDia(cursor.getString(cursor.getColumnIndex("dia")));



            itemExercicios.add(itemExercicio);
        }
        cursor.close();
        return  itemExercicios;

    }

    public ItemExercicio SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemExercicio ORDER BY iditemexercicio DESC",null);
        while (cursor.moveToNext()){
            ItemExercicio itemExercicio = new ItemExercicio();
            itemExercicio.setIdItemExercicio(cursor.getInt(cursor.getColumnIndex("iditemexercicio")));
            itemExercicio.setIdExercicio(cursor.getInt(cursor.getColumnIndex("idexercicio")));
            itemExercicio.setIdTreino(cursor.getInt(cursor.getColumnIndex("idtreino")));
            itemExercicio.setDia(cursor.getString(cursor.getColumnIndex("dia")));




            cursor.close();
            return itemExercicio;

        }

        return null;

    }


    public ItemExercicio SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM ItemExercicio WHERE iditemexercicio = "+ id ,null);

        if(cursor.moveToFirst()){
            ItemExercicio itemExercicio = new ItemExercicio();
            itemExercicio.setIdItemExercicio(cursor.getInt(cursor.getColumnIndex("iditemexercicio")));
            itemExercicio.setIdExercicio(cursor.getInt(cursor.getColumnIndex("idexercicio")));
            itemExercicio.setIdTreino(cursor.getInt(cursor.getColumnIndex("idtreino")));
            itemExercicio.setDia(cursor.getString(cursor.getColumnIndex("dia")));





            cursor.close();
            return  itemExercicio;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_ITEMEXERCICIO,"iditemexercicio=?",new String[]{id + ""}) > 0;
    }





}
