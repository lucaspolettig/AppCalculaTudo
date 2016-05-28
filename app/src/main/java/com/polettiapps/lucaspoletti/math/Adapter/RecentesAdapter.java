package com.polettiapps.lucaspoletti.math.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.polettiapps.lucaspoletti.math.Model.RecentesModel;
import com.polettiapps.lucaspoletti.math.R;

import java.util.List;

/**
 * Created by Lucas on 26/05/2016.
 */
public class RecentesAdapter extends BaseAdapter {

    private List<RecentesModel> listaCalculadorasRecentes;
    private Context context;
    private LayoutInflater layoutInflater;

    RecentesModel calculadoraModel = new RecentesModel();

    public RecentesAdapter(List<RecentesModel> listaCalculadorasRecentes, Context context) {
        this.listaCalculadorasRecentes = listaCalculadorasRecentes;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public void setListaCalculadorasRecentes(List<RecentesModel> listaCalculadoras) {
        this.listaCalculadorasRecentes = listaCalculadoras;
    }

    @Override
    public int getCount() {
        return listaCalculadorasRecentes.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCalculadorasRecentes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = layoutInflater.inflate(R.layout.item_calculadora, null);

        TextView tituloCalculadora = (TextView) view.findViewById(R.id.textView_itemCalculadora);
        tituloCalculadora.setText(listaCalculadorasRecentes.get(position).getNomeCalculadora() + " - " + listaCalculadorasRecentes.get(position).getCategoria());

        return view;
    }

    public void inserItem(RecentesModel item){
        this.listaCalculadorasRecentes.add(item);
        this.notifyDataSetChanged();
    }


}
