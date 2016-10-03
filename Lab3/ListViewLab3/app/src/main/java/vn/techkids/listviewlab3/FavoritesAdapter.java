package vn.techkids.listviewlab3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dell latitude E6520 on 10/3/2016.
 */

public class FavoritesAdapter extends ArrayAdapter<FavoritesItem> {
    public FavoritesAdapter(Context context, int resource, List<FavoritesItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_favorites, parent, false);
        }
        FavoritesItem favoritesItem = getItem(position);
//        TextView title = (TextView) convertView.findViewById(R.id.tv_title_favorites);
//        TextView minutes = (TextView) convertView.findViewById(R.id.tv_minute_favorites);
//        ImageView imageFavorites = (ImageView) convertView.findViewById(R.id.iv_favorites);
        new FavoritesViewHolder(convertView)
                .getData(favoritesItem);

//        title.setText(favoritesItem.getTitle());
//        minutes.setText(favoritesItem.getMinutes());
//        imageFavorites.setImageResource(favoritesItem.getImageResId());

        return convertView;
    }
}
