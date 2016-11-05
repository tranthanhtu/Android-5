package com.example.tu.homeworkss15_daily_quote.services;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.tu.homeworkss15_daily_quote.constants.Constants;
import com.example.tu.homeworkss15_daily_quote.managers.DbContextRealm;
import com.example.tu.homeworkss15_daily_quote.managers.FileManager;
import com.example.tu.homeworkss15_daily_quote.managers.Preferrences;
import com.example.tu.homeworkss15_daily_quote.models.Image;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Hau on 25/10/2016.
 */
public class UnplashDownloadService extends IntentService {

    private static final String TAG = UnplashDownloadService.class.toString();
    private static final int IMAGE_COUNT = 10;

    public UnplashDownloadService() {
        super("UnplashDownloadService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");
        for (int i = 0; i < IMAGE_COUNT; i++) {
            Log.d(TAG, String.format("Unplash #%s", i));
            Log.d(TAG, "Downloading image");
            // 1: Download image
            Bitmap bitmap = ImageLoader.getInstance().loadImageSync(Constants.UNPLASH_API);
            Log.d(TAG, "Done downloading!");
            Log.d(TAG, "Saving downloading image");
            // converse bitmap to byte array
//            int bytes = bitmap.getByteCount();
//
//            ByteBuffer buffer = ByteBuffer.allocate(bytes);
//            bitmap.copyPixelsToBuffer(buffer);
////            byte[] byteArray = buffer.array();
//
//            ByteArrayOutputStream blob = new ByteArrayOutputStream();
//            byte[] bitmapdata = blob.toByteArray();
//
//            Image image = Image.create(bitmapdata);
//            image.setBytes(bitmapdata);
//            saveImage(image);


            // 2: Save
            FileManager.getInstance().createImage(bitmap, i);
            Log.d(TAG, "Done saving!");
            // 3: Mark preference
            Preferrences.getInstance().putImageCount(i + 1);
        }

        // Save to realm database

    }

    private void saveImage(final Image image) {
        Handler handler = new Handler(Looper.getMainLooper());

        handler.post(new Runnable() {
            @Override
            public void run() {
                DbContextRealm.getInstance().add(image);
            }
        });
    }

}
