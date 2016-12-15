package com.example.hau.music_ranking.json_models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 26/11/2016.
 */
public class SubgenresJSON {
    @SerializedName("id")
    private String id;
    @SerializedName("translation_key")
    private String key;

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "SubgenresJSON{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
