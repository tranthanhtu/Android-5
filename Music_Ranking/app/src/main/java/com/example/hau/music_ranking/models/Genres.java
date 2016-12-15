package com.example.hau.music_ranking.models;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Hau on 26/11/2016.
 */
public class Genres implements Serializable {
    private String id;
    private String key;
    private int  image;


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Genres(String id, String key, int image) {

        this.id = id;
        this.key = key;
        this.image = image;
    }

    public Genres(String id, String key) {
        this.id = id;
        this.key = key;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }


    public void setKey(String key) {
        this.key = key;
    }

    public static ArrayList<Genres> list = new ArrayList<>();

    @Override
    public String toString() {
        return "Genres{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", image=" + image +
                '}';
    }
}
