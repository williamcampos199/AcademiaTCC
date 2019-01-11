package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.Alimento;
import com.campos.william.academiatcc.banco.model.Dieta;

import java.util.ArrayList;
import java.util.List;

public class AlimentoDAO {



    private final String TABLE_ALIMENTO = "Alimento";
    private DbGateway gw;
    private static Alimento ultimoAlimentoEditado;

    public AlimentoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(Alimento alimento){
        ContentValues cv = new ContentValues();
        cv.put("nome",alimento.getNome());
        cv.put("calorias" , alimento.getCalorias());


        return gw.getDatabase().insert(TABLE_ALIMENTO,null,cv) > 0;
    }

    public boolean Update(Alimento alimento){

        ContentValues cv = new ContentValues();
        cv.put("nome",alimento.getNome());
        cv.put("calorias" , alimento.getCalorias());


        ultimoAlimentoEditado = alimento;
        return gw.getDatabase().update(TABLE_ALIMENTO,cv,"idalimento=?",new String[]{alimento.getIdAlimento() + ""}) > 0;

    }

    public List<Alimento> Select(){
        List<Alimento> alimentos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Alimento",null);
        while (cursor.moveToNext()){
            Alimento alimento = new Alimento();
            alimento.setIdAlimento(cursor.getInt(cursor.getColumnIndex("idalimento")));
            alimento.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            alimento.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));


            alimentos.add(alimento);
        }
        cursor.close();
        return  alimentos;

    }

    public Alimento SelectUltimoRegistro(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Alimento ORDER BY idalimento DESC",null);
        while (cursor.moveToNext()){
            Alimento alimento = new Alimento();
            alimento.setIdAlimento(cursor.getInt(cursor.getColumnIndex("idalimento")));
            alimento.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            alimento.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));

            cursor.close();
           return alimento;

        }

        return null;

    }


    public Alimento SelectByID(int id){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Alimento WHERE idalimento = "+ id ,null);

        if(cursor.moveToFirst()){
            Alimento alimento = new Alimento();
            alimento.setIdAlimento(cursor.getInt(cursor.getColumnIndex("idalimento")));
            alimento.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            alimento.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));

            cursor.close();
         return  alimento;
        }



        return null;

    }


    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_ALIMENTO,"idalimento=?",new String[]{id + ""}) > 0;
    }


    public static Alimento getUltimoAlimentoEditado() {
        return ultimoAlimentoEditado;
    }

    public static void setUltimoAlimentoEditado(Alimento ultimoAlimentoEditado) {
        AlimentoDAO.ultimoAlimentoEditado = ultimoAlimentoEditado;
    }
}
