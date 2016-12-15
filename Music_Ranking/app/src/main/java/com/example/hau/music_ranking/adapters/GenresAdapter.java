package com.example.hau.music_ranking.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.music_ranking.R;
import com.example.hau.music_ranking.adapters.viewholders.GenresViewHolder;
import com.example.hau.music_ranking.models.Genres;

/**
 * Created by Hau on 26/11/2016.
 */
public class GenresAdapter extends RecyclerView.Adapter<GenresViewHolder> {
    @Override
    public GenresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_genres, parent, false);
        GenresViewHolder genresViewHolder = new GenresViewHolder(view);
        return genresViewHolder;
    }

    @Override
    public void onBindViewHolder(GenresViewHolder holder, int position) {
        Genres genres = Genres.list.get(position);

        holder.bind(genres);
    }

    @Override
    public int getItemCount() {
        return Genres.list.size();
    }
}
