package com.example.haduo.networking.activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.haduo.networking.R;
import com.example.haduo.networking.adapters.PostAdapter;
import com.example.haduo.networking.constans.Constans;
import com.example.haduo.networking.jsonmodels.PostJSONModel;
import com.example.haduo.networking.models.Post;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @BindView(R.id.rv_post)
    RecyclerView rvPost;

    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupUI();

        sendGETRequest();
    }

    private void setupUI() {
        //1 Layout Manager
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        rvPost.setLayoutManager(layoutManager);

        //2 Setup Adapter
        postAdapter = new PostAdapter();
        rvPost.setAdapter(postAdapter);
    }

    private void sendPOSTRequest() {
        
        // 1
        OkHttpClient client = new OkHttpClient();

        //2 Create Request
        //2.1 Create Request Data Body
//        FormBody formBody = new FormBody.Builder()
//                .add("title","Yesterday")
//                .add("content","Bad day")
//                .build();
        PostJSONModel postJSONModel = new PostJSONModel("Ha Duong","He is A Lord");
        String jsonBody = (new Gson().toJson(postJSONModel));
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),jsonBody);
        //2.2 Create Post Request
//        Request request = new Request.Builder().url("https://tumblelogdemo.herokuapp.com/").post(formBody).build();
        Request request = new Request.Builder().url(Constans.TUMBLELOG).post(requestBody).build();
        //2.3 Send Request
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, String.format("onFailure:%s", e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d(TAG, String.format("onResponse:body = %s", body));
            }
        });

    }

    void sendGETRequest(){
        String URL = "https://tumblelogdemo.herokuapp.com/";
        // 1
        OkHttpClient client = new OkHttpClient();

        //2
        Request request = new Request.Builder().url(URL).build();

        //3 send request

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    String body = response.body().string();
                    Log.d(TAG, String.format("onResponse:body = %s", body));
                    PostJSONModel[] postJSONModels = (new Gson()).fromJson(body, PostJSONModel[].class);

                    Post.list.clear();
                    for (PostJSONModel postJSONModel : postJSONModels){
                        Post.list.add(new Post(
                                postJSONModel.getTitle(),
                                postJSONModel.getContent()));
                    }
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            postAdapter.notifyDataSetChanged();
                        }
                    });

                }

            }
        });
    }
}
