package com.example.hau.music_ranking.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hau.music_ranking.R;
import com.example.hau.music_ranking.models.Genres;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hau on 26/11/2016.
 */
public class GenresViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = GenresViewHolder.class.toString();
    @BindView(R.id.tv_genres)
    TextView tvGenres;
    @BindView(R.id.iv_genres)
    ImageView ivGenres;

    public GenresViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Genres genres) {
        Log.d(TAG, genres.toString());
        tvGenres.setText(genres.getKey());
        if (genres.getImage() == 0) {
            ivGenres.setImageResource(R.drawable.genres_0);
        } else {
            ivGenres.setImageResource(genres.getImage());
        }
        Log.d(TAG, String.format("%s", genres.getImage()));
        Log.d(TAG, "bind done!");
    }
}
