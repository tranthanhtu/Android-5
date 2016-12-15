package vn.techkids.youtubeapiv3;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Dell latitude E6520 on 10/25/2016.
 */

public class YoutubeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

       ConnectionAsync connectionAsync = new ConnectionAsync();
        connectionAsync.execute();
    }
}
