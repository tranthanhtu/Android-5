package vn.techkids.musicchallenge.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Nhan on 11/9/2016.
 */

public class Song extends RealmObject {

    public static Song create(String name, String artist, String linkStream){
        Song song = new Song();
        song.name = name;
        song.artist = artist;
        song.linkStream = linkStream;
        return song;
    }

    public Song() {

    }

    @SerializedName("title")
    private String name;
    @SerializedName("artist")
    private String artist;
    @SerializedName("source")
    private String linkStream;

    public Song(String name, String artist, String linkStream) {
        this.name = name;
        this.artist = artist;
        this.linkStream = linkStream;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLinkStream() {
        return linkStream;
    }

    public void setLinkStream(String linkStream) {
        this.linkStream = linkStream;
    }
}
