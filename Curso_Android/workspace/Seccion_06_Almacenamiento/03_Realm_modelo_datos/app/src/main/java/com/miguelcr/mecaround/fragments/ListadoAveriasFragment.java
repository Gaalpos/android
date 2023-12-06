package com.miguelcr.mecaround.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelcr.mecaround.adapters.MyAveriaRecyclerViewAdapter;
import com.miguelcr.mecaround.interfaces.OnAveriaInteractionListener;
import com.miguelcr.mecaround.R;
import com.miguelcr.mecaround.models.AveriaDB;

import java.util.ArrayList;
import java.util.List;

public class ListadoAveriasFragment extends Fragment {
    OnAveriaInteractionListener mListener;
    List<AveriaDB> averiaDBList;

    public ListadoAveriasFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_averia_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            // Lista de averias
            averiaDBList = new ArrayList<>();
            averiaDBList.add(new AveriaDB("Espejo roto","Audi - A4","http://blog.mister-auto.es/wp-content/uploads/2014/09/23116650_m.jpg",2));
            averiaDBList.add(new AveriaDB("Paragolpes delantero","Citroen - C4","",0));
            averiaDBList.add(new AveriaDB("Embrague","Seat - Ibiza","",0));
            averiaDBList.add(new AveriaDB("Cambio de aceite","Seat - Toledo","",1));

            recyclerView.setAdapter(new MyAveriaRecyclerViewAdapter(getActivity(), averiaDBList, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAveriaInteractionListener) {
            mListener = (OnAveriaInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAveriaInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
