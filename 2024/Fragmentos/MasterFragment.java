package com.example.lib4a;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

public class MasterFragment extends ListFragment {
    public interface OnMasterSelectedListener {
        void onItemSelected(String countryName);
    }

    private OnMasterSelectedListener mOnMasterSelectedListener=null;
    public void setOnMasterSelectedListener(OnMasterSelectedListener listener) {
        mOnMasterSelectedListener=listener;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String[] nombres =  Estados.NOMBRES;


        ListAdapter countryAdapter = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_list_item_1,
                nombres);


        setListAdapter(countryAdapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View
                    view, int position, long id) {
                //Si hay listener lo que pasa e
                if (mOnMasterSelectedListener != null) {

                    String descripcion [] = Estados.DETALLES;
                    mOnMasterSelectedListener.onItemSelected(descripcion[position]);
                }
            }
        });
    }


}
