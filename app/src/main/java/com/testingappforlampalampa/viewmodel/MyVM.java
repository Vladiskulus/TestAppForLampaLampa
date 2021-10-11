package com.testingappforlampalampa.viewmodel;

import static com.testingappforlampalampa.Constants.*;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.testingappforlampalampa.model.Model;
import com.testingappforlampalampa.view.fragment.FavoriteFragment;
import com.testingappforlampalampa.view.fragment.StoryFragment;
import com.testingappforlampalampa.view.fragment.VideoFragment;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;


public class MyVM extends ViewModel {

    private MutableLiveData<String> liveData = new MutableLiveData<>();

    public LiveData<String> valueLiveData(){
        return liveData;
    }


}
