package com.polettiapps.lucaspoletti.math.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.polettiapps.lucaspoletti.math.Model.CalculadoraModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 21/05/2016.
 */
public class CalculadoraDao {

    SQLiteHelper sqLiteHelper;

    public CalculadoraDao(Context context) {
        sqLiteHelper = new SQLiteHelper(context);
    }

    public List<CalculadoraModel> listarCalculadorasHome() {

        List<CalculadoraModel> listarCalculadorasHome = new ArrayList<CalculadoraModel>();

        SQLiteDatabase banco = sqLiteHelper.getReadableDatabase();
        Cursor cursor = banco.query(SQLiteHelper.tabela_calculadoras, new String[]
                {"_id", "calculadora", "categoria"}, null, null, null, null, "categoria, calculadora");

        while(cursor.moveToNext()) {
            CalculadoraModel objetoCalculadorasHome = new CalculadoraModel();
            objetoCalculadorasHome.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
            objetoCalculadorasHome.setNomeCalculadora(cursor.getString(cursor.getColumnIndex("calculadora")));
            objetoCalculadorasHome.setCategoria(cursor.getString(cursor.getColumnIndex("categoria")));
            listarCalculadorasHome.add(objetoCalculadorasHome);
        }

        return listarCalculadorasHome;
    }
}
