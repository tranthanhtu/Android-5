package com.example.hau.music_ranking.json_models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Hau on 26/11/2016.
 */
public class MediaJSON {
    @SerializedName("subgenres")
    private ArrayList<SubgenresJSON> list = new ArrayList<>();
    @SerializedName("translation_key")
    private String key;

    public String getKey() {
        return key;
    }

    public ArrayList<SubgenresJSON> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "MediaJSON{" +
                "list=" + list +
                '}';
    }
}
