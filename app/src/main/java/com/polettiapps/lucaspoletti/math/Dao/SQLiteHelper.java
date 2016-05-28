package com.polettiapps.lucaspoletti.math.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Lucas on 14/05/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "CalculaTudo_db";
    private static final int VERSAO_BD = 2;

    /*
     * TABELAS
     */

    public static final String tabela_calculadoras = "Calculadoras";
    public static final String tabela_recentes = "Recentes";

    ContentValues valores = new ContentValues();


    public SQLiteHelper(Context context){
        super(context, NOME_BANCO, null, VERSAO_BD);
    }



    @Override
    public void onCreate(SQLiteDatabase banco) {

        criarTabelaCalculadoras(banco);
        criarTabelaRecentes(banco);

        insertCalculadoras(banco);



    }

    @Override
    public void onUpgrade(SQLiteDatabase banco, int oldVersion, int newVersion) {
        banco.execSQL("drop table " + tabela_calculadoras + ";");
        banco.execSQL("drop table " + tabela_recentes + ";");

        onCreate(banco);
    }


    public void criarTabelaCalculadoras(SQLiteDatabase banco) {

        String tabelaCalculadoras = "CREATE TABLE " + tabela_calculadoras + "( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "calculadora TEXT NOT NULL ," +
                "categoria TEXT NOT NULL );";

        banco.execSQL(tabelaCalculadoras);

        Log.d("CREATE CALCULADORAS: ", tabelaCalculadoras);

    }

    public void criarTabelaRecentes(SQLiteDatabase banco) {

        String tabelaRecentes = "CREATE TABLE " + tabela_recentes + " ( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "idCalculadoraRecente INTEGER ," +
                "calculadora TEXT NOT NULL ," +
                "categoria TEXT NOT NULL );";

        banco.execSQL(tabelaRecentes);

        Log.d("CREATE CONFIGURAÇÕES: ", tabelaRecentes);

    }

    public void insertCalculadoras(SQLiteDatabase banco) {

        valores.put("calculadora", "Regra de 3 Simples");
        valores.put("categoria", "Básica");
        banco.insert(tabela_calculadoras, null, valores);

        valores.put("calculadora", "Potenciação");
        valores.put("categoria", "Básica");
        banco.insert(tabela_calculadoras, null, valores);

        valores.put("calculadora", "IMC");
        valores.put("categoria", "Saúde");
        banco.insert(tabela_calculadoras, null, valores);

        valores.put("calculadora", "Raiz Quadrada");
        valores.put("categoria", "Básica");
        banco.insert(tabela_calculadoras, null, valores);

    }


}
