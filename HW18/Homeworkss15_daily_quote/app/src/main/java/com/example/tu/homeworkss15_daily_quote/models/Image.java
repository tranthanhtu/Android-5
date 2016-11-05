package com.example.tu.homeworkss15_daily_quote.models;

import java.util.Arrays;

import io.realm.RealmObject;

/**
 * Created by Hau on 04/11/2016.
 */
public class Image extends RealmObject {
    private byte[] bytes;

    public Image() {
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public static Image create(byte[] bytes) {
        Image image = new Image();
        image.setBytes(bytes);
        return image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "bytes=" + Arrays.toString(bytes) +
                "\nlength=" + bytes.length +
                '}';
    }
}
