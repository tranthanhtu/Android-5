package vn.techkids.session12.jsonmodels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell latitude E6520 on 10/13/2016.
 */

public class FlickerItem {
    @SerializedName("title")
    private String title;
    @SerializedName("date_taken")
    private String dateTaken;
    @SerializedName("link")
    private String links;

    public FlickerItem(String title, String dateTaken, String links) {
        this.title = title;
        this.dateTaken = dateTaken;
        this.links = links;
    }


    public String getTitle() {
        return title;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public String getLinks() {
        return links;
    }

    @SerializedName("media")
    private Media media;

    public String getLink(){
        return media.getLink();
    }

    public Media getMedia() {
        return media;
    }

    private class Media{
        @SerializedName("m")
        private String link;

        public String getLink() {
            return link;
        }


    }


    @Override
    public String toString() {
        return getLink();
    }
}
