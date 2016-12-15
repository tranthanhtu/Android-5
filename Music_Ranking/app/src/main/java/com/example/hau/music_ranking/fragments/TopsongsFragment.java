package com.example.hau.music_ranking.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hau.music_ranking.R;
import com.example.hau.music_ranking.adapters.TopSongAdapter;
import com.example.hau.music_ranking.listensers.RecyclerItemClickListener;
import com.example.hau.music_ranking.models.Entry;
import com.example.hau.music_ranking.models.Genres;
import com.example.hau.music_ranking.networks.GetSongFromAPI;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopsongsFragment extends Fragment {

    private static final String TAG = TopsongsFragment.class.toString();
    private Genres genres;
    @BindView(R.id.iv_play)
    ImageView ivPlay;
    @BindView(R.id.ll_cover)
    LinearLayout llCover;
    @BindView(R.id.tv_genres_topsong)
    TextView tvGenresTopSong;
    @BindView(R.id.rv_topsong)
    RecyclerView rvTopSong;
    @BindView(R.id.tv_number_song)
    TextView tvNumberSong;
    private TopSongAdapter adapter;
    String position;

    public TopsongsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        Entry.list.clear();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_topsongs, container, false);
        ButterKnife.bind(this, view);
        genres = (Genres) getArguments().getSerializable("genres_key");
        position = getArguments().getString("genres_position");
        if (position == null) {
            position = "";
        }
        Log.d(TAG, "onCreateView: " + position);
        setupUI();
        getDataFromAPI();
        addListener();
        return view;
    }

    private void addListener() {
        rvTopSong.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d(TAG, "onItemClick: ");
                EventBus.getDefault().post(new TopSongClass());
            }
        }));
    }

    private void getDataFromAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetSongFromAPI getSongFromAPI = retrofit.create(GetSongFromAPI.class);
        getSongFromAPI.callFeed(position).enqueue(new Callback<GetSongFromAPI.Feed>() {
            @Override
            public void onResponse(Call<GetSongFromAPI.Feed> call, Response<GetSongFromAPI.Feed> response) {
                Log.d(TAG, "onResponse: ");
                GetSongFromAPI.Feed feed = response.body();
                ArrayList<GetSongFromAPI.Entry> list = (ArrayList<GetSongFromAPI.Entry>) feed.getSongEntry().getEntryList();
                Log.d(TAG, "onResponse: " + list.size());
                for (GetSongFromAPI.Entry entry : list) {
//                    Log.d(TAG, entry.getListImage().get(1).getLabel());
//                    Log.d(TAG, entry.getSongArtist().getLabel());
//                    Log.d(TAG, entry.getSongName().getLabel());
                    Entry.list.add(new Entry(
                            entry.getListImage().get(1).getLabel(),
                            entry.getSongArtist().getLabel(),
                            entry.getSongName().getLabel()));
                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        tvNumberSong.setText(Entry.list.size() + " songs");
                    }
                });
            }

            @Override
            public void onFailure(Call<GetSongFromAPI.Feed> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }


    private void setupUI() {
        Log.d(TAG, getFragmentManager().getBackStackEntryCount() + "");
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        int size = width / 5;
        ivPlay.setLayoutParams(new RelativeLayout.LayoutParams(size, size));
        ivPlay.setX((width - size) * 14 / 15);
        ivPlay.setY((height - size) * 4 / 11);

        if (genres.getImage() != 0) {
            llCover.setBackgroundResource(genres.getImage());
        } else {
            llCover.setBackgroundResource(R.drawable.genres_0);
        }

        tvGenresTopSong.setText(genres.getKey());


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvTopSong.setLayoutManager(layoutManager);
        adapter = new TopSongAdapter(getActivity());
        rvTopSong.setAdapter(adapter);

    }

    public static TopsongsFragment create(Genres genres, String position) {
        TopsongsFragment topsongsFragment = new TopsongsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("genres_key", genres);
        bundle.putString("genres_position", position);
        topsongsFragment.setArguments(bundle);
        return topsongsFragment;
    }

    @Subscribe
    public void receiveDate(FragmentEvent fragmentEvent) {
        genres = fragmentEvent.getGenres();
    }
}
