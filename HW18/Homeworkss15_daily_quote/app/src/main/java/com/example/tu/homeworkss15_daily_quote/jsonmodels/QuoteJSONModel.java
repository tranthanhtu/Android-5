package com.example.tu.homeworkss15_daily_quote.jsonmodels;

/**
 * Created by Hau on 25/10/2016.
 */
public class QuoteJSONModel {
    private String title;
    private String content;

    public QuoteJSONModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content.replace("\n", "");
    }

    public void setContent(String content) {
        this.content = content;
    }
}
