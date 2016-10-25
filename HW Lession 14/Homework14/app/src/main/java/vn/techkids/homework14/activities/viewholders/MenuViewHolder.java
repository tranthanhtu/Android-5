package vn.techkids.homework14.activities.viewholders;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.techkids.homework14.R;
import vn.techkids.homework14.activities.models.Menu;

/**
 * Created by Dell latitude E6520 on 10/25/2016.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.imv_menu)
    ImageView imvMenu;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    public MenuViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Menu menu){
        tvTitle.setText(menu.getTitle());
        imvMenu.setImageResource(menu.getImageMenu());
    }
}
