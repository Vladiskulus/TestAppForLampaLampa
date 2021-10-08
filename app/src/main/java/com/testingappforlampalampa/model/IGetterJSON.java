package com.testingappforlampalampa.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IGetterJSON {

    @GET("/")
    Observable<List<Model>> getList();

}