package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;
import com.campos.william.academiatcc.banco.model.Dieta;

import java.util.ArrayList;
import java.util.List;

public class DietaDAO {

    private final String TABLE_DIETA = "Dieta";
    private DbGateway gw;

  public DietaDAO(Context ctx){
      gw = DbGateway.getInstance(ctx);
  }

  public boolean Insert(Dieta dieta){
      ContentValues cv = new ContentValues();
      cv.put("nome",dieta.getNome());
      cv.put("datadieta" , dieta.getDatadieta());
      cv.put("calorias",dieta.getCalorias());

      return gw.getDatabase().insert(TABLE_DIETA,null,cv) > 0;
  }

  public boolean Update(Dieta dieta){

      ContentValues cv = new ContentValues();
      cv.put("nome",dieta.getNome());
      cv.put("datadieta" , dieta.getDatadieta());
      cv.put("calorias",dieta.getCalorias());

      return gw.getDatabase().update(TABLE_DIETA,cv,"iddieta=?",new String[]{dieta.getIdDieta() + ""}) > 0;

  }

  public List<Dieta> Select(){
      List<Dieta> dietas = new ArrayList<>();
      Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Dieta",null);
      while (cursor.moveToNext()){
          Dieta dieta = new Dieta();
          dieta.setIdDieta(cursor.getInt(cursor.getColumnIndex("iddieta")));
          dieta.setNome(cursor.getString(cursor.getColumnIndex("nome")));
          dieta.setDatadieta(cursor.getString(cursor.getColumnIndex("datadieta")));
          dieta.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));

          dietas.add(dieta);
      }
      cursor.close();
      return dietas;

  }

  public Dieta SelectUltimoRegistro(){
      Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Dieta ORDER BY iddieta DESC",null);
      while (cursor.moveToNext()){
          Dieta dieta = new Dieta();
          dieta.setIdDieta(cursor.getInt(cursor.getColumnIndex("iddieta")));
          dieta.setNome(cursor.getString(cursor.getColumnIndex("nome")));
          dieta.setDatadieta(cursor.getString(cursor.getColumnIndex("datadieta")));
          dieta.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));
         cursor.close();
         return dieta;

      }

      return null;

  }


  public Dieta SelectByID(int id){
      Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Dieta WHERE iddieta = "+ id ,null);

      if(cursor.moveToFirst()){
          Dieta dieta = new Dieta();
          dieta.setIdDieta(cursor.getInt(cursor.getColumnIndex("iddieta")));
          dieta.setNome(cursor.getString(cursor.getColumnIndex("nome")));
          dieta.setDatadieta(cursor.getString(cursor.getColumnIndex("datadieta")));
          dieta.setCalorias(cursor.getDouble(cursor.getColumnIndex("calorias")));
          cursor.close();
          return dieta;
      }



      return null;

  }


public boolean Delete(int id){
      return gw.getDatabase().delete(TABLE_DIETA,"iddieta=?",new String[]{id + ""}) > 0;
}


}
