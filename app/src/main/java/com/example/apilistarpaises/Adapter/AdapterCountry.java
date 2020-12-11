package com.example.apilistarpaises.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.apilistarpaises.Model.Country;
import com.example.apilistarpaises.R;

import java.util.ArrayList;

public class AdapterCountry extends ArrayAdapter<Country> {

    public AdapterCountry(Context context, ArrayList<Country> datos)
    {
        super(context, R.layout.ly_country, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_country, null);

        TextView lblTitulo = item.findViewById(R.id.LblTitulo);
        lblTitulo.setText(getItem(position).getCountry());

        TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
        String msj = "Total de confirmados: " + getItem(position).getTotalConfirmed() + "\t" + "Total de muertes: " + getItem(position).getTotalDeaths() + "\n" + "Fecha: " + getItem(position).getDate();
        lblSubtitulo.setText(msj);

        return(item);
    }
}
