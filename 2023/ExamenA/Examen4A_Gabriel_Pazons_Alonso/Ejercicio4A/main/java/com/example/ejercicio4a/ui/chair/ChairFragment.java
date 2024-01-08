package com.example.ejercicio4a.ui.chair;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ejercicio4a.databinding.FragmentChairBinding;
import com.example.ejercicio4a.databinding.FragmentDashboardBinding;

public class ChairFragment extends Fragment {

    private FragmentChairBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ChairViewModel chairViewModel =
                new ViewModelProvider(this).get(ChairViewModel.class);

        binding = FragmentChairBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textChair;
        chairViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}