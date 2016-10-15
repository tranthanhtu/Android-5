package vn.techkids.session12.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import vn.techkids.session12.R;
import vn.techkids.session12.jsonmodels.FakeItems;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment {
    @BindView(R.id.et_user_id)
    EditText etUserId;

    @BindView(R.id.et_title)
    EditText etTitle;

    @BindView(R.id.et_body)
    EditText etBody;

    @BindView(R.id.tv_result)
    TextView tvResult;

    public PostFragment() {
        // Required empty public constructor
    }

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.btn_post)
    public void onPostClick() {
        Log.d("Post Fragment", "post");
        //get input data
        FakeItems item = new FakeItems(
                etTitle.getText().toString(),
                etBody.getText().toString(),
                etUserId.getText().toString()
        );

        //convert item to json
        Gson gson = new Gson();
        String jsonItem = gson.toJson(item);

        //send post
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, jsonItem);
        Request request = new Request.Builder()
                .url("http://jsonplaceholder.typicode.com/posts")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                updateBody("Failure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                updateBody(response.toString()
                        + "\n"
                        + response.body().string());
            }
        });
    }
    private void updateBody(final String result) {
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResult.setText(result);
            }
        });
    }


}
