package vn.techkids.listviewlab3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dell latitude E6520 on 10/3/2016.
 */

public class FavoritesViewHolder {
    @BindView(R.id.tv_title_favorites)
    TextView tv_title;
    @BindView(R.id.tv_minute_favorites)
    TextView tv_minutes;
    @BindView(R.id.iv_favorites)
    ImageView iv_favorites;

    public FavoritesViewHolder(View rootview) {
        ButterKnife.bind(this, rootview);
    }

    public void getData(FavoritesItem favoritesItem){
        tv_title.setText(favoritesItem.getTitle());
        tv_minutes.setText(favoritesItem.getMinutes());
        iv_favorites.setImageResource(favoritesItem.getImageResId());
    }
}
