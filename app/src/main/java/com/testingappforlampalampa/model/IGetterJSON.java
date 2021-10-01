package com.testingappforlampalampa.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IGetterJSON {

    @GET("/")
    Call<List<Model>> getList();

}