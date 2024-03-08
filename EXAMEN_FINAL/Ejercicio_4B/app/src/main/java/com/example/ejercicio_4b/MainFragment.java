package com.example.ejercicio_4b;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends ListFragment {
    private OnMasterSelectedListener mOnMasterSelectedListener = null;
    public void setOnMasterSelectedListener(OnMasterSelectedListener listener) {
        mOnMasterSelectedListener = listener;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<DatosElemento> listaDatos = DatosElemento.poblarLista();
        List<String> listaNombres = new ArrayList<String>();
        for (DatosElemento elemento : listaDatos) {
            listaNombres.add(elemento.getNombreComunidad());
        }
        ListAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listaNombres);
        setListAdapter(adapter);
        getListView().setChoiceMode(getListView().CHOICE_MODE_SINGLE);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatosElemento datosElemento = listaDatos.get(position);
                // Si no hay listener, no hacemos nada
                if (mOnMasterSelectedListener != null) {
                    mOnMasterSelectedListener.onItemSelected(datosElemento);
                }
            }
        });
    }

    // Inner interface
    public interface OnMasterSelectedListener {
        public void onItemSelected(DatosElemento datosElemento);
    }
}
