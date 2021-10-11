package com.testingappforlampalampa.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.testingappforlampalampa.model.*;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MyVM extends ViewModel {

    private MutableLiveData<List<Model>> data = new MutableLiveData<>();

    public LiveData<List<Model>> getList() {
        return data;
    }

    public void initList(String type) {
        CompositeDisposable disposable = new CompositeDisposable();
        IGetterJSON iGetterJSON = RetrofitClient.getInstance().create(IGetterJSON.class);
        disposable.add(iGetterJSON.getList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(list -> list
                        .stream()
                        .filter(item -> item.getType()
                                .equals(type))
                        .collect(Collectors.toList()))
                .subscribe(list -> data.setValue(list)));
    }
}