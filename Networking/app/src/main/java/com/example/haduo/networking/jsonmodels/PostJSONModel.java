package com.example.haduo.networking.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haduo on 10/22/2016.
 */

public class PostJSONModel {
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;

    public PostJSONModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
