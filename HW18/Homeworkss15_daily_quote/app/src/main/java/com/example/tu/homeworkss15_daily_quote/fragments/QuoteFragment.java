package com.example.tu.homeworkss15_daily_quote.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.homeworkss15_daily_quote.R;
import com.example.tu.homeworkss15_daily_quote.adapters.QuoteAdapter;
import com.example.tu.homeworkss15_daily_quote.constants.Constants;
import com.example.tu.homeworkss15_daily_quote.jsonmodels.QuoteJSONModel;
import com.example.tu.homeworkss15_daily_quote.managers.DbContextRealm;
import com.example.tu.homeworkss15_daily_quote.managers.DbHelper;
import com.example.tu.homeworkss15_daily_quote.models.Quote;
import com.example.tu.homeworkss15_daily_quote.networks.QuoteService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {


    private static final String TAG = QuoteFragment.class.toString();
    @BindView(R.id.rv_quote)
    RecyclerView rvQuote;

    private QuoteAdapter quoteAdapter;

    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setupUI();
//        sendGETRequest();
        sendGETRequestByRetrofit();
    }


    private void setupUI() {
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvQuote.setLayoutManager(layoutManager);
        quoteAdapter = new QuoteAdapter();
        rvQuote.setAdapter(quoteAdapter);
    }

    private void sendGETRequest() {

//        ImageLoader.getInstance().loadImage(Constants.UNPLASH_API, new ImageLoadingListener() {
//            @Override
//            public void onLoadingStarted(String imageUri, View view) {
//
//            }
//
//            @Override
//            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//
//            }
//
//            @Override
//            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                FileManager.getInstance().createImage(loadedImage, unplash);
//                Log.d(TAG, "onLoadingComplete");
//            }
//
//            @Override
//            public void onLoadingCancelled(String imageUri, View view) {
//
//            }
//        });
        // Image


        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constants.QUOTE_API).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Quote.list.clear();
                Quote.list.add(DbHelper.getInstance().selectRandomQuote());
                updateQuote();
                Log.d(TAG, String.valueOf(Quote.list.size()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String bodyString = response.body().string();

                    Gson gson = new Gson();
                    QuoteJSONModel[] quotes = gson.fromJson(bodyString, QuoteJSONModel[].class);

//                    for (QuoteJSONModel quoteJSONModel : quotes) {
////                        Bitmap bitmap = ImageLoader.getInstance().loadImageSync(Constants.UNPLASH_API);
//                        Quote.list.add(new Quote(quoteJSONModel.getTitle(), quoteJSONModel.getContent()));
//                    }
                    Quote.list.clear();
                    for (QuoteJSONModel q : quotes) {
                        DbHelper.getInstance().insert(new Quote(q.getTitle(), q.getContent()));
                    }
                    Quote quote = new Quote(quotes[0].getTitle(), quotes[0].getContent());
                    Quote.list.add(quote);
                    if (quotes.length > 0) {
                        updateQuote();
                    }
                }
            }
        });
    }

    private void updateQuote() {
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                quoteAdapter.notifyDataSetChanged();
            }
        });
    }


    private void sendGETRequestByRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_QUOTE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QuoteService quoteService = retrofit.create(QuoteService.class);
        quoteService.
                listQuote("rand", 1)
                .enqueue(new retrofit2.Callback<List<Quote>>() {
                    @Override
                    public void onResponse(retrofit2.Call<List<Quote>> call, retrofit2.Response<List<Quote>> response) {
                        List<Quote> quoteList = response.body();
                        Quote.list.clear();
                        for (Quote quote : quoteList) {
                            Quote.list.add(quote);
                            if (DbContextRealm.getInstance().getSizeQuote() < 10) {
                                DbContextRealm.getInstance().add(quote);
                            }
                        }
                        for (Quote quote : DbContextRealm.getInstance().findAllQuote()) {
                            Log.d(TAG, quote.toString());
                        }
                        if (quoteList.size() > 0) {
                            updateQuote();
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<List<Quote>> call, Throwable t) {
                        Log.d(TAG, "onFailure");
                        Quote.list.add(DbContextRealm.getInstance().findFirstQuoteRandom());
                        updateQuote();
                    }
                });
    }
}
