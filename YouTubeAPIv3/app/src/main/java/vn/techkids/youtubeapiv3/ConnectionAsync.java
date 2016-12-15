package vn.techkids.youtubeapiv3;

import android.os.AsyncTask;

/**
 * Created by Dell latitude E6520 on 10/25/2016.
 */

public class ConnectionAsync extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params) {
        Connection.getInstance().setArrayList(Connection.getInstance().getListId());
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {

    }
}
