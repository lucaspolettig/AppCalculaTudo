package com.polettiapps.lucaspoletti.math.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.polettiapps.lucaspoletti.math.Model.CalculadoraModel;
import com.polettiapps.lucaspoletti.math.R;

import java.util.List;

/**
 * Created by Lucas on 21/05/2016.
 */

public class CalculadorasAdapter extends BaseAdapter {

    private List<CalculadoraModel> listaCalculadoras;
    private Context context;
    private LayoutInflater layoutInflater;

    CalculadoraModel calculadoraModel = new CalculadoraModel();

    public CalculadorasAdapter(List<CalculadoraModel> listaCalculadoras, Context context) {
        this.listaCalculadoras = listaCalculadoras;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public void setListaCalculadoras(List<CalculadoraModel> listaCalculadoras) {
        this.listaCalculadoras = listaCalculadoras;
    }

    @Override
    public int getCount() {
        return listaCalculadoras.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCalculadoras.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = layoutInflater.inflate(R.layout.item_calculadora, null);

        //chamar consulta do banco que retorna ordem
        //criar if else conforme abaixo

        TextView tituloCalculadora = (TextView) view.findViewById(R.id.textView_itemCalculadora);
        tituloCalculadora.setText(listaCalculadoras.get(position).getCategoria() + " - " + listaCalculadoras.get(position).getNomeCalculadora());

        return view;
    }

}
