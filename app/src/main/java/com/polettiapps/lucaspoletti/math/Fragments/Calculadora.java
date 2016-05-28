package com.polettiapps.lucaspoletti.math.Fragments;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.polettiapps.lucaspoletti.math.Activity.CalculadoraIMCActivity;
import com.polettiapps.lucaspoletti.math.Activity.CalculadoraPotenciaActivity;
import com.polettiapps.lucaspoletti.math.Activity.CalculadoraRaizesActivity;
import com.polettiapps.lucaspoletti.math.Activity.CalculadoraRegraDeTresSimplesActivity;
import com.polettiapps.lucaspoletti.math.Adapter.CalculadorasAdapter;
import com.polettiapps.lucaspoletti.math.Adapter.RecentesAdapter;
import com.polettiapps.lucaspoletti.math.Dao.CalculadoraDao;
import com.polettiapps.lucaspoletti.math.Dao.ComandosBanco;
import com.polettiapps.lucaspoletti.math.Dao.RecentesDao;
import com.polettiapps.lucaspoletti.math.Dao.SQLiteHelper;
import com.polettiapps.lucaspoletti.math.Model.CalculadoraModel;
import com.polettiapps.lucaspoletti.math.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Lucas on 14/05/2016.
 */
public class Calculadora extends Fragment implements AdapterView.OnItemClickListener {

    ListView lv_calculadoras;
    Context context;
    List<CalculadoraModel> listaHome;
    ComandosBanco comandosBanco = new ComandosBanco(context);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_main, container, false);
        CalculadoraDao calculadoraDao = new CalculadoraDao(getActivity());
        listaHome = calculadoraDao.listarCalculadorasHome();

        CalculadorasAdapter calculadorasAdapter = new CalculadorasAdapter(listaHome, getActivity());

        lv_calculadoras = (ListView) v.findViewById(R.id.listView_calculadoras);

        lv_calculadoras.setAdapter(calculadorasAdapter);

        lv_calculadoras.setOnItemClickListener(this);

        return v;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        int numeroPosicao = listaHome.get(position).get_id();
        String nomeCalculadora = listaHome.get(position).getNomeCalculadora();
        String categoriaCalculadora = listaHome.get(position).getCategoria();

        Intent intent;
        Context context = this.getContext();


        if(numeroPosicao == 1) {
            intent = new Intent(getActivity(), CalculadoraRegraDeTresSimplesActivity.class);
            comandosBanco.insertRecentes(numeroPosicao, nomeCalculadora, categoriaCalculadora, context);
            startActivity(intent);
        } else if(numeroPosicao == 2) {
            intent = new Intent(getActivity(), CalculadoraPotenciaActivity.class);
            comandosBanco.insertRecentes(numeroPosicao, nomeCalculadora, categoriaCalculadora, context);
            startActivity(intent);
        } else if(numeroPosicao == 3) {
            intent = new Intent(getActivity(), CalculadoraIMCActivity.class);
            comandosBanco.insertRecentes(numeroPosicao, nomeCalculadora, categoriaCalculadora, context);
            startActivity(intent);
        } else if(numeroPosicao == 4) {
            intent = new Intent(getActivity(), CalculadoraRaizesActivity.class);
            comandosBanco.insertRecentes(numeroPosicao, nomeCalculadora, categoriaCalculadora, context);
            startActivity(intent);
        }




    }


}
