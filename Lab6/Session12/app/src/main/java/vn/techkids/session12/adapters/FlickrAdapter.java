package vn.techkids.session12.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import vn.techkids.session12.R;
import vn.techkids.session12.jsonmodels.FlickerItem;

/**
 * Created by Dell latitude E6520 on 10/14/2016.
 */

public class FlickrAdapter extends ArrayAdapter<FlickerItem> {

    public FlickrAdapter(Context context, int resource, List<FlickerItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        convertView = layoutInflater.inflate(R.layout.layout_flick_item, parent, false);

        FlickerItem item = getItem(position);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title_flickr);
        TextView tvLink = (TextView) convertView.findViewById(R.id.tv_link_flickr);
        TextView tvDateTaken = (TextView) convertView.findViewById(R.id.tv_date_taken_flickr);


        tvTitle.setText(item.getTitle());
        tvLink.setText(item.getLinks());
        tvDateTaken.setText(item.getDateTaken());


        return convertView;
    }
}
