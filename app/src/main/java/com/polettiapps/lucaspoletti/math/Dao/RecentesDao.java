package com.polettiapps.lucaspoletti.math.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.polettiapps.lucaspoletti.math.Model.RecentesModel;

import java.util.ArrayList;
import java.util.List;

public class RecentesDao {

    SQLiteHelper sqLiteHelper;
    SQLiteDatabase banco;

    public RecentesDao(Context context) {
        sqLiteHelper = new SQLiteHelper(context);
    }

    public List<RecentesModel> listarCalculadorasRecentesHome() {

        List<RecentesModel> listarCalculadorasHome = new ArrayList<RecentesModel>();

        banco = sqLiteHelper.getReadableDatabase();
        Cursor cursor = banco.query(SQLiteHelper.tabela_recentes, new String[]
                {"_id", "idCalculadoraRecente", "calculadora", "categoria"}, null, null, "idCalculadoraRecente" , null, null);

        while(cursor.moveToNext()) {
            RecentesModel objetoCalculadorasRecentesHome = new RecentesModel();
            objetoCalculadorasRecentesHome.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
            objetoCalculadorasRecentesHome.setId(cursor.getInt(cursor.getColumnIndex("idCalculadoraRecente")));
            objetoCalculadorasRecentesHome.setNomeCalculadora(cursor.getString(cursor.getColumnIndex("calculadora")));
            objetoCalculadorasRecentesHome.setCategoria(cursor.getString(cursor.getColumnIndex("categoria")));
            listarCalculadorasHome.add(objetoCalculadorasRecentesHome);
        }

        return listarCalculadorasHome;
    }
}
