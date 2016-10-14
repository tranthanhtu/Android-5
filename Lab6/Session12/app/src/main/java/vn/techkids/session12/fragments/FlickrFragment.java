package vn.techkids.session12.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import vn.techkids.session12.MainActivity;
import vn.techkids.session12.R;
import vn.techkids.session12.adapters.FlickrAdapter;
import vn.techkids.session12.jsonmodels.FlickerItem;
import vn.techkids.session12.jsonmodels.FlickrFeed;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlickrFragment extends Fragment {
    ListView lvlink;
//    ArrayAdapter<FlickerItem> flickerItemArrayAdapter;
//    List<FlickerItem> items;
    private static final String TAG = FlickrFragment.class.toString() ;

    public FlickrFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flickr, container, false);

        lvlink = (ListView) view.findViewById(R.id.lv_link);
//        items = new ArrayList<FlickerItem>();

        setupUI();
        return view;
    }



    private void setupUI() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://www.flickr.com/services/feeds/photos_public.gne?tags=girl&format=json&title=girl")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string()
                        .replace("jsonFlickrFeed(", "")
                        .replace("})", "}")
                        ;

                FlickrFeed flickrFeed = new Gson().fromJson(body, FlickrFeed.class);

                List<FlickerItem> flickrItems = flickrFeed.getItems();

                Log.d(TAG, String.format("%s", flickrItems));

                updateBody(flickrItems);





//                for (FlickerItem item : flickrFeed.getItems())
//                {
//
//                    items.add(item);
//
//                }



//                Log.d(TAG, flickrFeed.getTitle());

            }
        });
    }
    private void updateBody(final List<FlickerItem> flickrItems) {
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                lvlink.setAdapter(new FlickrAdapter(
                        getContext(),
                        R.layout.layout_flick_item,
                        flickrItems
                ));
            }
        });
    }

}
