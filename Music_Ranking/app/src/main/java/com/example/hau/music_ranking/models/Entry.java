package com.example.hau.music_ranking.models;

import com.example.hau.music_ranking.networks.GetSongFromAPI;

import java.util.ArrayList;

/**
 * Created by Hau on 30/11/2016.
 */
public class Entry {
    private String image;
    private String artist;
    private String song;

    public Entry(String image, String artist, String song) {
        this.image = image;
        this.artist = artist;
        this.song = song;
    }

    public String getImage() {
        return image;
    }

    public String getArtist() {
        return artist;
    }

    public String getSong() {
        return song;
    }

    public static ArrayList<Entry> list = new ArrayList<>();
}
