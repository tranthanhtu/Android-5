package com.example.tu.homeworkss15_daily_quote;

import android.app.Application;

import com.example.tu.homeworkss15_daily_quote.managers.DbContextRealm;
import com.example.tu.homeworkss15_daily_quote.managers.DbHelper;
import com.example.tu.homeworkss15_daily_quote.managers.FileManager;
import com.example.tu.homeworkss15_daily_quote.managers.NetworkManger;
import com.example.tu.homeworkss15_daily_quote.managers.Preferrences;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Hau on 25/10/2016.
 */
public class QuoteApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManger.init(this);
        Preferrences.init(this);
        FileManager.init(this);
        initImageLoader();
        DbHelper.init(this);
        DbContextRealm.init(this);


    }

    private void initImageLoader() {
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(displayImageOptions)
                .build();
        ImageLoader.getInstance().init(imageLoaderConfiguration);
    }
}
