package vn.techkids.session12.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import vn.techkids.session12.R;
import vn.techkids.session12.adapters.FakeAdapter;
import vn.techkids.session12.jsonmodels.FakeItems;

/**
 * A simple {@link Fragment} subclass.
 */
public class FakeFragment extends Fragment {
    ListView lvFake;
    private static final String TAG = FakeFragment.class.toString() ;

    public FakeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fake, container, false);
        lvFake = (ListView) view.findViewById(R.id.lv_fake);
//        getData();
//        postData();
        return view;
    }

//    private void postData() {
//
//        OkHttpClient client = new OkHttpClient();
//
//        RequestBody formBody = new FormBody.Builder()
//                .add("Key", "Value")
//                .build();
//        Request request = new Request.Builder()
//                .url("http://jsonplaceholder.typicode.com/posts")
//                .post(formBody)
//                .addHeader("Key", "Value")
//                .build();
//
//        try {
//            client.newCall(request).execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void getData() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://jsonplaceholder.typicode.com/posts")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bodystring = response.body().string();

                FakeItems[] items = new Gson().fromJson(bodystring, FakeItems[].class);

                FakeFragment.this.updateBody(items);
            }
        });

    }
    private void updateBody(final FakeItems[] fakeItemses) {
        final Activity parent = getActivity();
        final List<FakeItems> itemses = new ArrayList<>(Arrays.asList(fakeItemses));
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FakeAdapter bodyAdapter = new FakeAdapter(parent, R.layout.layout_fake_item, itemses);
                lvFake.setAdapter(bodyAdapter);
            }
        });
    }

}
