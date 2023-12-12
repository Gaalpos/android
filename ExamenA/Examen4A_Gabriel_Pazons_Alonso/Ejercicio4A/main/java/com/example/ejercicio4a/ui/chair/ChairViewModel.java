package com.example.ejercicio4a.ui.chair;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChairViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ChairViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is chair fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}