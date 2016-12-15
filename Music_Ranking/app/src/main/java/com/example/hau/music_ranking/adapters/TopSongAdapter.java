package com.example.hau.music_ranking.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.music_ranking.R;
import com.example.hau.music_ranking.adapters.viewholders.TopSongViewHolder;
import com.example.hau.music_ranking.models.Entry;
import com.example.hau.music_ranking.networks.GetSongFromAPI;

/**
 * Created by Hau on 30/11/2016.
 */
public class TopSongAdapter extends RecyclerView.Adapter<TopSongViewHolder>{

    Context context;

    public TopSongAdapter(Context context) {
        this.context = context;
    }

    @Override
    public TopSongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_topsong, parent, false);
        TopSongViewHolder topSongViewHolder = new TopSongViewHolder(view);
        return topSongViewHolder;
    }

    @Override
    public void onBindViewHolder(TopSongViewHolder holder, int position) {
        Entry entry = Entry.list.get(position);
        holder.bind(entry, context);
    }

    @Override
    public int getItemCount() {
        return Entry.list.size();
    }
}
