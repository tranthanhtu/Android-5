package com.example.haduo.networking.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell latitude E6520 on 10/23/2016.
 */

public class Post {
    private String title;
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public static final List<Post> list = new ArrayList<>();
}
