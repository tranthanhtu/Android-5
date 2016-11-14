package vn.techkids.musicchallenge.managers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Dell latitude E6520 on 11/13/2016.
 */

public class NetworkManager {
    private ConnectivityManager connectivityManager;

    private NetworkManager(Context context) {
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public boolean isConnectedToInternet() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    private static NetworkManager instance;
    public static NetworkManager getInstance() {
        return instance;
    }

    public static void init (Context context) {
        instance = new NetworkManager(context);
    }


}
