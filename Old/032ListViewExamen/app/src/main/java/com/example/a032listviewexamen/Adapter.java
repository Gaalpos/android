package com.example.a032listviewexamen;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Equipo> {
    LayoutInflater layoutInflater;
    public Adapter(@NonNull Context context , int resource , @NonNull List<Equipo> objects){
        super(context , resource , objects);
        layoutInflater = LayoutInflater.from(context);
    }

    public View getView ( int position , @Nullable View convertView , @NonNull ViewGroup parent){
        View rowView = layoutInflater.inflate(R.layout.element,parent, false);
        Equipo equipo = getItem(position);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.equipoImagen);
        imageView.setImageResource(equipo.getImagen());

        TextView ciudad = (TextView) rowView.findViewById(R.id.equipoCiudad);
        ciudad.setText(equipo.getCiudad());

        TextView nombre = (TextView) rowView.findViewById(R.id.equipoNombre);
        nombre.setText(equipo.getNombre());

        TextView pais = (TextView) rowView.findViewById(R.id.equipoPais);
        pais.setText(equipo.getPais());

        TextView año = (TextView) rowView.findViewById(R.id.equipoAño);
        año.setText(equipo.getAño());

        return rowView;
    }

    /*
    @Override
    public View getDropDownView( int position , @Nullable View convertView , @NonNull ViewGroup parent){

        if(convertView == null)
            convertView = layoutInflater.inflate(R.layout.element, parent, false);

        Equipo equipo = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.equipoImagen);
        imageView.setImageResource(equipo.getImagen());

        TextView ciudad = (TextView) convertView.findViewById(R.id.equipoCiudad);
        ciudad.setText(equipo.getCiudad());

        TextView nombre = (TextView) convertView.findViewById(R.id.equipoNombre);
        nombre.setText(equipo.getNombre());

        TextView pais = (TextView) convertView.findViewById(R.id.equipoPais);
        pais.setText(equipo.getPais());

        TextView año = (TextView) convertView.findViewById(R.id.equipoAño);
        año.setText(equipo.getAño());

        return convertView;
    }
*/
}
