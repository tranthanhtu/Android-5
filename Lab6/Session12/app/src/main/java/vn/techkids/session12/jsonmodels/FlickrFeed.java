package vn.techkids.session12.jsonmodels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell latitude E6520 on 10/13/2016.
 */

public class FlickrFeed {
    @SerializedName("title")
    private String title;
    @SerializedName("date_taken")
    private String dateTaken;
    @SerializedName("link")
    private String links;




    @SerializedName("items")
    public List<FlickerItem> items;

    public String getDateTaken() {
        return dateTaken;
    }

    public String getLinks() {
        return links;
    }

    public List<FlickerItem> getItems() {
        return items;

    }

    public String getTitle() {
        return title;
    }
}
