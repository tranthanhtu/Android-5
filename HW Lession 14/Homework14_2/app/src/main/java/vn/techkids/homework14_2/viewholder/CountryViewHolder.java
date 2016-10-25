package vn.techkids.homework14_2.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.techkids.homework14_2.R;
import vn.techkids.homework14_2.models.CountryModels;

/**
 * Created by Dell latitude E6520 on 10/25/2016.
 */

public class CountryViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.imv_country)
    ImageView imvCountry;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    public CountryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(CountryModels countryModels){
        tvTitle.setText(countryModels.getCountry());
        imvCountry.setImageResource(countryModels.getImageContry());
    }
}
