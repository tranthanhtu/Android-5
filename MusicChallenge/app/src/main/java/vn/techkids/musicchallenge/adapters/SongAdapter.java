package vn.techkids.musicchallenge.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import vn.techkids.musicchallenge.R;
import vn.techkids.musicchallenge.models.Song;

/**
 * Created by Dell latitude E6520 on 11/9/2016.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, int resource, List<Song> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_music, parent, false);
        Song song = getItem(position);

        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        tvName.setText(song.getName());
        TextView tvArtist = (TextView) view.findViewById(R.id.tv_artist);
        tvArtist.setText(song.getArtist());


        return view;
    }
}
