package com.testingappforlampalampa.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyVM extends ViewModel {

    private MutableLiveData<String> liveData = new MutableLiveData<>();

    public LiveData<String> valueLiveData(){
        return liveData;
    }
}
