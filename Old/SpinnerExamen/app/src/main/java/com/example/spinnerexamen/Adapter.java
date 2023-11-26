package com.example.spinnerexamen;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Team> {

    LayoutInflater layoutInflater;

    public Adapter(@NonNull Context context, int resource) {
        super(context, resource);
        layoutInflater = LayoutInflater.from(context);
    }

    public Adapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent){
        View view = layoutInflater.inflate(R.layout.elemento, null, true);
        return super.getView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.elemento, null, true);
        } else {
            return convertView;
        }
    }
}
