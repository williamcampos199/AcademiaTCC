package com.campos.william.academiatcc.banco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.campos.william.academiatcc.banco.helper.DbGateway;

import com.campos.william.academiatcc.banco.model.Login;

import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
    private final String TABLE_LOGIN = "Login";
    private DbGateway gw;

    public LoginDAO(Context ctx){
    gw = DbGateway.getInstance(ctx);
    }

    public boolean Insert(Login login){
        ContentValues cv = new ContentValues();
        cv.put("idaluno",login.getIdAluno());
        cv.put("usuario",login.getUsuario());
        cv.put("senha",login.getSenha());

        return gw.getDatabase().insert(TABLE_LOGIN,null,cv) > 0;
    }

    public boolean Update(Login login){
        ContentValues cv = new ContentValues();
        cv.put("idaluno",login.getIdAluno());
        cv.put("usuario",login.getUsuario());
        cv.put("senha",login.getSenha());

        return gw.getDatabase().update(TABLE_LOGIN,cv,"idlogin=?",new String[]{login.getIdLogin() + ""}) > 0;
    }

    public List<Login> Select(){
        String sql = "SELECT idlogin,";
        sql += " idaluno,";
        sql += " usuario,";
        sql += " senha";
        sql += " FROM Login";

        List<Login> logins = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery(sql,null);
        while (cursor.moveToNext()){
            Login login = new Login();
            login.setIdLogin(cursor.getInt(cursor.getColumnIndex("idlogin")));
            login.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));
            login.setUsuario(cursor.getString(cursor.getColumnIndex("usuario")));
            login.setSenha(cursor.getString(cursor.getColumnIndex("senha")));

            logins.add(login);
        }
        cursor.close();
        return  logins;
    }

    public Login SelectUltimoRegistro(){
        String sql = "SELECT idlogin,";
        sql += " idaluno,";
        sql +=  "usuario,";
        sql += " senha";
        sql += " FROM Login";
        sql += " ORDER BY idlogin DESC";

        Cursor cursor = gw.getDatabase().rawQuery(sql,null);
        while (cursor.moveToNext()){
            Login login = new Login();
            login.setIdLogin(cursor.getInt(cursor.getColumnIndex("idlogin")));
            login.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));
            login.setUsuario(cursor.getString(cursor.getColumnIndex("usuario")));
            login.setSenha(cursor.getString(cursor.getColumnIndex("senha")));

            cursor.close();
            return login;
        }
        return null;
    }

    public Login SelectByID(int id){
        String sql = "SELECT idlogin,";
        sql += " idaluno,";
        sql += " usuario,";
        sql += " senha";
        sql += " FROM Login";
        sql += " WHERE idlogin = ";

        Cursor cursor = gw.getDatabase().rawQuery(sql + id ,null);

        if(cursor.moveToFirst()){
            Login login = new Login();
            login.setIdLogin(cursor.getInt(cursor.getColumnIndex("idlogin")));
            login.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));
            login.setUsuario(cursor.getString(cursor.getColumnIndex("usuario")));
            login.setSenha(cursor.getString(cursor.getColumnIndex("senha")));

            cursor.close();
            return  login;
        }

        return null;
    }


    public Login SelectByUsuario(String usuario){
        String sql = "SELECT idlogin,";
        sql += " idaluno,";
        sql += " usuario,";
        sql += "senha";
        sql += " FROM Login";
        sql += " WHERE usuario = ?";

        Cursor cursor = gw.getDatabase().rawQuery(sql ,new String[]{usuario});

        if(cursor.moveToFirst()){
            Login login = new Login();
            login.setIdLogin(cursor.getInt(cursor.getColumnIndex("idlogin")));
            login.setIdAluno(cursor.getInt(cursor.getColumnIndex("idaluno")));
            login.setUsuario(cursor.getString(cursor.getColumnIndex("usuario")));
            login.setSenha(cursor.getString(cursor.getColumnIndex("senha")));

            cursor.close();
            return  login;
        }

        return null;

    }

    public boolean Delete(int id){
        return gw.getDatabase().delete(TABLE_LOGIN,"idlogin=?",new String[]{id + ""}) > 0;
    }

}
