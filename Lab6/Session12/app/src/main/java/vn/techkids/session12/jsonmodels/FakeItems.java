package vn.techkids.session12.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell latitude E6520 on 10/14/2016.
 */

public class FakeItems {
    @SerializedName("userId")
    private String userId;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public FakeItems(String userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
