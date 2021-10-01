package com.testingappforlampalampa.model;

import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    @SerializedName("img")
    private String img;

    @SerializedName("click_url")
    private String click_url;

    @SerializedName("time")
    private String time;


    public Model(String title, String img, String click_url, String time, String type) {
        this.title = title;
        this.type = type;
        this.img = img;
        this.click_url = click_url;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getImg() {
        return img;
    }

    public String getClick_url() {
        return click_url;
    }

    public String getTime() {
        return time;
    }
}