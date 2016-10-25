package vn.techkids.homework14_2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.techkids.homework14_2.R;
import vn.techkids.homework14_2.models.CountryModels;
import vn.techkids.homework14_2.viewholder.CountryViewHolder;

/**
 * Created by Dell latitude E6520 on 10/25/2016.
 */

public class Adapter extends RecyclerView.Adapter<CountryViewHolder> {
    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.country_list, parent, false);

        CountryViewHolder countryViewHolder = new CountryViewHolder(view);
        return countryViewHolder;
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        CountryModels countryModels = CountryModels.list.get(position);
        holder.bind(countryModels);

    }

    @Override
    public int getItemCount() {
        return CountryModels.list.size();
    }
}
