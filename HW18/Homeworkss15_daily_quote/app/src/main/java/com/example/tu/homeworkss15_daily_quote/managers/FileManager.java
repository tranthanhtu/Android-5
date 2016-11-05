package com.example.tu.homeworkss15_daily_quote.managers;

import android.content.Context;
import android.graphics.Bitmap;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import java.io.File;

/**
 * Created by Hau on 25/10/2016.
 */
public class FileManager {
    private Storage storage;
    private static final String IMAGE_DIR = "images";
    public static final String IMAGE_DIR_FORMAT = "unplash_%s.png";

    private FileManager(Context context) {
        this.storage = SimpleStorage.getInternalStorage(context);
    }

    private static FileManager instance;

    public static FileManager getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new FileManager(context);
    }

    public void createImage(Bitmap bitmap, String fileName) {
        storage.createFile(IMAGE_DIR, fileName, bitmap);
    }

    public File loadImageFile(String fileName) {
        return storage.getFile(IMAGE_DIR, fileName);
    }

    public void createImage(Bitmap bitmap, int index) {
        createImage(bitmap, String.format(IMAGE_DIR_FORMAT, index));
    }

    public File loadImageFile(int index) {
        return loadImageFile(String.format(IMAGE_DIR_FORMAT, index));
    }
}
