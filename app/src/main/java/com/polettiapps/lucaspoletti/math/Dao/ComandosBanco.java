package com.polettiapps.lucaspoletti.math.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ComandosBanco {

    SQLiteHelper banco;
    SQLiteDatabase db;


    public ComandosBanco(Context context) {
        banco = new SQLiteHelper(context);
    }

    public void insertRecentes(int id, String calculadora, String categoria, Context context) {

            SQLiteDatabase db = new SQLiteHelper(context).getWritableDatabase();
            ContentValues valores = new ContentValues();

            valores.put("idCalculadoraRecente", id);
            valores.put("calculadora", calculadora);
            valores.put("categoria", categoria);

            db.insert(SQLiteHelper.tabela_recentes, null, valores);
            db.close();

    }

}

