package com.polettiapps.lucaspoletti.math.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.polettiapps.lucaspoletti.math.Activity.CalculadoraRegraDeTresSimplesActivity;
import com.polettiapps.lucaspoletti.math.Activity.MainActivity;
import com.polettiapps.lucaspoletti.math.Adapter.CalculadorasAdapter;
import com.polettiapps.lucaspoletti.math.Adapter.RecentesAdapter;
import com.polettiapps.lucaspoletti.math.Dao.CalculadoraDao;
import com.polettiapps.lucaspoletti.math.Dao.RecentesDao;
import com.polettiapps.lucaspoletti.math.Model.CalculadoraModel;
import com.polettiapps.lucaspoletti.math.Model.RecentesModel;
import com.polettiapps.lucaspoletti.math.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 14/05/2016.
 */
public class RecentesFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView lv_calculadorasRecentes;
    List<RecentesModel> listaRecentesHome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_recentes, container, false);
        RecentesDao recentesDao = new RecentesDao(getActivity());
        listaRecentesHome = recentesDao.listarCalculadorasRecentesHome();

        RecentesAdapter recentesAdapter = new RecentesAdapter(listaRecentesHome, getActivity());

        lv_calculadorasRecentes = (ListView) v.findViewById(R.id.listView_recentes);

        lv_calculadorasRecentes.setAdapter(recentesAdapter);

        lv_calculadorasRecentes.setOnItemClickListener(this);

        return v;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        int numeroPosicao = listaRecentesHome.get(position).get_id();

        Intent intent;

        if(numeroPosicao == 1) {
            intent = new Intent(getActivity(), CalculadoraRegraDeTresSimplesActivity.class);
            startActivity(intent);
        }


    }


}

