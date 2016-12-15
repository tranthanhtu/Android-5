package com.example.hau.music_ranking.adapters.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hau.music_ranking.R;
import com.example.hau.music_ranking.models.Entry;
import com.example.hau.music_ranking.networks.GetSongFromAPI;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Hau on 30/11/2016.
 */
public class TopSongViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_artist)
    TextView tvArtist;
    @BindView(R.id.tv_song)
    TextView tvSong;
    @BindView(R.id.civ_song)
    CircleImageView civSong;

    public TopSongViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Entry entry, Context context) {
        tvArtist.setText(entry.getArtist());
        tvSong.setText(entry.getSong());
        Picasso.with(context).load(entry.getImage()).into(civSong);
    }
}
