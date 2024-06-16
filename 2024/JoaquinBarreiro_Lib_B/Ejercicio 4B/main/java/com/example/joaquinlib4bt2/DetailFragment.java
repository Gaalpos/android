package com.example.joaquinlib4bt2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    public static String KEY_DATA = "KEY_DATA";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(KEY_DATA)){
            String dialogue = bundle.getString(KEY_DATA);
            showSelected(dialogue);
        }
    }

    void showSelected(String countryDetail) {
        TextView detailTextView = getView().findViewById(R.id.tv_detail);
        detailTextView.setText(countryDetail);
    }
}
