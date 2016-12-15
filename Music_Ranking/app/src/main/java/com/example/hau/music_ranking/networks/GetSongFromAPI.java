package com.example.hau.music_ranking.networks;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Hau on 30/11/2016.
 */
public interface GetSongFromAPI {

    @GET("/us/rss/topsongs/limit=10/genre={id}/explicit=true/json")
    Call<Feed> callFeed(@Path("id") String id);


    class Feed {
        @SerializedName("feed")
        private SongEntry songEntry;

        public SongEntry getSongEntry() {
            return songEntry;
        }
    }

    class SongEntry {
        @SerializedName("entry")
        private List<Entry> entryList;

        public List<Entry> getEntryList() {
            return entryList;
        }
    }

    class Entry{
        @SerializedName("im:name")
        private Label songName;
        @SerializedName("im:image")
        private List<Label> listImage;
        @SerializedName("im:artist")
        private Label songArtist;

        public Label getSongName() {
            return songName;
        }

        public List<Label> getListImage() {
            return listImage;
        }

        public Label getSongArtist() {
            return songArtist;
        }
    }

    class Label{
        @SerializedName("label")
        private String label;

        public String getLabel() {
            return label;
        }
    }
}
