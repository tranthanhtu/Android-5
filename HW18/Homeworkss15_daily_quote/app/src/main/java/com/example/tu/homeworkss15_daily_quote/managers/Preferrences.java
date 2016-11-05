package com.example.tu.homeworkss15_daily_quote.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Hau on 25/10/2016.
 */
public class Preferrences {
    private static final String KEY = "Quote";
    private static final String USER_NAME_KEY = "Username";
    private static final String OFFLINE_IMAGE_COUNT_KEY = "ImageCount";
    private SharedPreferences sharedPreferences;

    private Preferrences(Context context) {
        this.sharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }

    public String getUsername() {
        return sharedPreferences.getString(USER_NAME_KEY, null);
    }

    public void putUsername(String username) {
        sharedPreferences.edit().putString(USER_NAME_KEY, username).commit();
    }

    private static Preferrences instance;

    public static Preferrences getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new Preferrences(context);
    }

    public int getImageCount() {
        return sharedPreferences.getInt(OFFLINE_IMAGE_COUNT_KEY, -1);
    }

    public void putImageCount(int imageCount) {
        sharedPreferences.edit().putInt(OFFLINE_IMAGE_COUNT_KEY, imageCount).commit();
    }
}
