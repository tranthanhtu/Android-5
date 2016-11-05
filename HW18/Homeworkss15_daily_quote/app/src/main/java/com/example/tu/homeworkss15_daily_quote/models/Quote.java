package com.example.tu.homeworkss15_daily_quote.models;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;

/**
 * Created by Hau on 25/10/2016.
 */
public class Quote extends RealmObject {
    private int id;
    private String title;
    private String content;

    public Quote(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Quote() {

    }

    public Quote(String title, String content) {
        this(-1, title, content);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", id, title, content);
    }
    public static List<Quote> list = new ArrayList<>();
}
