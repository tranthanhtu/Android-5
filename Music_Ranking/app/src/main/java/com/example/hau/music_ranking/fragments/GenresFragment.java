package com.example.hau.music_ranking.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.music_ranking.R;
import com.example.hau.music_ranking.listensers.RecyclerItemClickListener;
import com.example.hau.music_ranking.adapters.GenresAdapter;
import com.example.hau.music_ranking.json_models.MediaJSON;
import com.example.hau.music_ranking.json_models.SubgenresJSON;
import com.example.hau.music_ranking.models.Genres;
import com.example.hau.music_ranking.networks.MediaService;

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
public class GenresFragment extends Fragment {


    private static final String TAG = GenresFragment.class.toString();
    private ArrayList<SubgenresJSON> listSubgenres;
    private GenresAdapter adapter;
    @BindView(R.id.rv_genres)
    RecyclerView rvGenres;

    public GenresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_genres, container, false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        setupUI();
        getDataFromAPI();
        addListeners();
        return view;
    }

    private void addListeners() {
        rvGenres.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d(TAG, "onItemClick " + position);
                TopsongsFragment fragment = TopsongsFragment.create(Genres.list.get(position), String.valueOf(Genres.list.get(position).getId()));
//                TopsongsFragment fragment = new TopsongsFragment();
                FragmentEvent fragmentEvent = new FragmentEvent(fragment, true, Genres.list.get(position));
                EventBus.getDefault().post(fragmentEvent);
            }
        }));
    }

    private void getDataFromAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rss.itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MediaService service = retrofit.create(MediaService.class);

        service.listMedias().enqueue(new Callback<List<MediaJSON>>() {
            @Override
            public void onResponse(Call<List<MediaJSON>> call, Response<List<MediaJSON>> response) {
                Log.d(TAG, "onResponse");
                List<MediaJSON> mediaJSONList = response.body();
                listSubgenres = null;
                for (MediaJSON mediaJSON : mediaJSONList) {
//                    Log.d(TAG, mediaJSON.getKey());
                    if (mediaJSON.getList() != null && "music".equals(mediaJSON.getKey())) {
                        listSubgenres = mediaJSON.getList();
                    }
                }
                for (SubgenresJSON subgenresJSON : listSubgenres) {
                    Log.d(TAG, subgenresJSON.toString());
                    Genres genres = new Genres(
                            subgenresJSON.getId(),
                            subgenresJSON.getKey(),
                            loadImage(subgenresJSON.getId())
                    );
                    Log.d(TAG, genres.toString());
//                    Log.d(TAG, String.format("%s %s", loadImage(subgenresJSON.getId()), genres.getId()));
                    Genres.list.add(genres);
                }
                EventBus.getDefault().post(new EventDataReady());

//                updateUI();
            }

            @Override
            public void onFailure(Call<List<MediaJSON>> call, Throwable t) {
                Log.d(TAG, "onFailure");
            }
        });
    }

    @Subscribe
    public void onDataReady(EventDataReady event) {
        adapter = new GenresAdapter();
        rvGenres.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setupUI() {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position % 3 == 0 ? 2 : 1);
            }
        });
        rvGenres.setLayoutManager(layoutManager);
//        adapter = new GenresAdapter();
//        rvGenres.setAdapter(adapter);
        adapter = new GenresAdapter();
        rvGenres.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private int loadImage(String id) {
        return getActivity().getResources().getIdentifier("genres_" + id, "drawable", getActivity().getPackageName());
    }

    private void updateUI() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }

}
